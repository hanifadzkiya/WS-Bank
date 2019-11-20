package ws.util;

public class NasabahRequest {
    private String idNasabah;


    public NasabahRequest(NasabahRequestBuilder nasabahRequestBuilder){
        this.idNasabah = nasabahRequestBuilder.getIdNasabah();
    }

    public String getIdNasabah() {
        return idNasabah;
    }
}
