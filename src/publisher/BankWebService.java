package publisher;

import ws.service.RekeningService;
import ws.util.RekeningRequest;

import ws.util.RekeningRequestBuilder;
import ws.helper.DetailNasabahClass;
import ws.model.Rekening;
import ws.model.Transaksi;
import ws.service.TransaksiService;
import ws.service.CreditTransactionService;
import ws.util.TransactionRequest;
import ws.util.TransactionRequestBuilder;
import ws.service.NewVirtualAccountService;
import ws.service.TransferService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService()
public class BankWebService {
    @WebMethod
    public String newVirtualAccount(String nomorRekening) throws Exception {
        String result = NewVirtualAccountService.createNew(nomorRekening);
        return result;
    }

    @WebMethod
    public String transfer(String nomorPengirim, String nomorPenerima, long nominal) throws Exception {
        boolean nomorValid = TransferService.validate(nomorPengirim, nomorPenerima, nominal);
        if (nomorValid) {
            TransferService.Transfer(nomorPengirim, nomorPenerima, nominal);
            String result = "Transfer berhasil";
            System.out.println(result);
            return result;
        } else {
            String result = "Transfer gagal";
            System.out.println(result);
            return result;
        }
    }

    @WebMethod
    public boolean isRekeningExist(String nomorRekening) {
        RekeningRequest rekeningRequest = new RekeningRequestBuilder(nomorRekening)
                .build();

        boolean result = RekeningService.isExistNomorRekening(rekeningRequest);
        return result;
    }

    @WebMethod
    public DetailNasabahClass getRekeningDetail(String noRekening) {
        RekeningRequest rekeningRequest = new RekeningRequestBuilder(noRekening)
                .build();
        Rekening resultDetailRekening = RekeningService.getRekeningDetail(rekeningRequest);
        List<Transaksi> resultListTransaksi = TransaksiService.getAllNasabahTransaksi(rekeningRequest);
        DetailNasabahClass result = new DetailNasabahClass(resultDetailRekening,resultListTransaksi);
        return result;
    }

    @WebMethod
    public Boolean isCreditTransactionExist(String nomorTerkait, Double jumlah, String startTime, String endTime) {
        TransactionRequest transactionRequest = new TransactionRequestBuilder(nomorTerkait, jumlah)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .build();

        Boolean result = CreditTransactionService.isExistCreditTransaction(transactionRequest);
        System.out.println(result);
        return result;
    }

    public static void main(String[] argv) {
        Object implementor = new BankWebService ();
        String address = "http://localhost:9000/wsbank";
        Endpoint.publish(address, implementor);
    }
}
