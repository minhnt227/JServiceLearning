/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.Khoa;
import MODEL.ListSinhVien;
import MODEL.SinhVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            PreparedStatement stmt = con.prepareStatement("INSERT INTO SINH_VIEN VALUES (?,?,?,false)");

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
            String sqlSelect = "SELECT * FROM SINH_VIEN WHERE HoTen LIKE '%" + Name + "%'";
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
        if(limit <=0)
            sqlQuery = "SELECT * FROM SINH_VIEN WHERE Hide = '" + Hide + "'";
        else
            sqlQuery = "SELECT TOP " + limit + " * FROM SINH_VIEN WHERE Hide = '" + Hide + "'";
        if (!ID.isBlank()) {
            sqlQuery += " AND MSSV LIKE '%" + ID + "%'";
        }
        if (!NAME.isBlank()) {
            sqlQuery += " AND HoTen LIKE '%" + NAME + "%'";
        }
        if (!FalcultyID.isBlank()) {
            sqlQuery += " AND Khoa LIKE " + FalcultyID;
        }
        Statement stm = con.createStatement();
        ResultSet result = stm.executeQuery(sqlQuery);
        while(result.next()){
            SVs.list.add(getSingleByID(result.getString(1)));
        }
        SVs.colHeader = getColunmHeader(result);
        return SVs;
    }
}
