import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class Khoa {
    private static  String id;
    private static String name;
    private static String phone;
    private static String email;
    private static Date date;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        KHOA.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        KHOA.name = name;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        KHOA.phone = phone;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        KHOA.email = email;
    }

    public static Date getDate() {
        return date;
    }

    public static void setDate(Date date) {
        KHOA.date = date;
    }

    

    public KHOA(){
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

    public static Khoa find(ArrayList<Khoa> list, String id){
        Iterator<Khoa> it = list.iterator();
        while(it.hasNext()){
            Khoa temp = it.next();
            if(temp.getId().contains(id))
                return temp;
        }
        return null;
    }

    public static String findName(ArrayList<Khoa> list, String name){
        Iterator<Khoa> it = list.iterator();
        while(it.hasNext()){
            Khoa temp = it.next();
            if(temp.getName().contains(name))
                return temp.getId();
        }
        return null;
    }

    public static void importFile(BufferedReader file, ArrayList<Khoa> list) throws IOException, ParseException{
        String line;
        while ((line = file.readLine()) != null) {
            String[] value = line.split("\t");
            list.add(new KHOA(value[0], value[1], value[2], value[3], new SimpleDateFormat("dd/MM/yyyy").parse(value[4])));
        }
    }

    public static void  exportFile(PrintWriter file, ArrayList<Khoa> list){
        for (Khoa khoa : list) {
            file.write(khoa.getId() + "\t" + khoa.getName() + "\t" + khoa.getPhone() + "\t" + khoa.getEmail() + "\t" + khoa.getDate());
        }
    }
    
    public static void addList(ArrayList<Khoa> list, KHOA khoa){
        if (!khoa.getName().isEmpty() && !khoa.getId().isEmpty() && !khoa.getEmail().isEmpty()){
            if (Check.isPhoneNumber(getPhone())){
                list.add(khoa);
            }else JOptionPane.showMessageDialog(null,"Check Phone Number", "Try again",JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(null,"Information is not valid\nPlease enter all fields", "Try again",JOptionPane.ERROR_MESSAGE);
    }

}
 
