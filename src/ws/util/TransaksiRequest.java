package ws.util;

import ws.model.Transaksi;

public class TransaksiRequest {
  private String idNasabah;

  /**
   * Constructor.
   * @param transaksiRequestBuilder Transaksi Request Builder.
   */
  public TransaksiRequest(TransaksiRequestBuilder transaksiRequestBuilder) {
    this.idNasabah = transaksiRequestBuilder.getIdNasabah();
  }

  /**
   * Get Id Nasabah.
   * @return id Nasabah.
   */
  public String getIdNasabah() {
    return idNasabah;
  }
}
