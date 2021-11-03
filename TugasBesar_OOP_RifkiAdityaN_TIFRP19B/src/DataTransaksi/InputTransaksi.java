package DataTransaksi;

import MainMenu_Dashboard_Bantuan.MenuUtama;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acer_
 */
public class InputTransaksi extends javax.swing.JFrame {

    /**
     * Creates new form InputTransaksi
     */
    public InputTransaksi() {
        initComponents();
        
        tanggalHariini();
    }
    
    //
    ClassTransaksi1 ct = new ClassTransaksi1();
    
    private void changecolor(JPanel panel, Color warna) {
        panel.setBackground(warna);
    }
    
    private void tanggalHariini(){
        Date dt = new Date();
        
        tgl.setDate(dt);
    }
    
    private void cetak(){
        String namak = txtnamaK.getText();
    String id = txtidK.getText() ;
        String noT = txttrans.getText();
        String kodea = txtkodeA.getText(); 
        String namaP = txtnamaP.getText();
        String harga = txtharga.getText();
        String qty = txtqty.getText();
        
        SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
        String tglTrans = df.format(tgl.getDate());
        
        String idM = txtidM.getText();
        String dis = txtdiscount.getText();
        String total = txttotal.getText();
        
        struk.setText(struk.getText() + "======================================================\n");
        struk.setText(struk.getText() + "================ MATAHARI DEPT. STORE ==================\n");
        struk.setText(struk.getText() + "=========================================================\n");
        struk.setText(struk.getText() + "============ jl. SOEKARNO HATTA BANDUNG ===================\n");
        struk.setText(struk.getText() + "======================================================\n");
        struk.setText(struk.getText() + "\n\n");
        
        struk.setText(struk.getText() + "No jual         : " +noT+ "\n\n") ;
        struk.setText(struk.getText() + "ID Cashier      : " +id+ "\n\n") ;
        struk.setText(struk.getText() + "======================================================\n");
        struk.setText(struk.getText() + "No Kuitansi        : " +"-"+ "\n\n");
        struk.setText(struk.getText() + "Tgl Transaksi      : " +tglTrans+ "\n\n");
        struk.setText(struk.getText() + "No. Member         : " +idM+ "\n\n");
        struk.setText(struk.getText() + "======================================================\n");
        struk.setText(struk.getText() + "Item   : "+kodea+ " | " +namaP+ " | " +harga+ "\n\n") ; 
        struk.setText(struk.getText() + "======================================================\n");
        struk.setText(struk.getText() + "qty    : "+qty+ "\n\n") ; 
        struk.setText(struk.getText() + "======================================================\n");
        struk.setText(struk.getText() + "Total              : " +total+ "\n\n");
        struk.setText(struk.getText() + "Cash               : " +txtcash.getText()+ "\n\n");
        struk.setText(struk.getText() + "Kembali            : " +labelkembali.getText()+ "\n\n");
        struk.setText(struk.getText() + "\n\n");
        struk.setText(struk.getText() + "======================================================\n");
        
        struk.setText(struk.getText() + "=========== Terima Kasih ==========\n");
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelIcon = new javax.swing.JPanel();
        jPclose = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPMax = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPMin = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        labelnoTrans = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnamaP = new javax.swing.JTextField();
        tgl = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtkodeA = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        txtqty = new javax.swing.JTextField();
        txtnamaM = new javax.swing.JTextField();
        txtidM = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtsubTotal = new javax.swing.JTextField();
        txtdiscount = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        labelid = new javax.swing.JLabel();
        labelnama = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtcash = new javax.swing.JTextField();
        labelkembali = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        struk = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txttrans = new javax.swing.JTextField();
        txtnamaK = new javax.swing.JTextField();
        txtidK = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(890, 32));
        jPanel2.setLayout(new java.awt.BorderLayout());

        panelIcon.setBackground(new java.awt.Color(255, 255, 255));
        panelIcon.setPreferredSize(new java.awt.Dimension(138, 32));
        panelIcon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPclose.setBackground(new java.awt.Color(152, 201, 216));
        jPclose.setPreferredSize(new java.awt.Dimension(50, 50));
        jPclose.setLayout(new java.awt.BorderLayout());

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/closeToolbar.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        jPclose.add(jLabel11, java.awt.BorderLayout.CENTER);

