/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import DAO.DAO_DoiTac;
import MODEL.DoiTac;
import MODEL.ListDoiTac;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author A715-42G
 */
public class PartnerForm extends javax.swing.JFrame {

    /**
     * Creates new form PartnerForm
     */
    public PartnerForm() {
        initComponents();
        try {
            LoadDoiTac();
        } catch (SQLException ex) {
            Logger.getLogger(PartnerForm.class.getName()).log(Level.SEVERE, null, ex);
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

        FilterPnl = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        DoiTac_Name_txt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        DoiTac_ExportExcel_btn = new javax.swing.JButton();
        DoiTac_Add_btn = new javax.swing.JButton();
        DoiTac_ImportExcel_btn = new javax.swing.JButton();
        DoiTac_Edit_btn = new javax.swing.JButton();
        DoiTac_Delete_btn = new javax.swing.JButton();
        DoiTac_DaiDien_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        DoiTac_Phone_txt = new javax.swing.JTextField();
        DoiTac_Email_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        HDTbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FilterPnl.setBackground(new java.awt.Color(110, 89, 222));
        FilterPnl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(204, 255, 255), java.awt.Color.lightGray, null));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Partner:");

        DoiTac_Name_txt.setBackground(new java.awt.Color(255, 255, 255));
        DoiTac_Name_txt.setForeground(new java.awt.Color(0, 0, 0));
        DoiTac_Name_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoiTac_Name_txtActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Represent:");

