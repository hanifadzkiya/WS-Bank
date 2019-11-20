package ws.helper;

import ws.model.Rekening;
import ws.model.Transaksi;

import java.util.List;

public class DetailNasabahClass {
    public Rekening rekening;
    public List<Transaksi> listTransaksi;

    public DetailNasabahClass(Rekening rekening, List<Transaksi> listTransaksi) {
        this.rekening = rekening;
        this.listTransaksi = listTransaksi;
    }

    public Rekening getRekening() {
        return rekening;
    }

    public List<Transaksi> getListTransaksi() {
        return listTransaksi;
    }

}
