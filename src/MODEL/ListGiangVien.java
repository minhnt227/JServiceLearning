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

/**
 *
 * @author Kisa
 */
public class ListGiangVien extends GiangVien{
    public static ArrayList<GiangVien> list;

    public ListGiangVien(){
        super();
        list = new ArrayList<>();
    }

    public void importFile(BufferedReader file) throws IOException{
        String line;
        while ((line = file.readLine()) != null) {
            String[] value = line.split("\t");
            list.add(new GiangVien(value[0], value[1], value[2], value[3], value[4]));
        }
    }

    public void  exportFile(PrintWriter file){
        for (GiangVien gv : list) {
            file.write(gv.getId() + "\t" + gv.getFirtName() + "\t" + gv.getLastName() + "\t" + gv.getNameKhoa() + "\t" + gv.getTenHD());
        }
    }

    public GiangVien find(String id){
        Iterator<GiangVien> it = list.iterator();
        while(it.hasNext()){
            GiangVien temp = it.next();
            if(temp.getId().contains(id))
                return temp;
        }
        return null;
    }
    
    public void addList(GiangVien gv){
        if (!gv.getFirtName().isEmpty() && !gv.getLastName().isEmpty() && !gv.getNameKhoa().isEmpty() && !gv.getId().isEmpty()){
            list.add(gv);
        } else JOptionPane.showMessageDialog(null,"Information is not valid\nPlease enter all fields", "Try again",JOptionPane.ERROR_MESSAGE);
    } 

    public ArrayList outList(){
        return list;
    }
}