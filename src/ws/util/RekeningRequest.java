package ws.util;

public class RekeningRequest {
  private String noRekening;

  /**
   * Rekening Request Constructor.
   * @param rekeningRequestBuilder Rekening Request Builder.
   */
  public RekeningRequest(RekeningRequestBuilder rekeningRequestBuilder) {
    this.noRekening = rekeningRequestBuilder.getNoRekening();
  }

  /**
   * Get No Rekening.
   * @return noRekening.
   */
  public String getNoRekening() {
    return noRekening;
  }
}
