package MODEL;

import DAO.DAO_DoiTac;
import java.lang.*;

public class DoiTac extends HOAT_DONG{
    private int dtID ;
    private String name;
    private String nameHost;
    private String phone;
    private String email;
    private String noiDung;

    
    public int getDtID() {
        return dtID;
    }

    public void setDtID(int dtID) {
        this.dtID = dtID;
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

    public DoiTac(){}


    public DoiTac(String name, String nameHost, String phone, String email){
        setDtID(-1);
        setName(name);
        setNameHost(nameHost);
        setPhone(phone);
        setEmail(email);
    }

    public DoiTac(int dtID, String name, String nameHost, String phone, String email) {
        this.dtID = dtID;
        this.name = name;
        this.nameHost = nameHost;
        this.phone = phone;
        this.email = email;
    }
    
    public DoiTac(int dtID, String name, String nameHost, String phone, String email, String noiDung){
        setDtID(dtID);
        setName(name);
        setNameHost(nameHost);
        setPhone(phone);
        setEmail(email);
        setNoiDung(noiDung);
    }
    
    public DoiTac(String name, String nameHost, String phone, String email, String noiDung){
        setName(name);
        setNameHost(nameHost);
        setPhone(phone);
        setEmail(email);
        setNoiDung(noiDung);
    }

    public Object[] getRowData(){
        return new Object[]{getName(), getNameHost(), getEmail(), getPhone()};
    }

    public boolean insertDoiTac(){
        DAO_DoiTac dAO_DoiTac = new DAO_DoiTac();
        return dAO_DoiTac.updateDT(this);
    }

    public DoiTac getSingleByName() {
        DAO_DoiTac dAO_DoiTac = new DAO_DoiTac();
        return dAO_DoiTac.getSingleByName(this.getName());
    }


    public boolean deleteDT(){
        DAO_DoiTac dAO_DoiTac = new DAO_DoiTac();
        return dAO_DoiTac.deleteDoiTac(this.getName());
    }

    public boolean existDT(){
        DAO_DoiTac dAO_DoiTac = new DAO_DoiTac();
        return dAO_DoiTac.existDT(this.getName());
    }
    
}

