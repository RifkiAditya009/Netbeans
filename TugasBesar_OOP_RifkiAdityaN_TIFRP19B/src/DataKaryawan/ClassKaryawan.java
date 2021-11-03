/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataKaryawan;

import java.util.Date;

/**
 *
 * @author acer_
 */
public abstract class ClassKaryawan {
    
    //deklare Var
    private String idKaryawan, namaKaryawan, divisi, gender, status, noKtp, alamat, noTelp, tglLahir;
    
    //constructor
    ClassKaryawan(){
        
    }
    
    ClassKaryawan(String idKaryawan, String namaKaryawan, String divisi, String gender, String status, 
                  String noKtp, String alamat, String noTelp, String tglLahir){
        this.idKaryawan = idKaryawan;
        this.namaKaryawan = namaKaryawan;
        this.divisi = divisi;
        this.gender = gender;
        this.status = status;
        this.noKtp = noKtp;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.tglLahir = tglLahir;
    }
    
    //setter
    public void setidKar(String id){
        this.idKaryawan = id;
    }
    public void setnamaKar(String nama){
        this.namaKaryawan = nama;
    }
    public void setdivisi(String div){
        this.divisi = div;
    }
    public void setgender(String gender){
        this.gender = gender;
    }
    public void setstatus(String status){
        this.status = status;
    }
    public void setnoKtp(String ktp){
        this.noKtp = ktp;
    }
    public void setalamat(String alamat){
        this.alamat = alamat;
    }
    public void setTelpKar(String telp){
        this.noTelp = telp;
    }
    public void setTglLahir(String tgllahir){
        this.tglLahir = tgllahir;
    }
    
    //getter
    public String getidKar(){
        return idKaryawan;
    }
    public String getnamaKar(){
        return namaKaryawan;
    }
    public String getdivisi(){
        return divisi;
    }
    public String getgender(){
        return gender;
    }
    public String getstatus(){
        return status;
    }
    public String getnoKtp(){
        return noKtp;
    }
    public String getalamat(){
        return alamat;
    }
    public String getTelpKar(){
        return noTelp;
    }
    public String getTglLahir(){
        return tglLahir;
    }
}
