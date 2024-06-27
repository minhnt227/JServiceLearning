/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

/**
 *
 * @author A715-42G
 */
public class LecturerForm extends javax.swing.JFrame {

    /**
     * Creates new form LecturerForm
     */
    public LecturerForm() {
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
        GV_ID_txt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        GV_Search_btn = new javax.swing.JButton();
        GV_ExportExcel_btn = new javax.swing.JButton();
        GV_Add_btn = new javax.swing.JButton();
        GV_Refrech_btn = new javax.swing.JButton();
        GV_Edit_btn = new javax.swing.JButton();
        GV_Delete_btn = new javax.swing.JButton();
        GV_MiddleName_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        GV_LastName_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        GV_Khoa_cmb = new javax.swing.JComboBox<>();
        GV_ImportExcel_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        HDTbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FilterPnl.setBackground(new java.awt.Color(110, 89, 222));
        FilterPnl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(204, 255, 255), java.awt.Color.lightGray, null));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("LecturerID");

        GV_ID_txt.setBackground(new java.awt.Color(255, 255, 255));
        GV_ID_txt.setForeground(new java.awt.Color(0, 0, 0));
        GV_ID_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GV_ID_txtActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Middle name");

        GV_Search_btn.setBackground(new java.awt.Color(153, 153, 255));
        GV_Search_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GV_Search_btn.setForeground(new java.awt.Color(0, 0, 0));
        GV_Search_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-search-25.png"))); // NOI18N
        GV_Search_btn.setText("Search");

        GV_ExportExcel_btn.setBackground(new java.awt.Color(153, 153, 255));
        GV_ExportExcel_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GV_ExportExcel_btn.setForeground(new java.awt.Color(0, 0, 0));
        GV_ExportExcel_btn.setText("Export Excel");

        GV_Add_btn.setBackground(new java.awt.Color(153, 153, 255));
        GV_Add_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GV_Add_btn.setForeground(new java.awt.Color(0, 0, 0));
        GV_Add_btn.setText("Add");
        GV_Add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GV_Add_btnActionPerformed(evt);
            }
        });

        GV_Refrech_btn.setBackground(new java.awt.Color(153, 153, 255));
        GV_Refrech_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GV_Refrech_btn.setForeground(new java.awt.Color(0, 0, 0));
        GV_Refrech_btn.setText("Refrech");
        GV_Refrech_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GV_Refrech_btnActionPerformed(evt);
            }
        });

        GV_Edit_btn.setBackground(new java.awt.Color(153, 153, 255));
        GV_Edit_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GV_Edit_btn.setForeground(new java.awt.Color(0, 0, 0));
        GV_Edit_btn.setText("Edit");

        GV_Delete_btn.setBackground(new java.awt.Color(153, 153, 255));
        GV_Delete_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GV_Delete_btn.setForeground(new java.awt.Color(0, 0, 0));
        GV_Delete_btn.setText("Delete");

        GV_MiddleName_txt.setBackground(new java.awt.Color(255, 255, 255));
        GV_MiddleName_txt.setForeground(new java.awt.Color(0, 0, 0));
        GV_MiddleName_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GV_MiddleName_txtActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Department");

        GV_LastName_txt.setBackground(new java.awt.Color(255, 255, 255));
        GV_LastName_txt.setForeground(new java.awt.Color(0, 0, 0));
        GV_LastName_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GV_LastName_txtActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Last name");

        GV_Khoa_cmb.setBackground(new java.awt.Color(255, 255, 255));
        GV_Khoa_cmb.setForeground(new java.awt.Color(0, 0, 0));
        GV_Khoa_cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","Môn học", "Sự kiện", "Dự án"}));

        GV_ImportExcel_btn.setBackground(new java.awt.Color(153, 153, 255));
        GV_ImportExcel_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GV_ImportExcel_btn.setForeground(new java.awt.Color(0, 0, 0));
        GV_ImportExcel_btn.setText("Import Excel");

        javax.swing.GroupLayout FilterPnlLayout = new javax.swing.GroupLayout(FilterPnl);
        FilterPnl.setLayout(FilterPnlLayout);
        FilterPnlLayout.setHorizontalGroup(
            FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilterPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FilterPnlLayout.createSequentialGroup()
                        .addComponent(GV_ImportExcel_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GV_ExportExcel_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GV_Add_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GV_Edit_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GV_Delete_btn)
                        .addGap(49, 49, 49))
                    .addGroup(FilterPnlLayout.createSequentialGroup()
                        .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(FilterPnlLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(33, 33, 33)
                                .addComponent(GV_ID_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FilterPnlLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(GV_MiddleName_txt)))
                        .addGap(18, 18, 18)
                        .addComponent(GV_Search_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GV_LastName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GV_Khoa_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48))
                    .addGroup(FilterPnlLayout.createSequentialGroup()
                        .addComponent(GV_Refrech_btn)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        FilterPnlLayout.setVerticalGroup(
            FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilterPnlLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(GV_Search_btn)
                    .addComponent(GV_ID_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(GV_Khoa_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(GV_MiddleName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(GV_LastName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GV_Add_btn)
                    .addComponent(GV_Edit_btn)
                    .addComponent(GV_Delete_btn)
                    .addComponent(GV_ExportExcel_btn)
                    .addComponent(GV_ImportExcel_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GV_Refrech_btn)
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
                "LecturerID ", "Middle name", "Last name", "DepartmentID", "DepartmentName"
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GV_ID_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GV_ID_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GV_ID_txtActionPerformed

    private void GV_Add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GV_Add_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GV_Add_btnActionPerformed

    private void GV_MiddleName_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GV_MiddleName_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GV_MiddleName_txtActionPerformed

    private void GV_LastName_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GV_LastName_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GV_LastName_txtActionPerformed

    private void HDTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HDTblMouseClicked

    }//GEN-LAST:event_HDTblMouseClicked

    private void HDTblLoadHDs(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_HDTblLoadHDs

    }//GEN-LAST:event_HDTblLoadHDs

    private void GV_Refrech_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GV_Refrech_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GV_Refrech_btnActionPerformed

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
            java.util.logging.Logger.getLogger(LecturerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LecturerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LecturerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LecturerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LecturerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FilterPnl;
    private javax.swing.JButton GV_Add_btn;
    private javax.swing.JButton GV_Delete_btn;
    private javax.swing.JButton GV_Edit_btn;
    private javax.swing.JButton GV_ExportExcel_btn;
    private javax.swing.JTextField GV_ID_txt;
    private javax.swing.JButton GV_ImportExcel_btn;
    private javax.swing.JComboBox<String> GV_Khoa_cmb;
    private javax.swing.JTextField GV_LastName_txt;
    private javax.swing.JTextField GV_MiddleName_txt;
    private javax.swing.JButton GV_Refrech_btn;
    private javax.swing.JButton GV_Search_btn;
    private javax.swing.JTable HDTbl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
