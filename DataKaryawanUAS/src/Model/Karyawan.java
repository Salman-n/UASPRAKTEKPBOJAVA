/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Salman W K3520070
 */


import Abstrak.GajiPokok;

public class Karyawan{
    private String kode;
    private String nama;
    private String alamat;
    private String lahir;
    private GajiPokok golongan;
    private String hubungan;
    private int anak;

    public Karyawan(String kode, String nama, String alamat, String lahir, GajiPokok golongan, String hubungan, int anak) {
        this.kode = kode;
        this.nama = nama;
        this.alamat = alamat;
        this.lahir = lahir;
        this.golongan = golongan;
        this.hubungan = hubungan;
        this.anak = anak;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getLahir() {
        return lahir;
    }

    public void setLahir(String lahir) {
        this.lahir = lahir;
    }

    public GajiPokok getGolongan() {
        return golongan;
    }

    public void setGolongan(GajiPokok golongan) {
        this.golongan = golongan;
    }

    public String getHubungan() {
        return hubungan;
    }

    public void setHubungan(String hubungan) {
        this.hubungan = hubungan;
    }

    public int getAnak() {
        return anak;
    }

    public void setAnak(int anak) {
        this.anak = anak;
    }
}

