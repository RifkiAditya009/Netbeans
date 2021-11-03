/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataGudang;

/**
 *
 * @author acer_
 */
public abstract class ClassGudang {
    
    //deklare var
    private String idKaryawan, namaKaryawan, kodeArticle, namaProduk, idSupplier, tglMasuk;
    private int jumlahProduk;
    
    //
    ClassGudang(){
        
    }
    
    ClassGudang(String idK, String namaK, String kodeA, String namaP, String idSupp, String tgl, int jumlah){
        this.idKaryawan = idK;
        this.namaKaryawan = namaK;
        this.kodeArticle = kodeA;
        this.namaProduk = namaP;
        this.idSupplier = idSupp;
        this.tglMasuk = tgl;
        this.jumlahProduk = jumlah;
    }
    
    //setter
    public void setidKaryawan(String idK){
        this.idKaryawan = idK;
    }
    public void setnamaKaryawan(String namaK){
        this.namaKaryawan = namaK;
    }
    public void setkodeA(String kodeA){
        this.kodeArticle = kodeA;
    }
    public void setnamaProduk(String namaP){
        this.namaProduk = namaP;
    }
    public void setidSupply(String idSupp){
        this.idSupplier = idSupp;
    }
    public void settglMasuk(String tgl){
        this.tglMasuk = tgl;
    }
    public void setjumlahMasukProduk(int jml){
        this.jumlahProduk = jml;
    }
    
    
    //getter
    public String getidKaryawan(){
        return idKaryawan;
    }
    public String getnamaKaryawan(){
        return namaKaryawan;
    }
    public String getkodeA(){
        return kodeArticle;
    }
    public String getnamaProduk(){
        return namaProduk;
    }
    public String getidSupply(){
        return idSupplier;
    }
    public String gettglMasuk(){
        return tglMasuk ;
    }
    public int getjumlahMasukProduk(){
        return jumlahProduk;
    }
    
}
