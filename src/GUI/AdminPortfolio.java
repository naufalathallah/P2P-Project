/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DB.DBP2P;
import MODEL.Purchase;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author NAUFAL
 */
public class AdminPortfolio extends javax.swing.JFrame {

    static Connection conn;
    static Statement st;
    static String sql;
    PreparedStatement ps;
    static ResultSet rs;
    Purchase purchase;
    
    public AdminPortfolio() {
        conn = new DBP2P().setConnection();
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        tampilData();
    }

    public ArrayList<Purchase> daftarPurchaseAsc(){
        ArrayList<Purchase> daftarPurchase = new ArrayList<>();
        
        try {
            sql = "SELECT * FROM purchase ORDER BY company ASC";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
                while(rs.next()){
                    purchase = new Purchase(rs.getInt("id_user"),
                            rs.getString("company"),
                            rs.getInt("rate"),
                            rs.getInt("amount"),
                            rs.getInt("total"));
                    daftarPurchase.add(purchase);
                }
        } catch (Exception e) {
            System.out.println("ERROR"+e.getMessage());
        }
        return daftarPurchase;
    }
    
    public ArrayList<Purchase> daftarPurchaseAsc2(){
        ArrayList<Purchase> daftarPurchase = new ArrayList<>();
        
        try {
            sql = "SELECT * FROM purchase ORDER BY id_user ASC";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
                while(rs.next()){
                    purchase = new Purchase(rs.getInt("id_user"),
                            rs.getString("company"),
                            rs.getInt("rate"),
                            rs.getInt("amount"),
                            rs.getInt("total"));
                    daftarPurchase.add(purchase);
                }
        } catch (Exception e) {
            System.out.println("ERROR"+e.getMessage());
        }
        return daftarPurchase;
    }
    
    public ArrayList<Purchase> daftarPurchaseDesc(){
        ArrayList<Purchase> daftarPurchase = new ArrayList<>();
        
        try {
            sql = "SELECT * FROM purchase ORDER BY id_purchase DESC";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
                while(rs.next()){
                    purchase = new Purchase(rs.getInt("id_user"),
                            rs.getString("company"),
                            rs.getInt("rate"),
                            rs.getInt("amount"),
                            rs.getInt("total"));
                    daftarPurchase.add(purchase);
                }
        } catch (Exception e) {
            System.out.println("ERROR"+e.getMessage());
        }
        return daftarPurchase;
    }
    
    public ArrayList<Purchase> cariNama(){
        ArrayList<Purchase> daftarPurchase = new ArrayList<>();
        
        try {
            sql = "SELECT * FROM purchase WHERE company LIKE '"+tfSearch.getText()+"'";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
                while(rs.next()){
                    purchase = new Purchase(rs.getInt("id_user"),
                            rs.getString("company"),
                            rs.getInt("rate"),
                            rs.getInt("amount"),
                            rs.getInt("total"));
                    daftarPurchase.add(purchase);
                }
        } catch (Exception e) {
            System.out.println("ERROR"+e.getMessage());
        }
        return daftarPurchase;
    }
    
    public void bersihTabel(){
        DefaultTableModel model = (DefaultTableModel) tblPortfolio.getModel();
        model.setRowCount(0);
    }
    
    public void tampilData(){
        ArrayList<Purchase> daftar = daftarPurchaseAsc();
        DefaultTableModel model = (DefaultTableModel) tblPortfolio.getModel();
        Object[] row = new Object[6];
        
        for(int i = 0; i<daftar.size();i++){
            row [0] = false;
            row [1] = daftar.get(i).getId();
            row [2] = daftar.get(i).getCompany();
            row [3] = daftar.get(i).getRate();
            row [4] = daftar.get(i).getAmount();
            row [5] = daftar.get(i).getTotal();
            model.addRow(row);
        }
    }
    
    public void tampilData2(){
        ArrayList<Purchase> daftar = daftarPurchaseAsc2();
        DefaultTableModel model = (DefaultTableModel) tblPortfolio.getModel();
        Object[] row = new Object[6];
        
        for(int i = 0; i<daftar.size();i++){
            row [0] = false;
            row [1] = daftar.get(i).getId();
            row [2] = daftar.get(i).getCompany();
            row [3] = daftar.get(i).getRate();
            row [4] = daftar.get(i).getAmount();
            row [5] = daftar.get(i).getTotal();
            model.addRow(row);
        }
    }
    
