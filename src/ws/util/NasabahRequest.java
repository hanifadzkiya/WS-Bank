package ws.util;

public class NasabahRequest {
  private String idNasabah;

  /**
   * Constructor.
   * @param nasabahRequestBuilder nasabahRequestBuilder.
   */
  public NasabahRequest(NasabahRequestBuilder nasabahRequestBuilder) {
    this.idNasabah = nasabahRequestBuilder.getIdNasabah();
  }

  /**
   * Get Id Nasabah.
   * @return idNasabah.
   */
  public String getIdNasabah() {
    return idNasabah;
  }
}
