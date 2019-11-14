package publisher;

import ws.model.Rekening;
import ws.service.CreditTransactionService;
import ws.service.RekeningService;
import ws.util.RekeningRequest;
import ws.util.TransactionRequest;
import ws.util.TransactionRequestBuilder;

import ws.util.RekeningRequestBuilder;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

//class TestingAja {
//    private String coba;
//    public TestingAja(String coba){
//        this.coba = coba;
//    }
//}
@WebService()
public class BankWebService {
    @WebMethod
    public String isRekeningExist(String nomorRekening) {
        RekeningRequest rekeningRequest = new RekeningRequestBuilder(nomorRekening)
                .build();

        String result = RekeningService.isExistNomorRekening(rekeningRequest);
        System.out.println(result);
        return result;
    }

    public static void main(String[] argv) {
        Object implementor = new BankWebService ();
        String address = "http://localhost:9000/wsbank";
        Endpoint.publish(address, implementor);
    }
}
