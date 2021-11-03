/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataProduk_dan_Supplier;

/**
 *
 * @author acer_
 */
public abstract class ClassSupplier {
    
    //deklare var
    private String idSupplier, namaSupplier, alamatKantor, telpKantor;
    
    //constructor
    ClassSupplier(){
        
    }
    
    ClassSupplier(String idS, String namaS, String alamat, String telp){
        this.idSupplier = idS;
        this.namaSupplier = namaS;
        this.alamatKantor = alamat;
        this.telpKantor = telp;
    }
    
    //setter
    public void setIdSupplier(String id){
        this.idSupplier = id;
    }
    public void setnamaSupplier(String nama){
        this.namaSupplier = nama;
    }
    public void setalamatKantor(String alamat){
        this.alamatKantor = alamat;
    }
    public void settelpKantor(String telp){
        this.telpKantor = telp;
    }
    
    //getter
    public String getIdSupplier(){
        return idSupplier;
    }
    public String getnamaSupplier(){
        return namaSupplier;
    }
    public String getalamatKantor(){
        return alamatKantor;
    }
    public String gettelpKantor(){
        return telpKantor;
    }
}
