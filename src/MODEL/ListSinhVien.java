
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

class ListSinhVien extends SinhVien{
    ArrayList<SinhVien> list;

    public ListSinhVien(){
        list = new ArrayList<>();
    }

    public SinhVien find(String nameKhoa){
        Iterator<SinhVien> it = list.iterator();
        while(it.hasNext()){
            SinhVien temp = it.next();
            if(temp.getNameKhoa().contains(nameKhoa))
                return temp;
        }
        return null;
    }

    public int countKhoa(String nameKhoa){
        int cnt = 0;
        for (SinhVien sinhVien : list) {
            if (find(nameKhoa) != null) cnt++;
        }
        return cnt;
    }

    public int soLuong(){
        return list.size();
    }

    public void importFile(BufferedReader file) throws IOException{
        String line;
        while ((line = file.readLine()) != null) {
            String[] value = line.split("\t");
            list.add(new SinhVien(value[0], value[1], value[2]));
        }
    }

    public void  exportFile(PrintWriter file){
        for (SinhVien sv : list) {
            file.write(sv.getId() + "\t" + sv.getName() + "\t" + sv.getNameKhoa() + "\t" + sv.getIdKhoa());
        }
    }
    
    public void addList(SinhVien sv){
        if (!sv.getName().isEmpty() && !sv.getId().isEmpty() && !sv.getNameKhoa().isEmpty()){
            list.add(sv);
        } else JOptionPane.showMessageDialog(null,"Information is not valid\nPlease enter all fields", "Try again",JOptionPane.ERROR_MESSAGE);
    }

}
