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
    
    public SinhVien(int MaHD, String TenHD, String Loai, Date NgayBD, Date NgayKT, Boolean Hide, Date CreatedDate, String id, String name, String nameKhoa) {
        super(MaHD, TenHD, Loai, NgayBD, NgayKT, Hide, CreatedDate);
        setId(id);
        setName(name);
        setNameKhoa(nameKhoa);
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

}
