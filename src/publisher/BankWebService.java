package publisher;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import ws.helper.DetailNasabahClass;
import ws.model.Rekening;
import ws.model.Transaksi;
import ws.service.CreditTransactionService;
import ws.service.NewVirtualAccountService;
import ws.service.RekeningService;
import ws.service.TransaksiService;
import ws.service.TransferService;
import ws.util.RekeningRequest;
import ws.util.RekeningRequestBuilder;
import ws.util.TransactionRequest;
import ws.util.TransactionRequestBuilder;

@WebService()
public class BankWebService {
  /**
   * Membuat Virtual Akun Baru.
   * @param nomorRekening Nomor Rekenig.
   * @return result
   * @throws Exception Exception.
   */
  @WebMethod
  public String newVirtualAccount(String nomorRekening) throws Exception {
    String result = NewVirtualAccountService.createNew(nomorRekening);
    return result;
  }

  /**
   * Transfer Uang.
   * @param nomorPengirim Nomor Pengirim.
   * @param nomorPenerima Nomor Penerima.
   * @param nominal Nominal.
   * @return result
   * @throws Exception Exception.
   */
  @WebMethod
  public String transfer(String nomorPengirim, String nomorPenerima, long nominal)
      throws Exception {
    boolean nomorValid = TransferService.validate(nomorPengirim, nomorPenerima, nominal);
    if (nomorValid) {
      TransferService.transfer(nomorPengirim, nomorPenerima, nominal);
      String result = "Transfer berhasil";
      System.out.println(result);
      return result;
    } else {
      String result = "Transfer gagal";
      System.out.println(result);
      return result;
    }
  }

  /**
   * Mengecek Ketersediaan Rekening.
   * @param nomorRekening Nomor Rekening.
   * @return boolean
   */
  @WebMethod
  public boolean isRekeningExist(String nomorRekening) {
    RekeningRequest rekeningRequest = new RekeningRequestBuilder(nomorRekening)
        .build();

    boolean result = RekeningService.isExistNomorRekening(rekeningRequest);
    return result;
  }

  /**
   * Mengambil detail rekening.
   * @param noRekening Nomor Rekening.
   * @return DetailNasabahClass
   */
  @WebMethod
  public DetailNasabahClass getRekeningDetail(String noRekening) {
    RekeningRequest rekeningRequest = new RekeningRequestBuilder(noRekening)
        .build();
    Rekening resultDetailRekening = RekeningService.getRekeningDetail(rekeningRequest);
    List<Transaksi> resultListTransaksi = TransaksiService.getAllNasabahTransaksi(rekeningRequest);
    DetailNasabahClass result = new DetailNasabahClass(resultDetailRekening,resultListTransaksi);
    return result;
  }

  /**
   * Mengecek Ketersediaan Kredit.
   * @param nomorTerkait Nomor Terkait.
   * @param jumlah Jumlah.
   * @param startTime Start Time.
   * @param endTime End Time.
   * @return Boolean
   */
  @WebMethod
  public Boolean isCreditTransactionExist(
      String nomorTerkait, Double jumlah, String startTime, String endTime) {
    TransactionRequest transactionRequest = new TransactionRequestBuilder(nomorTerkait, jumlah)
        .setStartTime(startTime)
        .setEndTime(endTime)
        .build();

    Boolean result = CreditTransactionService.isExistCreditTransaction(transactionRequest);
    System.out.println(result);
    return result;
  }

  /**
   * Main.
   * @param argv argv.
   */
  public static void main(String[] argv) {
    Object implementor = new BankWebService();
    String address = "http://localhost:9000/wsbank";
    Endpoint.publish(address, implementor);
  }
}
