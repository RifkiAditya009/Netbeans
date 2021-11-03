/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTransaksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author acer_
 */
public class ClassTransaksi1 extends ClassTransaksi{
    PreparedStatement pst;
    Statement stm;
    ResultSet rs;
    
    //connect DB
    Connection connect = DatabaseConnect.DatabaseConnect.getKoneksi("localhost", "3306", "root", "", "database_ooptugasakhir");
    
    //deklare var
    private String noTransaksi, idKaryawan, namaKaryawan, tglTransaksi, kodeArticle, namaProduk, idPelanggan, namaPelanggan;
    private int qty;
    private double harga, jumlah, diskon, hargaTotal;
    
    //constructor
    ClassTransaksi1(){
        
    }
    
    ClassTransaksi1(String noTransaksi, String idKaryawan, String namaKaryawan, String tglTransaksi, String kodeArticle, String namaProduk, 
                   String idPelanggan, String namaPelanggan, String qty, String harga, String jumlah, double diskon, String hargaTotal){
            super.setnoTransaksi(noTransaksi);
            super.setidKaryawan(idKaryawan);
            super.setnamaKaryawan(namaKaryawan);
            super.settglTransaksi(tglTransaksi);
            super.setkodeArticle(kodeArticle);
            super.setnamaProduk(namaProduk);
            super.setidPelanggan(idPelanggan);
            super.setnamaPelanggan(namaPelanggan);
            super.setqty(qty);
            super.setharga(harga);
            super.setjumlah(jumlah);
            super.setdiskon(diskon);
            super.sethargaTotal(hargaTotal);
    }
    
    //getter
    public String getnoTransaksi(){
        return super.getnoTransaksi();
    }
    public String getidKaryawan(){
        return super.getidKaryawan();
    }
    public String getnamaKaryawan(){
        return super.getnamaKaryawan();
    }
    public String gettglTransaksi(){
        return super.gettglTransaksi();
    }
    public String getkodeArticle(){
        return super.getkodeArticle();
    }
    public String getnamaProduk(){
        return super.getnamaProduk();
    }
    public String getidPelanggan(){
        return super.getidPelanggan();
    }
    public String getnamaPelanggan(){
        return super.getnamaPelanggan();
    }
    public String getqty(){
        return super.getqty();
    }
    public String getharga(){
        return super.getharga();
    }
    public String getjumlah(){
        return super.getjumlah();
    }
    public double getdiskon(){
        return super.getdiskon();
    }
    public String gethargaTotal(){
        return super.gethargaTotal();
    }
    
    public void discount(){
        String cekmember = "Select * from data_member where no_member ='"+getidPelanggan()+"' ";
        double rateDiskon = 0.20;
        try{
            stm = connect.createStatement();
            rs = stm.executeQuery(cekmember);
            
            while(rs.next()){
              setnamaPelanggan(rs.getString("nama_member")) ; 
            }
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println(""+ ex.getMessage());
        }
    }
    
    public void saveTransaksi(String idk, String namak, String tglTrans, String noTrans, String kodeA, String namaP, String harga, 
                                String qty, String idM, String subTotal, String total){
                                
        try{
            String sql = "insert into data_transaksi (id_karyawan, nama_karyawan, tgl_transaksi, no_transaksi, kode_articleProduk, nama_produk, harga, qty, id_member, subtotal, total)"
                    +   "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = connect.prepareStatement(sql);
            
            
            setidKaryawan(idk);
            setnamaKaryawan(namak);
            settglTransaksi(tglTrans);
            setnoTransaksi(noTrans);
            setkodeArticle(kodeA);
            setnamaProduk(namaP);
            setharga(harga);
            setqty(qty);
            setidPelanggan(idM);
            setjumlah(subTotal);
            sethargaTotal(total);
            
            pst.setString(1, getidKaryawan());
            pst.setString(2, getnamaKaryawan());
            pst.setString(3, gettglTransaksi());
            pst.setString(4, getnoTransaksi());
            pst.setString(5, getkodeArticle());
            pst.setString(6, getnamaProduk());
            pst.setString(7, getharga());
            pst.setString(8, getqty());
            pst.setString(9, getidPelanggan());
            pst.setString(10, getjumlah());
            pst.setString(11, gethargaTotal());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Transaksi Berhasil Disimpan");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //kurangStok
    private int cekStok(String kodeArt){
        int stok=0;
        setkodeArticle(kodeArt);
        
        String cekJumlahProduk = "select stok_produk from data_produk where kode_articleProduk ='"+getkodeArticle()+"' ";
        
        try{
            stm = connect.createStatement();
            rs  = stm.executeQuery(cekJumlahProduk);
        while(rs.next()){
            stok = Integer.parseInt(rs.getString(1));
        }
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("" +ex.getMessage());
        }
        return stok;
    }
    public void Updatestok(String ubah, String kodeArt, JTextField js) {
        int stokbaru =0;
        
        setkodeArticle(kodeArt);
        int jmlbeli = Integer.parseInt(js.getText());
        Object [] pilih = {"OK"} ; 
        try{
        
            if(ubah.equals("Beli")){
                stokbaru = cekStok(getkodeArticle()) -jmlbeli;
                JOptionPane.showMessageDialog(null, "Data Telah Berhasil Di Simpan " +"\n"+
                "\t\t" +"Jumlah Stok ID Produk " +getkodeArticle()+ " Berkurang -" +jmlbeli);
                
            }else if(ubah.equals("hapus")){
                stokbaru = cekStok(getkodeArticle());
            }
            
        String update = "update data_produk set stok_produk ='"+stokbaru+"' where kode_articleProduk ='"+getkodeArticle()+"' ";    
        pst = connect.prepareStatement(update);
        
        pst.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void getmember(String idM, JTextField nama, JTextField disc){
        double potongan = 0.25;
        try{
           setidPelanggan(idM);
           
           String sql = "select nama_konsumen from data_member where no_member= '"+getidPelanggan()+"' "; 
           stm = connect.createStatement();
           rs= stm.executeQuery(sql);
           
           while(rs.next()){
               
               setnamaPelanggan(rs.getString(1));
               
               nama.setText(getnamaPelanggan());
               disc.setText(Double.toString(potongan));
               
               }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void gettxtKodeA(String kodeArt, JTextField nama, JTextField harga){
        try{
           setkodeArticle(kodeArt);
           
           String sql = "select nama_produk, harga from data_produk where kode_articleProduk ='"+getkodeArticle()+"' "; 
           stm = connect.createStatement();
           rs= stm.executeQuery(sql);
           
           while(rs.next()){
               setnamaProduk(rs.getString(1));
               setharga(rs.getString(2));
               
               nama.setText(getnamaProduk());
               harga.setText(getharga());
           }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    public void subTotal(JTextField txtharga, JTextField txtqty, JTextField txtsubTotal, JTextField total){
        setharga(txtharga.getText());
        setqty(txtqty.getText());
        double jmlah = Double.parseDouble(getharga()) * Integer.parseInt(getqty());
        
        txtsubTotal.setText(String.valueOf(jmlah));
        total.setText(String.valueOf(jmlah));
    }
}
