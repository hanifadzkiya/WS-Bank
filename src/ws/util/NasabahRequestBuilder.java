package ws.util;

public class NasabahRequestBuilder {
  public String idNasabah;

  /**
   * Constructor.
   * @param idNasabah id Nasabah.
   */
  public NasabahRequestBuilder(String idNasabah) {
    this.idNasabah = idNasabah;
  }

  /**
   * Set Id Nasabah.
   * @param idNasabah idNasabah.
   * @return id Nasabah.
   */
  public NasabahRequestBuilder setIdNasabah(String idNasabah) {
    this.idNasabah = idNasabah;
    return this;
  }

  /**
   * Get Id Nasabah.
   * @return id Nasabah.
   */
  public String getIdNasabah() {
    return idNasabah;
  }

  /**
   * Build.
   * @return Nasabah Request.
   */
  public NasabahRequest build() {
    return new NasabahRequest(this);
  }
}
