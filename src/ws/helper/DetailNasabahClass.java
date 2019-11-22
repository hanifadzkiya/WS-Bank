package ws.helper;

import java.util.List;
import ws.model.Rekening;
import ws.model.Transaksi;

public class DetailNasabahClass {
  public Rekening rekening;
  public List<Transaksi> listTransaksi;

  /**
   * Mendapatkan Detail Nasabah.
   * @param rekening rekening.
   * @param listTransaksi listTransaksi.
   */
  public DetailNasabahClass(Rekening rekening, List<Transaksi> listTransaksi) {
    this.rekening = rekening;
    this.listTransaksi = listTransaksi;
  }

  /**
   * Mendapatkan Rekening.
   * @return rekening.
   */
  public Rekening getRekening() {
    return rekening;
  }

  /**
   * Get List Transaksi.
   * @return transaksi.
   */
  public List<Transaksi> getListTransaksi() {
    return listTransaksi;
  }

}
