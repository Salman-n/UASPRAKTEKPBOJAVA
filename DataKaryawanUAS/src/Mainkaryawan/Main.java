/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mainkaryawan;

import Abstrak.GajiPokok;
import Kelas.GolonganA;
import Kelas.GolonganB;
import Kelas.GolonganC;
import Model.Karyawan;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Salman W K3520070
 */
public class Main {
    static Scanner scan;
    static ArrayList<Karyawan> karyawans = new ArrayList<Karyawan>();
    public static void main(String[] args)  {
	// write your code here
        scan = new Scanner(System.in);
        menu();
    }

    private static void menu() {
        while(true) {
            print("Menu Aplikasi");
            print("1.Tambah Data");
            print("2.Hapus Data");
            print("3.Cari Data");
            print("4.Lihat Data");
            print("5.Exit");
            print("Menu Pilihan : ",false);;
            int pilihan = scan.nextInt();
            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    hapusData();
                    break;
                case 3:
                    cariData();
                    break;
                case 4:
                    lihatData();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    print("Input tidak valid");

            }
        }
    }
    private static void tambahData() {

        OUTER:
        while (true) {
            scan = new Scanner(System.in);
            print("Masukan Kode Karyawan    : ", false);
            String kode = scan.nextLine();
            print("Masukan Nama Karyawan    : ", false);
            String nama = scan.nextLine();
            print("Masukan Alamat           : ", false);
            String alamat = scan.nextLine();
            print("Masukan Tanggal Lahir    : ", false);
            String lahir = scan.nextLine();
            print("Masukan Golongan (A/B/C) : ", false);
            String golongan = scan.nextLine().toUpperCase(Locale.ROOT);
            if (!golongan.equals("A") && !golongan.equals("B") && !golongan.equals("C")) {
                print("Golongan Tidak Valid");
                continue;
            }
            print("Masukan Status Menikah   : ", false);
            String hubungan = scan.nextLine();
            print("Masukan Jumlah Anak      : ", false);
            scan = new Scanner(System.in);
            int anak = scan.nextInt();
            GajiPokok gajiPokok = new GolonganA();
            if (golongan.equals("B")) {
                gajiPokok = new GolonganB();
            } else if (golongan.equals("C")) {
                gajiPokok = new GolonganC();
            }
            Karyawan karyawan = new Karyawan(kode,nama,alamat,lahir,gajiPokok,hubungan,anak);
            karyawans.add(karyawan);
            print(" ");
            print("Data berhasil ditambahkan!");
            print("1.Kembali ke menu utama");
            print("2.Tambah data kembali");
            print("Menu Pilihan: ",false);
            int pilihan = scan.nextInt();
            switch (pilihan) {
                case 1:
                    break OUTER;
                case 2:
                    continue;
                default:
                    print("Input Tidak Valid");
                    break OUTER;
            }
        }
    }
    private static void hapusData() {
        while (true){
            scan = new Scanner(System.in);

        print("Masukan Kode Karyawan untuk dihapus: ");
        String kode = scan.nextLine();
        karyawans.removeIf(karyawan -> karyawan.getKode().equals(kode));
            print("Data berhasil dihapus!");
            print("1.Kembali ke menu utama");
            print("2.hapus data kembali");
            int pilihan = scan.nextInt();
            if (pilihan == 1) {
                break;
            } else if (pilihan == 2) {
                continue;
            } else {
                print("Input Tidak Valid");

                break;
            }
        }
    }
    private static void cariData() {
        scan = new Scanner(System.in);
        print("Masukan Kode karyawan: ");
        String kode = scan.nextLine();
        karyawans.forEach((karyawan) -> {

            if (karyawan.getKode().equals(kode)) {
                String golongan = "A";
                if (karyawan.getGolongan().hitungGaji() == 6000000.00) {
                    golongan = "B";
                } else if  (karyawan.getGolongan().hitungGaji() == 7000000.00) {
                    golongan = "C";
                }
                Date d = new Date();
                int year = Calendar.getInstance().get(Calendar.YEAR);
                int tahunlahir = Integer.valueOf(karyawan.getLahir().substring(karyawan.getLahir().length() - 4));
                String usia = String.valueOf(year - tahunlahir);

                double tunjanganpasangan = 0.00;
                if (karyawan.getHubungan().toLowerCase().equals("menikah")) {
                    tunjanganpasangan = karyawan.getGolongan().hitungGaji() * 0.1;
                }
                double tunjanganpegawai = 0.00;
                if (Integer.valueOf(usia) > 30) {
                    tunjanganpegawai = karyawan.getGolongan().hitungGaji() * 0.15;
                }
                double ttunjangananak = karyawan.getGolongan().hitungGaji() * 0.05 * karyawan.getAnak();
                double gajikotor = karyawan.getGolongan().hitungGaji() + tunjanganpasangan + tunjanganpegawai + ttunjangananak;
                double gajibersih = gajikotor * 0.975 ;
                double potongan = gajikotor - gajibersih;
                print("==================================");
                print("Data Karyawan");
                print("------------------------------");
                print("Kode Karyawan            : " + karyawan.getKode());
                print("Nama Karyawan            : " + karyawan.getNama());
                print("Golongan Karyawan        : " + golongan);
                print("Usia                     : " + usia);
                print("Status Menikah           : " + karyawan.getHubungan());
                print("Jumlah Anak              : " + karyawan.getAnak());
                print("----------------------------------");
                print("Gaji Pokok               : Rp " + karyawan.getGolongan().hitungGaji() );
                print("Tunjangan suami/istri    : Rp" + tunjanganpasangan);
                print("Tunjangan pegawai        : Rp" + tunjanganpegawai);
                print("Tunjangan anak           : Rp" + ttunjangananak);
                print("---------------------------------------------");
                print("Gaji Kotor               : Rp " + gajikotor);
                print("Potongan                 : Rp " + potongan);
                print("Gaji Bersih              : Rp " + gajibersih);


            }

        });
        print("Pilih Submenu");
        print("1. Kembali ke menu utama");
        int pilihan = scan.nextInt();
    }
    private static void lihatData() {
        print("=======================================================================================");
        print("DATA KARYAWAN");
        print("---------------------------------------------------------------------------------------");
        print("KODE KARY\tNAMA KARY\tGOL\tUSIA\tSTATUS NIKAH\t\tJUMLAH ANAK");
        print("---------------------------------------------------------------------------------------");
        karyawans.forEach((karyawan) -> {
            String golongan = "A";
            if (karyawan.getGolongan().hitungGaji() == 6000000.00) {
                golongan = "B";
            } else if  (karyawan.getGolongan().hitungGaji() == 7000000.00) {
                golongan = "C";
            }
            Date d=new Date();
            int year = Calendar.getInstance().get(Calendar.YEAR);
            int tahunlahir = Integer.valueOf(karyawan.getLahir().substring(karyawan.getLahir().length() - 4));
            String usia = String.valueOf(year - tahunlahir);
            print(karyawan.getKode()+ "\t" + "\t" + karyawan.getNama() + "\t" + "\t" + golongan + "\t" + usia + "\t" + karyawan.getHubungan() + "\t" + "\t" + "\t" + karyawan.getAnak()  );
        });
        print("Pilih Submenu");
        print("1. Kembali ke menu utama");
        int pilihan = scan.nextInt();
    }

    private static void print(String message ) {
        System.out.println(message);
    }
    private static void print(String message,Boolean newline ) {
        if (newline) {
            System.out.println(message);
        } else {
            System.out.print(message);
        }

    }
}
