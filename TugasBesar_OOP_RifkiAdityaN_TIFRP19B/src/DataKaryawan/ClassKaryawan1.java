/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataKaryawan;

import DataProduk_dan_Supplier.ClassProduk1;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer_
 */
public class ClassKaryawan1 extends ClassKaryawan{
    PreparedStatement pst;
    Statement stm;
    ResultSet rs;
    //connect DB
    Connection connect = DatabaseConnect.DatabaseConnect.getKoneksi("localhost", "3306", "root", "", "database_ooptugasakhir");
    
    //deklare Var
    private String idKaryawan, namaKaryawan, divisi, gender, status, noKtp, alamat, noTelp, tglLahir;
    
    //constructor
    ClassKaryawan1(){
        
    }
    
    ClassKaryawan1(String idKaryawan, String namaKaryawan, String divisi, String gender, String status, 
                  String noKtp, String alamat, String noTelp, String tglLahir){
        super.setidKar(idKaryawan);
        super.setnamaKar(namaKaryawan);
        super.setdivisi(divisi);
        super.setgender(gender);
        super.setstatus(status);
        super.setnoKtp(noKtp);
        super.setalamat(alamat);
        super.setTelpKar(noTelp);
        super.setTglLahir(tglLahir);
    }
    
    //getter
    public String getidKar(){
        return super.getidKar();
    }
    public String getnamaKar(){
        return super.getnamaKar();
    }
    public String getdivisi(){
        return super.getdivisi();
    }
    public String getgender(){
        return super.getgender();
    }
    public String getstatus(){
        return super.getstatus();
    }
    public String getnoKtp(){
        return super.getnoKtp();
    }
    public String getalamat(){
        return super.getalamat();
    }
    public String getTelpKar(){
        return super.getTelpKar();
    }
    public String getTglLahir(){
        return super.getTglLahir();
    }
    
    //
    byte[] photo =null ;
    private ImageIcon format =null;
    private File selectedFileFile;
    private FileInputStream fis;
    