        panelIcon.add(jPclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 0, -1, 25));

        jPMax.setBackground(new java.awt.Color(255, 255, 255));
        jPMax.setPreferredSize(new java.awt.Dimension(50, 50));
        jPMax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPMaxMouseEntered(evt);
            }
        });
        jPMax.setLayout(new java.awt.BorderLayout());

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/maxToolBar2.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        jPMax.add(jLabel12, java.awt.BorderLayout.CENTER);

        panelIcon.add(jPMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 0, 50, 25));

        jPMin.setBackground(new java.awt.Color(255, 255, 255));
        jPMin.setPreferredSize(new java.awt.Dimension(50, 50));
        jPMin.setLayout(new java.awt.BorderLayout());

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/minToolBar.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        jPMin.add(jLabel13, java.awt.BorderLayout.CENTER);

        panelIcon.add(jPMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 32, 25));

        jPanel2.add(panelIcon, java.awt.BorderLayout.LINE_END);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setPreferredSize(new java.awt.Dimension(200, 548));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/latarTransaksi.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel3.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.LINE_START);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelnoTrans.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelnoTrans.setText("no. Transaksi");
        jPanel4.add(labelnoTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 90, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setText("Tanggal");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 70, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setText("Kode Article");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 90, 30));

        txtnamaP.setEditable(false);
        txtnamaP.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtnamaP.setText("Tampil Nama Produk");
        txtnamaP.setEnabled(false);
        jPanel4.add(txtnamaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 130, 30));

        tgl.setDateFormatString("dd/MM/yyyy");
        tgl.setEnabled(false);
        jPanel4.add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 130, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setText("qty");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 100, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Discount");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, 80, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("sub Total");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, 80, 30));

        txtkodeA.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtkodeA.setText("kode Article");
        jPanel4.add(txtkodeA, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 100, 30));

        txtharga.setEditable(false);
        txtharga.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtharga.setText("harga");
        txtharga.setEnabled(false);
        jPanel4.add(txtharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 130, 30));

        txtqty.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtqty.setText("qty");
        jPanel4.add(txtqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 130, 30));

        txtnamaM.setEditable(false);
        txtnamaM.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtnamaM.setText("Tampil Nama");
        txtnamaM.setEnabled(false);
        jPanel4.add(txtnamaM, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 130, 30));

        txtidM.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtidM.setText("ID Member");
        txtidM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidMActionPerformed(evt);
            }
        });
        jPanel4.add(txtidM, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 130, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setText("Member");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 80, 30));

        txtsubTotal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtsubTotal.setText("Kalkulasi Jumlah");
        txtsubTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.add(txtsubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 130, 30));

        txtdiscount.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtdiscount.setText("Discount");
        txtdiscount.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtdiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiscountActionPerformed(evt);
            }
        });
        jPanel4.add(txtdiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, 130, 30));

        jButton1.setText("-->");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 50, 30));

        labelid.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelid.setText("id Cashier");
        jPanel4.add(labelid, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 30));

        labelnama.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelnama.setText("Nama Cashier");
        jPanel4.add(labelnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 80, 30));

        txttotal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txttotal.setText("Total");
        jPanel4.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 130, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel16.setText("Total");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 80, 30));

        txtcash.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtcash.setText("cash");
        jPanel4.add(txtcash, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 130, 30));

        labelkembali.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        labelkembali.setText("Kembali");
        labelkembali.setEnabled(false);
        jPanel4.add(labelkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 130, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel18.setText(" /produk");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, 50, 30));

        struk.setColumns(20);
        struk.setRows(5);
        jScrollPane1.setViewportView(struk);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 300, 310));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel20.setText("Cash");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 80, 30));

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 30, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/save.png"))); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 460, 80, 70));

        txttrans.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txttrans.setText("no. Transaksi");
        txttrans.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txttransFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txttransFocusLost(evt);
            }
        });
        jPanel4.add(txttrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 130, 30));

        txtnamaK.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel4.add(txtnamaK, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 130, 30));

        txtidK.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtidK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidKActionPerformed(evt);
            }
        });
        jPanel4.add(txtidK, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 30));

        jButton4.setText("Hitung");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, -1, 30));

        jButton5.setText("Tampilkan");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 370, 90, 30));

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        this.dispose();
        new MenuUtama().setVisible(true);
        
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        changecolor(jPclose, new Color(234, 44, 12));
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        changecolor(jPclose, new Color(152,201,216));
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        if(this.getExtendedState() != InputTransaksi.MAXIMIZED_BOTH){
            this.setExtendedState(InputTransaksi.MAXIMIZED_BOTH);
        }else {
            this.setExtendedState(InputTransaksi.NORMAL);
        }
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        changecolor(jPMax, new Color(0, 149, 246));
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        changecolor(jPMax, new Color(255,255,255));
    }//GEN-LAST:event_jLabel12MouseExited

    private void jPMaxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPMaxMouseEntered

    }//GEN-LAST:event_jPMaxMouseEntered

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        if(this.getExtendedState() != InputTransaksi.HIDE_ON_CLOSE){
            this.setExtendedState(InputTransaksi.HIDE_ON_CLOSE);
        }else {
            this.setExtendedState(InputTransaksi.HIDE_ON_CLOSE);
        }
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        changecolor(jPMin, new Color(0, 149, 246));
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        changecolor(jPMin, new Color(255,255,255));
    }//GEN-LAST:event_jLabel13MouseExited

    private void txtdiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiscountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiscountActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    ct.gettxtKodeA(txtkodeA.getText(), txtnamaP, txtharga);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String idk = txtidK.getText();         String noTrans = txttrans.getText();
        String namak = txtnamaK.getText();     String kodeA = txtkodeA.getText();
        String namaP = txtnamaP.getText();      String idM = txtidM.getText();
        SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
        String tglTrans = df.format(tgl.getDate());
        String harga = txtharga.getText();
        String qty = txtqty.getText();
        String sub = txtsubTotal.getText();
        String total = txttotal.getText().toString();
        
        ct.saveTransaksi(idk, namak, tglTrans, noTrans, kodeA, namaP, harga, qty, idM, sub, total);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ct.Updatestok("Beli", txtkodeA.getText(), txtqty);
        ct.subTotal(txtharga, txtqty, txtsubTotal, txttotal);
        ct.getmember(txtidM.getText(), txtnamaM, txtdiscount);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txttransFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttransFocusGained
        if(txttrans.getText().equals("no. Transaksi")){
            txttrans.setText("");
        }
    }//GEN-LAST:event_txttransFocusGained

    private void txttransFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttransFocusLost
        if(txttrans.getText().equals("")){
            txttrans.setText("no. Transaksi");
        }
    }//GEN-LAST:event_txttransFocusLost

    private void txtidKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidKActionPerformed

    private void txtidMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidMActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        double sub = Double.parseDouble(txtsubTotal.getText());
        double total = Double.parseDouble(txttotal.getText());
        double disc = Double.parseDouble(txtdiscount.getText());
        
        double cash = Double.parseDouble(txtcash.getText());
        double eksekusi = cash - sub;
        labelkembali.setText(Double.toString(eksekusi));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        cetak();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InputTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPMax;
    private javax.swing.JPanel jPMin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPclose;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelid;
    private javax.swing.JLabel labelkembali;
    private javax.swing.JLabel labelnama;
    private javax.swing.JLabel labelnoTrans;
    private javax.swing.JPanel panelIcon;
    private javax.swing.JTextArea struk;
    private com.toedter.calendar.JDateChooser tgl;
    private javax.swing.JTextField txtcash;
    private javax.swing.JTextField txtdiscount;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtidK;
    private javax.swing.JTextField txtidM;
    private javax.swing.JTextField txtkodeA;
    private javax.swing.JTextField txtnamaK;
    private javax.swing.JTextField txtnamaM;
    private javax.swing.JTextField txtnamaP;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txtsubTotal;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txttrans;
    // End of variables declaration//GEN-END:variables
}