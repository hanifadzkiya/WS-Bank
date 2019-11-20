package ws.model;

public class TransaksiBuilder {
    private int id;
    private int idNasabah;
    private String jenis;
    private int jumlah;
    public String nomorTerkait;
    public String waktuTransaksi;

    public TransaksiBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public TransaksiBuilder setIdNasabah(int idNasabah) {
        this.idNasabah = idNasabah;
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

    public TransaksiBuilder setNomorTerkait(String nomorTerkait) {
        this.nomorTerkait = nomorTerkait;
        return this;
    }

    public TransaksiBuilder setWaktuTransaksi(String waktuTransaksi) {
        this.waktuTransaksi = waktuTransaksi;
        return this;
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

    public TransaksiBuilder(int id, int idNasabah, String jenis, int jumlah, String nomorTerkait, String waktuTransaksi) {
        this.id = id;
        this.idNasabah = idNasabah;
        this.jenis = jenis;
        this.jumlah = jumlah;
        this.nomorTerkait = nomorTerkait;
        this.waktuTransaksi = waktuTransaksi;
    }

    public Transaksi build(){
        return new Transaksi(this);
    }
}
