package publisher;

import ws.model.Rekening;
import ws.service.RekeningService;
import ws.util.RekeningRequest;

import ws.util.RekeningRequestBuilder;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService()
public class BankWebService {
    @WebMethod
    public Rekening getRekeningDetail(String nomorRekening) {
        RekeningRequest rekeningRequest = new RekeningRequestBuilder(nomorRekening)
                .build();
        Rekening result = RekeningService.getRekeningDetail(rekeningRequest);
        return result;
    }

    public static void main(String[] argv) {
        Object implementor = new BankWebService ();
        String address = "http://localhost:9000/wsbank";
        Endpoint.publish(address, implementor);
    }
}
