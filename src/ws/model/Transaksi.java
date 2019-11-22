package ws.model;

public class Transaksi {
  public int id;
  public String noRekening1;
  public String jenis;
  public int jumlah;
  public String noRekening2;
  public String waktuTransaksi;

  /**
   * Constrctor.
   * @param transaksiBuilder TransaksiBuilder.
   */
  public Transaksi(TransaksiBuilder transaksiBuilder) {
    this.id = transaksiBuilder.getId();
    this.noRekening1 = transaksiBuilder.getNoRekening1();
    this.jenis = transaksiBuilder.getJenis();
    this.jumlah = transaksiBuilder.getJumlah();
    this.noRekening2 = transaksiBuilder.getNoRekening2();
    this.waktuTransaksi = transaksiBuilder.getWaktuTransaksi();
  }

  /**
   * GetId.
   * @return id.
   */
  public int getId() {
    return id;
  }

  /**
   * GetNomorRekening1.
   * @return noRekening1.
   */
  public String getNoRekening1() {
    return noRekening1;
  }

  /**
   * getJenis.
   * @return jenis.
   */
  public String getJenis() {
    return jenis;
  }

  /**
   * getJumlah.
   * @return jumlah.
   */
  public int getJumlah() {
    return jumlah;
  }

  /**
   * GetNomorRekening2.
   * @return noRekening2.
   */
  public String getNoRekening2() {
    return noRekening2;
  }

  /**
   * getWaktuTransaksi.
   * @return waktuTransaksi.
   */
  public String getWaktuTransaksi() {
    return waktuTransaksi;
  }
}
