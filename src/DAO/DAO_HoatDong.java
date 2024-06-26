/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.HOAT_DONG;
import java.util.logging.*;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author bom19
 */
public class DAO_HoatDong extends DBConnector {

    public ArrayList GetListHoatDong(int number, String ten, String loai, String ngayBD, String ngayKT, boolean Hide) throws SQLException {
        ArrayList<HOAT_DONG> HDList = new ArrayList<>();
        String sql;
        if (number <= 0) {
            sql = "SELECT * FROM HOAT_DONG WHERE Hide = '" + Hide + "'";
        } else {
            sql = "SELECT TOP " + number + " * FROM HOAT_DONG WHERE Hide = '" + Hide + "'";
        }
        try {
            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery(sql);
            while (result.next()) {
                //System.out.println(result.getInt(1));
                HOAT_DONG hd = new HOAT_DONG(result.getInt(1), result.getNString(2), result.getNString(3), result.getDate(4), result.getDate(5), result.getBoolean(6), result.getDate(7));
                if (!ten.isBlank()) {
                    if (!hd.getTenHD().contains(ten)) {
                        continue;
                    }
                }
                if (!loai.isBlank()) {
                    if (!hd.getLoai().contains(loai)) {
                        continue;
                    }
                }
                //ngayBD < hd.ngayBD && hd.ngayKT > ngayKT : continue(filtered out)
                if (!ngayBD.isBlank()) {
                    if (!hd.getNgayBD().after(new SimpleDateFormat("dd/MM/yyyy").parse(ngayBD))) {
                        continue;
                    }

                }
                if (!ngayKT.isBlank()) {
                    if (hd.getNgayKT().after(new SimpleDateFormat("dd/MM/yyyy").parse(ngayKT))) {
                        continue;
                    }
                }
                HDList.add(hd);
            }
            stm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        con.close();
        return HDList;
    }

    public static boolean exist(int id) {
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM HOAT_DONG WHERE MaHD = " + id + " AND Hide = 'false'";
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

    public boolean existTaiChinh(int id) {
        if (!exist(id)) {
            return false;
        }
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM TAI_CHINH WHERE MaHD = " + id;
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
    
    private boolean insertTaiChinh(HOAT_DONG newData) throws SQLException {
        try {
            Prepstm = con.prepareStatement("INSERT INTO TAI_CHINH VALUES (?,?,?,?,'false')");

            Prepstm.setInt(1, newData.getMaHD());
            Prepstm.setBigDecimal(2, newData.getUEF());
            Prepstm.setBigDecimal(3, newData.getTaiTro());
            Prepstm.setNString(4, newData.getKhac());
            Prepstm.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            
            return super.updateDB();
        } catch (SQLException e) {
            e.printStackTrace();
            Prepstm.close();
            return false;
        }
    }
    
    public boolean updateTaiChinh(HOAT_DONG hd) {
        if (hd == null) {
            return false;
        }
        if (!existTaiChinh(hd.getMaHD())) {
            try {
                return insertTaiChinh(hd);
            } catch (SQLException ex) {
                Logger.getLogger(DAO_HoatDong.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Prepstm = con.prepareStatement("UPDATE TAI_CHINH "
                    + "SET UEF = ?, TaiTro = ?, Khac = ?, Hide = 'false' , CreatedDate = ?"
                    + "WHERE MaHD = ?");

            Prepstm.setBigDecimal(1, hd.getUEF());
            Prepstm.setBigDecimal(2, hd.getTaiTro());
            Prepstm.setNString(3, hd.getKhac());
            Prepstm.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            Prepstm.setInt(5, hd.getMaHD());

            return super.updateDB();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getSQLState());
            return false;
        }
    }
    
    /**
     *
     * @param ID
     * @return a model HOAT_DONG with it's TaiChinh info
     */
    public HOAT_DONG getTaiChinhByHDID(int ID) {
        HOAT_DONG hd = null;
        if (!existTaiChinh(ID)) {
            return hd;
        }
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM TAI_CHINH WHERE MaHD = '" + ID + "' AND Hide = 'false'";
            ResultSet rst = stm.executeQuery(sqlSelect);
            if (!rst.first()) {
                stm.close();
                return null;
            }
            hd = new HOAT_DONG();
            hd.setMaHD(ID);
            hd.setUEF(rst.getBigDecimal(3)); hd.setTaiTro(rst.getBigDecimal(4)); hd.setKhac(rst.getNString(5));
            stm.close();
            return hd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hd;
    }

    private boolean insertBasicHoatDong(HOAT_DONG newData) {
        try {

            PreparedStatement stmt = con.prepareStatement("INSERT INTO HOAT_DONG VALUES (?,?,?,?,'false',?)");

            stmt.setNString(1, newData.getTenHD());
            stmt.setNString(2, newData.getLoai());
            stmt.setTimestamp(3, new Timestamp(newData.getNgayBD().getTime()));
            stmt.setTimestamp(4, new Timestamp(newData.getNgayKT().getTime()));
            stmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

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
    
    public boolean updateBasicHoatDong(HOAT_DONG newData){
        if (newData == null) {
            return false;
        }
        if(!exist(newData.getMaHD())){
            return insertBasicHoatDong(newData);
        }
        try {

            Prepstm = con.prepareStatement("UPDATE HOAT_DONG "
                    + "SET TenHoatDong = ?, Loai = ?, NgayBatDau = ?, NgayKetThuc = ?, Hide = 'false' , CreatedDate = ? "
                    + " WHERE MaHD = ?");

            Prepstm.setNString(1, newData.getTenHD());
            Prepstm.setNString(2, newData.getLoai());
            Prepstm.setTimestamp(3, new Timestamp(newData.getNgayBD().getTime()));
            Prepstm.setTimestamp(4, new Timestamp(newData.getNgayKT().getTime()));
            Prepstm.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            Prepstm.setInt(5, newData.getMaHD());

            return super.updateDB();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getSQLState());
            return false;
        }
                
    }
    
    public HOAT_DONG getBasicHoatDong(int ID) {
        HOAT_DONG hd = null;
        if (!exist(ID)) {
            return hd;
        }
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM HOAT_DONG WHERE MaHD = '" + ID + "' AND Hide = 'false'";
            ResultSet rst = stm.executeQuery(sqlSelect);
            if (!rst.first()) {
                stm.close();
                return null;
            }
            hd = new HOAT_DONG(ID, rst.getNString(2), rst.getNString(3), rst.getDate(4), rst.getDate(5), false, rst.getDate(6));
            stm.close();
            return hd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hd;
    }
    
    public boolean deleteBasicHoatDong(int ID) {
        try {
            Prepstm = con.prepareStatement("UPDATE HOAT_DONG SET Hide = 'true' WHERE MaHD = ?");
            Prepstm.setInt(1, ID);
            
            return super.updateDB();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getSQLState());
            return false;
        }
    }

}
