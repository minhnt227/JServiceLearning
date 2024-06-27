/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.GiangVien;
import MODEL.Khoa;
import MODEL.ListGiangVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author bom19
 */
public class DAO_GiangVien extends DBConnector {

    public DAO_GiangVien() {
    }

    public boolean existGV(String ID) {
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM GIANG_VIEN WHERE MaGV LIKE '" + ID + "'";
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

    public boolean insertGiangVien(GiangVien newData) throws SQLException {
        try {
            Prepstm = con.prepareStatement("INSERT INTO GIANG_VIEN VALUES (?,?,?,?,'false')");

            Prepstm.setString(1, newData.getId());
            Prepstm.setNString(2, newData.getLastName());
            Prepstm.setNString(3, newData.getFirtName());
            Prepstm.setString(4, newData.getIdKhoa());

            return super.updateDB();
        } catch (SQLException e) {
            e.printStackTrace();
            Prepstm.close();
            return false;
        }
    }
    
    public boolean deleteGiangVien(String ID) {
        try {
            Prepstm = con.prepareStatement("UPDATE GIANG_VIEN SET Hide = 'true' WHERE MaGV LIKE ?");
            Prepstm.setString(1, ID);
            
            return super.updateDB();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getSQLState());
            return false;
        }
    }
    
    /**
     * Update an GIANG_VIEN model to the Database. If a GIANG_VIEN is already in
     * DB, update its data, if not, insert a new record of GIANG_VIEN
     *
     * @param gv New GiangVien data to add or update to DB
     * @return true if insert or update success, false if operation failed
     */
    public boolean updateGV(GiangVien gv) {
        if (gv == null) {
            return false;
        }
        if (!existGV(gv.getId())) {
            try {
                return insertGiangVien(gv);
            } catch (SQLException ex) {
                Logger.getLogger(DAO_GiangVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Prepstm = con.prepareStatement("UPDATE GIANG_VIEN "
                    + "SET HoTenLot = ?, Ten = ?, Khoa = ?, Hide = 'false' "
                    + "WHERE MaGV = ?");

            Prepstm.setNString(1, gv.getLastName());
            Prepstm.setNString(2, gv.getFirtName());
            Prepstm.setString(3, gv.getIdKhoa());
            Prepstm.setString(4, gv.getId());

            return super.updateDB();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getSQLState());
            return false;
        }
    }
    
    public GiangVien getSingleByID(String ID) {
        GiangVien gv = null;
        if (!existGV(ID)) {
            return gv;
        }
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM GIANG_VIEN WHERE MaGV LIKE '" + ID + "' AND Hide = 'false'";
            ResultSet rst = stm.executeQuery(sqlSelect);
            if (!rst.first()) {
                stm.close();
                return null;
            }
            Khoa kh = (new DAO_Khoa()).getSingleKhoaFromID(rst.getString(4));                //Faculty of Teacher
            gv = new GiangVien(rst.getString(1), rst.getNString(2), rst.getNString(3), kh.getName());
            gv.setIdKhoa(kh.getId());
            stm.close();
            return gv;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gv;
    }
    
    /**
     *
     * @param FirstName
     * @return gv from Database
     */
    public GiangVien getSingleByName(String FirstName) {
        GiangVien gv = null;
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM GIANG_VIEN WHERE Ten LIKE N'%" + FirstName + "%'";
            ResultSet rst = stm.executeQuery(sqlSelect);
            if (!rst.first()) {
                stm.close();
                return null;
            }
            Khoa kh = (new DAO_Khoa()).getSingleKhoaFromID(rst.getString(3));                //Faculty of Student
            gv = new GiangVien(rst.getString(1), rst.getNString(2), rst.getNString(3), kh.getName());
            gv.setIdKhoa(kh.getId());
            stm.close();
            return gv;
        } catch (Exception e) {
            e.printStackTrace();
            return gv;
        }
    }
    