        jButton2.setBackground(new java.awt.Color(153, 153, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-search-25.png"))); // NOI18N
        jButton2.setText("Search");

        DoiTac_ExportExcel_btn.setBackground(new java.awt.Color(153, 153, 255));
        DoiTac_ExportExcel_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DoiTac_ExportExcel_btn.setForeground(new java.awt.Color(0, 0, 0));
        DoiTac_ExportExcel_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-export-20.png"))); // NOI18N
        DoiTac_ExportExcel_btn.setText("Export Excel");

        DoiTac_Add_btn.setBackground(new java.awt.Color(153, 153, 255));
        DoiTac_Add_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DoiTac_Add_btn.setForeground(new java.awt.Color(0, 0, 0));
        DoiTac_Add_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-add-20.png"))); // NOI18N
        DoiTac_Add_btn.setText("Add");
        DoiTac_Add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoiTac_Add_btnActionPerformed(evt);
            }
        });

        DoiTac_ImportExcel_btn.setBackground(new java.awt.Color(153, 153, 255));
        DoiTac_ImportExcel_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DoiTac_ImportExcel_btn.setForeground(new java.awt.Color(0, 0, 0));
        DoiTac_ImportExcel_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-import-20.png"))); // NOI18N
        DoiTac_ImportExcel_btn.setText("Import Excel");

        DoiTac_Edit_btn.setBackground(new java.awt.Color(153, 153, 255));
        DoiTac_Edit_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DoiTac_Edit_btn.setForeground(new java.awt.Color(0, 0, 0));
        DoiTac_Edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-edit-20.png"))); // NOI18N
        DoiTac_Edit_btn.setText("Edit");

        DoiTac_Delete_btn.setBackground(new java.awt.Color(153, 153, 255));
        DoiTac_Delete_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DoiTac_Delete_btn.setForeground(new java.awt.Color(0, 0, 0));
        DoiTac_Delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-delete-20.png"))); // NOI18N
        DoiTac_Delete_btn.setText("Delete");

        DoiTac_DaiDien_txt.setBackground(new java.awt.Color(255, 255, 255));
        DoiTac_DaiDien_txt.setForeground(new java.awt.Color(0, 0, 0));
        DoiTac_DaiDien_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoiTac_DaiDien_txtActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Phone:");

        DoiTac_Phone_txt.setBackground(new java.awt.Color(255, 255, 255));
        DoiTac_Phone_txt.setForeground(new java.awt.Color(0, 0, 0));
        DoiTac_Phone_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoiTac_Phone_txtActionPerformed(evt);
            }
        });

        DoiTac_Email_txt.setBackground(new java.awt.Color(255, 255, 255));
        DoiTac_Email_txt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DoiTac_Email_txt.setForeground(new java.awt.Color(0, 0, 0));
        DoiTac_Email_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoiTac_Email_txtActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Email:");

        javax.swing.GroupLayout FilterPnlLayout = new javax.swing.GroupLayout(FilterPnl);
        FilterPnl.setLayout(FilterPnlLayout);
        FilterPnlLayout.setHorizontalGroup(
            FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilterPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FilterPnlLayout.createSequentialGroup()
                        .addComponent(DoiTac_ImportExcel_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DoiTac_ExportExcel_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DoiTac_Add_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DoiTac_Edit_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DoiTac_Delete_btn))
                    .addGroup(FilterPnlLayout.createSequentialGroup()
                        .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FilterPnlLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(33, 33, 33)
                                .addComponent(DoiTac_Name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addGroup(FilterPnlLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(DoiTac_DaiDien_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DoiTac_Email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DoiTac_Phone_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49))
        );
        FilterPnlLayout.setVerticalGroup(
            FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilterPnlLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton2)
                    .addComponent(DoiTac_Name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DoiTac_Phone_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(16, 16, 16)
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(DoiTac_DaiDien_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(DoiTac_Email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DoiTac_Add_btn)
                    .addComponent(DoiTac_Edit_btn)
                    .addComponent(DoiTac_Delete_btn)
                    .addComponent(DoiTac_ExportExcel_btn)
                    .addComponent(DoiTac_ImportExcel_btn))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        HDTbl.setBackground(new java.awt.Color(255, 255, 255));
        HDTbl.setForeground(new java.awt.Color(255, 255, 255));
        HDTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PartnerName", "Represent", "Email", "Phone"
            }
        ));
        HDTbl.setToolTipText("");
        HDTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HDTblMouseClicked(evt);
            }
        });
        HDTbl.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                HDTblLoadHDs(evt);
            }
        });
        jScrollPane1.setViewportView(HDTbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FilterPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(FilterPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DoiTac_Name_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoiTac_Name_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DoiTac_Name_txtActionPerformed

    private void DoiTac_DaiDien_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoiTac_DaiDien_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DoiTac_DaiDien_txtActionPerformed

    private void HDTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HDTblMouseClicked

    }//GEN-LAST:event_HDTblMouseClicked

    private void HDTblLoadHDs(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_HDTblLoadHDs

    }//GEN-LAST:event_HDTblLoadHDs

    private void DoiTac_Phone_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoiTac_Phone_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DoiTac_Phone_txtActionPerformed

    private void DoiTac_Email_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoiTac_Email_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DoiTac_Email_txtActionPerformed

    private void DoiTac_Add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoiTac_Add_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DoiTac_Add_btnActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PartnerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PartnerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PartnerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PartnerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new PartnerForm().setVisible(true);
////            }
////        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DoiTac_Add_btn;
    private javax.swing.JTextField DoiTac_DaiDien_txt;
    private javax.swing.JButton DoiTac_Delete_btn;
    private javax.swing.JButton DoiTac_Edit_btn;
    private javax.swing.JTextField DoiTac_Email_txt;
    private javax.swing.JButton DoiTac_ExportExcel_btn;
    private javax.swing.JButton DoiTac_ImportExcel_btn;
    private javax.swing.JTextField DoiTac_Name_txt;
    private javax.swing.JTextField DoiTac_Phone_txt;
    private javax.swing.JPanel FilterPnl;
    private javax.swing.JTable HDTbl;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void LoadDoiTac() throws SQLException {
        DefaultTableModel model = (DefaultTableModel)HDTbl.getModel();
        RemoveTableData(model);
        DAO_DoiTac daoHD = new DAO_DoiTac();
        ArrayList<DoiTac> DTs = new ArrayList<>();
        DTs = daoHD.getListFromDB(0, "", false).list;
        
        for(DoiTac hd : DTs){
                model.addRow(hd.getRowData());
        }
        HDTbl.setAutoCreateRowSorter(true);
    }

    private void RemoveTableData(DefaultTableModel model) {
        int count = model.getRowCount();
        for(int i = 0; i< count;i++){
            model.removeRow(0);
        }
    }
}
