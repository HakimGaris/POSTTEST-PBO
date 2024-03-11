package PBO1;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pertemuan1 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> data = new ArrayList<>();

        // int dataw[] = new int[]{1,2,3,4,5,6,7,8,9};
        // 10 int;

        // dataw.add();

        data.add(12);
        data.add(15);
        data.add(19);

        System.out.print("masukkan angka : ");
        data.add(Integer.parseInt(input.readLine()));

        for (int i : data){
            System.out.println(i);
        }

        for (int i = 0; i < data.size(); i++){
            System.out.println("Perulangan ke - " + i);
        }

        // Scanner inout = new Scanner(System.in);
        // System.out.print("masukkan nama : ");
        // String nama = input.readLine();
        // System.out.print("masukkan umur : ");
        // // int umur = Integer.parseInt(input.readLine());
        // float umur = Float.parseFloat(input.readLine());

        // System.out.println("Nama anda : " + nama);
        // System.out.println("umur anda : " + umur);

        //========================================

        // String nama;
        // int umur;

        // Scanner inputScanner = new Scanner(System.in);
        // System.out.print("Masukkan Nama: ");
        // nama = inputScanner.nextLine();
        // System.out.print("Masukkan Umur: ");
        // umur = inputScanner.nextInt();
        // System.out.println("====================");
        // System.out.println("Nama Karyawan: " + nama);
        // System.out.println("Umur Karyawan: " + umur);
    }
}