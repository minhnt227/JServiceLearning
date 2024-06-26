/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.Khoa;
import MODEL.ListSinhVien;
import MODEL.SinhVien;
import java.util.logging.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author bom19
 */
public class DAO_SinhVien extends DBConnector {

    public DAO_SinhVien() {
    }

    public boolean existSV(String ID) {
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM SINH_VIEN WHERE MSSV LIKE '" + ID + "'";
            ResultSet rst = stm.executeQuery(sqlSelect);
            if (!rst.first()) {
                stm.close();
                return false;
            }
            stm.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean insertSinhVien(SinhVien newData) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO SINH_VIEN VALUES (?,?,?,'false')");

            stmt.setString(1, newData.getId());
            stmt.setNString(2, newData.getName());
            stmt.setString(3, newData.getIdKhoa());

            if (stmt.executeUpdate() == 0) {
                stmt.close();
                return false;
            } else {
                stmt.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteSinhVien(String ID) {
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE SINH_VIEN SET Hide = 'true' WHERE MSSV LIKE '" + ID + "'");
            if (stmt.executeUpdate() != 0) {
                stmt.close();
                return true;
            } else {
                stmt.close();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getSQLState());
            return false;
        }
    }

    /**
     * Update an SinhVien model to the Database. If a SINH_VIEN is already in
     * DB, update its data, if not, insert a new record of SINH_VIEN
     *
     * @param sv New SinhVien data to add or update to DB
     * @return true if insert or update success, false if operation failed
     */
    public boolean updateSV(SinhVien sv) {
        if (sv == null) {
            return false;
        }
        if (!existSV(sv.getId())) {
            if (insertSinhVien(sv)) {
                return true;
            } else {
                return false;
            }
        }
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE SINH_VIEN "
                    + "Set HoTen = ?, Khoa = ?, Hide = 'false' "
                    + "WHERE MSSV = ?");

            stmt.setNString(1, sv.getName());
            stmt.setString(2, sv.getIdKhoa());
            stmt.setString(3, sv.getId());

            if (stmt.executeUpdate() != 0) {
                stmt.close();
                return true;
            } else {
                stmt.close();
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getSQLState());
            return false;
        }
    }

    public SinhVien getSingleByID(String ID) {
        SinhVien sv = null;
        if (!existSV(ID)) {
            return sv;
        }
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM SINH_VIEN WHERE MSSV LIKE '" + ID + "'";
            ResultSet rst = stm.executeQuery(sqlSelect);
            if (!rst.first()) {
                stm.close();
                return null;
            }
            Khoa kh = (new DAO_Khoa()).getSingleKhoaFromID(rst.getString(3));                //Falcuty of Student
            sv = new SinhVien(rst.getString(1), rst.getNString(2), kh.getName());
            sv.setIdKhoa(kh.getId());
            stm.close();
            return sv;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sv;
    }

    public SinhVien getSingleByName(String Name) {
        SinhVien sv = null;
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM SINH_VIEN WHERE HoTen LIKE N'%" + Name + "%'";
            ResultSet rst = stm.executeQuery(sqlSelect);
            if (!rst.first()) {
                stm.close();
                return null;
            }
            Khoa kh = (new DAO_Khoa()).getSingleKhoaFromID(rst.getString(3));                //Falcuty of Student
            sv = new SinhVien(rst.getString(1), rst.getNString(2), kh.getName());
            sv.setIdKhoa(kh.getId());
            stm.close();
            return sv;
        } catch (Exception e) {
            e.printStackTrace();
            return sv;
        }
    }

    public ListSinhVien getListFromDB(int limit, String ID, String NAME, String FalcultyID, boolean Hide) throws SQLException {
        ListSinhVien SVs = new ListSinhVien();
        if (limit <= 0) {
            sqlQuery = "SELECT * FROM SINH_VIEN WHERE Hide = '" + Hide + "'";
        } else {
            sqlQuery = "SELECT TOP " + limit + " * FROM SINH_VIEN WHERE Hide = '" + Hide + "'";
        }
        if (!ID.isBlank()) {
            sqlQuery += " AND MSSV LIKE '%" + ID + "%'";
        }
        if (!NAME.isBlank()) {
            sqlQuery += " AND HoTen LIKE N'%" + NAME + "%'";
        }
        if (!FalcultyID.isBlank()) {
            sqlQuery += " AND Khoa = " + FalcultyID;
        }
        Statement stm = con.createStatement();
        ResultSet result = stm.executeQuery(sqlQuery);
        while (result.next()) {
            SVs.list.add(getSingleByID(result.getString(1)));
        }
        SVs.colHeader = getColunmHeader(result);
        return SVs;
    }

    /**
     *
     * @param idHD
     * @return A ListSinhVien with their HOAT_DONG properties.
     */
    public ListSinhVien getListHD_GiangVien(int idHD) {
        if (DAO_HoatDong.exist(idHD)) {
            try {
                ListSinhVien Objs = new ListSinhVien();
                Objs.setMaHD(idHD);
                //Build a list of SinhVien's ID belong to the HoatDong with idHD
                sqlQuery = "SELECT * FROM HD_SINHVIEN WHERE MaHD = '" + idHD + "'";
                Statement stm = con.createStatement();
                ResultSet result = stm.executeQuery(sqlQuery);
                while (result.next()) {
                    String idSV = result.getString(2);
                    SinhVien sv = new SinhVien();
                    //set the first 3 attribute from HD_SINHVIEN
                    sv.setMaHD(idHD);
                    sv.setId(idSV);
                    sv.setVaiTro(result.getNString(3));
                    //find a temporary SINHVIEN from SINH_VIEN Table to fill in the rest attribute
                    SinhVien temp = getSingleByID(idSV);
                    if (temp.getHide() || temp == null) {
                        continue;           //don't add to list if SinhVien is deleted or null
                    }
                    sv.setName(temp.getName());
                    sv.setNameKhoa(temp.getNameKhoa());
                    sv.setIdKhoa(temp.getIdKhoa());
                    sv.setHide(Boolean.FALSE);

                    Objs.list.add(sv); //add SinhVien to list with the same index as ID in DB
                }
                if (Objs.list.size() <= 0) {
                    return null;
                }
                return Objs;
            } catch (SQLException ex) {
                Logger.getLogger(DAO_SinhVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    /**
     * Delete all HD_SINHVIEN with idHD
     *
     * @param idHD
     * @return @true if success or @false when there's no row to delete or fails
     */
    public boolean deleteListHD_SinhVien(int idHD) {
        if (!DAO_HoatDong.exist(idHD)) {
            return false;
        }
        try {
            Prepstm = con.prepareStatement("DELETE FROM HD_SINHVIEN WHERE MaHD = ?");
            Prepstm.setInt(1, idHD);

            return super.updateDB();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getSQLState());
            return false;
        }
    }

    /**
     *
     * @param HD_GVs
     * @return
     */
    public boolean updateListHD_SinhVien(ListSinhVien HD_SVs) {
        if (HD_SVs.getMaHD() <= 0 || HD_SVs == null) //ListSinhVien must have HDid. Add by using method setMaHD() from parent class
        {
            //System.out.println("There's no HOAT_DONG to add this list to!!! Create a HOAT_DONG and add it's id to this list!");
            return false;
        }
        try {

            //delete old data in HD_SINHVIEN
            deleteListHD_SinhVien(HD_SVs.getMaHD());
            //loop through the list
            for (SinhVien sv : HD_SVs.list) {
                //update or insert into SINH_VIEN
                updateSV(sv);
                //get SinhVien's ID
                String iDSV = sv.getId();
                //Add new HD_SinhVien 
                sqlQuery = "INSERT INTO HD_SINHVIEN VALUES (?,?,?)";
                Prepstm = con.prepareStatement(sqlQuery);
                Prepstm.setInt(1, HD_SVs.getMaHD());
                Prepstm.setString(2, iDSV);
                Prepstm.setNString(3, sv.getVaiTro());

                return super.updateDB();
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
