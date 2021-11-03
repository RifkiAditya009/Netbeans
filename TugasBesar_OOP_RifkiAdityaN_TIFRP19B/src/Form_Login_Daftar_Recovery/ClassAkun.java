/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form_Login_Daftar_Recovery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author acer_
 */
public abstract class ClassAkun {
    PreparedStatement pst;
    Statement stm;
    ResultSet rs ;
    
    // deklare var 
    private String id, username, password, securecode;
    
    //constructor
    ClassAkun()
    {
    }
    
    ClassAkun(String id, String user, String pass, String secure) {
        this.id =id;
        this.username =user;
        this.password =pass;
        this.securecode =secure;
    }
    
    //setter
    
    public void setid(String id)  {
        this.id = id;
    }
    public void setUsername (String u){
        this.username = u;
    }
    public void setPass (String p){
        this.password = p;
    }
    public void setsecurecode(String sc){
        this.securecode = sc;
    }
   
    
    //getter
    public String getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getsecurecode() {
        return securecode;
    }
}
