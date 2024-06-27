/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

/**
 *
 * @author A715-42G
 */
public class FundingForm extends javax.swing.JFrame {

    /**
     * Creates new form FundingForm
     */
    public FundingForm() {
        initComponents();
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
        jLabel3 = new javax.swing.JLabel();
        TaiTro_Name_txt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        TaiTro_ExportExcel_btn = new javax.swing.JButton();
        TaiTro_Add_txt = new javax.swing.JButton();
        TaiTro_ImportExcel_btn = new javax.swing.JButton();
        TaiTro_Edit_txt = new javax.swing.JButton();
        TaiTro_Delete_btn = new javax.swing.JButton();
        TaiTro_DaiDien_txt = new javax.swing.JTextField();
        TaiTro_Refrech_btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        TaiTro_Email_txt = new javax.swing.JTextField();
        TaiTro_Phone_txt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        HDTbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FilterPnl.setBackground(new java.awt.Color(110, 89, 222));
        FilterPnl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(204, 255, 255), java.awt.Color.lightGray, null));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Funder ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Phone");

        TaiTro_Name_txt.setBackground(new java.awt.Color(255, 255, 255));
        TaiTro_Name_txt.setForeground(new java.awt.Color(0, 0, 0));
        TaiTro_Name_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaiTro_Name_txtActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Repersent");

        jButton2.setBackground(new java.awt.Color(153, 153, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-search-25.png"))); // NOI18N
        jButton2.setText("Search");

        TaiTro_ExportExcel_btn.setBackground(new java.awt.Color(153, 153, 255));
        TaiTro_ExportExcel_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TaiTro_ExportExcel_btn.setForeground(new java.awt.Color(0, 0, 0));
        TaiTro_ExportExcel_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-export-20.png"))); // NOI18N
        TaiTro_ExportExcel_btn.setText("Export Excel");

        TaiTro_Add_txt.setBackground(new java.awt.Color(153, 153, 255));
        TaiTro_Add_txt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TaiTro_Add_txt.setForeground(new java.awt.Color(0, 0, 0));
        TaiTro_Add_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-add-20.png"))); // NOI18N
        TaiTro_Add_txt.setText("Add");

        TaiTro_ImportExcel_btn.setBackground(new java.awt.Color(153, 153, 255));
        TaiTro_ImportExcel_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TaiTro_ImportExcel_btn.setForeground(new java.awt.Color(0, 0, 0));
        TaiTro_ImportExcel_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-import-20.png"))); // NOI18N
        TaiTro_ImportExcel_btn.setText("Import Excel");

        TaiTro_Edit_txt.setBackground(new java.awt.Color(153, 153, 255));
        TaiTro_Edit_txt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TaiTro_Edit_txt.setForeground(new java.awt.Color(0, 0, 0));
        TaiTro_Edit_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-edit-20.png"))); // NOI18N
        TaiTro_Edit_txt.setText("Edit");

        TaiTro_Delete_btn.setBackground(new java.awt.Color(153, 153, 255));
        TaiTro_Delete_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TaiTro_Delete_btn.setForeground(new java.awt.Color(0, 0, 0));
        TaiTro_Delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-delete-20.png"))); // NOI18N
        TaiTro_Delete_btn.setText("Delete");

        TaiTro_DaiDien_txt.setBackground(new java.awt.Color(255, 255, 255));
        TaiTro_DaiDien_txt.setForeground(new java.awt.Color(0, 0, 0));
        TaiTro_DaiDien_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaiTro_DaiDien_txtActionPerformed(evt);
            }
        });

        TaiTro_Refrech_btn.setBackground(new java.awt.Color(153, 153, 255));
        TaiTro_Refrech_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TaiTro_Refrech_btn.setForeground(new java.awt.Color(0, 0, 0));
        TaiTro_Refrech_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-refresh-20.png"))); // NOI18N
        TaiTro_Refrech_btn.setText("Refrech");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Email");

        TaiTro_Email_txt.setBackground(new java.awt.Color(255, 255, 255));
        TaiTro_Email_txt.setForeground(new java.awt.Color(0, 0, 0));
        TaiTro_Email_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaiTro_Email_txtActionPerformed(evt);
            }
        });

        TaiTro_Phone_txt.setBackground(new java.awt.Color(255, 255, 255));
        TaiTro_Phone_txt.setForeground(new java.awt.Color(0, 0, 0));
        TaiTro_Phone_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaiTro_Phone_txtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FilterPnlLayout = new javax.swing.GroupLayout(FilterPnl);
        FilterPnl.setLayout(FilterPnlLayout);
        FilterPnlLayout.setHorizontalGroup(
            FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilterPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TaiTro_Refrech_btn)
                    .addComponent(TaiTro_DaiDien_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(FilterPnlLayout.createSequentialGroup()
                        .addComponent(TaiTro_Name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(TaiTro_Email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TaiTro_Phone_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FilterPnlLayout.createSequentialGroup()
                        .addComponent(TaiTro_Add_txt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TaiTro_Edit_txt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TaiTro_Delete_btn))
                    .addGroup(FilterPnlLayout.createSequentialGroup()
                        .addComponent(TaiTro_ImportExcel_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TaiTro_ExportExcel_btn)))
                .addGap(17, 17, 17))
        );
        FilterPnlLayout.setVerticalGroup(
            FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilterPnlLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(TaiTro_Name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TaiTro_DaiDien_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FilterPnlLayout.createSequentialGroup()
                        .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TaiTro_Phone_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(8, 8, 8)
                        .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TaiTro_Email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FilterPnlLayout.createSequentialGroup()
                        .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TaiTro_ExportExcel_btn)
                            .addComponent(TaiTro_ImportExcel_btn))
                        .addGap(14, 14, 14)))
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TaiTro_Add_txt)
                        .addComponent(TaiTro_Edit_txt)
                        .addComponent(TaiTro_Delete_btn))
                    .addComponent(TaiTro_Refrech_btn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        HDTbl.setBackground(new java.awt.Color(255, 255, 255));
        HDTbl.setForeground(new java.awt.Color(255, 255, 255));
        HDTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Funder", "Repersent", "Phone", "Email", "FunderID"
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
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(FilterPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(FilterPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TaiTro_Name_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaiTro_Name_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TaiTro_Name_txtActionPerformed

    private void TaiTro_DaiDien_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaiTro_DaiDien_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TaiTro_DaiDien_txtActionPerformed

    private void HDTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HDTblMouseClicked

    }//GEN-LAST:event_HDTblMouseClicked

    private void HDTblLoadHDs(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_HDTblLoadHDs

    }//GEN-LAST:event_HDTblLoadHDs

    private void TaiTro_Email_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaiTro_Email_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TaiTro_Email_txtActionPerformed

    private void TaiTro_Phone_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaiTro_Phone_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TaiTro_Phone_txtActionPerformed

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
//            java.util.logging.Logger.getLogger(FundingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FundingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FundingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FundingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new FundingForm().setVisible(true);
////            }
////        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FilterPnl;
    private javax.swing.JTable HDTbl;
    private javax.swing.JButton TaiTro_Add_txt;
    private javax.swing.JTextField TaiTro_DaiDien_txt;
    private javax.swing.JButton TaiTro_Delete_btn;
    private javax.swing.JButton TaiTro_Edit_txt;
    private javax.swing.JTextField TaiTro_Email_txt;
    private javax.swing.JButton TaiTro_ExportExcel_btn;
    private javax.swing.JButton TaiTro_ImportExcel_btn;
    private javax.swing.JTextField TaiTro_Name_txt;
    private javax.swing.JTextField TaiTro_Phone_txt;
    private javax.swing.JButton TaiTro_Refrech_btn;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}