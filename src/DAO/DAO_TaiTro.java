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
public class DAO_TaiTro extends DBConnector{

    public DAO_TaiTro() {
    }
    
    public boolean existTT(String Name) {
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM TAI_TRO WHERE TenTaiTro LIKE '" + Name + "'";
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
     * Update an TAI_TRO model to the Database. If a TAI_TRO is already in
     * DB, update its data, if not, insert a new record of TAI_TRO
     * NEED ID IF UPDATE
     *
     * @param gv New TaiTro data to add or update to DB
     * @return true if insert or update success, false if operation failed
     */
    public boolean updateDT(TaiTro dt) {
        //null check
        if (dt == null||dt.getName().isBlank()) {
            return false;
        }
        //if not in DB, add it in
        if (!existTT(dt.getName())) {
            try {
                return insertTaiTro(dt);
            } catch (SQLException ex) {
                Logger.getLogger(DAO_TaiTro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        try {
            Prepstm = con.prepareStatement("UPDATE TAI_TRO "
                    + "SET TenTaiTro = ?, DaiDien = ?, SDT = ?, Email = ?, Hide = 'false' "
                    + "WHERE ID_TaiTro = ?");

            Prepstm.setNString(1, dt.getName());
            Prepstm.setNString(2, dt.getNameHost());
            Prepstm.setString(3, dt.getPhone());
            Prepstm.setString(4, dt.getPhone());
            Prepstm.setInt(5, dt.getId());

            return super.updateDB();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getSQLState());
            return false;
        }
    }
    
    public boolean deleteDoiTac(String name) {
        if(name.isBlank())
            return false;
        try {
            Prepstm = con.prepareStatement("UPDATE TAI_TRO SET Hide = 'true' WHERE TenTaiTro LIKE ?");
            Prepstm.setString(1, name.trim());
            
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
     * @return dt from Database
     */
    public TaiTro getSingleByName(String Name) {
        TaiTro dt = null;
        try {
            Statement stm = con.createStatement();
            String sqlSelect;
            sqlSelect = "SELECT * FROM TAI_TRO WHERE TenTaiTro LIKE '%" + Name + "%'";
            ResultSet rst = stm.executeQuery(sqlSelect);
            if (!rst.first()) {
                stm.close();
                return null;
            }
            dt = new TaiTro(rst.getInt(1),rst.getNString(2), rst.getNString(3), rst.getString(4), rst.getString(5));
            stm.close();
            return dt;
        } catch (Exception e) {
            e.printStackTrace();
            return dt;
        }
    
    }
    
    public ListTaiTro getListFromDB(int limit, String name,  boolean Hide) throws SQLException {
        ListTaiTro Objs = new ListTaiTro();
        if(limit <=0)
            sqlQuery = "SELECT * FROM TAI_TRO WHERE Hide = '" + Hide + "'";
        else
            sqlQuery = "SELECT TOP " + limit + " * FROM TAI_TRO WHERE Hide = '" + Hide + "'";
        
        
        if (!name.isBlank()) {
            sqlQuery += " AND TenTaiTro LIKE '%" + name + "%'";
        }
        
        
        Statement stm = con.createStatement();
        ResultSet result = stm.executeQuery(sqlQuery);
        while(result.next()){
            Objs.list.add(getSingleByName(result.getNString(2)));
        }
        Objs.colHeader = getColunmHeader(result);
        return Objs;
    }
}
