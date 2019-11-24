package ws.model;

public class RekeningBuilder {
  private int id;
  private String nama;
  private String noRekening;
  private String namaBank;
  private int saldo;

  /**
   * Constructor.
   * @param id id.
   * @param nama nama.
   * @param noRekening noRekening.
   * @param namaBank namaBank.
   * @param saldo saldo.
   */
  public RekeningBuilder(int id, String nama, String noRekening, String namaBank,int saldo) {
    this.id = id;
    this.nama = nama;
    this.noRekening = noRekening;
    this.namaBank = namaBank;
    this.saldo = saldo;
  }

  /**
   * Constructor.
   * @param id id.
   * @return this.
   */
  public RekeningBuilder setId(int id) {
    this.id = id;
    return this;
  }

  /**
   * SetNama.
   * @param nama nama.
   * @return this.
   */
  public RekeningBuilder setNama(String nama) {
    this.nama = nama;
    return this;
  }

  /**
   * Set No Rekening.
   * @param noRekening noRekening.
   * @return this.
   */
  public RekeningBuilder setNoRekening(String noRekening) {
    this.noRekening = noRekening;
    return this;
  }

  /**
   * Set Nama Bank.
   * @param namaBank namaBank.
   * @return this.
   */
  public RekeningBuilder setNamaBank(String namaBank) {
    this.namaBank = namaBank;
    return this;
  }

  /**
   * Set Saldo.
   * @param saldo saldo.
   * @return this.
   */
  public RekeningBuilder setSaldo(int saldo) {
    this.saldo = saldo;
    return this;
  }

  /**
   * GetId.
   * @return id.
   */
  public int getId() {
    return id;
  }

  /**
   * GetNama.
   * @return nama.
   */
  public String getNama() {
    return nama;
  }

  /**
   * GetNoRekening.
   * @return rekening.
   */
  public String getNoRekening() {
    return noRekening;
  }

  /**
   * GetNamaBank.
   * @return nama bank.
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
   * Build.
   * @return rkeening.
   */
  public Rekening build() {
    return new Rekening(this);
  }
}
