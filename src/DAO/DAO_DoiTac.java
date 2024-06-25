/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.logging.*;
import MODEL.DoiTac;
import MODEL.ListDoiTac;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author bom19
 */
public class DAO_DoiTac extends DBConnector {

    public DAO_DoiTac() {
    }
    
    public boolean existDT(String Name) {
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM DOI_TAC WHERE TenDoiTac LIKE '" + Name + "'";
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
    
    private boolean insertDoiTac(DoiTac newData) throws SQLException {
        try {
            Prepstm = con.prepareStatement("INSERT INTO DOI_TAC VALUES (?,?,?,?,'false')");

            Prepstm.setString(1, newData.getName());
            Prepstm.setNString(2, newData.getNameHost());
            Prepstm.setNString(3, newData.getPhone());
            Prepstm.setString(4, newData.getEmail());

            return super.updateDB();
        } catch (SQLException e) {
            e.printStackTrace();
            Prepstm.close();
            return false;
        }
    }
    
    /**
     * Update an DOI_TAC model to the Database. If a DOI_TAC is already in
     * DB, update its data, if not, insert a new record of GIANG_VIEN
     *
     * @param gv New DoiTac data to add or update to DB
     * @return true if insert or update success, false if operation failed
     */
    public boolean updateDT(DoiTac dt) {
        if (dt == null||dt.getName().isBlank()) {
            return false;
        }
        if (!existDT(dt.getName())) {
            try {
                return insertDoiTac(dt);
            } catch (SQLException ex) {
                Logger.getLogger(DAO_GiangVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        try {
            Prepstm = con.prepareStatement("UPDATE DOI_TAC "
                    + "SET DaiDien = ?, SDT = ?, Email = ?, Hide = 'false' "
                    + "WHERE TenDoiTac = ?");

            Prepstm.setNString(1, dt.getNameHost());
            Prepstm.setNString(2, dt.getPhone());
            Prepstm.setString(3, dt.getEmail());
            Prepstm.setString(4, dt.getName().trim());

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
            Prepstm = con.prepareStatement("UPDATE DOI_TAC SET Hide = 'true' WHERE TenDoiTac LIKE ?");
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
    public DoiTac getSingleByName(String Name) {
        DoiTac dt = null;
        try {
            Statement stm = con.createStatement();
            String sqlSelect;
            sqlSelect = "SELECT * FROM DOI_TAC WHERE TenDoiTac LIKE '%" + Name + "%'";
            ResultSet rst = stm.executeQuery(sqlSelect);
            if (!rst.first()) {
                stm.close();
                return null;
            }
            dt = new DoiTac(rst.getNString(2), rst.getNString(3), rst.getString(4), rst.getString(5));
            dt.setDtID(rst.getInt(1));
            stm.close();
            return dt;
        } catch (Exception e) {
            e.printStackTrace();
            return dt;
        }
    
    }
    
    public ListDoiTac getListFromDB(int limit, String name,  boolean Hide) throws SQLException {
        ListDoiTac Objs = new ListDoiTac();
        if(limit <=0)
            sqlQuery = "SELECT * FROM DOI_TAC WHERE Hide = '" + Hide + "'";
        else
            sqlQuery = "SELECT TOP " + limit + " * FROM DOI_TAC WHERE Hide = '" + Hide + "'";
        
        
        if (!name.isBlank()) {
            sqlQuery += " AND TenDoiTac LIKE '%" + name + "%'";
        }
        
        
        Statement stm = con.createStatement();
        ResultSet result = stm.executeQuery(sqlQuery);
        while(result.next()){
            Objs.list.add(getSingleByName(result.getString(2)));
        }
        Objs.colHeader = getColunmHeader(result);
        return Objs;
    }
}
