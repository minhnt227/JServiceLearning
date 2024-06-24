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
public class ListDoiTac extends DoiTac{
    public static ArrayList<DoiTac> list;

    public ListDoiTac(){
        list = new ArrayList<>();
    }

    public static DoiTac find(String name){
        Iterator<DoiTac> it = list.iterator();
        while(it.hasNext()){
            DoiTac temp = it.next();
            if(temp.getName().contains(name))
                return temp;
        }
        return null;
    }

    public static int soLuong(){
        return list.size();
    }

    public static void addList(DoiTac doiTac){
        if (!doiTac.getName().isEmpty() && !doiTac.getNameHost().isEmpty() && !doiTac.getEmail().isEmpty()){
            if (Check.isPhoneNumber(getPhone())){
                if (Check.isValidEmail(getEmail())) list.add(doiTac);
                else JOptionPane.showMessageDialog(null,"Check Email Number", "Try again",JOptionPane.ERROR_MESSAGE);
            }else JOptionPane.showMessageDialog(null,"Check Phone Number", "Try again",JOptionPane.ERROR_MESSAGE);
        } else JOptionPane.showMessageDialog(null,"Information is not valid\nPlease enter all fields", "Try again",JOptionPane.ERROR_MESSAGE);
    }

    public static void importFile(BufferedReader file) throws IOException{
        String line;
        while ((line = file.readLine()) != null) {
            String[] value = line.split("\t");
            list.add(new DoiTac(value[0], value[1], value[2], value[3]));
        }
    }

    public static void  exportFile(PrintWriter file){
        for (DoiTac doiTac : list) {
            file.write(doiTac.getName() + "\t" + doiTac.getNameHost() + "\t" + doiTac.getPhone() + "\t" + doiTac.getEmail());
        }
    }

    public static ArrayList outList(){
        return list;
    }
    
}
