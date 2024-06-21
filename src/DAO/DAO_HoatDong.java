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
        ArrayList<HOAT_DONG> HDList = new ArrayList<>();
        String sql;
        if(number <=0)
            sql = "SELECT * FROM HOAT_DONG WHERE Hide = '" + Hide + "'";
        else
            sql = "SELECT TOP " + number + " * FROM HOAT_DONG WHERE Hide = '" + Hide + "'";
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
                if(!ngayKT.isBlank()){
                    if (hd.getNgayKT().after(new SimpleDateFormat("dd/MM/yyyy").parse(ngayKT)))
                        continue;
                }
                HDList.add(hd);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return HDList;
    }
}
