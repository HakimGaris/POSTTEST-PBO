// Kelas turunan kedua (Subclass)
public class BahanBakuPadat extends BahanBaku {
    private String bentuk;

    public BahanBakuPadat(String nama, int stok, String satuan, String bentuk) {
        super(nama, stok, satuan);
        this.bentuk = bentuk;
    }

    // getters dan setters khusus untuk BahanBakuPadat
    public String getBentuk() {
        return bentuk;
    }

    public void setBentuk(String bentuk) {
        this.bentuk = bentuk;
    }

    // Fungsi override untuk mencetak informasi tambahan
    @Override
    public String toString() {
        return "Nama: " + getNama() + "\n" +
                "Jenis: Padat\n" +
                "Bentuk: " + getBentuk() + "\n" +
                "Stok: " + getStok() + "\n" +
                "Satuan: " + getSatuan() + "\n";
    }
}
