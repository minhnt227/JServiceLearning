import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class KHOA {
    private static  String id;
    private static String name;
    private static String phone;
    private static String email;
    private static String date;

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

    public static String getDate() {
        return date;
    }

    public static void setDate(String date) {
        KHOA.date = date;
    }

    public KHOA(){
        setId(null);
        setName(null);
        setPhone(null);
        setEmail(null);
        setDate(null);
    }
    
    

    public KHOA(String id, String name, String phone, String email, String date){
        setId(id);
        setName(name);
        setPhone(phone);
        setEmail(email);
        setDate(date);
    }

    

    public static KHOA find(ArrayList<KHOA> list, String id){
        Iterator<KHOA> it = list.iterator();
        while(it.hasNext()){
            KHOA temp = it.next();
            if(temp.getId().contains(id))
                return temp;
        }
        return null;
    }

    public static String findName(ArrayList<KHOA> list, String name){
        Iterator<KHOA> it = list.iterator();
        while(it.hasNext()){
            KHOA temp = it.next();
            if(temp.getName().contains(name))
                return temp.getId();
        }
        return null;
    }

    public static void importFile(BufferedReader file, ArrayList<KHOA> list) throws IOException{
        String line;
        while ((line = file.readLine()) != null) {
            String[] value = line.split("\t");
            list.add(new KHOA(value[0], value[1], value[2], value[3], value[4]));
        }
    }

    public static void  exportFile(PrintWriter file, ArrayList<KHOA> list){
        for (KHOA khoa : list) {
            file.write(khoa.getId() + "\t" + khoa.getName() + "\t" + khoa.getPhone() + "\t" + khoa.getEmail() + "\t" + khoa.date);
        }
    }
    
    public static void addList(ArrayList<KHOA> list, KHOA khoa){
        if (!khoa.getName().isEmpty() && !khoa.getId().isEmpty() && !khoa.getEmail().isEmpty() && !khoa.getDate().isEmpty()){
            if (Check.isPhoneNumber(getPhone())){
                list.add(khoa);
            }else JOptionPane.showMessageDialog(null,"Check Phone Number", "Try again",JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(null,"Information is not valid\nPlease enter all fields", "Try again",JOptionPane.ERROR_MESSAGE);
    }

}
 
