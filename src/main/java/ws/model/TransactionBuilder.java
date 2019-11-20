package ws.model;

public class TransactionBuilder {
    private int id;
    private String idNasabah;
    private String jenis;
    private Double jumlah;
    private String nomorTerkait;
    private String waktuTransaksi;

    public TransactionBuilder(int id, String idNasabah){
        this.id = id;
        this.idNasabah = idNasabah;
    }

    public TransactionBuilder setJenis(String jenis){
        this.jenis = jenis;
        return this;
    }

    public TransactionBuilder setJumlah(Double jumlah){
        this.jumlah = jumlah;
        return this;
    }

    public TransactionBuilder setNomorTerkait(String startTime){
        this.nomorTerkait = startTime;
        return this;
    }

    public TransactionBuilder setWaktuTransaksi(String endTime){
        this.waktuTransaksi = endTime;
        return this;
    }

    public Transaction build(){
        return new Transaction(this);
    }

    public int getId() {
        return id;
    }

    public String getIdNasabah() {
        return idNasabah;
    }

    public String getJenis() {
        return jenis;
    }

    public Double getJumlah() {
        return jumlah;
    }

    public String getNomorTerkait() {
        return nomorTerkait;
    }

    public String getWaktuTransaksi() {
        return waktuTransaksi;
    }
}
