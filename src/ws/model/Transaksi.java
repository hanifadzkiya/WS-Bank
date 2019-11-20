package ws.model;

public class Transaksi {
    public int id;
    public String noRekening_1;
    public String jenis;
    public int jumlah;
    public String noRekening_2;
    public String waktuTransaksi;

    public Transaksi(TransaksiBuilder transaksiBuilder) {
        this.id = transaksiBuilder.getId();
        this.noRekening_1 = transaksiBuilder.getNoRekening_1();
        this.jenis = transaksiBuilder.getJenis();
        this.jumlah = transaksiBuilder.getJumlah();
        this.noRekening_2 = transaksiBuilder.getNoRekening_2();
        this.waktuTransaksi = transaksiBuilder.getWaktuTransaksi();
    }
    public int getId() {
        return id;
    }

    public String getNoRekening_1() {
        return noRekening_1;
    }

    public String getJenis() {
        return jenis;
    }

    public int getJumlah() {
        return jumlah;
    }

    public String getNoRekening_2() {
        return noRekening_2;
    }

    public String getWaktuTransaksi() {
        return waktuTransaksi;
    }
}
