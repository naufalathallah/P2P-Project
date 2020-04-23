/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DB.DBP2P;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author NAUFAL
 */
public class Balance extends javax.swing.JFrame {

    static Connection conn;
    static Statement st;
    static String sql;
    PreparedStatement ps;
    static ResultSet rs;
    int idnya;
    
    public Balance() {
        conn = new DBP2P().setConnection();
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
    }

    public Balance(int id){
        conn = new DBP2P().setConnection();
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        idnya = id;
        tampilBalance();
    }
    
    public void tampilBalance(){
        try {
            sql = "SELECT * FROM user WHERE id_user LIKE '"+idnya+"'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while(rs.next()){
                lbBalance.setText(rs.getString("balance"));
            }
            
        } catch (Exception e) {
            System.out.println("ERROR"+e.getMessage());
        }
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
        lbBalance = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btBack2 = new javax.swing.JButton();
        tfTopUp = new javax.swing.JTextField();
        btTopUp = new javax.swing.JButton();
        lbId1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(194, 194, 194));

        lbBalance.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbBalance.setForeground(new java.awt.Color(0, 0, 0));
        lbBalance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBalance.setText("jLabel7");

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(43, 72, 109));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("BALANCE");

        btBack2.setBackground(new java.awt.Color(143, 38, 41));
        btBack2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btBack2.setForeground(new java.awt.Color(255, 255, 255));
        btBack2.setText("BACK");
        btBack2.setBorder(null);
        btBack2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBack2ActionPerformed(evt);
            }
        });

        tfTopUp.setBackground(new java.awt.Color(255, 255, 255));
        tfTopUp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfTopUp.setForeground(new java.awt.Color(0, 0, 0));
        tfTopUp.setBorder(null);

        btTopUp.setBackground(new java.awt.Color(65, 175, 96));
        btTopUp.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btTopUp.setForeground(new java.awt.Color(255, 255, 255));
        btTopUp.setText("TOP UP");
        btTopUp.setBorder(null);
        btTopUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btTopUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTopUpActionPerformed(evt);
            }
        });

        lbId1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbId1.setForeground(new java.awt.Color(0, 0, 0));
        lbId1.setText("Top up");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(469, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfTopUp, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(453, 453, 453))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbId1)
                        .addGap(547, 547, 547))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(499, 499, 499))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btTopUp, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(501, 501, 501))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbBalance)
                .addGap(48, 48, 48)
                .addComponent(lbId1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfTopUp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btTopUp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addComponent(btBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

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
    }// </editor-fold>//GEN-END:initComponents

    private void btBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBack2ActionPerformed
        this.dispose();
        Home home = new Home(idnya);
        home.setVisible(true);
    }//GEN-LAST:event_btBack2ActionPerformed

    private void btTopUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTopUpActionPerformed
        int n = JOptionPane.showConfirmDialog(null, "Are you sure want to Top Up?",
                                                    "Top Up",
                                                    JOptionPane.YES_NO_CANCEL_OPTION,
                                                    JOptionPane.QUESTION_MESSAGE, null);
        if(n == 0){
            int topup = Integer.parseInt(tfTopUp.getText());
            int saldo = Integer.parseInt(lbBalance.getText());

            try {
                sql = "UPDATE user SET "
                    + "balance = ? "
                    + "WHERE id_user="+idnya;
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, saldo+topup);

                    int rt = ps.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Succeed","Information",JOptionPane.INFORMATION_MESSAGE);
                    tfTopUp.setText("");
                    tampilBalance();
            } catch (Exception e) {
                System.out.println("ERROR"+e.getMessage());
            }
        }
        
        
    }//GEN-LAST:event_btTopUpActionPerformed

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
            java.util.logging.Logger.getLogger(Balance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Balance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Balance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Balance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Balance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack2;
    private javax.swing.JButton btTopUp;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbBalance;
    private javax.swing.JLabel lbId1;
    private javax.swing.JTextField tfTopUp;
    // End of variables declaration//GEN-END:variables
}