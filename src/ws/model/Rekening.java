package ws.model;

public class Rekening {
    private int id;
    private String nama;
    private String noRekening;
    private String namaBank;

    public Rekening(RekeningBuilder rekeningBuilder){
        this.id = rekeningBuilder.getId();
        this.nama = rekeningBuilder.getNama();
        this.noRekening = rekeningBuilder.getNoRekening();
        this.namaBank = rekeningBuilder.getNamaBank();
    }

    public Rekening(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoRekening() {
        return noRekening;
    }

    public void setNoRekening(String noRekening) {
        this.noRekening = noRekening;
    }

    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }
}
