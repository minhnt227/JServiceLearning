/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.ListTaiTro;
import MODEL.TaiTro;
import java.sql.*;
import java.util.logging.*;
import javax.swing.JOptionPane;

/**
 *
 * @author bom19
 */
public class DAO_TaiTro extends DBConnector {

    public DAO_TaiTro() {
    }

    public boolean existTT(String Name) {
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM TAI_TRO WHERE TenTaiTro LIKE N'" + Name + "'";
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

    private boolean insertTaiTro(TaiTro newData) throws SQLException {
        try {
            Prepstm = con.prepareStatement("INSERT INTO TAI_TRO VALUES (?,?,?,?,'false')");

            Prepstm.setNString(1, newData.getName());
            Prepstm.setNString(2, newData.getNameHost());
            Prepstm.setString(3, newData.getPhone());
            Prepstm.setString(4, newData.getEmail());

            return super.updateDB();
        } catch (SQLException e) {
            e.printStackTrace();
            Prepstm.close();
            return false;
        }
    }

    /**
     * Update an TAI_TRO model to the Database. If a TAI_TRO is already in DB,
     * update its data, if not, insert a new record of TAI_TRO NEED ID IF UPDATE
     *
     * @param gv New TaiTro data to add or update to DB
     * @return true if insert or update success, false if operation failed
     */
    public boolean updateTT(TaiTro tt) {
        //null check
        if (tt == null || tt.getName().isBlank()) {
            return false;
        }
        //if not in DB, add it in
        if (!existTT(tt.getName())) {
            try {
                return insertTaiTro(tt);
            } catch (SQLException ex) {
                Logger.getLogger(DAO_TaiTro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        try {
            Prepstm = con.prepareStatement("UPDATE TAI_TRO "
                    + "SET TenTaiTro = ?, DaiDien = ?, SDT = ?, Email = ?, Hide = 'false' "
                    + "WHERE ID_TaiTro = ?");

            Prepstm.setNString(1, tt.getName());
            Prepstm.setNString(2, tt.getNameHost());
            Prepstm.setString(3, tt.getPhone());
            Prepstm.setString(4, tt.getPhone());
            Prepstm.setInt(5, tt.getId());

            return super.updateDB();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getSQLState());
            return false;
        }
    }

    public boolean deleteTaiTro(String name) {
        if (name.isBlank()) {
            return false;
        }
        try {
            Prepstm = con.prepareStatement("UPDATE TAI_TRO SET Hide = 'true' WHERE TenTaiTro LIKE ?");
            Prepstm.setNString(1, name.trim());

            return super.updateDB();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getSQLState());
            return false;
        }
    }

    /**
     *
     * @param Name
     * @return tt from Database
     */
    public TaiTro getSingleByName(String Name) {
        TaiTro dt = null;
        try {
            Statement stm = con.createStatement();
            String sqlSelect;
            sqlSelect = "SELECT * FROM TAI_TRO WHERE TenTaiTro LIKE N'%" + Name + "%'";
            ResultSet rst = stm.executeQuery(sqlSelect);
            if (!rst.first()) {
                stm.close();
                return null;
            }
            dt = new TaiTro(rst.getInt(1), rst.getNString(2), rst.getNString(3), rst.getString(4), rst.getString(5));
            stm.close();
            return dt;
        } catch (Exception e) {
            e.printStackTrace();
            return dt;
        }

    }

    public TaiTro getSingleById(int Id) {
        TaiTro dt = null;
        try {
            Statement stm = con.createStatement();
            String sqlSelect;
            sqlSelect = "SELECT * FROM TAI_TRO WHERE ID_TaiTro = " + Id;
            ResultSet rst = stm.executeQuery(sqlSelect);
            if (!rst.first()) {
                stm.close();
                return null;
            }
            dt = new TaiTro(rst.getInt(1), rst.getNString(2), rst.getNString(3), rst.getString(4), rst.getString(5));
            dt.setHide(rst.getBoolean(6));
            stm.close();
            return dt;
        } catch (Exception e) {
            e.printStackTrace();
            return dt;
        }

    }

    public ListTaiTro getListFromDB(int limit, String name, boolean Hide) throws SQLException {
        ListTaiTro Objs = new ListTaiTro();
        if (limit <= 0) {
            sqlQuery = "SELECT * FROM TAI_TRO WHERE Hide = '" + Hide + "'";
        } else {
            sqlQuery = "SELECT TOP " + limit + " * FROM TAI_TRO WHERE Hide = '" + Hide + "'";
        }

        if (!name.isBlank()) {
            sqlQuery += " AND TenTaiTro LIKE N'%" + name + "%'";
        }

        Statement stm = con.createStatement();
        ResultSet result = stm.executeQuery(sqlQuery);
        while (result.next()) {
            Objs.list.add(getSingleByName(result.getNString(2)));
        }
        Objs.colHeader = getColunmHeader(result);
        return Objs;
    }

    /**
     *
     * @param idHD
     * @return A ListTaiTro with their HOAT_DONG properties. TaiTro in this list
     * have the same index as their ID
     */
    public ListTaiTro getListHD_TaiTro(int idHD) {
        if (DAO_HoatDong.exist(idHD)) {
            try {
                ListTaiTro Objs = new ListTaiTro();
                Objs.setMaHD(idHD);
                //Build a list of TaiTro's ID belong to the HoatDong with idHD
                sqlQuery = "SELECT * FROM HD_TAITRO WHERE MaHD = '" + idHD + "'";
                Statement stm = con.createStatement();
                ResultSet result = stm.executeQuery(sqlQuery);
                while (result.next()) {
                    int idTaiTro = result.getInt(1);
                    TaiTro tt = new TaiTro();
                    //set the first 3 attribute from HD_TAITRO
                    tt.setMaHD(idHD);
                    tt.setId(idTaiTro);
                    tt.setNoiDung(result.getNString(3));
                    //find a temporary TaiTro from TAI_TRO Table to fill in the rest attribute
                    TaiTro temp = getSingleById(idTaiTro);
                    if (temp.getHide() || temp == null) {
                        continue;           //don't add to list if TaiTro is deleted or null
                    }
                    tt.setName(temp.getName());
                    tt.setNameHost(temp.getNameHost());
                    tt.setPhone(temp.getPhone());
                    tt.setEmail(temp.getEmail());
                    tt.setHide(Boolean.FALSE);

                    Objs.list.add(idTaiTro, tt); //add TaiTro to list with the same index as ID in DB
                }
                if (Objs.list.size() <= 0) {
                    return null;
                }
                return Objs;
            } catch (SQLException ex) {
                Logger.getLogger(DAO_TaiTro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    /**
     * @author MinhNT Delete all HD_TAITRO with idHD
     *
     * @param idHD
     * @return @true if success or @false when there's no row to delete or fails
     */
    public boolean deleteListHD_TaiTro(int idHD) {
        if (idHD <= 0) {
            return false;
        }
        try {
            Prepstm = con.prepareStatement("DELETE FROM HD_TAITRO WHERE MaHD = ?");
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
     * @param HD_TTs
     * @return
     */
    public boolean updateListHD_TaiTro(ListTaiTro HD_TTs) {
        if (HD_TTs.getMaHD() <= 0) //ListTaiTro must have HDid. Add by using method setMaHD() from parent class
        {
            System.out.println("There's no HOAT_DONG to add this list to!!! Create a HOAT_DONG and add it's id to this list!");
            return false;
        }
        try {

            //delete old data in HD_TAITRO
            deleteListHD_TaiTro(HD_TTs.getMaHD());
            //loop through the list
            for (TaiTro tt : HD_TTs.list) {
                //update or insert into TAI_TRO
                updateTT(tt);
                //get TaiTro's ID
                int TTId = getSingleByName(tt.getName()).getId();
                //Add new HD_TaiTro 
                sqlQuery = "INSERT INTO HD_TAITRO VALUES (?,?,?)";
                Prepstm = con.prepareStatement(sqlQuery);
                Prepstm.setInt(1, TTId);
                Prepstm.setInt(2, tt.getMaHD());
                Prepstm.setNString(3, tt.getNoiDung());

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
