package ws.util;

public class TransactionRequest {
    private String nomorTerkait;
    private Double jumlah;
    private String startTime;
    private String endTime;

    public TransactionRequest(TransactionRequestBuilder transactionRequest){
        nomorTerkait = transactionRequest.getNomorTerkait();
        jumlah = transactionRequest.getJumlah();
        startTime = transactionRequest.getStartTime();
        endTime = transactionRequest.getEndTime();
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
