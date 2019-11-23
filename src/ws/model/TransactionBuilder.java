package ws.model;

public class TransactionBuilder {
  private int id;
  private String idNasabah;
  private String jenis;
  private Double jumlah;
  private String nomorTerkait;
  private String waktuTransaksi;

  /**
   * Constructor.
   * @param id id.
   * @param idNasabah idNasabah.
   */
  public TransactionBuilder(int id, String idNasabah) {
    this.id = id;
    this.idNasabah = idNasabah;
  }

  /**
   * Constructor.
   * @param jenis jenis.
   * @return this.
   */
  public TransactionBuilder setJenis(String jenis) {
    this.jenis = jenis;
    return this;
  }

  /**
   * SetJumlah.
   * @param jumlah jumlah.
   * @return this.
   */
  public TransactionBuilder setJumlah(Double jumlah) {
    this.jumlah = jumlah;
    return this;
  }

  /**
   * setNomorTerkait.
   * @param startTime startTime.
   * @return this.
   */
  public TransactionBuilder setNomorTerkait(String startTime) {
    this.nomorTerkait = startTime;
    return this;
  }

  /**
   * setWaktuTransaksi.
   * @param endTime endTime.
   * @return this.
   */
  public TransactionBuilder setWaktuTransaksi(String endTime) {
    this.waktuTransaksi = endTime;
    return this;
  }

  /**
   * build.
   * @return Transaction.
   */
  public Transaction build() {
    return new Transaction(this);
  }

  /**
   * Get ID.
   * @return id.
   */
  public int getId() {
    return id;
  }

  /**
   * GetIdNasabah.
   * @return idNasabah.
   */
  public String getIdNasabah() {
    return idNasabah;
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
  public Double getJumlah() {
    return jumlah;
  }

  /**
   * Get Nomor Terkait.
   * @return Nomor Terkait.
   */
  public String getNomorTerkait() {
    return nomorTerkait;
  }

  /**
   * Get Waktu Transaksi.
   * @return Waktu Transaksi.
   */
  public String getWaktuTransaksi() {
    return waktuTransaksi;
  }
}