    public void tampilData3(){
        ArrayList<Purchase> daftar = daftarPurchaseDesc();
        DefaultTableModel model = (DefaultTableModel) tblPortfolio.getModel();
        Object[] row = new Object[6];
        
        for(int i = 0; i<daftar.size();i++){
            row [0] = false;
            row [1] = daftar.get(i).getId();
            row [2] = daftar.get(i).getCompany();
            row [3] = daftar.get(i).getRate();
            row [4] = daftar.get(i).getAmount();
            row [5] = daftar.get(i).getTotal();
            model.addRow(row);
        }
    }
    
    public void tampilNama(){
        ArrayList<Purchase> daftar = cariNama();
        DefaultTableModel model = (DefaultTableModel) tblPortfolio.getModel();
        Object[] row = new Object[6];
        
        for(int i = 0; i<daftar.size();i++){
            row [0] = false;
            row [1] = daftar.get(i).getId();
            row [2] = daftar.get(i).getCompany();
            row [3] = daftar.get(i).getRate();
            row [4] = daftar.get(i).getAmount();
            row [5] = daftar.get(i).getTotal();
            model.addRow(row);
        }
    }
    
    private void hapusData(String id){
        try {
            st = conn.createStatement();
            sql = "DELETE FROM purchase WHERE id_user='"+id+"'";
            st.execute(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
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
        btBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPortfolio = new javax.swing.JTable();
        cbxFilter = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btSearch = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(121, 125, 127));

        btBack.setBackground(new java.awt.Color(143, 38, 41));
        btBack.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btBack.setForeground(new java.awt.Color(255, 255, 255));
        btBack.setText("BACK");
        btBack.setBorder(null);
        btBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });

        tblPortfolio.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tblPortfolio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Id User", "Company", "Rate %", "Amount", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPortfolio.setColumnSelectionAllowed(true);
        tblPortfolio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPortfolioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPortfolio);
        tblPortfolio.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        cbxFilter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Company", "Id User", "Newest" }));
        cbxFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbxFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFilterActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(43, 72, 109));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PORTFOLIO");

        tfSearch.setBackground(new java.awt.Color(255, 255, 255));
        tfSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfSearch.setForeground(new java.awt.Color(0, 0, 0));
        tfSearch.setBorder(null);

        btSearch.setBackground(new java.awt.Color(43, 72, 109));
        btSearch.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btSearch.setForeground(new java.awt.Color(255, 255, 255));
        btSearch.setText("SEARCH");
        btSearch.setBorder(null);
        btSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        btDelete.setBackground(new java.awt.Color(143, 38, 41));
        btDelete.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btDelete.setForeground(new java.awt.Color(255, 255, 255));
        btDelete.setText("DELETE");
        btDelete.setBorder(null);
        btDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(119, 119, 119)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(cbxFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
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

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
        this.dispose();
        AdminHome ah = new AdminHome();
        ah.setVisible(true);
    }//GEN-LAST:event_btBackActionPerformed

    private void tblPortfolioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPortfolioMouseClicked

        
    }//GEN-LAST:event_tblPortfolioMouseClicked

    private void cbxFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFilterActionPerformed
        bersihTabel();
        if(cbxFilter.getSelectedItem().toString()=="Company"){
            tampilData();
        }else if(cbxFilter.getSelectedItem().toString()=="Id User"){
            tampilData2();
        }else {
            tampilData3();
        }
    }//GEN-LAST:event_cbxFilterActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        bersihTabel();
        cariNama();
        tampilNama();
    }//GEN-LAST:event_btSearchActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed

        int n = JOptionPane.showConfirmDialog(null, "Are you sure?",
            "Delete",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE, null);
        if(n == 0){
            for(int i = 0; i<tblPortfolio.getRowCount();i++){
                Boolean chkDel = Boolean.valueOf(tblPortfolio.getValueAt(i, 0).toString());
                if(chkDel){
                    String id = tblPortfolio.getValueAt(i, 1).toString();
                    hapusData(id);
                }
            }
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            bersihTabel();
            tampilData();
        }
    }//GEN-LAST:event_btDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(AdminPortfolio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPortfolio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPortfolio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPortfolio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPortfolio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btSearch;
    private javax.swing.JComboBox<String> cbxFilter;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPortfolio;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
