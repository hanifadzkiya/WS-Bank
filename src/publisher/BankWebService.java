package publisher;


import jdk.nashorn.internal.runtime.Version;
import ws.helper.DetailNasabahClass;
import ws.model.Rekening;
import ws.model.Transaksi;
import ws.service.RekeningService;
import ws.service.TransaksiService;
import ws.util.*;
import ws.service.CreditTransactionService;
import ws.util.TransactionRequest;
import ws.util.TransactionRequestBuilder;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebService()
public class BankWebService {
    @WebMethod
    public DetailNasabahClass getRekeningDetail(String idNasabah) {
        NasabahRequest nasabahRequest = new NasabahRequestBuilder(idNasabah)
                .build();
        TransaksiRequest transaksiRequest = new TransaksiRequestBuilder(idNasabah)
                .build();
        Rekening resultDetailRekening = RekeningService.getRekeningDetailByIdNasabah(nasabahRequest);
        List<Transaksi> resultListTransaksi = TransaksiService.getAllNasabahTransaksi(transaksiRequest);
        int saldo;
        try{
            saldo = RekeningService.getSaldoByIdNasabah(nasabahRequest);
        } catch (Exception e){
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
            throw e;
        }
        DetailNasabahClass result = new DetailNasabahClass(resultDetailRekening,saldo,resultListTransaksi);
        return result;
    }

    public String isCreditTransactionExist(String nomorTerkait, Double jumlah, String startTime, String endTime) {
        TransactionRequest transactionRequest = new TransactionRequestBuilder(nomorTerkait, jumlah)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .build();

        String result = CreditTransactionService.isExistCreditTransaction(transactionRequest);
        System.out.println(result);
        return result;
    }

    public static void main(String[] argv) {
        Object implementor = new BankWebService ();
        String address = "http://localhost:9000/wsbank";
        Endpoint.publish(address, implementor);
    }
}
