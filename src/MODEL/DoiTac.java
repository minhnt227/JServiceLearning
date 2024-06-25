package MODEL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class DoiTac extends HOAT_DONG{
    private int dtID = 0;
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
        setName(name);
        setNameHost(nameHost);
        setPhone(phone);
        setEmail(email);
    }
    
    public DoiTac(String name, String nameHost, String phone, String email, String noiDung){
        setName(name);
        setNameHost(nameHost);
        setPhone(phone);
        setEmail(email);
        setNoiDung(noiDung);
    }

    public Object[] getRowData(){
        return new Object[]{getName(), getNameHost(), getPhone(), getEmail()};
    }

    
}

