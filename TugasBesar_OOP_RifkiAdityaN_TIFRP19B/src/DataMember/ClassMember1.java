/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataMember;

import DatabaseConnect.DatabaseConnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer_
 */
public class ClassMember1 extends ClassMember{
    PreparedStatement pst, pst1;
    Statement stm;
    ResultSet rs;
    DefaultTableModel dtm;
    
    //connect DB
    Connection connect = DatabaseConnect.getKoneksi("localhost", "3306", "root", "", "database_ooptugasakhir");
    
    //deklare Var
    private String idM, namaM, alamatM, telpM;
    
    //constructor
    ClassMember1(){
        
    }
    
    ClassMember1(String id, String nama, String alamat, String telp){
        super.setidMember(id);
        super.setnamaMember(nama);
        super.setalamatMember(alamat);
        super.setTelpMember(telp);
    }
    
    //getter
    public String getidMember(){
        return super.getidMember();
    }
    public String getnamaMember(){
        return super.getnamaMember();
    }
    public String getalamatMember(){
        return super.getalamatMember();
    }
    public String getTelpMember(){
        return super.getTelpMember();
    }
    
    //
    public void settxt(JTextField idMember, JTextField namaMember, JTextField telp, JTextArea alamat){
        idMember.setText("");
        namaMember.setText("") ;
        telp.setText("") ;
        alamat.setText("") ;
                
    }
    public boolean val(String id, String nama, String telp, String alamat){
        return !id.isEmpty() && !nama.isEmpty() && !alamat.isEmpty() && !telp.isEmpty() ;
    }
    
