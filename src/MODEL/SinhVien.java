import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.time.chrono.ThaiBuddhistChronology;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class SinhVien {
    

    private static  String id;
    private static String name;
    private static String nameKhoa;
    private static String idKhoa;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        SinhVien.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        SinhVien.name = name;
    }

    public static String getNameKhoa() {
        return nameKhoa;
    }

    public static void setNameKhoa(String nameKhoa) {
        SinhVien.nameKhoa = nameKhoa;
    }

    public static String getIdKhoa() {
        return idKhoa;
    }

    public static void setIdKhoa(String id) {
        SinhVien.idKhoa = id;
        
    }

    public static void setIdKhoa(ArrayList<Khoa> list) {
        Iterator<Khoa> it = list.iterator();
        while(it.hasNext()){
            Khoa temp = it.next();
            if(temp.getName().contains(SinhVien.getNameKhoa())){
                setIdKhoa(temp.getId());
                return;
            }
        }
    }
    
    public SinhVien(String id, String name, String nameKhoa) {
        setId(id);
        setName(name);
        setNameKhoa(nameKhoa);
    }

    public static SinhVien find(ArrayList<SinhVien> list, String id){
        Iterator<SinhVien> it = list.iterator();
        while(it.hasNext()){
            SinhVien temp = it.next();
            if(temp.getId().contains(id))
                return temp;
        }
        return null;
    }

    public static void importFile(BufferedReader file, ArrayList<SinhVien> list) throws IOException{
        String line;
        while ((line = file.readLine()) != null) {
            String[] value = line.split("\t");
            list.add(new SinhVien(value[0], value[1], value[2]));
        }
    }

    public static void  exportFile(PrintWriter file, ArrayList<SinhVien> list){
        for (SinhVien sv : list) {
            file.write(sv.getId() + "\t" + sv.getName() + "\t" + sv.getNameKhoa() + "\t" + sv.getIdKhoa());
        }
    }
    
    public static void addList(ArrayList<SinhVien> list, SinhVien sv){
        if (!sv.getName().isEmpty() && !sv.getId().isEmpty() && !sv.getNameKhoa().isEmpty()){
            list.add(sv);
        } else JOptionPane.showMessageDialog(null,"Information is not valid\nPlease enter all fields", "Try again",JOptionPane.ERROR_MESSAGE);
    }
}
