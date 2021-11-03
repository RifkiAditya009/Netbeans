/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTransaksi;

/**
 *
 * @author acer_
 */
public abstract class ClassTransaksi {
    
    //deklare var
    private String noTransaksi, idKaryawan, namaKaryawan, tglTransaksi, kodeArticle, namaProduk, idPelanggan, namaPelanggan,
                    harga, qty, jumlah, hargaTotal;
    
    private double diskon;
    
    //constructor
    ClassTransaksi(){
        
    }
    
    ClassTransaksi(String noTransaksi, String idKaryawan, String namaKaryawan, String tglTransaksi, String kodeArticle, String namaProduk, 
                   String idPelanggan, String namaPelanggan, String qty, String harga, String jumlah, double diskon, String hargaTotal){
            this.noTransaksi = noTransaksi;
            this.idKaryawan = idKaryawan;
            this.namaKaryawan = namaKaryawan;
            this.tglTransaksi = tglTransaksi;
            this.kodeArticle = kodeArticle;
            this.namaProduk = namaProduk;
            this.idPelanggan = idPelanggan;
            this.namaPelanggan = namaPelanggan;
            this.qty = qty;
            this.harga = harga;
            this.jumlah = jumlah;
            this.diskon = diskon;
            this.hargaTotal = hargaTotal;
    }
    
    //setter
    public void setnoTransaksi(String no){
        this.noTransaksi = no;
    }
    public void setidKaryawan(String idk){
        this.idKaryawan = idk;
    }
    public void setnamaKaryawan(String namak){
        this.namaKaryawan = namak;
    }
    public void settglTransaksi(String tgl){
        this.tglTransaksi = tgl;
    }
    public void setkodeArticle(String kodeA){
        this.kodeArticle = kodeA;
    }
    public void setnamaProduk(String namaP){
        this.namaProduk = namaP;
    }
    public void setidPelanggan(String idP){
        this.idPelanggan = idP;
    }
    public void setnamaPelanggan(String namaP){
        this.namaPelanggan = namaP;
    }
    public void setqty(String q){
        this.qty = q;
    }
    public void setharga(String h){
        this.harga = h;
    }
    public void setjumlah(String j){
        this.jumlah = j;
    }
    public void setdiskon(double d){
        this.diskon = d;
    }
    public void sethargaTotal(String hT){
        this.hargaTotal = hT;
    }
    
    //getter
    public String getnoTransaksi(){
        return noTransaksi;
    }
    public String getidKaryawan(){
        return idKaryawan;
    }
    public String getnamaKaryawan(){
        return namaKaryawan;
    }
    public String gettglTransaksi(){
        return tglTransaksi;
    }
    public String getkodeArticle(){
        return kodeArticle;
    }
    public String getnamaProduk(){
        return namaProduk;
    }
    public String getidPelanggan(){
        return idPelanggan;
    }
    public String getnamaPelanggan(){
        return namaPelanggan;
    }
    public String getqty(){
        return qty;
    }
    public String getharga(){
        return harga;
    }
    public String getjumlah(){
        return jumlah;
    }
    public double getdiskon(){
        return diskon;
    }
    public String gethargaTotal(){
        return hargaTotal;
    }
}
