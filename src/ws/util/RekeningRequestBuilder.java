package ws.util;

import ws.model.Rekening;

public class RekeningRequestBuilder {
  public String noRekening;

  /**
   * Constructor.
   * @param noRekening No Rekening.
   */
  public RekeningRequestBuilder(String noRekening) {
    this.noRekening = noRekening;
  }

  /**
   * Set Nomor Rekening.
   * @param noRekening No Rekening.
   * @return this.
   */
  public RekeningRequestBuilder setNoRekening(String noRekening) {
    this.noRekening = noRekening;
    return this;
  }

  /**
   * Get Nomor Rekening.
   * @return nomor Rekening.
   */
  public String getNoRekening() {
    return noRekening;
  }

  /**
   * Build.
   * @return RekeningRequest.
   */
  public RekeningRequest build() {
    return new RekeningRequest(this);
  }
}
