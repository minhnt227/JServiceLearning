  import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class TaiTro{

    private int id = 0;
    private String name;
    private String nameHost;
    private String phone;
    private String email;

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

    public TaiTro(){}

    public TaiTro(String name, String nameHost, String phone, String email){
        setId(id);
        setName(name);
        setNameHost(nameHost);
        setPhone(phone);
        setEmail(email);
    }

}

class ListTaiTro extends TaiTro{

    ArrayList<TaiTro> list;

    public ListTaiTro(){
        super();
        list = new ArrayList<>();
    }

    public TaiTro find(String name){
        Iterator<TaiTro> it = list.iterator();
        while(it.hasNext()){
            TaiTro temp = it.next();
            if(temp.getName().contains(name))
                return temp;
        }
        return null;
    }

    public void importFile(BufferedReader file) throws IOException{
        String line;
        while ((line = file.readLine()) != null) {
            String[] value = line.split("\t");
            list.add(new TaiTro(value[0], value[1], value[2], value[3]));
        }
    }

    public void  exportFile(PrintWriter file){
        for (TaiTro taiTro : list) {
            file.write(taiTro.getName() + "\t" + taiTro.getNameHost() + "\t" + taiTro.getPhone() + "\t" + taiTro.getEmail());
        }
    }
    
    public void addList(TaiTro taiTro){
        if (!taiTro.getName().isEmpty() && !taiTro.getNameHost().isEmpty() && !taiTro.getEmail().isEmpty()){
            if (Check.isPhoneNumber(getPhone())){
                list.add(taiTro);
            }else JOptionPane.showMessageDialog(null,"Check Phone Number", "Try again",JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(null,"Information is not valid\nPlease enter all fields", "Try again",JOptionPane.ERROR_MESSAGE);
    }

    public ArrayList outList(){
        return list;
    }

}
 
