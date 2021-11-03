/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataGudang;

import DataProduk_dan_Supplier.ClassProduk1;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer_
 */
public class ClassGudang1 extends ClassGudang{
    PreparedStatement pst;
    Statement stm;
    ResultSet rs;
    DefaultTableModel dtm;
    //connect DB
    Connection connect = DatabaseConnect.DatabaseConnect.getKoneksi("localhost", "3306", "root", "", "database_ooptugasakhir");
    
    
    //deklare Var
    private String idM, namaM, alamatM, telpM;
    private File selectedFileFile;
    private FileInputStream fis;
    byte[] photo=null ;
    private ImageIcon format=null;
    
    
    //constructor
    ClassGudang1(){
        
    }
    
    ClassGudang1(String idK, String namaK, String kodeA, String namaP, String idSupp, String tgl, int jumlah){
        super.setidKaryawan(idK);
        super.setnamaKaryawan(namaK);
        super.setkodeA(kodeA);
        super.setnamaProduk(namaP);
        super.setidSupply(idSupp);
        super.settglMasuk(tgl);
        super.setjumlahMasukProduk(jumlah);
    }
    
    //getter
    public String getidKaryawan(){
        return super.getidKaryawan();
    }
    public String getnamaKaryawan(){
        return super.getnamaKaryawan();
    }
    public String getkodeA(){
        return super.getkodeA();
    }
    public String getnamaProduk(){
        return super.getnamaProduk();
    }
    public String getidSupply(){
        return super.getidSupply();
    }
    public String gettglMasuk(){
        return super.gettglMasuk() ;
    }
    public int getjumlahMasukProduk(){
        return super.getjumlahMasukProduk();
    }
    
