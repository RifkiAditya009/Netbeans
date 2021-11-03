/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataMember;

/**
 *
 * @author acer_
 */
public abstract class ClassMember {
    
    //deklarasi var
    private String idMember, namaMember, alamat, noTelp;
    
    //constructor
    ClassMember(){
        
    }
    
    ClassMember (String idM, String namaM, String alamatM, String noM){
        this.idMember = idM;
        this.namaMember = namaM;
        this.alamat = alamatM;
        this.noTelp = noM;
    }
    
    //setter
    public void setidMember(String idM){
        this.idMember = idM;
    }
    public void setnamaMember(String namaM){
        this.namaMember = namaM;
    }
    public void setalamatMember(String alamatM){
        this.alamat = alamatM;
    }
    public void setTelpMember(String noM){
        this.noTelp = noM;
    }
    
    //getter
    public String getidMember(){
        return idMember;
    }
    public String getnamaMember(){
        return namaMember;
    }
    public String getalamatMember(){
        return alamat;
    }
    public String getTelpMember(){
        return noTelp;
    }
    
}
