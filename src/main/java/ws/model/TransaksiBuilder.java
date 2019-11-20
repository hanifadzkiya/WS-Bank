package ws.model;

public class TransaksiBuilder {
    private int id;
    private String noRekening_1;
    private String jenis;
    private int jumlah;
    public String noRekening_2;
    public String waktuTransaksi;

    public TransaksiBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public TransaksiBuilder setNoRekening_1(String noRekening_1) {
        this.noRekening_1 = noRekening_1;
        return this;
    }

    public TransaksiBuilder setJenis(String jenis) {
        this.jenis = jenis;
        return this;
    }

    public TransaksiBuilder setJumlah(int jumlah) {
        this.jumlah = jumlah;
        return this;
    }

    public TransaksiBuilder setNoRekening_2(String noRekening_2) {
        this.noRekening_2 = noRekening_2;
        return this;
    }

    public TransaksiBuilder setWaktuTransaksi(String waktuTransaksi) {
        this.waktuTransaksi = waktuTransaksi;
        return this;
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

    public TransaksiBuilder(int id, String noRekening_1, String jenis, int jumlah, String noRekening_2, String waktuTransaksi) {
        this.id = id;
        this.noRekening_1 = noRekening_1;
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.noRekening_2 = noRekening_2;
        this.waktuTransaksi = waktuTransaksi;
    }

    public Transaksi build(){
        return new Transaksi(this);
    }
}
