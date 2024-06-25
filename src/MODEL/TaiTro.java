package MODEL;

import DAO.DAO_TaiTro;
import java.lang.*;

public class TaiTro extends HOAT_DONG{

    private int id;
    private String name;
    private String nameHost;
    private String phone;
    private String email;
    private String noiDung;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameHost() {
        return nameHost;
    }

    public void setNameHost(String nameHost) {
        this.nameHost = nameHost;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public TaiTro(){}

    public TaiTro(String name, String nameHost, String phone, String email){
        setId(id);
        setName(name);
        setNameHost(nameHost);
        setPhone(phone);
        setEmail(email);
    }
    
    public TaiTro(String name, String nameHost, String phone, String email, String noiDung){
        setId(id);
        setName(name);
        setNameHost(nameHost);
        setPhone(phone);
        setEmail(email);
        setNoiDung(noiDung);
    }

    public TaiTro(int id, String name, String nameHost, String phone, String email) {
        this.id = id;
        this.name = name;
        this.nameHost = nameHost;
        this.phone = phone;
        this.email = email;
    }

    public boolean insertKhoa(){
        DAO_TaiTro dAO_TaiTro = new DAO_TaiTro();
        return dAO_TaiTro.updateDT(this);
    }

    public TaiTro getSingleByName() {
        DAO_TaiTro dAO_TaiTro = new DAO_TaiTro();
        return dAO_TaiTro.getSingleByName(this.getName());
    }


    public boolean delete(){
        DAO_TaiTro dAO_TaiTro = new DAO_TaiTro();
        return dAO_TaiTro.deleteDoiTac(this.getName());
    }

    public boolean existKhoa(){
        DAO_TaiTro dAO_TaiTro = new DAO_TaiTro();
        return dAO_TaiTro.existTT(this.getName());
    }
}

