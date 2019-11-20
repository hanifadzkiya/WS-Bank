package ws.util;

public class TransaksiRequestBuilder {
    public String idNasabah;

    public TransaksiRequestBuilder(String idNasabah) {
        this.idNasabah = idNasabah;
    }

    public TransaksiRequestBuilder setIdNasabah(String idNasabah) {
        this.idNasabah = idNasabah;
        return this;
    }

    public String getIdNasabah() {
        return this.idNasabah;
    }

    public TransaksiRequest build(){
        return new TransaksiRequest(this);
    }
}
