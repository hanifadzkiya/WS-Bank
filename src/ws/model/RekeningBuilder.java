package ws.model;

public class RekeningBuilder {
    private int id;
    private String nama;
    private String noRekening;
    private String namaBank;
    private int saldo;

    public RekeningBuilder(int id, String nama, String noRekening, String namaBank,int saldo) {
        this.id = id;
        this.nama = nama;
        this.noRekening = noRekening;
        this.namaBank = namaBank;
        this.saldo = saldo;
    }

    public RekeningBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public RekeningBuilder setNama(String nama) {
        this.nama = nama;
        return this;
    }

    public RekeningBuilder setNoRekening(String noRekening) {
        this.noRekening = noRekening;
        return this;
    }

    public RekeningBuilder setNamaBank(String namaBank) {
        this.namaBank = namaBank;
        return this;
    }

    public RekeningBuilder setSaldo(int saldo) {
        this.saldo = saldo;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public String getNamaBank() {
        return namaBank;
    }


    public int getSaldo() { return saldo; }

    public Rekening build(){
        return new Rekening(this);
    }
}
