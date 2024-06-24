/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Kisa
 */
public class ListKhoa  extends Khoa{
    public static ArrayList<Khoa> list;
    public ListKhoa(){
        list = new ArrayList<>();
    }

    public void addList(Khoa khoa){
        if (!khoa.getName().isEmpty() && !khoa.getId().isEmpty() && !khoa.getEmail().isEmpty()){
            if (Check.isPhoneNumber(getPhone())){
                if(Check.isValidEmail(getEmail())) list.add(khoa);
                else JOptionPane.showMessageDialog(null,"Check Email Number", "Try again",JOptionPane.ERROR_MESSAGE);
            }else JOptionPane.showMessageDialog(null,"Check Phone Number", "Try again",JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(null,"Information is not valid\nPlease enter all fields", "Try again",JOptionPane.ERROR_MESSAGE);
    }

    public String findName(ArrayList<Khoa> list, String name){
        Iterator<Khoa> it = list.iterator();
        while(it.hasNext()){
            Khoa temp = it.next();
            if(temp.getName().contains(name))
                return temp.getId();
        }
        return null;
    }

    public Khoa find( String id){
        Iterator<Khoa> it = list.iterator();
        while(it.hasNext()){
            Khoa temp = it.next();
            if(temp.getId().contains(id))
                return temp;
        }
        return null;
    }

    public void importFile(BufferedReader file) throws IOException, ParseException{
        String line;
        while ((line = file.readLine()) != null) {
            String[] value = line.split("\t");
            list.add(new Khoa(value[0], value[1], value[2], value[3], new SimpleDateFormat("dd/MM/yyyy").parse(value[4])));
        }
    }

    public void  exportFile(PrintWriter file){
        for (Khoa khoa : list) {
            file.write(khoa.getId() + "\t" + khoa.getName() + "\t" + khoa.getPhone() + "\t" + khoa.getEmail() + "\t" + khoa.getDate());
        }
    }

    public ArrayList outList(){
        return list;
    }
    
}