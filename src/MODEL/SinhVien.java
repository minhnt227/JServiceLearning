package MODEL;
import DAO.DAO_SinhVien;
import java.util.ArrayList;
import java.util.Iterator;

public class SinhVien extends HOAT_DONG{
    

    private String id;
    private String name;
    private String nameKhoa;
    private String idKhoa;
    private String vaiTro;

    public String getId() {
        return id;
    }

    public void setId(String iD) {
        id = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        name = Name;
    }

    public String getNameKhoa() {
        return nameKhoa;
    }

    public void setNameKhoa(String NameKhoa) {
        nameKhoa = NameKhoa;
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

    public SinhVien(String id, String name, String nameKhoa, String idKhoa, String vaiTro, int mahd) {
        this.id = id;
        this.name = name;
        this.nameKhoa = nameKhoa;
        this.idKhoa = idKhoa;
        this.vaiTro = vaiTro;
        this.MaHD = mahd;
    }

    public SinhVien(String id, String name, String nameKhoa, String idKhoa) {
        this.id = id;
        this.name = name;
        this.nameKhoa = nameKhoa;
        this.idKhoa = idKhoa;
    }
   
    
    
    

    public SinhVien(SinhVien sv){
        setId(sv.id);
        setName(sv.name);
        setNameKhoa(sv.nameKhoa);
    }

    void add(Object valueAt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean insertSV(){
        DAO_SinhVien dAO_SinhVien = new DAO_SinhVien();
        return dAO_SinhVien.updateSV(this);
    }

    public SinhVien getSingleByName() {
        DAO_SinhVien dAO_SinhVien = new DAO_SinhVien();
        return dAO_SinhVien.getSingleByName(this.getName());
    }

    public SinhVien getSingleByID() {
        DAO_SinhVien dAO_SinhVien = new DAO_SinhVien();
        return dAO_SinhVien.getSingleByID(this.getId());
    }

    public boolean deleteSinhVien(){
        DAO_SinhVien dAO_SinhVien = new DAO_SinhVien();
        return dAO_SinhVien.deleteSinhVien(this.getId());
    }

    public boolean existSV(){
        DAO_SinhVien dAO_SinhVien = new DAO_SinhVien();
        return dAO_SinhVien.existSV(this.getId());
    }

}


