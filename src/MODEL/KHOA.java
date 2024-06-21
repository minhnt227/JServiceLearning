import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class KHOA {
    private static  String maKhoa;
    private static String tenKhoa;
    private static String phoneNumber;
    private static String email;
    private static String ngay;

    public static String getMaKhoa() {
        return maKhoa;
    }

    public static void setMaKhoa(String maKhoa) {
        KHOA.maKhoa = maKhoa;
    }

    public static String getTenKhoa() {
        return tenKhoa;
    }

    public static void setTenKhoa(String tenKhoa) {
        KHOA.tenKhoa = tenKhoa;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static void setPhoneNumber(String phoneNumber) {
        KHOA.phoneNumber = phoneNumber;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        KHOA.email = email;
    }

    public static String getNgay() {
        return ngay;
    }

    public static void setNgay(String ngay) {
        KHOA.ngay = ngay;
    }

    
    

    public KHOA(String id, String name, String phone, String email, String ngay){
        setMaKhoa(id);
        setTenKhoa(name);
        setPhoneNumber(phone);
        setEmail(email);
        setNgay(ngay);
    }

    public static Boolean isNumber(){
        if (getPhoneNumber().length()>=10 && getPhoneNumber().length() <=12 ){
            for (int i = 0; i <= getPhoneNumber().length(); i++){
                if (!Character.isDigit(getPhoneNumber().charAt(i))){
                    return false;
                }
            }
            return true;
        } 
        return false;
    }

    public static KHOA find(ArrayList<KHOA> list, String id){
        Iterator<KHOA> it = list.iterator();
        while(it.hasNext()){
            KHOA temp = it.next();
            if(temp.getMaKhoa().contains(id))
                return temp;
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
            file.write(khoa.getMaKhoa() + "\t" + khoa.getTenKhoa() + "\t" + khoa.getPhoneNumber() + "\t" + khoa.getEmail() + "\t" + khoa.ngay);
        }
    }
    
    public static void addList(ArrayList<KHOA> list, KHOA khoa){
        if (!khoa.getTenKhoa().isEmpty() && !khoa.getMaKhoa().isEmpty() && !khoa.getEmail().isEmpty() && !khoa.getNgay().isEmpty()){
            if (isNumber()){
                list.add(khoa);
            }else JOptionPane.showMessageDialog(null,"Check Phone Number", "Try again",JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(null,"Information is not valid\nPlease enter all fields", "Try again",JOptionPane.ERROR_MESSAGE);
    }

}
