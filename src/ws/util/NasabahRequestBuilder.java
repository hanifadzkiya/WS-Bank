package ws.util;

public class NasabahRequestBuilder {
    public String idNasabah;

    public NasabahRequestBuilder(String idNasabah) {
        this.idNasabah = idNasabah;
    }

    public NasabahRequestBuilder setIdNasabah(String idNasabah) {
        this.idNasabah = idNasabah;
        return this;
    }

    public String getIdNasabah() {
        return idNasabah;
    }

    public NasabahRequest build(){
        return new NasabahRequest(this);
    }
}
