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
import ws.util.TokenValidator;
import ws.util.TransactionRequest;
import ws.util.TransactionRequestBuilder;

@WebService()
public class BankWebService {
  /**
   * Membuat Virtual Akun Baru.
   * @param token token request.
   * @return result
   */
  private boolean validateRequestToken(String token) {
    boolean result = TokenValidator.validateToken(token);
    return result;
  }

  /**
   * Membuat Virtual Akun Baru.
   * @param nomorRekening Nomor Rekening.
   * @param token Token
   * @return result
   * @throws Exception Exception.
   */
  @WebMethod
  public String newVirtualAccount(String nomorRekening, String token) throws Exception {
    if (validateRequestToken(token)) {
      String result = NewVirtualAccountService.createNew(nomorRekening);
      return result;
    } else {
      return new String("Error. Forbidden request");
    }
  }

  /**
   * Transfer Uang.
   * @param nomorPengirim Nomor Pengirim.
   * @param nomorPenerima Nomor Penerima.
   * @param nominal Nominal.
   * @param token Token
   * @return result
   * @throws Exception Exception.
   */
  @WebMethod
  public String transfer(String nomorPengirim, String nomorPenerima, long nominal, String token)
      throws Exception {
    if (validateRequestToken(token)) {
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
    } else {
      return new String("Error. Forbidden request");
    }
  }

  /**
   * Mengecek Ketersediaan Rekening.
   * @param nomorRekening Nomor Rekening.
   * @param token Token
   * @return boolean
   */
  @WebMethod
  public Boolean isRekeningExist(String nomorRekening, String token) {
    if (validateRequestToken(token)) {
      RekeningRequest rekeningRequest = new RekeningRequestBuilder(nomorRekening)
          .build();

      Boolean result = RekeningService.isExistNomorRekening(rekeningRequest);
      return result;
    } else {
      return null;
    }
  }

  /**
   * Mengambil detail rekening.
   * @param noRekening Nomor Rekening.
   * @param token Token
   * @return DetailNasabahClass
   */
  @WebMethod
  public DetailNasabahClass getRekeningDetail(String noRekening, String token) {
    if (validateRequestToken(token)) {
      RekeningRequest rekRequest = new RekeningRequestBuilder(noRekening)
          .build();
      Rekening resultDetailRekening = RekeningService.getRekeningDetail(rekRequest);
      List<Transaksi> resultListTransaksi = TransaksiService.getAllNasabahTransaksi(rekRequest);
      DetailNasabahClass result = new DetailNasabahClass(resultDetailRekening,resultListTransaksi);
      return result;
    } else {
      return null;
    }
  }

  /**
   * Mengecek Ketersediaan Kredit.
   * @param nomorTerkait Nomor Terkait.
   * @param jumlah Jumlah.
   * @param startTime Start Time.
   * @param endTime End Time.
   * @param token Token
   * @return Boolean
   */
  @WebMethod
  public Boolean isCreditTransactionExist(
      String nomorTerkait, Double jumlah, String startTime, String endTime, String token) {
    if (validateRequestToken(token)) {
      TransactionRequest transactionRequest = new TransactionRequestBuilder(nomorTerkait, jumlah)
          .setStartTime(startTime)
          .setEndTime(endTime)
          .build();

      Boolean result = CreditTransactionService.isExistCreditTransaction(transactionRequest);
      System.out.println(result);
      return result;
    } else {
      return null;
    }
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
