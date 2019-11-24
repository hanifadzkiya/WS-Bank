package ws.model;

public class TransaksiBuilder {
  private int id;
  private String noRekening1;
  private String jenis;
  private int jumlah;
  public String noRekening2;
  public String waktuTransaksi;

  /**
   * SetId.
   * @param id id.
   * @return this.
   */
  public TransaksiBuilder setId(int id) {
    this.id = id;
    return this;
  }

  /**
   * Constructor.
   * @param noRekening1 nomorRekening1.
   * @return this.
   */
  public TransaksiBuilder setNoRekening1(String noRekening1) {
    this.noRekening1 = noRekening1;
    return this;
  }

  /**
   * SetJenis.
   * @param jenis jenis.
   * @return jenis.
   */
  public TransaksiBuilder setJenis(String jenis) {
    this.jenis = jenis;
    return this;
  }

  /**
   * TransaksiBuilder.
   * @param jumlah jumlah.
   * @return jumlah.
   */
  public TransaksiBuilder setJumlah(int jumlah) {
    this.jumlah = jumlah;
    return this;
  }

  /**
   * SetNomorRekening2.
   * @param noRekening2 noRekening2.
   * @return this.
   */
  public TransaksiBuilder setNoRekening2(String noRekening2) {
    this.noRekening2 = noRekening2;
    return this;
  }

  /**
   * setWaktuTransaksi.
   * @param waktuTransaksi waktuTransaksi.
   * @return this.
   */
  public TransaksiBuilder setWaktuTransaksi(String waktuTransaksi) {
    this.waktuTransaksi = waktuTransaksi;
    return this;
  }

  /**
   * getId.
   * @return id.
   */
  public int getId() {
    return id;
  }

  /**
   * getNoRekening1.
   * @return noRekening1.
   */
  public String getNoRekening1() {
    return noRekening1;
  }

  /**
   * GetJenis.
   * @return jenis.
   */
  public String getJenis() {
    return jenis;
  }

  /**
   * GetJumlah.
   * @return jumlah.
   */
  public int getJumlah() {
    return jumlah;
  }

  /**
   * GetNoRekening 2.
   * @return noRekening 2.
   */
  public String getNoRekening2() {
    return noRekening2;
  }

  /**
   * Get Waktu Transaksi.
   * @return waktu transaksi.
   */
  public String getWaktuTransaksi() {
    return waktuTransaksi;
  }

  /**
   * constructor.
   * @param id id.
   * @param noRekening1 noRekening1.
   * @param jenis jenis.
   * @param jumlah jumlah.
   * @param noRekening2 noRekening2.
   * @param waktuTransaksi waktuTransaksi.
   */
  public TransaksiBuilder(
      int id, String noRekening1, String jenis, int jumlah,
      String noRekening2, String waktuTransaksi) {
    this.id = id;
    this.noRekening1 = noRekening1;
    this.jenis = jenis;
    this.jumlah = jumlah;
    this.noRekening2 = noRekening2;
    this.waktuTransaksi = waktuTransaksi;
  }

  /**
   * Build.
   * @return Transaksi.
   */
  public Transaksi build() {
    return new Transaksi(this);
  }
}
