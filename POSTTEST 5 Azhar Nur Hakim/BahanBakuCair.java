public class BahanBakuCair extends BahanBaku {
    private String jenis;

    public BahanBakuCair(String nama, int stok, String satuan, String jenis) {
        super(nama, stok, satuan);
        this.jenis = jenis;
    }

    // Getter dan setter khusus untuk jenis
    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
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
                "Jenis: Cair\n" +
                "Jenis: " + getJenis() + "\n" +
                "Stok: " + getStok() + "\n" +
                "Satuan: " + getSatuan() + "\n";
    }
}