    public void saveMember(JTextField id, JTextField nama, JTextField t, JTextArea a,
                           String idMember, String namaMember, String telp, String alamat){
        try{
            String sql = "insert into data_member (no_member, nama_konsumen, alamat, no_telp) values(?, ?, ?, ?)";
            pst = connect.prepareStatement(sql);
            
            String cek = "Select * from data_member where no_member ='"+idMember+"' ";
            stm = connect.createStatement();
            rs = stm.executeQuery(cek);
            
            setidMember(idMember);
            setnamaMember(namaMember);
            setalamatMember(alamat);
            setTelpMember(telp);
            
            if(val(idMember, namaMember, telp, alamat)){
            
                pst.setString(1, getidMember());
                pst.setString(2, getnamaMember());
                pst.setString(3, getalamatMember());
                pst.setString(4, getTelpMember());
            
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Member Telah Berhasil Disimpan");
                settxt(id, nama, t, a);
             
            }else {
            JOptionPane.showMessageDialog(null, "Data Lengkapi Untuk Diisi");
            }
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "" +ex.getMessage());
        }
    }
    
    public void loadMember(JTable table){
        int no = 1;
        DefaultTableModel dtm ;
        String kolom[] = {"ID Member","Nama Member","Alamat","Telpon"} ;
        dtm = new DefaultTableModel (null,kolom) ;
        
        try{
            String sql = "select * from data_member";
            stm = connect.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
            String id = rs.getString("no_member");
            String nama = rs.getString("nama_konsumen");
            String alamat = rs.getString("alamat");
            String telp = rs.getString("no_telp");
            
            dtm.addRow(new String[] {id, nama, alamat, telp});
            no++;
            table.setModel(dtm);
            }
            
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
    public void deleteData(JTable table){
        int record = table.getRowCount();
        int select = table.getSelectedRowCount() ;
        int i = table.getSelectedRow();
    
        int pilih;
        Object [] pilihan = {"Tidak!","Iya","sangat yakin."} ;
        
        try {   
        if (record > 0) {
        
        if(select>0){
            
                String hapus = "delete from data_member where no_member= '"+table.getValueAt(i, 0).toString()+"'" ;
                pst = connect.prepareStatement(hapus);
                
                pilih = JOptionPane.showOptionDialog(null,
                "Apakah Ingin Menghapus Data Member ?? "+"\n"+
                            "\t\t"+"ID Member :"+table.getValueAt(i, 0).toString()+"\n"+
                            "\t\t"+"Nama Member :"+table.getValueAt(i, 1).toString()+"\n",
                            "Konfirmasi",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        pilihan,
                        pilihan[1]) ;
                
            switch (pilih) {
                case 1:
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
                    loadMember(table);
                    break;
                case 2:
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Telah Berhasil Dihapus");
                    loadMember(table);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Batal Dihapus"); 
                    break;
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
    
    public void getTabletoTextField(JButton save, JButton update, JTable table, JTextField idMember, JTextField namaMember, JTextField telp, JTextArea alamat){
        int record = table.getRowCount();
        
        if (record > 0){
            int pilih = table.getSelectedColumnCount() ;
            if (pilih > 0 ) {
                int i = table.getSelectedRow();
                    
                idMember.setText(table.getValueAt(i, 0).toString());
                namaMember.setText(table.getValueAt(i, 1).toString()) ;
                telp.setText(table.getValueAt(i, 3).toString()) ;
                alamat.setText(table.getValueAt(i, 2).toString()) ;
                
                idMember.setEnabled(false);
                save.setEnabled(false);
                update.setEnabled(true);
               
            }else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada yang Dipilih");
            }
            }else {
            JOptionPane.showMessageDialog(null, "Data Kosong");
        }
    }
    
    public void updateMember(JButton update, JButton save, JTextField id, JTextField nama, JTextField t, JTextArea a,
                            JTextField txtid, String idMember, String namaMember, String telp, String alamat){
        try{
            String sql = "update data_member set no_member ='"+idMember+"', nama_konsumen ='"+namaMember+"', alamat ='"+alamat+"', no_telp ='"+telp+"' where no_member='"+idMember+"'" ;
            pst = connect.prepareStatement(sql);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update Data Berhasil");
            settxt(id, nama, t, a);
            
            txtid.setEnabled(true);
            save.setEnabled(true);
            update.setEnabled(false);
            
            JOptionPane.showMessageDialog(null, "to Refresh");
            
        } catch(SQLException ex){
          JOptionPane.showMessageDialog(null, "Perubahan Gagal " +ex.getMessage());
        }
    }
    
    
    public void SaveorUpdate(String idMember, String namaMember, String telp, String alamat){
        try{
            String sql = "select * from data_member where no_member ='"+idMember+"' ";
            stm = connect.createStatement();
            
            rs = stm.executeQuery(sql);
            
            setidMember(idMember);
            setnamaMember(namaMember);
            setalamatMember(alamat);
            setTelpMember(telp);
        
            while(rs.next()){
                
            if(idMember.equals(rs.getString("no_member"))){
                
                String update = "update data_member set no_member ='"+idMember+"', nama_konsumen ='"+namaMember+"', alamat ='"+alamat+"', no_telp ='"+telp+"' where no_member='"+idMember+"'" ;
                pst1 = connect.prepareStatement(update);
            
                pst1.execute();
                JOptionPane.showMessageDialog(null, "Update Data Berhasil Terbaru");    
            
            }else {
                
                if(idMember.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please insert id");
                
                }else {
                    String save = "insert into data_member (no_member, nama_konsumen, alamat, no_telp) values(?, ?, ?, ?)";
                    pst = connect.prepareStatement(save);
            
                pst.setString(1, getidMember());
                pst.setString(2, getnamaMember());
                pst.setString(3, getalamatMember());
                pst.setString(4, getTelpMember());
            
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Member Telah Berhasil Disimpan");
                
                }
            }
            }
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
    public void delete2(JTable table){
            
   try {
    int record = table.getRowCount();
    
    if (record > 0) {
        int selected = table.getSelectedRowCount() ;
        
        if (selected > 0) {
            int pilih = JOptionPane.showConfirmDialog(null, "Hapus Data ?","Pilih",JOptionPane.YES_NO_OPTION) ;
            if (pilih == JOptionPane.YES_OPTION) {
            int i = table.getSelectedRow() ;
            
           
            String sql = "delete from data_member where kode_articleProduk = '"+table.getValueAt(i, 0).toString()+"'";
            java.sql.Connection konek = (java.sql.Connection)DatabaseConnect.getKoneksi("localhost", "3306","root","","database_ooptugasakhir");
            java.sql.PreparedStatement prep = konek.prepareStatement(sql);
        
            prep.execute();
            
            JOptionPane.showMessageDialog(null,"Berhasil Dihapus");
            
            //disini loadTable
            
            }else {
                JOptionPane.showMessageDialog(null, "Hapus Data Batal");
            }
        
        }else {
            JOptionPane.showMessageDialog(null, "Pilih Baris Tabel");
        }
        
    }else {
        JOptionPane.showMessageDialog(null, "Data Masih Kosong");
    }
        }catch (Exception ex) {
            
        }
    }
    
    public void searchData(String txt, JTable tab){
        int jumlahRow = tab.getRowCount();
        for (int n=0; n<jumlahRow; n++){
        dtm.removeRow(0);
        }
        try{
            String sql = "SELECT * FROM data_member where nama_member like '%"+txt+"%'";
            stm = connect.createStatement();
            rs = stm.executeQuery(sql);
            
            String[] data = new String[4];
            int i = 1;
            
            while(rs.next()){
            data[0] = rs.getString("no_member") ;
            data[1] = rs.getString("nama_konsumen") ;
            data[2] = rs.getString("alamat") ;
            data[3] = rs.getString("no_telp") ;
            dtm.addRow(data);
            i++;
               
            }
            tab.setModel(dtm);
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Data yang amda cari tidak dapat ditemukan");
            System.err.println("error (search): " +ex);
        }
    }
}
