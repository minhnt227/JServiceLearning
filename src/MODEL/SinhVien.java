package MODEL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class SinhVien extends HOAT_DONG{
    

    private String id;
    private String name;
    private String nameKhoa;
    private String idKhoa;
    private String vaiTro;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getNameKhoa() {
        return nameKhoa;
    }

    public void setNameKhoa(String nameKhoa) {
        nameKhoa = nameKhoa;
    }

    public String getIdKhoa() {
        return idKhoa;
    }

    public void setIdKhoa(String id) {
        idKhoa = id;
        
    }
    
    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String setIdKhoa(ArrayList<Khoa> list) {
        Iterator<Khoa> it = list.iterator();
        while(it.hasNext()){
            Khoa temp = it.next();
            if(temp.getName().contains(getNameKhoa())){
                // setId(temp.getId());
                return temp.getId();
            }
        }
        return null;
    }

    public SinhVien(){}
    
    public SinhVien(String id, String name, String nameKhoa, String TenHD) {
        super.setTenHD(TenHD);
        setId(id);
        setName(name);
        setNameKhoa(nameKhoa);
    }
    
    public SinhVien(String id, String name, String nameKhoa, String TenHD, String vaiTro) {
        super.setTenHD(TenHD);
        setId(id);
        setName(name);
        setNameKhoa(nameKhoa);
        setVaiTro(vaiTro);
    }

    public SinhVien(String id, String name, String nameKhoa) {
        setId(id);
        setName(name);
        setNameKhoa(nameKhoa);
    }

    public SinhVien(SinhVien sv){
        setId(sv.id);
        setName(sv.name);
        setNameKhoa(sv.nameKhoa);
    }

    void add(Object valueAt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}


