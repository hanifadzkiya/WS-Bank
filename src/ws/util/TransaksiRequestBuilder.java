package ws.util;

public class TransaksiRequestBuilder {
  public String idNasabah;

  /**
   * Transaksi Request Builder.
   * @param idNasabah id Nasabah.
   */
  public TransaksiRequestBuilder(String idNasabah) {
    this.idNasabah = idNasabah;
  }

  /**
   * Set Id Nasabah.
   * @param idNasabah id NAsabah.
   * @return this.
   */
  public TransaksiRequestBuilder setIdNasabah(String idNasabah) {
    this.idNasabah = idNasabah;
    return this;
  }

  /**
   * Get Id Nasabah.
   * @return id Nasabah.
   */
  public String getIdNasabah() {
    return this.idNasabah;
  }

  /**
   * Build.
   * @return Transaksi Request.
   */
  public TransaksiRequest build() {
    return new TransaksiRequest(this);
  }
}
