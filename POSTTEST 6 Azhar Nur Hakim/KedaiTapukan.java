import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class KedaiTapukan {

    private static final ArrayList<BahanBaku> daftarBahanBaku = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static int jumlahBahanBaku = 0;

    public static int getJumlahBahanBaku() {
        return jumlahBahanBaku;
    }
    
    public static void main(String[] args) {
        while (true) {
            tampilkanMenu();
            int pilihan;
            while (true) {
                try {
                    pilihan = scanner.nextInt();
                    if (pilihan < 0) {
                        throw new IllegalArgumentException("angka pilihan tidak boleh negatif!");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Masukkan harus berupa angka!");
                    scanner.nextLine(); // Membersihkan buffer
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                System.out.print("Masukkan jumlah pilihan yang valid: ");
            }

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
                    kurangiStokBahanBaku();
                    break;
                case 6:
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
        System.out.println("5. Mengurangi jumlah Stock");
        System.out.println("6. Keluar Program");
        System.out.print("Masukkan pilihan: ");
    }

    private static void tambahBahanBaku() {
        System.out.println("=== Tambah Bahan Baku ===");

        System.out.print("Nama Bahan Baku: ");
        scanner.nextLine();
        String nama = scanner.nextLine();
        nama = nama.trim();

        System.out.print("Jumlah Stok: ");
        int stok;
        while (true) {
            try {
                stok = scanner.nextInt();
                if (stok < 0) {
                    throw new IllegalArgumentException("Jumlah stok tidak boleh negatif!");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Masukkan harus berupa angka!");
                scanner.nextLine(); // Membersihkan buffer
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.print("Masukkan jumlah stok yang valid: ");
        }
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
        jumlahBahanBaku++;
        delay();
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
            System.out.println(bahanBaku.toString());
        }
        System.out.println("Total Bahan Baku: " + jumlahBahanBaku);
        delay();
    }

    private static void ubahBahanBaku() {
        if (daftarBahanBaku.isEmpty()) {
            System.out.println("Belum ada data bahan baku!");
            delay();
            return;
        }
    
        System.out.println("=== Pilih Jenis Bahan Baku ===");
        System.out.println("1. Bahan Baku Cair");
        System.out.println("2. Bahan Baku Padat");
        System.out.print("Masukkan pilihan: ");
        int jenisPilihan = scanner.nextInt();
    
        scanner.nextLine(); // Membersihkan newline
    
        switch (jenisPilihan) {
            case 1:
                tampilkanDaftarBahanBakuCair();
                ubahBahanBakuCair();
                break;
    
            case 2:
                tampilkanDaftarBahanBakuPadat();
                ubahBahanBakuPadat();
                break;
    
            default:
                System.out.println("Pilihan tidak valid!");
                delay();
                return;
        }
    
        delay();
    }
    
    private static void ubahBahanBakuCair() {
        System.out.println("=== Ubah Bahan Baku Cair ===");
        System.out.print("Masukkan nama bahan baku yang ingin diubah: ");
        String namaLama = scanner.nextLine();
        System.out.println("");
        System.out.println("");
        System.out.println("");
    
        BahanBakuCair bahanBakuCair = null;
    
        for (BahanBaku bahanBaku : daftarBahanBaku) {
            if (bahanBaku instanceof BahanBakuCair && bahanBaku.getNama().equalsIgnoreCase(namaLama)) {
                bahanBakuCair = (BahanBakuCair) bahanBaku;
                break;
            }
        }
    
        if (bahanBakuCair == null) {
            System.out.println("Bahan Baku Cair tidak ditemukan!");
            return;
        }
    
        // Menampilkan detail bahan baku cair yang dipilih
        System.out.println("=== Detail Bahan Baku Cair ===");
        System.out.println("Nama: " + bahanBakuCair.getNama());
        System.out.println("Jumlah Stok: " + bahanBakuCair.getStok());
        System.out.println("Satuan Stok: " + bahanBakuCair.getSatuan());
        System.out.println("Tipe: " + bahanBakuCair.getJenis());
    
        // Meminta pengguna untuk memasukkan data baru
        System.out.println("");
        System.out.println("");
        System.out.print("Masukkan nama baru: ");
        String namaBaru = scanner.nextLine();
    
        System.out.print("Jumlah Stok Baru: ");
        int stok = scanner.nextInt();
    
        System.out.print("Satuan Stok Baru: ");
        scanner.nextLine(); // Membersihkan newline
        String satuan = scanner.nextLine();
    
        System.out.print("Tipe Baru: ");
        String tipe = scanner.nextLine();
    
        // Menggunakan setter pada objek BahanBakuCair untuk mengubah data
        bahanBakuCair.setNama(namaBaru);
        bahanBakuCair.setStok(stok);
        bahanBakuCair.setSatuan(satuan);
        bahanBakuCair.setJenis(tipe);
    
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Bahan Baku Cair berhasil diubah!");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    
        // Menampilkan daftar bahan baku cair setelah perubahan
        tampilkanDaftarBahanBakuCair();
    }
    
    private static void ubahBahanBakuPadat() {
        System.out.println("=== Ubah Bahan Baku Padat ===");
        System.out.print("Masukkan nama bahan baku yang ingin diubah: ");
        String namaLama = scanner.nextLine();
        System.out.println("");
        System.out.println("");
        System.out.println("");
    
        BahanBakuPadat bahanBakuPadat = null;
    
        for (BahanBaku bahanBaku : daftarBahanBaku) {
            if (bahanBaku instanceof BahanBakuPadat && bahanBaku.getNama().equalsIgnoreCase(namaLama)) {
                bahanBakuPadat = (BahanBakuPadat) bahanBaku;
                break;
            }
        }
    
        if (bahanBakuPadat == null) {
            System.out.println("Bahan Baku Padat tidak ditemukan!");
            return;
        }
    
        // Menampilkan detail bahan baku padat yang dipilih
        System.out.println("=== Detail Bahan Baku Padat ===");
        System.out.println("Nama: " + bahanBakuPadat.getNama());
        System.out.println("Jumlah Stok: " + bahanBakuPadat.getStok());
        System.out.println("Satuan Stok: " + bahanBakuPadat.getSatuan());
        System.out.println("Bentuk: " + bahanBakuPadat.getBentuk());
    
        // Meminta pengguna untuk memasukkan data baru
        System.out.println("");
        System.out.println("");
        System.out.print("Masukkan nama baru: ");
        String namaBaru = scanner.nextLine();
    
        System.out.print("Jumlah Stok Baru: ");
        int stok = scanner.nextInt();
    
        System.out.print("Satuan Stok Baru: ");
        scanner.nextLine(); // Membersihkan newline
        String satuan = scanner.nextLine();
    
        System.out.print("Bentuk Baru: ");
        String bentuk = scanner.nextLine();
    
        // Menggunakan setter pada objek BahanBakuPadat untuk mengubah data
        bahanBakuPadat.setNama(namaBaru);
        bahanBakuPadat.setStok(stok);
        bahanBakuPadat.setSatuan(satuan);
        bahanBakuPadat.setBentuk(bentuk);
    
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Bahan Baku Padat berhasil diubah!");
        System.out.println("");
        System.out.println("");
        System.out.println("");
    
        // Menampilkan daftar bahan baku padat setelah perubahan
        tampilkanDaftarBahanBakuPadat();
    }
    
    private static void tampilkanDaftarBahanBakuCair() {
        System.out.println("=== Daftar Bahan Baku Cair ===");
        for (BahanBaku bahanBaku : daftarBahanBaku) {
            if (bahanBaku instanceof BahanBakuCair) {
                System.out.println(bahanBaku);
            }
        }
    }
    
    private static void tampilkanDaftarBahanBakuPadat() {
        System.out.println("=== Daftar Bahan Baku Padat ===");
        for (BahanBaku bahanBaku : daftarBahanBaku) {
            if (bahanBaku instanceof BahanBakuPadat) {
                System.out.println(bahanBaku);
            }
        }
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
        System.out.println("Bahan Baku berhasil dihapus!");
        jumlahBahanBaku--;
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

    private static BahanBaku findBahanBakuByName(String nama) {
        for (BahanBaku bahanBaku : daftarBahanBaku) {
            if (bahanBaku.getNama().equalsIgnoreCase(nama)) {
                return bahanBaku;
            }
        }
        return null; // Mengembalikan null jika bahan baku tidak ditemukan
    }

    private static void kurangiStokBahanBaku() {
        if (daftarBahanBaku.isEmpty()) {
            System.out.println("Belum ada data bahan baku!");
            delay();
            return;
        }
        
        System.out.println("=== Daftar Bahan Baku ===");
        for (BahanBaku bahanBaku : daftarBahanBaku) {
            System.out.println("- " + bahanBaku.getNama());
        }
        
        System.out.println("=== Kurangi Stok Bahan Baku ===");
        System.out.print("Masukkan nama bahan baku yang ingin dikurangi stoknya: ");
        scanner.nextLine();
        String nama = scanner.nextLine();
        BahanBaku bahanBaku = findBahanBakuByName(nama);
    
        if (bahanBaku == null) {
            System.out.println("Bahan Baku tidak ditemukan!");
            delay();
            return;
        }
    
        // Tampilkan detail bahan baku sebelum pengurangan stok
        System.out.println("=== Detail Bahan Baku ===");
        System.out.println("Nama: " + bahanBaku.getNama());
        System.out.println("Stok saat ini: " + bahanBaku.getStok());
    
        // Meminta input jumlah stok yang akan dikurangi
        System.out.print("Masukkan jumlah stok yang ingin dikurangi: ");
        int jumlahKurang = scanner.nextInt();
    
        try {
            // Kurangi stok bahan baku menggunakan method dari interface StokManager
            ((StokManager) bahanBaku).kurangiStok(jumlahKurang);
            System.out.println("Stok berhasil dikurangi!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    
        delay();
    }
    
}
