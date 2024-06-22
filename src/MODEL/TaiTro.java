  import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class TaiTro{

    private static int id = 0;
    private static String name;
    private static String nameHost;
    private static String phone;
    private static String email;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        TaiTro.id = ++id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        TaiTro.name = name;
    }

    public static String getNameHost() {
        return nameHost;
    }

    public static void setNameHost(String nameHost) {
        TaiTro.nameHost = nameHost;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        TaiTro.phone = phone;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        TaiTro.email = email;
    }

    

    public TaiTro(String name, String nameHost, String phone, String email){
        setId(id++);
        setName(name);
        setNameHost(nameHost);
        setPhone(phone);
        setEmail(email);
    }

    public static Boolean isNumber(){
        if (getPhone().length()>=10 && getPhone().length() <=12 ){
            for (int i = 0; i <= getPhone().length(); i++){
                if (!Character.isDigit(getPhone().charAt(i))){
                    return false;
                }
            }
            return true;
        } 
        return false;
    }

    public static TaiTro find(ArrayList<TaiTro> list, int id){
        Iterator<TaiTro> it = list.iterator();
        while(it.hasNext()){
            TaiTro temp = it.next();
            if(temp.getId() == id )
                return temp;
        }
        return null;
    }

    public static void importFile(BufferedReader file, ArrayList<TaiTro> list) throws IOException{
        String line;
        while ((line = file.readLine()) != null) {
            String[] value = line.split("\t");
            list.add(new TaiTro(value[0], value[1], value[2], value[3]));
        }
    }

    public static void  exportFile(PrintWriter file, ArrayList<TaiTro> list){
        for (TaiTro taiTro : list) {
            file.write(taiTro.getName() + "\t" + taiTro.getNameHost() + "\t" + taiTro.getPhone() + "\t" + taiTro.getEmail() + "\t" + taiTro.getId());
        }
    }
    
    public static void addList(ArrayList<TaiTro> list, TaiTro taiTro){
        if (!taiTro.getName().isEmpty() && !taiTro.getNameHost().isEmpty() && !taiTro.getEmail().isEmpty()){
            if (isNumber()){
                list.add(taiTro);
            }else JOptionPane.showMessageDialog(null,"Check Phone Number", "Try again",JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(null,"Information is not valid\nPlease enter all fields", "Try again",JOptionPane.ERROR_MESSAGE);
    }

    

}
