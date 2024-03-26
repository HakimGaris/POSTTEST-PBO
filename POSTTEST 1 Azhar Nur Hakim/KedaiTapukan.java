package PBO1;

import java.util.ArrayList;
import java.util.Scanner;

public class KedaiTapukan {

    private static ArrayList<BahanBaku> daftarBahanBaku = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Menampilkan menu
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
                    try {
                        System.out.println();
                        System.out.println();
                        System.out.println("Delay");
        
                        Thread.sleep(2000); // timesleep 3 detik
                      } catch (InterruptedException e) {
                        e.printStackTrace();
                      }
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

        BahanBaku bahanBaku = new BahanBaku(nama, stok, satuan);
        daftarBahanBaku.add(bahanBaku);

        System.out.println("Bahan Baku berhasil ditambahkan!");
    }

    private static void tampilkanDaftarBahanBaku() {
        System.out.println();
        System.out.println();
        if (daftarBahanBaku.isEmpty()) {
            System.out.println("Belum ada data bahan baku!");
            try {
                System.out.println();
                System.out.println();
                System.out.println("Delay");

                Thread.sleep(2000); // timesleep 3 detik
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            return;
        }
    
        for (BahanBaku bahanBaku : daftarBahanBaku) {
            System.out.println("Nama: " + bahanBaku.getNama());
            System.out.println("Stok: " + bahanBaku.getStok());
            System.out.println("Satuan: " + bahanBaku.getSatuan());
        }
        try {
            System.out.println();
            System.out.println("Delay");
            System.out.println();
            Thread.sleep(2000); // timesleep 3 detik
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
    }
    

    private static void ubahBahanBaku() {
        if (daftarBahanBaku.isEmpty()) {
            System.out.println("Belum ada data bahan baku!");
            try {
                System.out.println();
                System.out.println();
                System.out.println("Delay");

                Thread.sleep(2000); // timesleep 3 detik
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
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
          try {
            System.out.println();
            System.out.println();
            System.out.println("Delay");
            Thread.sleep(2000); // timesleep 3 detik
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          return;
        }
      
        System.out.print("Masukkan nama baru: ");
        String namaBaru = scanner.nextLine();
      
        System.out.print("Jumlah Stok Baru: ");
        int stok = scanner.nextInt();
      
        System.out.print("Satuan Stok Baru: ");
        scanner.nextLine();
        String satuan = scanner.nextLine();
      
        bahanBaku.setNama(namaBaru);
        bahanBaku.setStok(stok);
        bahanBaku.setSatuan(satuan);
      
        System.out.println("Bahan Baku berhasil diubah!");
        try {
            System.out.println();
            System.out.println();
            System.out.println("Delay");
            Thread.sleep(2000); // timesleep 3 detik
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
    }

      
    private static void hapusBahanBaku() {
        if (daftarBahanBaku.isEmpty()) {
            System.out.println("Belum ada data bahan baku!");
            try {
                System.out.println();
                System.out.println();
                System.out.println("Delay");

                Thread.sleep(2000); // timesleep 3 detik
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
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
            try {
                System.out.println();
                System.out.println();
                System.out.println("Delay");
                Thread.sleep(2000); // timesleep 3 detik
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            return;
        }

        daftarBahanBaku.remove(bahanBaku);
        if (daftarBahanBaku.isEmpty()) {
            System.out.println("Belum ada data bahan baku!");
            try {
                System.out.println();
                System.out.println();
                System.out.println("Delay");

                Thread.sleep(2000); // timesleep 3 detik
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            return;
        }
        
        System.out.println("Bahan Baku berhasil dihapus!");
        try {
            System.out.println();
            System.out.println();
            System.out.println("Delay");
            Thread.sleep(2000); // timesleep 3 detik
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
    }

    private static void keluarProgram() {
        System.out.println("Terima kasih telah menggunakan program ini!");
        System.out.println();
        System.out.println();
        System.out.println();
        System.exit(0);
    }

    private static BahanBaku findBahanBakuByName(String nama) {
        for (BahanBaku bahanBaku : daftarBahanBaku) {
            if (bahanBaku.getNama().equals(nama)) {
                return bahanBaku;
            }
        }
        return null;
    }
}

class BahanBaku {

    private String nama;
    private int stok;
    private String satuan;

public BahanBaku(String nama, int stok, String satuan) {
    this.nama = nama;
    this.stok = stok;
    this.satuan = satuan;
}

public String getNama() {
    return nama;
}

public void setNama(String nama) {
    this.nama = nama;
}

public int getStok() {
    return stok;
}

public void setStok(int stok) {
    this.stok = stok;
}

public String getSatuan() {
    return satuan;
}

public void setSatuan(String satuan) {
    this.satuan = satuan;
}
}



