package ws.model;

public class Transaction {
  private int id;
  private String idNasabah;
  private String jenis;
  private Double jumlah;
  private String nomorTerkait;
  private String waktuTransaksi;

  /**
   * Constructor.
   * @param transactionBuilder TransactionBuilder.
   */
  public Transaction(TransactionBuilder transactionBuilder) {
    id = transactionBuilder.getId();
    idNasabah = transactionBuilder.getIdNasabah();
    jenis = transactionBuilder.getJenis();
    nomorTerkait = transactionBuilder.getNomorTerkait();
    jumlah = transactionBuilder.getJumlah();
    waktuTransaksi = transactionBuilder.getWaktuTransaksi();
  }

  /**
   * GetID.
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
   * GetNomorTerkait.
   * @return Nomor Terkait.
   */
  public String getNomorTerkait() {
    return nomorTerkait;
  }

  /**
   * GetWaktuTransaksi.
   * @return Waktu Transaksi.
   */
  public String getWaktuTransaksi() {
    return waktuTransaksi;
  }
}
