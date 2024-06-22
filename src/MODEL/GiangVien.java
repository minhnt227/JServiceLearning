
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class GiangVien {
    private static  String id;
    private static String firtName;
    private static String lastName;
    private static String nameKhoa;
    private static String idKhoa;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        GiangVien.id = id;
    }

    public static String getFirtName() {
        return firtName;
    }

    public static void setFirtName(String firtName) {
        GiangVien.firtName = firtName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        GiangVien.lastName = lastName;
    }

    public static String getNameKhoa() {
        return nameKhoa;
    }

    public static void setNameKhoa(String nameKhoa) {
        GiangVien.nameKhoa = nameKhoa;
    }

    public static String getIdKhoa() {
        return idKhoa;
    }

    public static void setIdKhoa(String idKhoa) {
        GiangVien.idKhoa = idKhoa;
    }

    public static void setIdKhoa(ArrayList<Khoa> list) {
        Iterator<Khoa> it = list.iterator();
        while(it.hasNext()){
            Khoa temp = it.next();
            if(temp.getName().contains(SinhVien.getNameKhoa())){
                setId(temp.getId());
                return;
            }
        }
    }

    public GiangVien(String id, String firstName, String lastName, String nameKhoa) {
        setId(id);
        setFirtName(firtName);
        setLastName(lastName);
        setNameKhoa(nameKhoa);
    }

    public static void importFile(BufferedReader file, ArrayList<GiangVien> list) throws IOException{
        String line;
        while ((line = file.readLine()) != null) {
            String[] value = line.split("\t");
            list.add(new GiangVien(value[0], value[1], value[2], value[3]));
        }
    }

    public static void  exportFile(PrintWriter file, ArrayList<GiangVien> list){
        for (GiangVien gv : list) {
            file.write(gv.getId() + "\t" + gv.getFirtName() + "\t" + gv.getLastName() + "\t" + gv.getNameKhoa());
        }
    }
    
    public static void addList(ArrayList<GiangVien> list, GiangVien gv){
        if (!gv.getFirtName().isEmpty() && !gv.getLastName().isEmpty() && !gv.getNameKhoa().isEmpty() && !gv.getId().isEmpty()){
            list.add(gv);
        } else JOptionPane.showMessageDialog(null,"Information is not valid\nPlease enter all fields", "Try again",JOptionPane.ERROR_MESSAGE);
    }
    
}
