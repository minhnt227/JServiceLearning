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
public class ListSinhVien extends SinhVien{
    public static ArrayList<SinhVien> list;

    public ListSinhVien(){
        list = new ArrayList<>();
    }

    public static SinhVien find(String nameKhoa){
        Iterator<SinhVien> it = list.iterator();
        while(it.hasNext()){
            SinhVien temp = it.next();
            if(temp.getNameKhoa().contains(nameKhoa))
                return temp;
        }
        return null;
    }

    public static int countKhoa(String nameKhoa){
        int cnt = 0;
        for (SinhVien sinhVien : list) {
            if (find(nameKhoa) != null) cnt++;
        }
        return cnt;
    }

    public static int soLuong(){
        return list.size();
    }

    public static void importFile(BufferedReader file) throws IOException{
        String line;
        while ((line = file.readLine()) != null) {
            String[] value = line.split("\t");
            list.add(new SinhVien(value[0], value[1], value[2]));
        }
    }

    public static void  exportFile(PrintWriter file){
        for (SinhVien sv : list) {
            file.write(sv.getId() + "\t" + sv.getName() + "\t" + sv.getNameKhoa() + "\t" + sv.getIdKhoa());
        }
    }
    
    public static void addList(SinhVien sv){
        if (!sv.getName().isEmpty() && !sv.getId().isEmpty() && !sv.getNameKhoa().isEmpty()){
            list.add(sv);
        } else JOptionPane.showMessageDialog(null,"Information is not valid\nPlease enter all fields", "Try again",JOptionPane.ERROR_MESSAGE);
    }

    public static ArrayList outList(){
        return list;
    }

}
