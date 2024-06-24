
package MODEL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class GiangVien extends HOAT_DONG {
    private  String id;
    private String firtName;
    private String lastName;
    private String nameKhoa;
    private String idKhoa;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNameKhoa() {
        return nameKhoa;
    }

    public void setNameKhoa(String nameKhoa) {
        this.nameKhoa = nameKhoa;
    }

    public String getIdKhoa() {
        return idKhoa;
    }

    public void setIdKhoa(String idKhoa) {
        this.idKhoa = idKhoa;
    }

    public void setIdKhoa(ArrayList<Khoa> list) {
        Iterator<Khoa> it = list.iterator();
        while(it.hasNext()){
            Khoa temp = it.next();
            if(temp.getName().contains(getNameKhoa())){
                setId(temp.getId());
                return;
            }
        }
    }

    public GiangVien(){}

    public GiangVien(String id, String firstName, String lastName, String nameKhoa, String TenHD) {
        super.setTenHD(TenHD);
        setId(id);
        setFirtName(firtName);
        setLastName(lastName);
        setNameKhoa(nameKhoa);
    }

    public GiangVien(String id, String firstName, String lastName, String nameKhoa) {
        setId(id);
        setFirtName(firtName);
        setLastName(lastName);
        setNameKhoa(nameKhoa);
    }

       
}