    /**
     *
     * If want to select all teacher, leaves Hide = true and others at null/0
     * 
     * @param limit number of records to select, if it's 0 or below, get all records in DB
     * @param gvID  check if records contain gvID
     * @param LastN  check for last name
     * @param FirstN check for first name
     * @param FalcultyID  select all teacher in this faculty
     * @param Hide Deleted or not
     * @return
     * @throws SQLException
     */
    public ListGiangVien getListFromDB(int limit, String gvID, String LastN, String FirstN, String FalcultyID, boolean Hide) throws SQLException {
        ListGiangVien Objs = new ListGiangVien();
        if(limit <=0)
            sqlQuery = "SELECT * FROM GIANG_VIEN WHERE Hide = '" + Hide + "'";
        else
            sqlQuery = "SELECT TOP " + limit + " * FROM GIANG_VIEN WHERE Hide = '" + Hide + "'";
        
        
        if (!gvID.isBlank()) {
            sqlQuery += " AND MaGV LIKE '%" + gvID + "%'";
        }
        if (!LastN.isBlank()) {
            sqlQuery += " AND HoTenLot LIKE N'%" + LastN + "%'";
        }
        if (!FirstN.isBlank()) {
            sqlQuery += " AND Ten LIKE N'%" + FirstN + "%'";
        }
        if (!FalcultyID.isBlank()) {
            sqlQuery += " AND Khoa = " + FalcultyID;
        }
        
        
        Statement stm = con.createStatement();
        ResultSet result = stm.executeQuery(sqlQuery);
        while(result.next()){
            Objs.list.add(getSingleByID(result.getString(1)));
        }
        Objs.colHeader = getColunmHeader(result);
        return Objs;
    }
    
    /**
     *
     * @param idHD
     * @return A ListGiangVien with their HOAT_DONG properties. GiangVien in this list
     * have the same index as their ID
     */
    public ListGiangVien getListHD_GiangVien(int idHD) {
        if (DAO_HoatDong.exist(idHD)) {
            try {
                ListGiangVien Objs = new ListGiangVien();
                Objs.setMaHD(idHD);
                //Build a list of GiangVien's ID belong to the HoatDong with idHD
                sqlQuery = "SELECT * FROM HD_GIANGVIEN WHERE MaHD = '" + idHD + "'";
                Statement stm = con.createStatement();
                ResultSet result = stm.executeQuery(sqlQuery);
                while (result.next()) {
                    String idGV = result.getString(2);
                    GiangVien gv = new GiangVien();
                    //set the first 3 attribute from HD_GIANGVIEN
                    gv.setMaHD(idHD);
                    gv.setId(idGV);
                    gv.setVaiTro(result.getNString(3));
                    //find a temporary GiangVien from GIANG_VIEN Table to fill in the rest attribute
                    GiangVien temp = getSingleByID(idGV);
                    if (temp.getHide() || temp == null) {
                        continue;           //don't add to list if GiangVien is deleted or null
                    }
                    gv.setLastName(temp.getLastName());
                    gv.setFirtName(temp.getFirtName());   
                    gv.setNameKhoa(temp.getNameKhoa());
                    gv.setIdKhoa(temp.getIdKhoa());
                    gv.setHide(Boolean.FALSE);

                    Objs.list.add(gv); //add GiangVien to list with the same index as ID in DB
                }
                if (Objs.list.size() <= 0) {
                    return null;
                }
                return Objs;
            } catch (SQLException ex) {
                Logger.getLogger(DAO_GiangVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    /**
     * Delete all HD_GIANGVIEN with idHD
     *
     * @param idHD
     * @return @true if success or @false when there's no row to delete or fails
     */
    public boolean deleteListHD_GiangVien(int idHD) {
        if (!DAO_HoatDong.exist(idHD)) {
            return false;
        }
        try {
            Prepstm = con.prepareStatement("DELETE FROM HD_GIANGVIEN WHERE MaHD = ?");
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
    public boolean updateListHD_GiangVien(ListGiangVien HD_GVs) {
        if (HD_GVs.getMaHD() <= 0 || HD_GVs == null) //ListGiangVien must have HDid. Add by using method setMaHD() from parent class
        {
            //System.out.println("There's no HOAT_DONG to add this list to!!! Create a HOAT_DONG and add it's id to this list!");
            return false;
        }
        try {

            //delete old data in HD_GIANGVIEN
            deleteListHD_GiangVien(HD_GVs.getMaHD());
            //loop through the list
            for (GiangVien gv : HD_GVs.list) {
                //update or insert into GIANG_VIEN
                updateGV(gv);
                //get GiangVien's ID
                String iDGV = gv.getId();
                //Add new HD_GiangVien 
                sqlQuery = "INSERT INTO HD_GIANGVIEN VALUES (?,?,?)";
                Prepstm = con.prepareStatement(sqlQuery);
                Prepstm.setInt(1, HD_GVs.getMaHD());
                Prepstm.setString(2, iDGV);
                Prepstm.setNString(3, gv.getVaiTro());

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
