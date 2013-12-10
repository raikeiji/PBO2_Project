/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyekpbo2;

import java.io.Serializable;

/**
 *
 * @author Echo
 */
public class Data implements Serializable {

    private String nama, noId, tempatLahir, alamat, pekerjaan, keterangan, namaPers,
            hariTanggalLahir, bulanTanggalLahir, tahunTanggalLahir, noTlp, email, umur;
    private Object jKel;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoId() {
        return noId;
    }

    public void setNoId(String noId) {
        this.noId = noId;
    }

    public Object getjKel() {
        return jKel;
    }

    public void setjKel(Object jKel) {
        this.jKel = jKel;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return hariTanggalLahir+"/"+bulanTanggalLahir+"/"+tahunTanggalLahir;
    }

    public void setTanggalLahir(String hariTanggalLahir, String bulanTanggalLahir, String tahunTanggalLahir) {
        this.hariTanggalLahir = hariTanggalLahir;
        this.bulanTanggalLahir = bulanTanggalLahir;
        this.tahunTanggalLahir = tahunTanggalLahir;
    }
    
    public String getHariTanggalLahir(){
        return hariTanggalLahir;
    }
    
    public String getBulanTanggalLahir(){
        return bulanTanggalLahir;
    }
    
    public String getTahunTanggalLahir(){
        return tahunTanggalLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTlp() {
        return noTlp;
    }

    public void setNoTlp(String noTlp) {
        this.noTlp = noTlp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNamaPers() {
        return namaPers;
    }

    public void setNamaPers(String namaPers) {
        this.namaPers = namaPers;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }
    
    
}
