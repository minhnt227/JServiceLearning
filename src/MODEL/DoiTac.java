import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class DoiTac {
    private static String name;
    private static String nameHost;
    private static String phone;
    private static String email;

    
    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        DoiTac.name = name;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        DoiTac.phone = phone;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        DoiTac.email = email;
    }

    public static String getNameHost() {
        return nameHost;
    }

    public static void setNameHost(String nameHost) {
        DoiTac.nameHost = nameHost;
    }


    public DoiTac(String name, String nameHost, String phone, String email){
        setName(name);
        setNameHost(nameHost);
        setPhone(phone);
        setEmail(email);
    }

    public static DoiTac find(ArrayList<DoiTac> list, String name){
        Iterator<DoiTac> it = list.iterator();
        while(it.hasNext()){
            DoiTac temp = it.next();
            if(temp.getName().contains(name))
                return temp;
        }
        return null;
    }

    public static void importFile(BufferedReader file, ArrayList<DoiTac> list) throws IOException{
        String line;
        while ((line = file.readLine()) != null) {
            String[] value = line.split("\t");
            list.add(new DoiTac(value[0], value[1], value[2], value[3]));
        }
    }

    public static void  exportFile(PrintWriter file, ArrayList<DoiTac> list){
        for (DoiTac doiTac : list) {
            file.write(doiTac.getName() + "\t" + doiTac.getNameHost() + "\t" + doiTac.getPhone() + "\t" + doiTac.getEmail());
        }
    }
    
    public static void addList(ArrayList<DoiTac> list, DoiTac doiTac){
        if (!doiTac.getName().isEmpty() && !doiTac.getNameHost().isEmpty() && !doiTac.getEmail().isEmpty()){
            if (Check.isPhoneNumber(getPhone())){
                list.add(doiTac);
            }else JOptionPane.showMessageDialog(null,"Check Phone Number", "Try again",JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(null,"Information is not valid\nPlease enter all fields", "Try again",JOptionPane.ERROR_MESSAGE);
    }

    
}


