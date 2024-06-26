/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;

/**
 *
 * @author bom19
 */
public class HOAT_DONG {
    int MaHD;          //auto increment
    String TenHD;
    String Loai;
    Date NgayBD;
    Date NgayKT;
    Boolean Hide;
    Date CreatedDate;
    public Object[] colHeader;

    public HOAT_DONG(int MaHD, String TenHD, String Loai, Date NgayBD, Date NgayKT, Boolean Hide, Date CreatedDate) {
        this.MaHD = MaHD;
        this.TenHD = TenHD;
        this.Loai = Loai;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.Hide = Hide;
        this.CreatedDate = CreatedDate;
    }

    public HOAT_DONG() {
    }

    public int getMaHD() {
        return MaHD;
    }

    public String getTenHD() {
        return TenHD;
    }

    public String getLoai() {
        return Loai;
    }

    public Date getNgayBD() {
        return NgayBD;
    }
    public String getStringNgayBD() {
        return new SimpleDateFormat("dd/MM/yyyy").format(NgayBD);
    }

    public Date getNgayKT() {
        return NgayKT;
    }
    public String getStringNgayKT() {
        return new SimpleDateFormat("dd/MM/yyyy").format(NgayKT);
    }

    public Boolean getHide() {
        return Hide;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public void setTenHD(String TenHD) {
        this.TenHD = TenHD;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public void setNgayBD(Date NgayBD) {
        this.NgayBD = NgayBD;
    }

    public Object[] getColHeader() {
        return colHeader;
    }

    public void setNgayKT(Date NgayKT) {
        this.NgayKT = NgayKT;
    }

    public void setHide(Boolean Hide) {
        this.Hide = Hide;
    }

    public void setCreatedDate(Date CreatedDate) {
        this.CreatedDate = CreatedDate;
    }
    public static ArrayList<HOAT_DONG> filterHDsByName(ArrayList<HOAT_DONG> List, String name){
        Iterator<HOAT_DONG> it = List.iterator();
        ArrayList<HOAT_DONG> newList = new ArrayList<>();
        while(it.hasNext()){
            HOAT_DONG temp = it.next();
            if(temp.getTenHD().contains(name))
                newList.add(temp);
        }
        
        return newList;
    }
    
    public Object[] getRowData(){
        return new Object[]{getTenHD(),getLoai(),getStringNgayBD(),getStringNgayKT()} ;
    }
    
}
