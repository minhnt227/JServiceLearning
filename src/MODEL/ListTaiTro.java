/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kisa
 */
public class ListTaiTro extends TaiTro{

    public static ArrayList<TaiTro> list;
    public Object[] colHeader;
    public DefaultTableModel model;

    public ListTaiTro(){
        super();
        list = new ArrayList<>();
        model = new DefaultTableModel(colHeader,0);
    }

    public DefaultTableModel getTableModel(){
        Iterator<TaiTro> it = list.iterator();
        while(it.hasNext()){
            TaiTro temp = it.next();
            model.addRow(new Object[]{temp.getName(), temp.getNameHost(), temp.getPhone(), temp.getEmail()});
        }
        return model;
    }
    
    public static ArrayList exportList(DefaultTableModel Model){
        ArrayList<TaiTro> listTT = new ArrayList<>();
        
        int rowCount = Model.getRowCount();

        for (int row = 0; row < rowCount; row++) {
            TaiTro tt = new TaiTro();
            tt.setName((String) Model.getValueAt(row, 0));
            tt.setNameHost((String) Model.getValueAt(row, 1));
            tt.setEmail((String) Model.getValueAt(row, 2));
            tt.setPhone((String) Model.getValueAt(row, 3));
            listTT.add(tt);
        }
        
        return listTT;
    }
    
    
    public static TaiTro find(String name){
        Iterator<TaiTro> it = list.iterator();
        while(it.hasNext()){
            TaiTro temp = it.next();
            if(temp.getName().contains(name))
                return temp;
        }
        return null;
    }

    public static void importFile(BufferedReader file) throws IOException{
        String line;
        while ((line = file.readLine()) != null) {
            String[] value = line.split("\t");
            list.add(new TaiTro(value[0], value[1], value[2], value[3]));
        }
    }

    public static void  exportFile(PrintWriter file){
        for (TaiTro taiTro : list) {
            file.write(taiTro.getName() + "\t" + taiTro.getNameHost() + "\t" + taiTro.getPhone() + "\t" + taiTro.getEmail());
        }
    }
    
    public static void addList(TaiTro taiTro){
        if (!taiTro.getName().isEmpty() && !taiTro.getNameHost().isEmpty() && !taiTro.getEmail().isEmpty()){
            if (Check.isPhoneNumber(taiTro.getPhone())){
                list.add(taiTro);
            }else JOptionPane.showMessageDialog(null,"Check Phone Number", "Try again",JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(null,"Information is not valid\nPlease enter all fields", "Try again",JOptionPane.ERROR_MESSAGE);
    }

    public static ArrayList outList(){
        return list;
    }

}
 
