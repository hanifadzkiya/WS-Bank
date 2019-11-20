package ws.util;

import ws.model.Transaksi;

public class TransaksiRequest {
    private String idNasabah;

    public TransaksiRequest(TransaksiRequestBuilder transaksiRequestBuilder){
        this.idNasabah = transaksiRequestBuilder.getIdNasabah();
    }

    public String getIdNasabah() {
        return idNasabah;
    }
}
