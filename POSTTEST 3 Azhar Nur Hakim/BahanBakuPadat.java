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
  }