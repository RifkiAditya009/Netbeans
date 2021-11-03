/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form_Login_Daftar_Recovery;

import MainMenu_Dashboard_Bantuan.MenuUtama;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author acer_
 */
public class ClassAkun1 extends ClassAkun {
    PreparedStatement pst;
    Statement stm;
    ResultSet rs;
    
    //connect DB
    Connection connect = DatabaseConnect.DatabaseConnect.getKoneksi("localhost", "3306", "root", "", "database_ooptugasakhir");
    
    
    //deklare var
    private String id, username, password, securecode;
    
    //constructor
    ClassAkun1(){
    }
    
    ClassAkun1(String id, String username, String password, String securecode){
        super.setid(id);
        super.setUsername(username);
        super.setPass(password);
        super.setsecurecode(securecode);
    }
    
    

    //getter
    public String getId(){
        return super.getId();
    }
    public String getUsername(){
        return super.getUsername();
    }
    public String getPassword(){
        return super.getPassword();
    }
    public String getsecurecode(){
        return super.getsecurecode();
    }
    
    //
    public void LoginAkun(String username, String password, JFrame jf, JFrame jf2) {
        try {
        
        String sql = "SELECT * FROM akses_akun where username ='"+username+"' AND password ='"+password+"' ";
        stm = connect.createStatement();    
        rs = stm.executeQuery(sql);
        
        //
        if (rs.next()){
            if(username.equals(rs.getString("username"))){
                if(password.equals(rs.getString("password"))) {
                JOptionPane.showMessageDialog(null, "get your access");
                
                //
                MenuUtama menu = new MenuUtama();
                
                setUsername(username);
                setPass(password);
                setid(rs.getString("id_karyawan"));
                setsecurecode(rs.getString("code_recovery")) ;
            
                menu.dashboardusername.setText("@"+getUsername());
                menu.dashboardid.setText(getId());
                
                menu.setVisible(true);
                jf2.dispose();
                } else {
                JOptionPane.showMessageDialog(null, "Password yang anda masukan salah");    
                
                }
                
            }else if(password.equals(rs.getString("password"))){
                //
                 if (username.equals(rs.getString("username"))){
                JOptionPane.showMessageDialog(null, "Username yang anda masukan salah");
                
                }else if(!password.equals(rs.getString("password"))) {
                JOptionPane.showMessageDialog(null, "Username Dan Password yang anda masukan salah");
            }
            }
            
        }else if(username.equals("") ){
            if(password.equals("")){
            JOptionPane.showMessageDialog(null, "Username & Password Tidak Boleh Kosong");
            }else {
                JOptionPane.showMessageDialog(null, "Username Tidak Boleh Kosong");
            }   
        }else if(password.equals("")){
            JOptionPane.showMessageDialog(null, "Password Tidak Boleh Kosong");
        }   
        
        }catch(SQLException e) {
         e.printStackTrace();
        }
    }
    
    //
    public void daftarakun(String id, String user, String pass, String securecode){
        try{
            
            String sql = "insert into akses_akun (id_karyawan, username, password, code_recovery) values (?, ?, ?, ?)" ;
            pst = connect.prepareStatement(sql);
            
            setid(id);
            setUsername(user);
            setPass(pass);
            setsecurecode(securecode);
            
            pst.setString(1, getId());
            pst.setString(2, getUsername());
            pst.setString(3, getPassword());
            pst.setString(4, getsecurecode());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Terdaftar");
            
        } catch(SQLException ex){
          ex.printStackTrace();
        }
    }
    
    //
    public void getNama(String id, JLabel lab) {
        try{
        
        String query = "SELECT * FROM data_karyawan where id_karyawan ='"+id+"' ";
        pst = connect.prepareStatement(query);
        rs = pst.executeQuery();
        
        while(rs.next()){
            if(id.equals(rs.getString("id_karyawan"))){
                
                setid(rs.getString("id_karyawan"));
                
                lab.setText(rs.getString("nama_karyawan"));
            }
        }
        
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    //
    public void getAkun(String id,String code, JLabel lab) {
        try{
        
        String query = "SELECT * FROM akses_akun where id_karyawan ='"+id+"' and code_recovery ='"+code+"' ";
        pst = connect.prepareStatement(query);
        rs = pst.executeQuery();
        
        while(rs.next()){
            if(id.equals(rs.getString("id_karyawan")) && code.equals(rs.getString("code_recovery"))){
                
                setid(rs.getString("id_karyawan"));
                setsecurecode(rs.getString("code_recovery"));
                setPass(rs.getString("password"));
                setUsername(rs.getString("username"));
                
                lab.setText(getPassword());
            } else {
                JOptionPane.showMessageDialog(null, "Cek kembali code yang anda masukan");
            }
        }
        
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    //ComboBox
    public void getDBtoBox(JComboBox box){
        try{
        String tampil = "select kode_articleProduk from data_produk order by kode_articleProduk asc";
        stm = connect.createStatement();
        rs = stm.executeQuery(tampil);
        
        while(rs.next()){
        Object[] ob = new Object [1];
        ob[0] = rs.getString(1);
        
        box.addItem((String) ob[0]);
        
        }
        rs.close();
        stm.close();
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }
    
    
    
}
