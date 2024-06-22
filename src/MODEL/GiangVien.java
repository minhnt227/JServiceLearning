
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class GiangVien {
    private  String id;
    private String firtName;
    private String lastName;
    private String nameKhoa;
    private String idKhoa;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNameKhoa() {
        return nameKhoa;
    }

    public void setNameKhoa(String nameKhoa) {
        this.nameKhoa = nameKhoa;
    }

    public String getIdKhoa() {
        return idKhoa;
    }

    public void setIdKhoa(String idKhoa) {
        this.idKhoa = idKhoa;
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

    public GiangVien(){}

    public GiangVien(String id, String firstName, String lastName, String nameKhoa) {
        setId(id);
        setFirtName(firtName);
        setLastName(lastName);
        setNameKhoa(nameKhoa);
    }

       
}

class ListGiangVien extends GiangVien{
    ArrayList<GiangVien> list;

    public ListGiangVien(){
        super();
        list = new ArrayList<>();
    }

    public void importFile(BufferedReader file) throws IOException{
        String line;
        while ((line = file.readLine()) != null) {
            String[] value = line.split("\t");
            list.add(new GiangVien(value[0], value[1], value[2], value[3]));
        }
    }

    public void  exportFile(PrintWriter file){
        for (GiangVien gv : list) {
            file.write(gv.getId() + "\t" + gv.getFirtName() + "\t" + gv.getLastName() + "\t" + gv.getNameKhoa());
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
