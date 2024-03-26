import java.util.ArrayList;
import java.util.Scanner;

public class KedaiTapukan {

    private static ArrayList<BahanBaku> daftarBahanBaku = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            tampilkanMenu();
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tambahBahanBaku();
                    break;
                case 2:
                    tampilkanDaftarBahanBaku();
                    break;
                case 3:
                    ubahBahanBaku();
                    break;
                case 4:
                    hapusBahanBaku();
                    break;
                case 5:
                    keluarProgram();
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    delay();
            }
        }
    }

    private static void tampilkanMenu() {
        System.out.println("=== Sistem Pendataan Bahan Baku Mocktail Kedai Tapukan ===");
        System.out.println("1. Tambah Bahan Baku");
        System.out.println("2. Tampilkan Daftar Bahan Baku");
        System.out.println("3. Ubah Bahan Baku");
        System.out.println("4. Hapus Bahan Baku");
        System.out.println("5. Keluar Program");
        System.out.print("Masukkan pilihan: ");
    }

    private static void tambahBahanBaku() {
        System.out.println("=== Tambah Bahan Baku ===");
        System.out.print("Nama Bahan Baku: ");
        scanner.nextLine();
        String nama = scanner.nextLine();
        nama = nama.trim();
        System.out.print("Jumlah Stok: ");
        int stok = scanner.nextInt();
        System.out.print("Satuan Stok: ");
        scanner.nextLine();
        String satuan = scanner.nextLine();
        satuan = satuan.trim();

        // Meminta jenis bahan baku
        System.out.print("Jenis (Cair/Padat): ");
        String jenis = scanner.nextLine();

        if (jenis.equalsIgnoreCase("cair")) {
            // Menambah bahan baku cair
            System.out.print("Tipe: ");
            String tipe = scanner.nextLine();
            BahanBakuCair bahanBaku = new BahanBakuCair(nama, stok, satuan, tipe);
            daftarBahanBaku.add(bahanBaku);
        } else if (jenis.equalsIgnoreCase("padat")) {
            // Menambah bahan baku padat
            System.out.print("Bentuk: ");
            String bentuk = scanner.nextLine();
            BahanBakuPadat bahanBaku = new BahanBakuPadat(nama, stok, satuan, bentuk);
            daftarBahanBaku.add(bahanBaku);
        } else {
            System.out.println("Jenis bahan baku tidak valid!");
        }

        System.out.println("Bahan Baku berhasil ditambahkan!");
        delay();
    }

    private static BahanBaku findBahanBakuByName(String nama) {
      for (BahanBaku bahanBaku : daftarBahanBaku) {
          if (bahanBaku.getNama().equalsIgnoreCase(nama)) {
              return bahanBaku;
          }
      }
      return null; // Mengembalikan null jika bahan baku tidak ditemukan
  }
  

    private static void tampilkanDaftarBahanBaku() {
        System.out.println();
        System.out.println();
        if (daftarBahanBaku.isEmpty()) {
            System.out.println("Belum ada data bahan baku!");
            delay();
            return;
        }

        System.out.println("===Daftar Bahan Baku===");
        for (BahanBaku bahanBaku : daftarBahanBaku) {
            if (bahanBaku instanceof BahanBakuCair) {
                BahanBakuCair bahanBakuCair = (BahanBakuCair) bahanBaku;
                System.out.println("Nama: " + bahanBakuCair.getNama());
                System.out.println("Jenis: Cair");
                System.out.println("Jenis: " + bahanBakuCair.getJenis());
                System.out.println("Stok: " + bahanBakuCair.getStok());
                System.out.println("Satuan: " + bahanBakuCair.getSatuan());
            } else if (bahanBaku instanceof BahanBakuPadat) {
                BahanBakuPadat bahanBakuPadat = (BahanBakuPadat) bahanBaku;
                System.out.println("Nama: " + bahanBakuPadat.getNama());
                System.out.println("Jenis: Padat");
                System.out.println("Bentuk: " + bahanBakuPadat.getBentuk());
                System.out.println("Stok: " + bahanBakuPadat.getStok());
                System.out.println("Satuan: " + bahanBakuPadat.getSatuan());
            }
        }
        delay();
    }

    private static void ubahBahanBaku() {
      if (daftarBahanBaku.isEmpty()) {
          System.out.println("Belum ada data bahan baku!");
          delay();
          return;
      }
  
      System.out.println("=== Daftar Bahan Baku ===");
      for (BahanBaku bahanBaku : daftarBahanBaku) {
          System.out.println("Nama: " + bahanBaku.getNama());
      }
      System.out.println("=== Ubah Bahan Baku ===");
      System.out.print("Masukkan nama bahan baku yang ingin diubah: ");
      scanner.nextLine();
      String namaLama = scanner.nextLine();
    
      BahanBaku bahanBaku = findBahanBakuByName(namaLama);
      if (bahanBaku == null) {
        System.out.println("Bahan Baku tidak ditemukan!");
        delay();
        return;
      }
    
      System.out.print("Masukkan nama baru: ");
      String namaBaru = scanner.nextLine();
    
      System.out.print("Jumlah Stok Baru: ");
      int stok = scanner.nextInt();
    
      System.out.print("Satuan Stok Baru: ");
      scanner.nextLine();
      String satuan = scanner.nextLine();
    
      if (bahanBaku instanceof BahanBakuCair) {
          BahanBakuCair bahanBakuCair = (BahanBakuCair) bahanBaku;
          System.out.print("Tipe Baru: ");
          String tipe = scanner.nextLine();
          bahanBakuCair.setJenis(tipe);
      } else if (bahanBaku instanceof BahanBakuPadat) {
          BahanBakuPadat bahanBakuPadat = (BahanBakuPadat) bahanBaku;
          System.out.print("Bentuk Baru: ");
          String bentuk = scanner.nextLine();
          bahanBakuPadat.setBentuk(bentuk);
      }
    
      bahanBaku.setNama(namaBaru);
      bahanBaku.setStok(stok);
      bahanBaku.setSatuan(satuan);
    
      System.out.println("Bahan Baku berhasil diubah!");
      delay();
  }
  
  private static void hapusBahanBaku() {
      if (daftarBahanBaku.isEmpty()) {
          System.out.println("Belum ada data bahan baku!");
          delay();
          return;
      }
  
      System.out.println("=== Daftar Bahan Baku ===");
      for (BahanBaku bahanBaku : daftarBahanBaku) {
          System.out.println("Nama: " + bahanBaku.getNama());
      }
      System.out.println();
      System.out.println("=== Hapus Bahan Baku ===");
      System.out.println();
      System.out.print("Masukkan nama bahan baku yang ingin dihapus: ");
      scanner.nextLine();
      String nama = scanner.nextLine();
  
      BahanBaku bahanBaku = findBahanBakuByName(nama);
      if (bahanBaku == null) {
          System.out.println("Bahan Baku tidak ditemukan!");
          delay();
          return;
      }
  
      daftarBahanBaku.remove(bahanBaku);
      if (daftarBahanBaku.isEmpty()) {
          System.out.println("Belum ada data bahan baku!");
          delay();
          return;
      }
      
      System.out.println("Bahan Baku berhasil dihapus!");
      delay();
  }
  

    private static void keluarProgram() {
        System.out.println("Terima kasih telah menggunakan program ini!");
        delay();
        System.exit(0);
    }

    private static void delay() {
        try {
            Thread.sleep(2000); // Delay selama 2 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
