public class BahanBaku {
    // Ini adalah enkapsulasi
    private String nama;
    private int stok;
    private String satuan;

public BahanBaku(String nama, int stok, String satuan) {
  this.nama = nama;
  this.stok = stok;
  this.satuan = satuan;
}

// Getter nama barang 
public String getNama() {
  return nama;
}

// Setter nama barang
public void setNama(String nama) {
  this.nama = nama;
}

// Getter stok
public int getStok() {
  return stok;
}

// Setter stok
public void setStok(int stok) {
  this.stok = stok;
}

// Getter satuan
public String getSatuan() {
  return satuan;
}

//Setter satuan
public void setSatuan(String satuan) {
  this.satuan = satuan;
}
}
