public abstract class BahanBaku {
    private String nama;
    private int stok;
    private String satuan;

    public BahanBaku(String nama, int stok, String satuan) {
        this.nama = nama;
        this.stok = stok;
        this.satuan = satuan;
    }

    // Getter dan setter untuk nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter dan setter untuk stok
    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    // Getter dan setter untuk satuan
    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    // Metode abstrak untuk tambahStok (didefinisikan ulang di subclass)
    public abstract void tambahStok(int jumlah);

    // Metode abstrak untuk toString (didefinisikan ulang di subclass)
    @Override
    public abstract String toString();
}
