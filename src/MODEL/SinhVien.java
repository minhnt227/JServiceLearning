import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class SinhVien extends HOAT_DONG {
    

    private String id;
    private String name;
    private String nameKhoa;
    private String idKhoa;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getNameKhoa() {
        return nameKhoa;
    }

    public void setNameKhoa(String nameKhoa) {
        nameKhoa = nameKhoa;
    }

    public String getIdKhoa() {
        return idKhoa;
    }

    public void setIdKhoa(String id) {
        idKhoa = id;
        
    }

    public void setIdKhoa(ArrayList<Khoa> list) {
        Iterator<Khoa> it = list.iterator();
        while(it.hasNext()){
            Khoa temp = it.next();
            if(temp.getName().contains(getNameKhoa())){
                setId(temp.getId());
                return;
            }
        }
    }
    
    public SinhVien(String id, String name, String nameKhoa) {
        super();
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
