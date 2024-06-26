
package MODEL;

import DAO.DAO_GiangVien;
import java.util.ArrayList;
import java.util.Iterator;

public class GiangVien extends HOAT_DONG {
    private  String id;
    private String firtName;
    private String lastName;
    private String nameKhoa;
    private String idKhoa;
    private String vaiTro;

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
    
    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
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

    public GiangVien(String id, String fName, String lastName, String nameKhoa, String TenHD) {
        super.setTenHD(TenHD);
        setId(id);
        setFirtName(fName);
        setLastName(lastName);
        setNameKhoa(nameKhoa);
    }
    
    public GiangVien(String id, String fName, String lastName, String nameKhoa, String TenHD, String vaiTro) {
        super.setTenHD(TenHD);
        setId(id);
        setFirtName(fName);
        setLastName(lastName);
        setNameKhoa(nameKhoa);
        setVaiTro(vaiTro);
    }

    public GiangVien(String id, String fName, String lastName, String nameKhoa) {
        setId(id);
        setFirtName(fName);
        setLastName(lastName);
        setNameKhoa(nameKhoa);
    }

    public boolean insertGV(){
        DAO_GiangVien dAO_GiangVien = new DAO_GiangVien();
        return dAO_GiangVien.updateGV(this);
    }

    public GiangVien getSingleByName() {
        DAO_GiangVien dAO_GiangVien = new DAO_GiangVien();
        return dAO_GiangVien.getSingleByName(this.getFirtName());
    }

    public GiangVien getSingleByID() {
        DAO_GiangVien dAO_GiangVien = new DAO_GiangVien();
        return dAO_GiangVien.getSingleByID(this.getId());
    }

    public boolean deleteSinhVien(){
        DAO_GiangVien dAO_GiangVien = new DAO_GiangVien();
        return dAO_GiangVien.deleteGiangVien(this.getId());
    }

    public boolean existGV(){
        DAO_GiangVien dAO_GiangVien = new DAO_GiangVien();
        return dAO_GiangVien.existGV(this.getId());
    }
}


