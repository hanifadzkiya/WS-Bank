package ws.util;

public class RekeningRequest {
    private String noRekening;

    public RekeningRequest(RekeningRequestBuilder rekeningRequestBuilder){
        this.noRekening = rekeningRequestBuilder.getNoRekening();
    }

    public String getNoRekening() {
        return noRekening;
    }
}
