package publisher;

import ws.service.CreditTransactionService;
import ws.util.TransactionRequest;
import ws.util.TransactionRequestBuilder;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService()
public class BankWebService {
    @WebMethod
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
