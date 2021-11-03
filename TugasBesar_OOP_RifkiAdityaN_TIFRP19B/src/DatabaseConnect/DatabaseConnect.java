/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author acer_
 */
public class DatabaseConnect {
 
    public static Connection getKoneksi (String host, String port, String Username, String Password, String db) {
    String konString = "jdbc:mysql://" +host+ ":" +port+ "/" +db ;
    Connection koneksi = null;
    
    try {
    Class.forName("com.mysql.jdbc.Driver") ;
    koneksi = DriverManager.getConnection(konString, Username, Password) ;
        System.out.println("Database Koneksi Berhasil");
        System.out.println();
    
    }catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null,"Gagal Koneksi");
        koneksi = null;
    }
    return koneksi;
    }
}
