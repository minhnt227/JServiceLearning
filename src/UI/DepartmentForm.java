/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

/**
 *
 * @author A715-42G
 */
public class DepartmentForm extends javax.swing.JFrame {

    /**
     * Creates new form DepartmentForm
     */
    public DepartmentForm() {
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
        Khoa_ID_txt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Search_Btn = new javax.swing.JButton();
        Khoa_ExportExcel_btn = new javax.swing.JButton();
        Khoa_Add_btn = new javax.swing.JButton();
        Khoa_ImportExcel_btn = new javax.swing.JButton();
        Khoa_Edit_btn = new javax.swing.JButton();
        Khoa_Delete_btn = new javax.swing.JButton();
        Khoa_Name_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Khoa_Email_txt = new javax.swing.JTextField();
        Khoa_Phone_txt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        DateOfEs = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Department_tbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FilterPnl.setBackground(new java.awt.Color(110, 89, 222));
        FilterPnl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(204, 255, 255), java.awt.Color.lightGray, null));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("DepartmentID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Phone");

        Khoa_ID_txt.setBackground(new java.awt.Color(255, 255, 255));
        Khoa_ID_txt.setForeground(new java.awt.Color(0, 0, 0));
        Khoa_ID_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Khoa_ID_txtActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("DepartmentName");

        Search_Btn.setBackground(new java.awt.Color(153, 153, 255));
        Search_Btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Search_Btn.setForeground(new java.awt.Color(0, 0, 0));
        Search_Btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-search-25.png"))); // NOI18N
        Search_Btn.setText("Search");

        Khoa_ExportExcel_btn.setBackground(new java.awt.Color(153, 153, 255));
        Khoa_ExportExcel_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Khoa_ExportExcel_btn.setForeground(new java.awt.Color(0, 0, 0));
        Khoa_ExportExcel_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-export-20.png"))); // NOI18N
        Khoa_ExportExcel_btn.setText("Export Excel");

        Khoa_Add_btn.setBackground(new java.awt.Color(153, 153, 255));
        Khoa_Add_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Khoa_Add_btn.setForeground(new java.awt.Color(0, 0, 0));
        Khoa_Add_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-add-20.png"))); // NOI18N
        Khoa_Add_btn.setText("Add");
        Khoa_Add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Khoa_Add_btnActionPerformed(evt);
            }
        });

        Khoa_ImportExcel_btn.setBackground(new java.awt.Color(153, 153, 255));
        Khoa_ImportExcel_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Khoa_ImportExcel_btn.setForeground(new java.awt.Color(0, 0, 0));
        Khoa_ImportExcel_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-import-20.png"))); // NOI18N
        Khoa_ImportExcel_btn.setText("Import Excel");

        Khoa_Edit_btn.setBackground(new java.awt.Color(153, 153, 255));
        Khoa_Edit_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Khoa_Edit_btn.setForeground(new java.awt.Color(0, 0, 0));
        Khoa_Edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-edit-20.png"))); // NOI18N
        Khoa_Edit_btn.setText("Edit");

        Khoa_Delete_btn.setBackground(new java.awt.Color(153, 153, 255));
        Khoa_Delete_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Khoa_Delete_btn.setForeground(new java.awt.Color(0, 0, 0));
        Khoa_Delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-delete-20.png"))); // NOI18N
        Khoa_Delete_btn.setText("Delete");

        Khoa_Name_txt.setBackground(new java.awt.Color(255, 255, 255));
        Khoa_Name_txt.setForeground(new java.awt.Color(0, 0, 0));
        Khoa_Name_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Khoa_Name_txtActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Email");

        Khoa_Email_txt.setBackground(new java.awt.Color(255, 255, 255));
        Khoa_Email_txt.setForeground(new java.awt.Color(0, 0, 0));
        Khoa_Email_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Khoa_Email_txtActionPerformed(evt);
            }
        });

        Khoa_Phone_txt.setBackground(new java.awt.Color(255, 255, 255));
        Khoa_Phone_txt.setForeground(new java.awt.Color(0, 0, 0));
        Khoa_Phone_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Khoa_Phone_txtActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Date of Establishment");

        DateOfEs.setBackground(new java.awt.Color(255, 255, 255));
        DateOfEs.setForeground(new java.awt.Color(0, 0, 0));
        DateOfEs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateOfEsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FilterPnlLayout = new javax.swing.GroupLayout(FilterPnl);
        FilterPnl.setLayout(FilterPnlLayout);
        FilterPnlLayout.setHorizontalGroup(
            FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilterPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20)
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Khoa_ID_txt)
                    .addComponent(Khoa_Name_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(Khoa_Phone_txt)
                    .addComponent(Khoa_Email_txt)
                    .addComponent(DateOfEs))
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FilterPnlLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FilterPnlLayout.createSequentialGroup()
                                .addComponent(Khoa_Add_btn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Khoa_Edit_btn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Khoa_Delete_btn))
                            .addGroup(FilterPnlLayout.createSequentialGroup()
                                .addComponent(Khoa_ImportExcel_btn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Khoa_ExportExcel_btn)))
                        .addGap(17, 17, 17))
                    .addGroup(FilterPnlLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(Search_Btn)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        FilterPnlLayout.setVerticalGroup(
            FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilterPnlLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Search_Btn)
                    .addComponent(Khoa_ID_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Khoa_Name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FilterPnlLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FilterPnlLayout.createSequentialGroup()
                        .addComponent(Khoa_Phone_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Khoa_ExportExcel_btn)
                        .addComponent(Khoa_ImportExcel_btn))
                    .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(Khoa_Email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Khoa_Add_btn)
                    .addComponent(Khoa_Edit_btn)
                    .addComponent(Khoa_Delete_btn)
                    .addComponent(DateOfEs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Department_tbl.setBackground(new java.awt.Color(255, 255, 255));
        Department_tbl.setForeground(new java.awt.Color(0, 0, 0));
        Department_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "DepartmentID", "DepartmentName", "Phone", "Email", "Date of Establishment"
            }
        ));
        Department_tbl.setToolTipText("");
        Department_tbl.setGridColor(new java.awt.Color(204, 204, 204));
        Department_tbl.setSelectionBackground(new java.awt.Color(110, 89, 222));
        Department_tbl.setSelectionForeground(new java.awt.Color(0, 0, 0));
        Department_tbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        Department_tbl.setShowGrid(true);
        Department_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Department_tblMouseClicked(evt);
            }
        });
        Department_tbl.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                Department_tblLoadHDs(evt);
            }
        });
        jScrollPane1.setViewportView(Department_tbl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FilterPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(FilterPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Khoa_ID_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Khoa_ID_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Khoa_ID_txtActionPerformed

    private void Khoa_Name_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Khoa_Name_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Khoa_Name_txtActionPerformed

    private void Khoa_Email_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Khoa_Email_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Khoa_Email_txtActionPerformed

    private void Khoa_Phone_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Khoa_Phone_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Khoa_Phone_txtActionPerformed

    private void Department_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Department_tblMouseClicked

    }//GEN-LAST:event_Department_tblMouseClicked

    private void Department_tblLoadHDs(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_Department_tblLoadHDs

    }//GEN-LAST:event_Department_tblLoadHDs

    private void Khoa_Add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Khoa_Add_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Khoa_Add_btnActionPerformed

    private void DateOfEsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateOfEsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateOfEsActionPerformed

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
//            java.util.logging.Logger.getLogger(DepartmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DepartmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DepartmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DepartmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new DepartmentForm().setVisible(true);
////            }
////        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DateOfEs;
    private javax.swing.JTable Department_tbl;
    private javax.swing.JPanel FilterPnl;
    private javax.swing.JButton Khoa_Add_btn;
    private javax.swing.JButton Khoa_Delete_btn;
    private javax.swing.JButton Khoa_Edit_btn;
    private javax.swing.JTextField Khoa_Email_txt;
    private javax.swing.JButton Khoa_ExportExcel_btn;
    private javax.swing.JTextField Khoa_ID_txt;
    private javax.swing.JButton Khoa_ImportExcel_btn;
    private javax.swing.JTextField Khoa_Name_txt;
    private javax.swing.JTextField Khoa_Phone_txt;
    private javax.swing.JButton Search_Btn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
