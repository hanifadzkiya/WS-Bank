package ws.model;

public class Transaksi {
    public int id;
    public int idNasabah;
    public String jenis;
    public int jumlah;
    public String nomorTerkait;
    public String waktuTransaksi;

    public Transaksi(TransaksiBuilder transaksiBuilder) {
        this.id = transaksiBuilder.getId();
        this.idNasabah = transaksiBuilder.getIdNasabah();
        this.jenis = transaksiBuilder.getJenis();
        this.jumlah = transaksiBuilder.getJumlah();
        this.nomorTerkait = transaksiBuilder.getNomorTerkait();
        this.waktuTransaksi = transaksiBuilder.getWaktuTransaksi();
    }
    public int getId() {
        return id;
    }

    public int getIdNasabah() {
        return idNasabah;
    }

    public String getJenis() {
        return jenis;
    }

    public int getJumlah() {
        return jumlah;
    }

    public String getNomorTerkait() {
        return nomorTerkait;
    }

    public String getWaktuTransaksi() {
        return waktuTransaksi;
    }
}
