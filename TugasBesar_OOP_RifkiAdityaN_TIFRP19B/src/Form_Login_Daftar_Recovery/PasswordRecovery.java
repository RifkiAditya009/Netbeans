/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form_Login_Daftar_Recovery;

import java.awt.Color;
import Form_Login_Daftar_Recovery.FormMasuk;

/**
 *
 * @author acer_
 */
public class PasswordRecovery extends javax.swing.JFrame {

    /**
     * Creates new form PasswordRecovery
     */
    public PasswordRecovery() {
        initComponents();
        txtidentitas.setBackground(new Color(0,0,0,0));
        jTextField2.setBackground(new Color(0,0,0,0));
        securityCode.setBackground(new Color(0,0,0,0));
    }
    
    //
    ClassAkun1 ca = new ClassAkun1();
    

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
        tampilPassword = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtidentitas = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        labelText = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        securityCode = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        labelText1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        tampilFoto = new javax.swing.JLabel();
        latarFoto = new javax.swing.JLabel();
        getLabelNama = new javax.swing.JLabel();
        latar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tampilPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tampilPassword.setForeground(new java.awt.Color(255, 255, 255));
        tampilPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tampilPassword.setText("password here");
        jPanel2.add(tampilPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 100, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Request get password");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 190, 30));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/singup.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/singup3.png"))); // NOI18N
        jButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/singup3.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 73, 27));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("demi keamanan masukan recovery code akun.");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Silahkan masukan id karyawan atau username anda,");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        txtidentitas.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtidentitas.setForeground(new java.awt.Color(255, 255, 255));
        txtidentitas.setBorder(null);
        txtidentitas.setOpaque(false);
        txtidentitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidentitasActionPerformed(evt);
            }
        });
        jPanel2.add(txtidentitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 210, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/cariicon.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 50, 30));

        labelText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/textfield.png"))); // NOI18N
        jPanel2.add(labelText, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 220, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/getPassword.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/getPassword2.png"))); // NOI18N
        jButton2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/getPassword2.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 290, 30));

        securityCode.setEditable(false);
        securityCode.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        securityCode.setForeground(new java.awt.Color(255, 255, 255));
        securityCode.setBorder(null);
        securityCode.setEnabled(false);
        securityCode.setOpaque(false);
        securityCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                securityCodeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                securityCodeFocusLost(evt);
            }
        });
        securityCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                securityCodeActionPerformed(evt);
            }
        });
        securityCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                securityCodeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                securityCodeKeyTyped(evt);
            }
        });
        jPanel2.add(securityCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 180, 30));

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setText("recovery code");
        jTextField2.setBorder(null);
        jTextField2.setEnabled(false);
        jTextField2.setOpaque(false);
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 180, 30));

        labelText1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/textfield.png"))); // NOI18N
        jPanel2.add(labelText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 190, 30));

        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Back to login");
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 405, 100, 30));

        tampilFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tampilFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/foto.png"))); // NOI18N
        jPanel2.add(tampilFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 120, 120));

        latarFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        latarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/bingkaifoto.png"))); // NOI18N
        jPanel2.add(latarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 120, 120));

        getLabelNama.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        getLabelNama.setForeground(new java.awt.Color(255, 255, 255));
        getLabelNama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getLabelNama.setText("Username");
        jPanel2.add(getLabelNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 262, 380, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 380, 450));

        latar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/latarPasswordRecovery.jpg"))); // NOI18N
        jPanel1.add(latar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 510));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FormMasuk fl = new FormMasuk(); 
        fl.setVisible(true);
        
        // aktif/off
        fl.PanelSignup.setVisible(true);
        fl.taskbar.setVisible(true);
        fl.PanelLogin.setVisible(false);
        fl.panelPilihan.setVisible(false);
        
        //
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ca.getAkun(txtidentitas.getText(), securityCode.getText(), tampilPassword);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtidentitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidentitasActionPerformed
        String txtnama = txtidentitas.getText();
        ca.getNama(txtnama, getLabelNama);
        
        securityCode.setEnabled(true);
        securityCode.setEditable(true);
    }//GEN-LAST:event_txtidentitasActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        jTextField2.setText("");
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FormMasuk fl = new FormMasuk(); 
        fl.setVisible(true);
        
        // aktif/off
        fl.PanelSignup.setVisible(false);
        fl.taskbar.setVisible(true);
        fl.PanelLogin.setVisible(true);
        fl.panelPilihan.setVisible(false);
        
        //
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String txtnama = txtidentitas.getText();
        ca.getNama(txtnama, getLabelNama);
        
        securityCode.setEnabled(true);
        securityCode.setEditable(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        
    }//GEN-LAST:event_jTextField2FocusLost

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
       
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        
    }//GEN-LAST:event_jTextField2KeyPressed

    private void securityCodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_securityCodeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_securityCodeFocusGained

    private void securityCodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_securityCodeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_securityCodeFocusLost

    private void securityCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_securityCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_securityCodeActionPerformed

    private void securityCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_securityCodeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_securityCodeKeyPressed

    private void securityCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_securityCodeKeyTyped
        if("".equals(securityCode.getText()))
        {
            jTextField2.setVisible(true);
            jTextField2.setEnabled(false);
        }else {
            jTextField2.setVisible(false);
            jTextField2.setEnabled(false);
        }
    }//GEN-LAST:event_securityCodeKeyTyped

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
            java.util.logging.Logger.getLogger(PasswordRecovery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasswordRecovery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasswordRecovery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordRecovery.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PasswordRecovery().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel getLabelNama;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelText;
    private javax.swing.JLabel labelText1;
    private javax.swing.JLabel latar;
    private javax.swing.JLabel latarFoto;
    public javax.swing.JTextField securityCode;
    private javax.swing.JLabel tampilFoto;
    public javax.swing.JLabel tampilPassword;
    public javax.swing.JTextField txtidentitas;
    // End of variables declaration//GEN-END:variables
}