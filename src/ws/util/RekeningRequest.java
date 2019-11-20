package ws.util;

public class RekeningRequest {
    private String noRekening;
    private int idNasabah;


    public RekeningRequest(RekeningRequestBuilder rekeningRequestBuilder){
        this.noRekening = rekeningRequestBuilder.getNoRekening();
    }

    public String getNoRekening() {
        return noRekening;
    }
}
