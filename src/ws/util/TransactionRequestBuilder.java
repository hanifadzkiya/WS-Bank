package ws.util;

public class TransactionRequestBuilder {
  private String nomorTerkait;
  private Double jumlah;
  private String startTime;
  private String endTime;

  /**
   * Constructor.
   * @param nomorTerkait nomor terkait.
   * @param jumlah jumlah.
   */
  public TransactionRequestBuilder(String nomorTerkait, Double jumlah) {
    this.nomorTerkait = nomorTerkait;
    this.jumlah = jumlah;
  }

  /**
   * Set Start Time.
   * @param startTime start Time.
   * @return this.
   */
  public TransactionRequestBuilder setStartTime(String startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * set End Time.
   * @param endTime end Time.
   * @return this.
   */
  public TransactionRequestBuilder setEndTime(String endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * Build.
   * @return Transaction Request.
   */
  public TransactionRequest build() {
    return new TransactionRequest(this);
  }

  /**
   * Get Nomot Terkait.
   * @return nomor Terkait.
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
   * @return start Time.
   */
  public String getStartTime() {
    return startTime;
  }

  /**
   * Get end Time.
   * @return End Time.
   */
  public String getEndTime() {
    return endTime;
  }
}
