public class BahanBakuPadat extends BahanBaku implements StokManager{
    private String bentuk;

    public BahanBakuPadat(String nama, int stok, String satuan, String bentuk) {
        super(nama, stok, satuan);
        this.bentuk = bentuk;
    }

    // Getter dan setter khusus untuk bentuk
    public String getBentuk() {
        return bentuk;
    }

    public void setBentuk(String bentuk) {
        this.bentuk = bentuk;
    }

    // Implementasi untuk menambah stok secara absolut
    @Override
    public void tambahStok(int jumlah) {
        setStok(getStok() + jumlah);
    }

    // Implementasi untuk representasi String
    @Override
    public String toString() {
        return "Nama: " + getNama() + "\n" +
                "Jenis: Padat\n" +
                "Bentuk: " + getBentuk() + "\n" +
                "Stok: " + getStok() + "\n" +
                "Satuan: " + getSatuan() + "\n";
    }

    @Override
    public void kurangiStok(int jumlah) throws IllegalArgumentException {
        if (jumlah < 0 || jumlah > getStok()) {
            throw new IllegalArgumentException("Jumlah stok yang dimasukkan tidak valid atau melebihi stok yang tersedia");
        }
        setStok(getStok() - jumlah);
    }
}
