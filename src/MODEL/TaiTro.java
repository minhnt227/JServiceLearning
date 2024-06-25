package MODEL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class TaiTro extends HOAT_DONG{

    private int id = 0;
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

}

