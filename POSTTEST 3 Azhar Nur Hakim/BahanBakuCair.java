public class BahanBakuCair extends BahanBaku {
  private String jenis;
  

  public BahanBakuCair(String nama, int stok, String satuan, String jenis) {
      super(nama, stok, satuan);
      this.jenis = jenis;
  }

  // getters dan setters khusus untuk BahanBakuCair
  public String getJenis() {
      return jenis;
  }

  public void setJenis(String jenis) {
      this.jenis = jenis;
  }
}