package ws.util;

public class TransactionRequest {
  private String nomorTerkait;
  private Double jumlah;
  private String startTime;
  private String endTime;

  /**
   * Constructor.
   * @param transactionRequest transactionRequest.
   */
  public TransactionRequest(TransactionRequestBuilder transactionRequest) {
    nomorTerkait = transactionRequest.getNomorTerkait();
    jumlah = transactionRequest.getJumlah();
    startTime = transactionRequest.getStartTime();
    endTime = transactionRequest.getEndTime();
  }

  /**
   * Get Nomor Terkait.
   * @return nomor terkait.
   */
  public String getNomorTerkait() {
    return nomorTerkait;
  }

  /**
   * Get Jumlah.
   * @return jumlah.
   */
  public Double getJumlah() {
    return jumlah;
  }

  /**
   * Get Start Time.
   * @return startTime.
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * Get End Time.
   * @return end Time.
   */
  public String getEndTime() {
    return endTime;
  }
}
