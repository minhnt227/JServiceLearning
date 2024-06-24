package MODEL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Khoa{
    private  String id;
    private  String name;
    private  String phone;
    private  String email;
    private  Date date;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    

    public Khoa(){
        setId(null);
        setName(null);
        setPhone(null);
        setEmail(null);
        setDate(null);
    }
    
    

    public Khoa(String id, String name, String phone, String email, Date date){
        setId(id);
        setName(name);
        setPhone(phone);
        setEmail(email);
        setDate(date);
    }

    public Object[] getRowData(){
        return new Object[]{getId(), getName(), getPhone(), getEmail(), getDate()};
    }

}
 
