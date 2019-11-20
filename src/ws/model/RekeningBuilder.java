package ws.model;

public class RekeningBuilder {
    private int id;
    private String nama;
    private String noRekening;
    private String namaBank;

    public RekeningBuilder(int id, String nama, String noRekening, String namaBank) {
        this.id = id;
        this.nama = nama;
        this.noRekening = noRekening;
        this.namaBank = namaBank;
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

    public Rekening build(){
        return new Rekening(this);
    }
}
