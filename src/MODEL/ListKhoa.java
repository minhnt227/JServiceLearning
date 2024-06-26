 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import DAO.DAO_Khoa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kisa
 */
public class ListKhoa  extends Khoa{
    public static ArrayList<Khoa> list;
    public Object[] colHeader;
    public DefaultTableModel model;
    private ArrayList<Khoa> newlist;
    
    public ListKhoa(){
        DAO_Khoa dAO_Khoa = new DAO_Khoa(false);
        list = dAO_Khoa.list;
        model = new DefaultTableModel(colHeader,0);
    }
    
    public DefaultTableModel getTableModel(){
        Iterator<Khoa> it = list.iterator();
        while(it.hasNext()){
            Khoa temp = it.next();
            model.addRow(new Object[]{temp.getId(), temp.getName(), temp.getPhone(), temp.getEmail()});
        }
        return model;
    }
    
    public static ArrayList exportList(DefaultTableModel Model){
        ArrayList<Khoa> listK = new ArrayList<>();
        
        int rowCount = Model.getRowCount();

        for (int row = 0; row < rowCount; row++) {
            Khoa k = new Khoa();
            k.setId((String) Model.getValueAt(row, 0));
            k.setName((String) Model.getValueAt(row, 1));
            k.setPhone((String) Model.getValueAt(row, 2));
            k.setEmail((String) Model.getValueAt(row, 3));
            k.setDate((Date) Model.getValueAt(row, 4));
            listK.add(k);
        }
        
        return listK;
    }

    public void addList(Khoa khoa){
        if (!khoa.getName().isEmpty() && !khoa.getId().isEmpty() && !khoa.getEmail().isEmpty()){
            if (Check.isPhoneNumber(khoa.getPhone())){
                if(Check.isValidEmail(khoa.getEmail())) list.add(khoa);
                else JOptionPane.showMessageDialog(null,"Check Email Number", "Try again",JOptionPane.ERROR_MESSAGE);
            }else JOptionPane.showMessageDialog(null,"Check Phone Number", "Try again",JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(null,"Information is not valid\nPlease enter all fields", "Try again",JOptionPane.ERROR_MESSAGE);
    }

    public static String findName(String name){
        Iterator<Khoa> it = list.iterator();
        while(it.hasNext()){
            Khoa temp = it.next();
            if(temp.getName().contains(name))
                return temp.getId();
        }
        return null;
    }

    public static Khoa find( String id){
        Iterator<Khoa> it = list.iterator();
        while(it.hasNext()){
            Khoa temp = it.next();
            if(temp.getId().contains(id))
                return temp;
        }
        return null;
    }

    public static void importFile(BufferedReader file) throws IOException, ParseException{
        String line;
        while ((line = file.readLine()) != null) {
            String[] value = line.split("\t");
            list.add(new Khoa(value[0], value[1], value[2], value[3], new SimpleDateFormat("dd/MM/yyyy").parse(value[4])));
        }
    }

    public static void  exportFile(PrintWriter file){
        for (Khoa khoa : list) {
            file.write(khoa.getId() + "\t" + khoa.getName() + "\t" + khoa.getPhone() + "\t" + khoa.getEmail() + "\t" + khoa.getDate());
        }
    }

    public static ArrayList outList(){
        return list;
    }
    
}
