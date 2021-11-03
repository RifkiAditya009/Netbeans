/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataProduk_dan_Supplier;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer_
 */
public class ClassSupplier1 extends ClassSupplier{
    PreparedStatement pst;
    Statement stm; 
    ResultSet rs;
    
    private String idSupplier, namaSupplier, alamatKantor, telpKantor;
    
    //Connect DB
    Connection connect = DatabaseConnect.DatabaseConnect.getKoneksi("localhost", "3306", "root", "", "database_ooptugasakhir");
    
    //constructor
    ClassSupplier1(){
        
    }
    
    ClassSupplier1(String idSup, String namaSup, String alamatSup, String telpSup){
        super.setIdSupplier(idSup);
        super.setnamaSupplier(namaSup);
        super.setalamatKantor(alamatSup);
        super.settelpKantor(telpSup);
    }
    
    
    //getter
    public String getIdSupplier(){
        return super.getIdSupplier();
    }
    public String getnamaSupplier(){
        return super.getnamaSupplier();
    }
    public String getalamatKantor(){
        return super.getalamatKantor();
    }
    public String gettelpKantor(){
        return super.gettelpKantor();
    }
    
    public boolean val(String id, String nama, String alamat, String telp){
        return !id.isEmpty() && !nama.isEmpty() && !alamat.isEmpty() && !telp.isEmpty() ;
    }
    
    public void settxt(JTextField id, JTextField nama, JTextField alamat, JTextField telp){
        id.setText(""); nama.setText(""); alamat.setText(""); telp.setText("");
    }
    
    //desain
    private void menuBar(JPanel pputih,JPanel pbiru, JPanel pclose, JPanel ptrue, JLabel label){
        pputih.setBackground(new Color(255,255,255));
        pbiru.setBackground(new Color(54,101,179));
        label.setForeground(new Color(0,0,0));
        
        pclose.setVisible(false);
        ptrue.setVisible(true);
    }
    private void changeCText(JLabel label, Color wr ){
        label.setForeground(wr);
    }
    //data
    public void saveSupplier(String id, String nama, String alamat, String telp, JTextField id2, JTextField nama2, 
                             JTextField alamat2, JTextField telp2){
        try{
            
            String sql = "insert into data_supplier (id_supplier, nama_supplier, alamat_kantor, telp_kantor) values (?, ?, ?, ?)";
            pst = connect.prepareStatement(sql);
            
            setIdSupplier(id);
            setnamaSupplier(nama);
            setalamatKantor(alamat);
            settelpKantor(telp);
            
            String cek = "Select * from data_supplier where id_supplier ='"+getIdSupplier()+"' ";
            stm = connect.createStatement();
            rs = stm.executeQuery(cek);
            
            if(val(id, nama, alamat, telp)){
                pst.setString(1, getIdSupplier());
                pst.setString(2, getnamaSupplier());
                pst.setString(3, getalamatKantor());
                pst.setString(4, gettelpKantor());
            
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                settxt(id2, nama2, alamat2, telp2);
                
            } else {
            JOptionPane.showMessageDialog(null, "Pastikan Semua Data Diisi");
                
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void loadSupplier(JTable table){
        int no = 1;
        DefaultTableModel dtm ;
        String kolom[] = {"ID Supplier","Nama Supplier","Alamat Kantor","Telpon Kantor"} ;
        dtm = new DefaultTableModel (null,kolom) ;
        
        try{
            String sql = "select * from data_supplier";
            stm = connect.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
            String id = rs.getString("id_supplier");
            String nama = rs.getString("nama_supplier");
            String alamat = rs.getString("alamat_kantor");
            String telp = rs.getString("telp_kantor");
            
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
            
                String hapus = "delete from data_supplier where id_supplier ='"+table.getValueAt(i, 0).toString()+"'" ;
                pst = connect.prepareStatement(hapus);
                
                pilih = JOptionPane.showOptionDialog(null,
                "Apakah Ingin Menghapus Data Member ?? "+"\n"+
                            "\t\t"+"ID Supplier :"+table.getValueAt(i, 0).toString()+"\n"+
                            "\t\t"+"Nama Supplier :"+table.getValueAt(i, 1).toString()+"\n",
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
                    break;
                case 2:
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Telah Berhasil Dihapus");
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
    
    public void getTabletoTextField(JTable table, JLabel label, JLabel label2, JPanel pputih,JPanel pbiru, JPanel pclose, JPanel ptrue, JTextField idS, 
                                    JTextField namaS, JTextField alamat, JTextField telp, JButton bt, JButton bt2){
        int record = table.getRowCount();
        
        if (record > 0){
            int pilih = table.getSelectedColumnCount() ;
            if (pilih > 0 ) {
                int i = table.getSelectedRow();
                    
                idS.setText(table.getValueAt(i, 0).toString());
                namaS.setText(table.getValueAt(i, 1).toString()) ;
                alamat.setText(table.getValueAt(i, 2).toString()) ;
                telp.setText(table.getValueAt(i, 3).toString()) ;
                
                menuBar(pputih, pbiru, pclose, ptrue, label2);
                label.setForeground(Color.WHITE);
                bt.setEnabled(false);
                idS.setEnabled(false);
                bt2.setEnabled(true);
            }else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada yang Dipilih");
            }
            }else {
            JOptionPane.showMessageDialog(null, "Data Kosong");
        }
    }
    
    public void updateSupplier(String idS, String namaS, String alamat, String telp, JButton jb, JTextField tf, JButton jb2){
        try{
            String sql = "update data_supplier set nama_supplier ='"+namaS+"', alamat_kantor ='"+alamat+"', telp_kantor ='"+telp+"' where id_supplier ='"+idS+"'" ;
            pst = connect.prepareStatement(sql);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Update Data Berhasil");
            jb.setEnabled(true);
            tf.setEnabled(true);
            jb2.setEnabled(false);
            
        } catch(SQLException ex){
          JOptionPane.showMessageDialog(null, "Perubahan Gagal " +ex.getMessage());
        }
    }
    
    
    
}
