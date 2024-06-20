/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.HOAT_DONG;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author bom19
 */
public class DAO_HoatDong extends DBConnector {

    public ArrayList GetHoatDong(int number, String ten, String loai, String ngayBD, String ngayKT, boolean Hide) {
        ArrayList<HOAT_DONG> HDLíst = new ArrayList<>();
        String sql = "SELECT * FROM HOATDONG WHERE Hide = '" + Hide + "'";
        try {
            Statement stm = con.createStatement();
            ResultSet result = stm.executeQuery(sql);
            while (result.next()) {
                HOAT_DONG hd = new HOAT_DONG(result.getInt(0), result.getNString(1), result.getNString(2), result.getDate(3), result.getDate(4), result.getBoolean(5), result.getDate(6));
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
                if(!ngayKT.isBlank()){
                    if (hd.getNgayKT().after(new SimpleDateFormat("dd/MM/yyyy").parse(ngayKT)))
                        continue;
                }
                HDLíst.add(hd);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return HDLíst;
    }
}
