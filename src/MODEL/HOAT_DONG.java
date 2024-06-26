/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import DAO.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
    //TaiChinh info
    BigDecimal UEF;
    BigDecimal TaiTro;
    String Khac;

    public BigDecimal getUEF() {
        return UEF;
    }

    public void setUEF(BigDecimal UEF) {
        this.UEF = UEF;
    }

    public BigDecimal getTaiTro() {
        return TaiTro;
    }

    public void setTaiTro(BigDecimal TaiTro) {
        this.TaiTro = TaiTro;
    }

    public String getKhac() {
        return Khac;
    }

    public void setKhac(String Khac) {
        this.Khac = Khac;
    }

    
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

    public boolean exist(){
        DAO_HoatDong dAO_HoatDong = new DAO_HoatDong();
        return dAO_HoatDong.exist(this.getMaHD());
    }
    
    /**
     *MAKE SURE THAT ALL THE LIST AND THEIR ELEMENTS HAVE THEIR MAHD SET. ALSO MAKE SURE THIS OBJECT HAVE TAICHINH INFO
     * 
     * @param svList
     * @param gvList
     * @param dtList
     * @param ttList
     */
    public void saveHDtoDB(ListSinhVien svList, ListGiangVien gvList, ListDoiTac dtList, ListTaiTro ttList){
        DAO_HoatDong    dAO_HoatDong    = new DAO_HoatDong();
        DAO_SinhVien    dAO_SinhVien    = new DAO_SinhVien();
        DAO_GiangVien   dAO_GiangVien   = new DAO_GiangVien();
        DAO_DoiTac      dAO_DoiTac      = new DAO_DoiTac();
        DAO_TaiTro      dAO_TaiTro      = new DAO_TaiTro();
        
        dAO_HoatDong.updateBasicHoatDong(this);
        dAO_SinhVien.updateListHD_SinhVien(svList);
        dAO_GiangVien.updateListHD_GiangVien(gvList);
        dAO_DoiTac.updateListHD_DoiTac(dtList);
        dAO_TaiTro.updateListHD_TaiTro(ttList);
        dAO_HoatDong.updateTaiChinh(this);
    }
}
