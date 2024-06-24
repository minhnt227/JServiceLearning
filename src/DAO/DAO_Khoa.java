/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.Khoa;
import java.util.*;
import java.sql.*;

/**
 *
 * @author bom19
 */
public class DAO_Khoa extends DBConnector {

    ArrayList<Khoa> list;

    public DAO_Khoa() {
    }

    /**
     *
     * @param Hide
     *
     * Create a new object with Khoa list from DB. Default Hide value is false
     */
    public DAO_Khoa(boolean Hide) {
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM KHOA WHERE Hide = " + Hide;
            ResultSet rst = stm.executeQuery(sqlSelect);
            if (rst == null) {
                stm.close();
                list = null;
                return;
            }
            while (rst.next()) {
                Khoa next = new Khoa(rst.getString(1), rst.getNString(2), rst.getString(3), rst.getString(4), rst.getDate(5));
                list.add(next);
            }
            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param
     *
     * get Name List of current Khoa
     */
    public List getNameKhoaList() {
        List<String> names = null;
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM KHOA WHERE Hide = false";
            ResultSet rst = stm.executeQuery(sqlSelect);
            if (rst == null) {
                stm.close();
                return null;
            }
            while (rst.next()) {
                names.add(rst.getNString(2));
            }
            stm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return names;
    }

    public Khoa getSingleKhoaFromName(String name) {
        Khoa kh;
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM KHOA WHERE TenKhoa LIKE '%" + name + "%'";
            ResultSet rst = stm.executeQuery(sqlSelect);
            if (!rst.first()) {
                stm.close();
                return null;
            }
            kh = new Khoa(rst.getString(1), rst.getNString(2), rst.getString(3), rst.getString(4), rst.getDate(5));
            return kh;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Khoa getSingleKhoaFromID(String ID) {
        Khoa kh;
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM KHOA WHERE MaKhoa LIKE '" + ID + "'";
            ResultSet rst = stm.executeQuery(sqlSelect);
            if (!rst.first()) {
                stm.close();
                return null;
            }
            kh = new Khoa(rst.getString(1), rst.getNString(2), rst.getString(3), rst.getString(4), rst.getDate(5));
            stm.close();
            return kh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean existKhoa(String ID) {
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM KHOA WHERE MaKhoa LIKE '" + ID + "'";
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

    /**
     * @author: MinhNT
     *
     * @param newData new Khoa to update into database
     * @return true if update successful. false if can't update DB with newData
     */
    public boolean updateKhoa(Khoa newData) {
        if (newData == null) {
            return false;
        }
        //if there's no Khoa's ID in DB, insert this as new data
        if (!existKhoa(newData.getId())) {
            if (insertKhoa(newData)) {
                return true;
            } else {
                return false;
            }
        }
        try {
            java.sql.Date sqlDate = new java.sql.Date(newData.getDate().getTime());
            PreparedStatement stmt = con.prepareStatement("UPDATE KHOA "
                    + "Set TenKhoa = ?, SDT = ?, Email = ?, NgayThanhLap = ?, Hide = false "
                    + "WHERE MaKhoa = ?");

            stmt.setNString(1, newData.getName());
            stmt.setString(2, newData.getPhone());
            stmt.setString(3, newData.getEmail());
            stmt.setDate(4, sqlDate);
            stmt.setString(5, newData.getId());

            if (stmt.executeUpdate() != 0) {
                stmt.close();
                return true;
            } else {
                stmt.close();
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private boolean insertKhoa(Khoa newData) {
        try {
            java.sql.Date sqlDate = new java.sql.Date(newData.getDate().getTime());
            PreparedStatement stmt = con.prepareStatement("INSERT INTO KHOA VALUES (?,?,?,?,?,false)");

            stmt.setString(1, newData.getId());
            stmt.setNString(1, newData.getName());
            stmt.setString(3, newData.getPhone());
            stmt.setString(4, newData.getEmail());
            stmt.setDate(5, sqlDate);

            if (stmt.executeUpdate() == 0) {
                stmt.close();
                return false;
            } else {
                stmt.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteKhoa(String ID) {
        try {
            PreparedStatement stmt = con.prepareStatement("DELETE FROM KHOA WHERE MaKhoa LIKE '" + ID + "'");
            if (stmt.executeUpdate() == 0) {
                stmt.close();
                return false;
            } else {
                stmt.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getSQLState());
            return false;
        }
    }
}
