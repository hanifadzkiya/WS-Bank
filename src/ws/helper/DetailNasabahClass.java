package ws.helper;

import ws.model.Rekening;
import ws.model.Transaksi;

import java.util.List;

public class DetailNasabahClass {
    public Rekening rekening;
    public int saldo;
    public List<Transaksi> listTransaksi;

    public DetailNasabahClass(Rekening rekening, int saldo, List<Transaksi> listTransaksi) {
        this.rekening = rekening;
        this.listTransaksi = listTransaksi;
        this.saldo = saldo;
    }

    public Rekening getRekening() {
        return rekening;
    }

    public List<Transaksi> getListTransaksi() {
        return listTransaksi;
    }

    public int getSaldo() {
        return saldo;
    }
}
