package ws.model;

public class Transaction {
    private int id;
    private int idNasabah;
    private String jenis;
    private Double jumlah;
    private String nomorTerkait;
    private String waktuTransaksi;

    public Transaction(TransactionBuilder transactionBuilder){
        id = transactionBuilder.getId();
        idNasabah = transactionBuilder.getIdNasabah();
        jenis = transactionBuilder.getJenis();
        nomorTerkait = transactionBuilder.getNomorTerkait();
        jumlah = transactionBuilder.getJumlah();
        waktuTransaksi = transactionBuilder.getWaktuTransaksi();
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
