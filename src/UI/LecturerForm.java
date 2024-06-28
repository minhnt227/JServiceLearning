/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import DAO.DAO_GiangVien;
import DAO.DAO_Khoa;
import MODEL.Check;
import MODEL.GiangVien;
import MODEL.Khoa;
import MODEL.ListGiangVien;
import MODEL.fileExcel;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
        loadDefaultTableFromDB();
        loadComboBoxKhoa();
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
        GV_FirstName_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        GV_LastName_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        GV_Khoa_cmb = new javax.swing.JComboBox<>();
        GV_ImportExcel_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lecturer_tbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FilterPnl.setBackground(new java.awt.Color(110, 89, 222));
        FilterPnl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(204, 255, 255), java.awt.Color.lightGray, null));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("LecturerID");

        GV_ID_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GV_ID_txtActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Last name");

        GV_Search_btn.setBackground(new java.awt.Color(153, 153, 255));
        GV_Search_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GV_Search_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-search-25.png"))); // NOI18N
        GV_Search_btn.setText("Search");
        GV_Search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GV_Search_btnActionPerformed(evt);
            }
        });

        GV_ExportExcel_btn.setBackground(new java.awt.Color(153, 153, 255));
        GV_ExportExcel_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GV_ExportExcel_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-export-20.png"))); // NOI18N
        GV_ExportExcel_btn.setText("Export Excel");
        GV_ExportExcel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GV_ExportExcel_btnActionPerformed(evt);
            }
        });

        GV_Add_btn.setBackground(new java.awt.Color(153, 153, 255));
        GV_Add_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GV_Add_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-add-20.png"))); // NOI18N
        GV_Add_btn.setText("Add");
        GV_Add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GV_Add_btnActionPerformed(evt);
            }
        });

        GV_Refrech_btn.setBackground(new java.awt.Color(153, 153, 255));
        GV_Refrech_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GV_Refrech_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-refresh-20.png"))); // NOI18N
        GV_Refrech_btn.setText("Refresh");
        GV_Refrech_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GV_Refrech_btnActionPerformed(evt);
            }
        });

        GV_Edit_btn.setBackground(new java.awt.Color(153, 153, 255));
        GV_Edit_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GV_Edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-edit-20.png"))); // NOI18N
        GV_Edit_btn.setText("Edit");
        GV_Edit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GV_Edit_btnActionPerformed(evt);
            }
        });

        GV_Delete_btn.setBackground(new java.awt.Color(153, 153, 255));
        GV_Delete_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GV_Delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-delete-20.png"))); // NOI18N
        GV_Delete_btn.setText("Delete");
        GV_Delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GV_Delete_btnActionPerformed(evt);
            }
        });

        GV_FirstName_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GV_FirstName_txtActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Department");

        GV_LastName_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GV_LastName_txtActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("First name");

        GV_Khoa_cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","Môn học", "Sự kiện", "Dự án"}));
        GV_Khoa_cmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GV_Khoa_cmbActionPerformed(evt);
            }
        });

        GV_ImportExcel_btn.setBackground(new java.awt.Color(153, 153, 255));
        GV_ImportExcel_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GV_ImportExcel_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/Images/icons8-import-20.png"))); // NOI18N
        GV_ImportExcel_btn.setText("Import Excel");
        GV_ImportExcel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GV_ImportExcel_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FilterPnlLayout = new javax.swing.GroupLayout(FilterPnl);
        FilterPnl.setLayout(FilterPnlLayout);
        FilterPnlLayout.setHorizontalGroup(
            FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilterPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(FilterPnlLayout.createSequentialGroup()
                        .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GV_FirstName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(FilterPnlLayout.createSequentialGroup()
                                .addComponent(GV_ID_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(GV_Search_btn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GV_Khoa_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GV_LastName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(FilterPnlLayout.createSequentialGroup()
                        .addComponent(GV_ImportExcel_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GV_ExportExcel_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GV_Refrech_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GV_Add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GV_Edit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(GV_Delete_btn)))
                .addContainerGap(29, Short.MAX_VALUE))
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
                    .addComponent(GV_FirstName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(GV_LastName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FilterPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GV_Add_btn)
                    .addComponent(GV_Edit_btn)
                    .addComponent(GV_Delete_btn)
                    .addComponent(GV_ExportExcel_btn)
                    .addComponent(GV_ImportExcel_btn)
                    .addComponent(GV_Refrech_btn))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        Lecturer_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LecturerID ", "Last name", "First name", "DepartmentID", "DepartmentName"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Lecturer_tbl.setToolTipText("");
        Lecturer_tbl.setGridColor(new java.awt.Color(204, 204, 204));
        Lecturer_tbl.setSelectionBackground(new java.awt.Color(110, 89, 222));
        Lecturer_tbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        Lecturer_tbl.setShowGrid(true);
        Lecturer_tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Lecturer_tblMouseClicked(evt);
            }
        });
        Lecturer_tbl.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                Lecturer_tblLoadHDs(evt);
            }
        });
        jScrollPane1.setViewportView(Lecturer_tbl);

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

    private void GV_ID_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GV_ID_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GV_ID_txtActionPerformed

    public boolean CheckTextField()
    {
        if (GV_ID_txt.getText() == null || GV_LastName_txt.getText() == null || GV_FirstName_txt.getText() == null || GV_Khoa_cmb.getSelectedIndex() == -1)
          return false;
        
        return true;
    }
    private void GV_Add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GV_Add_btnActionPerformed
        DAO_GiangVien AddGV = new DAO_GiangVien();
        GiangVien GV = new GiangVien();
        if (CheckTextField()== true)
        {
            GV.setId( GV_ID_txt.getText());
            GV.setLastName(GV_LastName_txt.getText());
            GV.setFirtName(GV_FirstName_txt.getText());
            GV.setNameKhoa(GV_Khoa_cmb.getSelectedItem().toString());
            DAO_Khoa kh = new DAO_Khoa();
            String ID= kh.getIDKhoaFromName(GV_Khoa_cmb.getSelectedItem().toString());
            GV.setIdKhoa(ID);
            if (AddGV.existGV(GV.getId())==false)
            {
                try {
                    AddGV.insertGiangVien(GV);
                    loadDefaultTableFromDB();
                    JOptionPane.showMessageDialog(null,"Them thanh cong","Success",JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(LecturerForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
            else {
                JOptionPane.showMessageDialog(null,"Giang vien da ton tai","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else JOptionPane.showMessageDialog(null,"Hay nhap day du thong tin","Error",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_GV_Add_btnActionPerformed

    private void GV_FirstName_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GV_FirstName_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GV_FirstName_txtActionPerformed

    private void GV_LastName_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GV_LastName_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GV_LastName_txtActionPerformed

    private void Lecturer_tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Lecturer_tblMouseClicked
       int index = Lecturer_tbl.getSelectedRow();
       TableModel model = Lecturer_tbl.getModel();
       if (index !=-1)
       {
        GV_ID_txt.setText( model.getValueAt(index, 0).toString()); 
        GV_FirstName_txt.setText(model.getValueAt(index, 1).toString());
        GV_LastName_txt.setText(model.getValueAt(index, 2).toString());
        GV_Khoa_cmb.setSelectedItem(model.getValueAt(index, 4));
       }
    }//GEN-LAST:event_Lecturer_tblMouseClicked

    public void Clear()
    {
        GV_ID_txt.setText("");
        GV_FirstName_txt.setText("");
        GV_LastName_txt.setText("");
        GV_Khoa_cmb.setSelectedIndex(-1);
        Check.RemoveTableData((DefaultTableModel) Lecturer_tbl.getModel());
    }
    private void Lecturer_tblLoadHDs(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_Lecturer_tblLoadHDs
        try {
            ListGiangVien lst = new ListGiangVien(0,null,null,null,null, false);
            DefaultTableModel model = lst.getTableModel();
            Lecturer_tbl.setModel(model);
            JOptionPane.showMessageDialog(null,"Xuat thanh cong","Success"
            ,JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.toString(),"Success",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_Lecturer_tblLoadHDs

    private void GV_Refrech_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GV_Refrech_btnActionPerformed
        loadDefaultTableFromDB();
            
    }//GEN-LAST:event_GV_Refrech_btnActionPerformed

    private void loadDefaultTableFromDB(){
        Clear();     
        try {
            DefaultTableModel model = (DefaultTableModel) Lecturer_tbl.getModel();
            ListGiangVien lst = new ListGiangVien(0,"","","","", false);
            lst.setTableModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(LecturerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void loadComboBoxKhoa()
    {   GV_Khoa_cmb.removeAllItems();
        
        DAO_Khoa khoa = new DAO_Khoa();
        List<String> listKhoa = khoa.getNameKhoaList();
        for (String i: listKhoa )
        {
            GV_Khoa_cmb.addItem(i);
        }
        GV_Khoa_cmb.setSelectedIndex(-1);
    }
    private void GV_Khoa_cmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GV_Khoa_cmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GV_Khoa_cmbActionPerformed

    private void GV_Edit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GV_Edit_btnActionPerformed
        
        DAO_GiangVien EditGV = new DAO_GiangVien();
        GiangVien GV = new GiangVien();
        int index = Lecturer_tbl.getSelectedRow();
        if (index !=-1)
        {
            if (CheckTextField())
            {
                GV.setId( GV_ID_txt.getText());
                GV.setLastName(GV_LastName_txt.getText());
                GV.setFirtName(GV_FirstName_txt.getText());
                GV.setNameKhoa(GV_Khoa_cmb.getSelectedItem().toString());
                DAO_Khoa kh = new DAO_Khoa();
                String ID= kh.getIDKhoaFromName(GV_Khoa_cmb.getSelectedItem().toString());
                GV.setIdKhoa(ID);
                EditGV.updateGV(GV);
                loadDefaultTableFromDB();
            }
        }
        else 
        {
            JOptionPane.showMessageDialog(null,"Hay chon dong de chinh sua","Error",JOptionPane.ERROR);
        }
    }//GEN-LAST:event_GV_Edit_btnActionPerformed

    private void GV_Delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GV_Delete_btnActionPerformed
        DAO_GiangVien DeleteGV = new DAO_GiangVien();
        int index = Lecturer_tbl.getSelectedRow();
        if (index != -1)
        {
            if (GV_ID_txt.getText() != null)
            {
                DeleteGV.deleteGiangVien(GV_ID_txt.getText());
                loadDefaultTableFromDB();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Hay chon dong de xoa","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_GV_Delete_btnActionPerformed

    private void GV_ImportExcel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GV_ImportExcel_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GV_ImportExcel_btnActionPerformed

    private void GV_Search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GV_Search_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GV_Search_btnActionPerformed

    private void GV_ExportExcel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GV_ExportExcel_btnActionPerformed
        fileExcel export = new fileExcel();
        try {
            ListGiangVien lst = new ListGiangVien(0,"","","","", false);
            final String excelFilePath = "C:/Desktop/books.xlsx";
            try {
                //JFileChooser fileChooser = new JFileChooser();
//            fileChooser.setDialogTitle("Save Excel File");
//            int userSelection = fileChooser.showSaveDialog(null);
//            if (userSelection == JFileChooser.APPROVE_OPTION) {
//                File fileToSave = fileChooser.getSelectedFile();
//                // Ensure the file has a .xlsx extension
//                if (!fileToSave.getAbsolutePath().endsWith(".xlsx")) {
//                    fileToSave = new File(fileToSave.getAbsolutePath() + ".xlsx");
//                    export.printGiangVien(lst.list, fileToSave);
//                }
            export.printGiangVien(lst.list, excelFilePath);
            } catch (IOException ex) {
                Logger.getLogger(LecturerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(LecturerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_GV_ExportExcel_btnActionPerformed

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
    private javax.swing.JTextField GV_FirstName_txt;
    private javax.swing.JTextField GV_ID_txt;
    private javax.swing.JButton GV_ImportExcel_btn;
    private javax.swing.JComboBox<String> GV_Khoa_cmb;
    private javax.swing.JTextField GV_LastName_txt;
    private javax.swing.JButton GV_Refrech_btn;
    private javax.swing.JButton GV_Search_btn;
    private javax.swing.JTable Lecturer_tbl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
