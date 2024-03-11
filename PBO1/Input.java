package PBO1;

import java.util.Scanner;

public class Input {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mencetak pesan untuk memasukkan nama
        System.out.print("Masukkan nama Anda: ");

        // Membaca seluruh baris input, termasuk spasi
        String nama = scanner.nextLine();

        // Mencetak nama yang telah diinput
        System.out.println("Nama Anda adalah: " + nama);
    }
}