    public boolean val(String idk, String namak, String divisi, String gender, String status, String ktp, String alamat, 
            String telp, String tgllahir){
        return !idk.isEmpty() && !namak.isEmpty() && !divisi.isEmpty() && !gender.isEmpty() && !status.isEmpty() && !ktp.isEmpty()
               && !alamat.isEmpty() && !telp.isEmpty() ;
    }
    public void settxt(JComboBox boxstatus, JComboBox boxdiv, JTextField idk, JTextField namak,JTextField telpk,
            JTextField ktp, JTextArea alamatk, JComboBox prov, JTextField kota, JTextField pos, JTextField rtrw){
        
        boxstatus.setSelectedIndex(0);
        boxdiv.setSelectedIndex(0);
        prov.setSelectedIndex(0);
        idk.setText("");
        namak.setText("") ;
        telpk.setText("") ;
        ktp.setText("") ;
        
        alamatk.setText("") ;
        pos.setText("");
        kota.setText("") ;
        rtrw.setText("") ;
                
    }
    
    
    public ImageIcon ResizeImage(String ImagePath, JLabel gambar) {
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
    
    public void showdata(JTable table) {
        DefaultTableModel dtm = new DefaultTableModel() ;
        String kolom[] = {"ID Karyawan","Nama Karyawan","Tgl. Lahir", "Divisi","Gender","Status", "ID KTP", "Alamat", "Telpon"} ;
        dtm = new DefaultTableModel(null,kolom) ;
        
        try {
            stm = connect.createStatement();
            String query = "SELECT * FROM data_karyawan" ;
            rs = stm.executeQuery(query);
            
            while(rs.next()){
                
            String id = rs.getString("id_karyawan") ;
            String nama = rs.getString("nama_karyawan") ;
            String jk = rs.getString("jenis_kelamin") ;
            Date tgllahir = rs.getDate("tgl_lahir") ;
            String ktp = rs.getString("no_ktp");
            String status = rs.getString("status") ;
            String kontak = rs.getString("no_hp") ;
            String div = rs.getString("divisi") ;
            String alamat = rs.getString("alamat") ;
            byte[] image = rs.getBytes("photoKaryawan") ;
            format = new ImageIcon(image) ;
            
            
            dtm.addRow(new String[] {id,nama, tgllahir.toString(), div, jk, status, ktp, alamat, kontak});
            table.setModel(dtm);
        }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void saveKaryawan(JLabel labeldivisi, String idk, String namak, String divisi, String gender, String status, String ktp, String alamat,
                             String telp, String tglLahir){
        try{
            String sql = "insert into data_karyawan (id_karyawan, nama_karyawan, no_ktp, tgl_lahir, jenis_kelamin, alamat, status, no_hp, divisi, photoKaryawan) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = connect.prepareStatement(sql);
            
            if(val(idk, namak, divisi, gender, status, ktp, alamat, telp, tglLahir)){
            
        setidKar(labeldivisi.getText()+idk);
        setnamaKar(namak);
        setdivisi(divisi);
        setgender(gender);
        setstatus(status);
        setnoKtp(ktp);
        setalamat(alamat);
        setTelpKar(telp);
        setTglLahir(tglLahir);
            
            pst.setString(1, getidKar());
            pst.setString(2, getnamaKar());
            pst.setString(3, getnoKtp());
            pst.setString(4, getTglLahir());
            pst.setString(5, getgender());
            pst.setString(6, getalamat());
            pst.setString(7, getstatus());
            pst.setString(8, getTelpKar());
            pst.setString(9, getdivisi());
            
            fis = new FileInputStream(selectedFileFile);
            pst.setBinaryStream(10 , fis,(int) selectedFileFile.length());
        
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Karyawan Telah Berhasil Disimpan");
            
            } else{
                JOptionPane.showMessageDialog(null, "Pastikan Data Karyawan Diisi Semua");
            
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClassProduk1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteKaryawan(JTable table){ 
        
        int record = table.getRowCount();
        int select = table.getSelectedRowCount() ;
        int i = table.getSelectedRow();
        
        try {
            if (record > 0) {

                if(select>0){
                    int pilih = JOptionPane.showConfirmDialog(null, "Apakah Data Akan Dihapus?","WARNING",JOptionPane.YES_NO_OPTION); ;

                    if (pilih == JOptionPane.YES_OPTION) {
                        Statement sat = connect.createStatement();
                        String hapus = "delete from data_karyawan where id_karyawan= '"+table.getValueAt(i, 0).toString()+"'" ;
                        PreparedStatement prep = connect.prepareStatement(hapus) ;
                        prep.execute() ;

                        JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
                        JOptionPane.showMessageDialog(null, "Klik Refresh!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Batal Dihapus");
                    }

                } else {
                    JOptionPane.showMessageDialog(null,"Pilih Data Di Tabel");
                }
            } else {
                JOptionPane.showMessageDialog(null,"Empty Data");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateKaryawan(JButton updatebutton, JTextField off, JButton button, JTextArea area, String idk, String namak, String divisi, String gender, String status, String ktp, String alamat,
                             String telp, String tglLahir, JComboBox stat, JComboBox div, JTextField nama1, JTextField hp, JTextField ktpk,
                             JComboBox prov, JTextField kota, JTextField pos, JTextField rtrw){
        try{
            String update = "update data_karyawan set id_karyawan ='"+idk+"', nama_karyawan ='"+namak+"', divisi ='"+divisi+"', jenis_kelamin ='"+gender+"', status ='"+status+"', "
                    + "     no_ktp ='"+ktp+"', alamat ='"+alamat+"', no_hp ='"+telp+"', tgl_lahir ='"+tglLahir+"' "
                    + "     where id_karyawan ='"+idk+"'" ;
            pst = connect.prepareStatement(update);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update Data Berhasil");
            
            settxt(stat, div, off, nama1, hp, ktpk, area, prov, kota, pos, rtrw);
            button.setEnabled(true);
            off.setEnabled(true);
            updatebutton.setEnabled(false);
            area.setEnabled(false);
        } catch(SQLException ex){
          JOptionPane.showMessageDialog(null, "Perubahan Gagal " +ex.getMessage());
        }
    }
    
    public void TabletoTextField(JTable table, JLabel idK, JLabel namaK, JLabel div,JLabel photo){
        int record = table.getRowCount();
            int i = table.getSelectedRow();
        try {
            stm = connect.createStatement();
            String query = "SELECT * FROM data_karyawan WHERE id_karyawan = '"+table.getValueAt(i, 0).toString()+"'"; ;
            rs = stm.executeQuery(query);
        if(record >0) {
            int row = table.getSelectedRowCount();
            if(row > 0) {
                while(rs.next()){
                    Blob gmb = (Blob) rs.getBlob("photoKaryawan") ;
                    int u = (int) (gmb.length());
                    ImageIcon im = new ImageIcon(gmb.getBytes(1, u));
                    
            
                idK.setText(table.getValueAt(i, 0).toString());
                namaK.setText(table.getValueAt(i, 1).toString());
                div.setText(table.getValueAt(i, 3).toString());
                photo.setIcon(im);
                }
            }
        } else {
            
        }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    
    public void EditData(JButton update, JTextField idoff, JButton button, JTable table, JPanel p1, JPanel p2, JComboBox boxstatus, JComboBox boxdiv, JTextField idk, JTextField namak, 
        JTextField telpk, JTextField ktp, JDateChooser tgllahir, JRadioButton gd1, JRadioButton gd2, JTextArea alamatk){
      int record = table.getRowCount();

        if (record > 0){
            int pilih = table.getSelectedColumnCount() ;
            if (pilih > 0 ) {
                try {
                    int i = table.getSelectedRow();

                    Date tgl1 = new SimpleDateFormat("yyyy-MM-dd").parse((String.valueOf(table.getValueAt(i, 2))));
                    
                    String jk = table.getValueAt(i, 4).toString();
                    if (jk.equals("Perempuan")){
                        gd1.setSelected(true);
                    }else {
                        gd2.setSelected(true);
                    }
                   
                    idk.setText(table.getValueAt(i, 0).toString());
                    idoff.setEnabled(false);
                    
                    namak.setText(table.getValueAt(i, 1).toString()) ;
                    
                    boxstatus.setSelectedItem(table.getValueAt(i, 5).toString()) ;
                    boxdiv.setSelectedItem(table.getValueAt(i, 3).toString());
                    
                    ktp.setText(table.getValueAt(i, 6).toString()); ;
                            
                    tgllahir.setDate(tgl1) ;
                    
                    alamatk.setText(table.getValueAt(i, 7).toString()) ;
                    telpk.setText(table.getValueAt(i, 8).toString()) ;
                    
                    p1.setVisible(true);
                    p2.setVisible(false);
                    update.setEnabled(true);
                    button.setEnabled(false);
                    alamatk.setEnabled(false);
                }catch (ParseException e){
                    Logger.getLogger(InputKaryawan.class.getName()).log(Level.SEVERE,null, e);

                }
            }else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada yang Dipilih");
            }
        }else {
            JOptionPane.showMessageDialog(null, "Data Kosong");
        }
    }

}