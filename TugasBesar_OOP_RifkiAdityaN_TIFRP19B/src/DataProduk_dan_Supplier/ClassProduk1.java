/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataProduk_dan_Supplier;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer_
 */
public class ClassProduk1 extends ClassProduk{
    PreparedStatement pst;
    Statement stm; 
    ResultSet rs;
    
    private File selectedFileFile;
    private FileInputStream fis;
    byte[] photo=null ;
    private ImageIcon format=null;
    
    
    //Connect DB
    Connection connect = DatabaseConnect.DatabaseConnect.getKoneksi("localhost", "3306", "root", "", "database_ooptugasakhir");
    
    
    //constructor
    ClassProduk1(){
        
    }
    
    ClassProduk1(Blob photo, String idS, String idArc, String nama, String jenis, String harga, int stok){
        super.setPhotoBrand(photo);
        super.setidSupp(idS);
        super.setidArticle(idArc);
        super.setnamaProduk(nama);
        super.setjenisProduk(jenis);
        super.sethargaProduk(harga);
        super.setjumlahStok(stok);
    }

    
    
    //getter
    public Blob getPhotoBrand(){
        return super.getPhotoBrand();
    }
    public String getidSupp(){
        return super.getidSupp();
    }
    public String getidArticle(){
        return super.getidArticle();
    }
    public String getnamaProduk(){
        return super.getnamaProduk();
    }
    public String getjenisProduk(){
        return super.getjenisProduk();
    }
    public String gethargaProduk(){
        return super.gethargaProduk();
    }
    public int getjumlahStok(){
        return super.getjumlahStok();
    }
            
    
    // fit foto sesuai ukuran jlabel
    private ImageIcon ResizeImage(String ImagePath, JLabel gambar) {
            ImageIcon MyImage = new ImageIcon(ImagePath) ;
            Image img = MyImage.getImage() ;
            Image newimg = img.getScaledInstance(gambar.getWidth(),gambar.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon image = new ImageIcon(newimg) ;
            return image ;
        }
    
    public void ambilpic(JLabel lgambar, JTextField txt){
        JFileChooser file = new JFileChooser() ;
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image","jpg","gif","png") ;
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null) ;
        //
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFileFile = file.getSelectedFile();
            String path = selectedFileFile.getAbsolutePath() ;
            lgambar.setIcon(ResizeImage(path, lgambar));
            txt.setText(file.getSelectedFile().getName());
        }
        else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("No file Selected");
        }
    }
    
    public boolean val(String idSup, String idArt, String namaP, String jenisP, String harga){
        return !idSup.isEmpty() && !idArt.isEmpty() && !namaP.isEmpty() && !jenisP.isEmpty() && !harga.isEmpty() ;
    }
    
    public void saveProduk(String idSup, String idArt, String namaProduk, String jenis, String harga) {
        int jumlahBarang =0;
        try{
            String sql = "insert into data_produk (id_brandSupplier, kode_articleProduk, nama_produk, jenis_produk, harga, stok_produk, photoBrand) values(?, ?, ?, ?, ?, ?, ?)";
            pst = connect.prepareStatement(sql);
            
            if(val(idSup, idArt, namaProduk, jenis, harga)){
            
            setidSupp(idSup);
            setidArticle(idArt);
            setnamaProduk(namaProduk);
            setjenisProduk(jenis);
            sethargaProduk(harga);
            
            
            pst.setString(1, getidSupp());
            pst.setString(2, getidArticle());
            pst.setString(3, getnamaProduk());
            pst.setString(4, getjenisProduk());
            pst.setString(5, gethargaProduk());
            pst.setInt(6, jumlahBarang);
            
            fis = new FileInputStream(selectedFileFile);
            pst.setBinaryStream(7, fis,(int) selectedFileFile.length());
        
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Produk Telah Berhasil Disimpan");
            } else{
                JOptionPane.showMessageDialog(null, "Pastikan Data Produk Diisi Semua");
            
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClassProduk1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateProduk(String idSup, JTextField idArt, String namaProduk, String jenis, String harga, JButton jb, JButton jb2){
        try{
            setidSupp(idSup);
            setidArticle(idArt.getText());
            setnamaProduk(namaProduk);
            setjenisProduk(jenis);
            sethargaProduk(harga);
            
            String sql = "update data_produk set id_brandSupplier ='"+getidSupp()+"', nama_produk ='"+getnamaProduk()+"', jenis_produk ='"+getjenisProduk()+"', harga ='"+gethargaProduk()+"' "
                    + "   where kode_articleProduk ='"+getidArticle()+"' " ;
            pst = connect.prepareStatement(sql);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update Data Berhasil");
            jb.setEnabled(true);
            jb2.setEnabled(false);
            idArt.setEnabled(true);
            
        } catch(SQLException ex){
          JOptionPane.showMessageDialog(null, "Perubahan Gagal " +ex.getMessage());
        }
    }
    
    public void showdata(JTable table) {
        DefaultTableModel dtm = new DefaultTableModel() ;
        String kolom[] = {"Kode Article","Nama Produk","ID Supplier","Jenis Produk","Harga"} ;
        dtm = new DefaultTableModel(null,kolom) ;
        
        try {
            stm = connect.createStatement();
            String query = "SELECT * FROM data_produk" ;
            rs = stm.executeQuery(query);
            
            while(rs.next()){
            String idSup = rs.getString("id_supplierBrand") ;
            String kodeA= rs.getString("kode_articleProduk") ;
            String namaP = rs.getString("nama_produk") ;
            String jenis = rs.getString("jenis_produk") ;
            String harga = rs.getString("harga") ;
            
            byte[] image = rs.getBytes("photo") ;
            format = new ImageIcon(image) ;
            
            
            dtm.addRow(new String[] {kodeA,namaP,idSup,jenis,harga});
            table.setModel(dtm);
        }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void addcBox(JComboBox x){
         try{
             
             String sql = "select id_supplier from data_supplier order by id_supplier asc";
             stm = connect.createStatement();
             rs = stm.executeQuery(sql);
             
             while(rs.next()){
                 Object[] b = new Object[1];
                 
                 b[0] = rs.getString(1);
                 x.addItem(b[0]);
             }
             
         }catch (SQLException ex){
             JOptionPane.showMessageDialog(null, ex.getMessage());
         }   
        }

    
}
