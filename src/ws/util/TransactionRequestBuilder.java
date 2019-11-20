package ws.util;

public class TransactionRequestBuilder {
    private String nomorTerkait;
    private Double jumlah;
    private String startTime;
    private String endTime;

    public TransactionRequestBuilder(String nomorTerkait, Double jumlah){
        this.nomorTerkait = nomorTerkait;
        this.jumlah = jumlah;
    }

    public TransactionRequestBuilder setStartTime(String startTime){
        this.startTime = startTime;
        return this;
    }

    public TransactionRequestBuilder setEndTime(String endTime){
        this.endTime = endTime;
        return this;
    }

    public TransactionRequest build(){
        return new TransactionRequest(this);
    }

    public String getNomorTerkait() {
        return nomorTerkait;
    }

    public Double getJumlah() {
        return jumlah;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
