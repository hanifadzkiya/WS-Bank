package ws.model;

public class Rekening {
  private int id;
  private String nama;
  private String noRekening;
  private String namaBank;
  private int saldo;

  /**
   * Constructor.
   * @param rekeningBuilder rekeningBuilder.
   */
  public Rekening(RekeningBuilder rekeningBuilder) {
    this.id = rekeningBuilder.getId();
    this.nama = rekeningBuilder.getNama();
    this.noRekening = rekeningBuilder.getNoRekening();
    this.namaBank = rekeningBuilder.getNamaBank();
    this.saldo = rekeningBuilder.getSaldo();
  }

  /**
   * Constructor.
   */
  public Rekening() {

  }

  /**
   * Get ID.
   * @return id.
   */
  public int getId() {
    return id;
  }

  /**
   * Set Id.
   * @param id Id.
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Get Nama.
   * @return nama.
   */
  public String getNama() {
    return nama;
  }

  /**
   * Set Nama.
   * @param nama nama.
   */
  public void setNama(String nama) {
    this.nama = nama;
  }

  /**
   * Get Nomor Rekening.
   * @return STring.
   */
  public String getNoRekening() {
    return noRekening;
  }

  /**
   * Set Nomor Rekening.
   * @param noRekening NoRekening.
   */
  public void setNoRekening(String noRekening) {
    this.noRekening = noRekening;
  }

  /**
   * GetNamaBank.
   * @return namaBank.
   */
  public String getNamaBank() {
    return namaBank;
  }

  /**
   * GetSaldo.
   * @return saldo.
   */
  public int getSaldo() {
    return saldo;
  }

  /**
   * SetSaldo.
   * @param saldo saldo.
   */
  public void setSaldo(int saldo) {
    this.saldo = saldo;
  }

  /**
   * Set Nama Bank.
   * @param namaBank namaBank.
   */
  public void setNamaBank(String namaBank) {
    this.namaBank = namaBank;
  }
}