    //
    public void showdataIDProduk(JTable table, JLabel lb) {
        DefaultTableModel dtm = new DefaultTableModel() ;
        String kolom[] = {"Kode Article","Nama Produk","ID Supplier","Jenis Produk","Harga"} ;
        dtm = new DefaultTableModel(null,kolom) ;
        
        try {
            stm = connect.createStatement();
            String query = "SELECT * FROM data_produk" ;
            rs = stm.executeQuery(query);
            
            while(rs.next()){
                    
            String idSup = rs.getString("id_brandSupplier") ;
            setkodeA(rs.getString("kode_articleProduk")) ;
            setnamaProduk(rs.getString("nama_produk")) ;
            String jenis = rs.getString("jenis_produk") ;
            String harga = rs.getString("harga") ;
            
            byte[] image = rs.getBytes("photoBrand") ;
            format = new ImageIcon(image) ;
            
            
            dtm.addRow(new String[] {getkodeA(),getnamaProduk(),idSup,jenis,harga});
            table.setModel(dtm);
            
            int total = rs.getRow();        
            lb.setText(Integer.toString(total) +" Product");
                
        }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    //updatestok
    private int cekStok(String kodeArt){
        int stok=0;
        String cekJumlahProduk = "select stok_produk from data_produk where kode_articleProduk ='"+kodeArt+"' ";
        
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
    private void Updatestok(String ubah, String kodeArt, JSpinner js) {
        int stokbaru =0;
        
        setkodeA(kodeArt);
        setjumlahMasukProduk(Integer.parseInt(js.getValue().toString()));
        Object [] pilih = {"OK"} ; 
        try{
        
            if(ubah.equals("tambah")){
                stokbaru = cekStok(getkodeA()) +getjumlahMasukProduk();
                JOptionPane.showMessageDialog(null, "Data Telah Berhasil Di Simpan " +"\n"+
                "\t\t" +"Jumlah Stok ID Produk " +getkodeA()+ " Bertambah " +getjumlahMasukProduk());
                
            }else if(ubah.equals("hapus")){
                stokbaru = cekStok(getkodeA());
            }
            
        String update = "update data_produk set stok_produk ='"+stokbaru+"' where kode_articleProduk ='"+getkodeA()+"' ";    
        pst = connect.prepareStatement(update);
        
        pst.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //tampil
    public void cBox(JComboBox box){
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
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("" +ex.getMessage());
        }
    }
    
    public void cBoxSupp(JComboBox box){
        try{
        String tampil = "select nama_supplier from data_supplier order by nama_supplier asc";
        stm = connect.createStatement();
        rs = stm.executeQuery(tampil);
        
        while(rs.next()){
        Object[] ob = new Object [1];
        ob[0] = rs.getString(1);
        
        box.addItem((String) ob[0]);
        
        }
        rs.close();
        stm.close();
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("" +ex.getMessage());
        }
    }
    
    public void tampildariCBox(JComboBox box, JTextField namaProduk, JTextField idSupp, JLabel jenis){
        try{
            String sql = "Select id_brandSupplier, nama_produk, jenis_produk from data_produk where kode_articleProduk ='"+box.getSelectedItem().toString()+"' ";
            stm = connect.createStatement();
            rs = stm.executeQuery(sql);
            
            if(box.getSelectedIndex() == 0){
                
                namaProduk.setText("");
                idSupp.setText("");
                jenis.setText("Jenis Produk");
            
            }else {
            
                while(rs.next()){
                Object[] ob = new Object[3];
                
                ob[0]   = rs.getString(1);
                ob[1]   = rs.getString(2);
                ob[2]   = rs.getString(3);
                
                namaProduk.setText((String) ob[1]);
                idSupp.setText((String) ob[0]);
                jenis.setText((String) ob[2]);
            }
            }
            rs.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void idSupplier(String idS, JLabel namaS){
        try{
            setidSupply(idS);
            
            String sql = "select id_supplier, nama_supplier from data_supplier where id_supplier ='"+idS+"' ";
            stm = connect.createStatement();
            rs = stm.executeQuery(sql);
        
            while(rs.next()){
                if(idS.equals(rs.getString(1))){
                    
                namaS.setText(rs.getString(2));
                
                }else if(getidSupply().equals("Tampil id Supplier") || getidSupply().equals("")){
                
                namaS.setText("Tampil Nama Supplier");
                }
        }
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void saveGudangUpdateStok(String kodeArt, String namaArt, String idKar, String namaKar, String idSupp, String tglMasuk, JSpinner jml){
        Object [] pilihan = {"Batal", "Yakin"};
        int xpilih;
        try{
            
        String sql = "insert into datamasuk_gudang (id_karyawan, nama_karyawan, kode_articleProduk, id_supplier, nama_produk, tgl_masukProduk, jumlahMasuk_produk) values (?, ?, ?, ?, ? ,? ,?)";
        pst = connect.prepareStatement(sql);
        
        setkodeA(kodeArt);
        setnamaProduk(namaArt);
        setidKaryawan(idKar);
        setnamaKaryawan(namaKar);
        setidSupply(idSupp);
        settglMasuk(tglMasuk);
        setjumlahMasukProduk(Integer.parseInt(jml.getValue().toString()));
        
            if(jml.getValue().toString().equals("0")){
             xpilih = JOptionPane.showOptionDialog(null, "Apakah Jumlah Stok Tidak Akan Ditambah ?? " +"\n"
             + "\t\t" +"ID Karyawan          : " +getidKaryawan()+ "\n" 
             + "\t\t" +"Nama Karyawan   : " +getnamaKaryawan()+ "\n"
             +"Tidak Menambahkan Stok Untuk " +getnamaProduk(),
              "Informasi",
              JOptionPane.YES_NO_OPTION, 
              JOptionPane.QUESTION_MESSAGE, null,
              pilihan, pilihan[1]);
             
            }else if (getjumlahMasukProduk() < 0) {
            JOptionPane.showMessageDialog(null, "Jumlah Stok Tidak Boleh (-)");
            
            }else {
        
        pst.setString(1, getidKaryawan());
        pst.setString(2, getnamaKaryawan());
        pst.setString(3, getkodeA());
        pst.setString(4, getidSupply());
        pst.setString(5, getnamaProduk());
        pst.setString(6, gettglMasuk());
        pst.setInt(7, getjumlahMasukProduk());
        
        JOptionPane.showMessageDialog(null, "Data Telah Tersimpan");
        Updatestok("tambah", getkodeA(), jml);
        }
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("" +ex.getMessage());
        }
    }
    
    
    public void EditTable(JFrame fr, JFrame fr2, JTable table, JTextField txt1, JTextField txt2, JComboBox cbox3, JComboBox cbox4,
                           JTextField txt5, JLabel labelfoto, JButton jb, JButton jb2){
        // TODO add your handling code here:
        int record = table.getRowCount();
        int i = table.getSelectedRow();
        
        if(record >0) {
            int row = table.getSelectedColumnCount();
            if(row > 0) {
                try {
                String query = "SELECT * FROM data_produk WHERE kode_articleProduk = '"+table.getValueAt(i, 0).toString()+"'"; 
                stm = connect.createStatement();
                rs = stm.executeQuery(query);
                
                while(rs.next()){
                    Blob gmb = (Blob) rs.getBlob("photoBrand") ;
                    int u = (int) (gmb.length());
                    ImageIcon im = new ImageIcon(gmb.getBytes(1, u));
                    
                
                fr.setVisible(true);
                txt1.setText(table.getValueAt(i, 0).toString());
                txt2.setText(table.getValueAt(i, 1).toString());
                cbox3.setSelectedItem(table.getValueAt(i, 2).toString());
                cbox4.setSelectedItem(table.getValueAt(i, 3).toString());
                txt5.setText(table.getValueAt(i, 4).toString());
                
                labelfoto.setIcon(im);
                jb.setEnabled(false);
                jb2.setEnabled(true);
                txt1.setEnabled(false);
                
                fr2.dispose();
                }
                }catch (SQLException e){
            e.printStackTrace();
            }
                
            }else{
                JOptionPane.showMessageDialog(null, "Data Tidak Ada yang Dipilih");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Data Kosong");
        }
        
    }
    
    public void clicktoTable(JTable table, JLabel txt1, JLabel labelfoto){
        // TODO add your handling code here:
        int record = table.getRowCount();
        int i = table.getSelectedRow();
        
        try {
            stm = connect.createStatement();
            String query = "SELECT * FROM data_produk WHERE kode_articleProduk = '"+table.getValueAt(i, 0).toString()+"'"; ;
            rs = stm.executeQuery(query);
        
        if(record >0) {
            int row = table.getSelectedRowCount();
            if(row > 0) {
                while(rs.next()){
                    Blob gmb = (Blob) rs.getBlob("photoBrand") ;
                    int u = (int) (gmb.length());
                    ImageIcon im = new ImageIcon(gmb.getBytes(1, u));
                    
            
                txt1.setText(table.getValueAt(i, 1).toString());
                
                labelfoto.setIcon(im);
                }
            }
        } else {
            
        }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void searchData(String txt, JTable tab){
        int jumlahRow = tab.getRowCount();
        for (int n=0; n<jumlahRow; n++){
        dtm.removeRow(0);
        }
        try{
            String sql = "SELECT * FROM data_produk where nama_produk like '%"+txt+"%'";
            stm = connect.createStatement();
            rs = stm.executeQuery(sql);
            
            String[] data = new String[5];
            int i = 1;
            
            while(rs.next()){
            data[0] = rs.getString("id_brandSupplier") ;
            data[1] = rs.getString("kode_articleProduk") ;
            data[2] = rs.getString("nama_produk") ;
            data[3] = rs.getString("jenis_produk") ;
            data[4] = rs.getString("harga") ;
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
    
    public void deleteProduk(JTable table){ 
        
        int record = table.getRowCount();
        int select = table.getSelectedRowCount() ;
        int i = table.getSelectedRow();
        
        try {
            if (record > 0) {

                if(select>0){
                    int pilih = JOptionPane.showConfirmDialog(null, "Apakah Data Akan Dihapus?","WARNING",JOptionPane.YES_NO_OPTION); ;

                    if (pilih == JOptionPane.YES_OPTION) {
                        Statement sat = connect.createStatement();
                        String hapus = "delete from data_produk where kode_articleProduk= '"+table.getValueAt(i, 0).toString()+"'" ;
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
    
    
    private void tgl(Date dateF){
    
        SimpleDateFormat dsf = new SimpleDateFormat("dd-MM-yyy");
        String date = dsf.format(dateF.getDate());
        
    }
    
}
