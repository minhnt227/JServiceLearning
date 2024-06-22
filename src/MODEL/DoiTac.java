import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class DoiTac {
    private String name;
    private String nameHost;
    private String phone;
    private String email;

    
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

    public DoiTac(){}


    public DoiTac(String name, String nameHost, String phone, String email){
        setName(name);
        setNameHost(nameHost);
        setPhone(phone);
        setEmail(email);
    }

    public Object[] getRowData(){
        return new Object[]{getName(), getNameHost(), getPhone(), getEmail()};
    }

    
}

class ListDoiTac extends DoiTac{
    ArrayList<DoiTac> list;

    public ListDoiTac(){
        list = new ArrayList<>();
    }

    public DoiTac find(String name){
        Iterator<DoiTac> it = list.iterator();
        while(it.hasNext()){
            DoiTac temp = it.next();
            if(temp.getName().contains(name))
                return temp;
        }
        return null;
    }

    public int soLuong(){
        return list.size();
    }

    public void addList(DoiTac doiTac){
        if (!doiTac.getName().isEmpty() && !doiTac.getNameHost().isEmpty() && !doiTac.getEmail().isEmpty()){
            if (Check.isPhoneNumber(getPhone())){
                if (Check.isValidEmail(getEmail())) list.add(doiTac);
                else JOptionPane.showMessageDialog(null,"Check Email Number", "Try again",JOptionPane.ERROR_MESSAGE);
            }else JOptionPane.showMessageDialog(null,"Check Phone Number", "Try again",JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(null,"Information is not valid\nPlease enter all fields", "Try again",JOptionPane.ERROR_MESSAGE);
    }

    public void importFile(BufferedReader file) throws IOException{
        String line;
        while ((line = file.readLine()) != null) {
            String[] value = line.split("\t");
            list.add(new DoiTac(value[0], value[1], value[2], value[3]));
        }
    }

    public void  exportFile(PrintWriter file){
        for (DoiTac doiTac : list) {
            file.write(doiTac.getName() + "\t" + doiTac.getNameHost() + "\t" + doiTac.getPhone() + "\t" + doiTac.getEmail());
        }
    }


}
