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
public class ListGiangVien extends GiangVien{
    public static ArrayList<GiangVien> list;
    public Object[] colHeader;
    public DefaultTableModel model;

    public ListGiangVien(){
        super();
        list = new ArrayList<>();
        model = new DefaultTableModel(colHeader,0);
    }
    
    public DefaultTableModel getTableModel(){
        Iterator<GiangVien> it = list.iterator();
        while(it.hasNext()){
            GiangVien temp = it.next();
            model.addRow(new Object[]{temp.getId(), temp.getFirtName(), temp.getLastName(), temp.getNameKhoa(), temp.getTenHD()});
        }
        return model;
    }
    
        public static ArrayList exportList(DefaultTableModel Model){
        ArrayList<GiangVien> listGV = new ArrayList<>();
        
        int rowCount = Model.getRowCount();

        for (int row = 0; row < rowCount; row++) {
            GiangVien gv = new GiangVien();
            gv.setId((String) Model.getValueAt(row, 0));
            gv.setFirtName((String) Model.getValueAt(row, 1));
            gv.setLastName((String) Model.getValueAt(row, 2));
            gv.setNameKhoa((String) Model.getValueAt(row, 3));
            gv.setNameKhoa((String) Model.getValueAt(row, 4));
            listGV.add(gv);
        }
        
        return listGV;
    }
    
    public static void importFile(BufferedReader file) throws IOException{
        String line;
        while ((line = file.readLine()) != null) {
            String[] value = line.split("\t");
            list.add(new GiangVien(value[0], value[1], value[2], value[3], value[4]));
        }
    }

    public static void  exportFile(PrintWriter file){
        for (GiangVien gv : list) {
            file.write(gv.getId() + "\t" + gv.getFirtName() + "\t" + gv.getLastName() + "\t" + gv.getNameKhoa() + "\t" + gv.getTenHD());
        }
    }

    public static GiangVien find(String id){
        Iterator<GiangVien> it = list.iterator();
        while(it.hasNext()){
            GiangVien temp = it.next();
            if(temp.getId().contains(id))
                return temp;
        }
        return null;
    }
    
    public static void addList(GiangVien gv){
        if (!gv.getFirtName().isEmpty() && !gv.getLastName().isEmpty() && !gv.getNameKhoa().isEmpty() && !gv.getId().isEmpty()){
            list.add(gv);
        } else JOptionPane.showMessageDialog(null,"Information is not valid\nPlease enter all fields", "Try again",JOptionPane.ERROR_MESSAGE);
    } 

    public static ArrayList outList(){
        return list;
    }
}
