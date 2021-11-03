/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataProduk_dan_Supplier;

import java.sql.Blob;

/**
 *
 * @author acer_
 */
public abstract class ClassProduk {
    
    //deklare var
    private String idSupplier, idArticle, namaProduk, jenisProduk, Harga;
    private Blob picture;
    private int stokProduk;
    
    //constructor
    ClassProduk(){
        
    }
    
    ClassProduk(Blob photo, String idSup, String idArticle, String namaProduk, String jenisProduk, String harga, int stok){
        this.picture = photo;
        this.idSupplier = idSup;
        this.idArticle = idArticle;
        this.namaProduk = namaProduk;
        this.jenisProduk = jenisProduk;
        this.Harga = harga;
        this.stokProduk = stok;
    }
    
    //setter
    public void setPhotoBrand(Blob pic){
        this.picture = pic;
    }
    public void setidSupp(String id){
        this.idSupplier = id;
    }
    public void setidArticle(String idArticle){
        this.idArticle = idArticle;
    }
    public void setnamaProduk(String nama){
        this.namaProduk = nama;
    }
    public void setjenisProduk(String jenis){
        this.jenisProduk = jenis;
    }
    public void sethargaProduk(String harga){
        this.Harga = harga;
    }
    public void setjumlahStok(int s){
        this.stokProduk = s;
    }
    
    //getter
    public Blob getPhotoBrand(){
        return picture;
    }
    public String getidSupp(){
        return idSupplier;
    }
    public String getidArticle(){
        return idArticle;
    }
    public String getnamaProduk(){
        return namaProduk;
    }
    public String getjenisProduk(){
        return jenisProduk;
    }
    public String gethargaProduk(){
        return Harga;
    }
    public int getjumlahStok(){
        return stokProduk;
    }
}
