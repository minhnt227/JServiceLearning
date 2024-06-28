/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kisa
 */
public class ListSinhVien extends SinhVien {

    public static ArrayList<SinhVien> list;
    public Object[] colHeader;
    public DefaultTableModel model;

    public ListSinhVien() {
        list = new ArrayList<>();
        model = new DefaultTableModel(colHeader, 0);
    }

    public ListSinhVien(int lim, String svID, String FullName, String FalcutyID, boolean hide) throws SQLException {
        ListSinhVien temp = (new DAO.DAO_SinhVien()).getListFromDB(lim, svID, FullName, FalcutyID, hide);
        list = temp.list;
        model = new DefaultTableModel();
    }

    public void getTableModel() {
        Iterator<SinhVien> it = list.iterator();
        while (it.hasNext()) {
            SinhVien temp = it.next();
            model.addRow(new Object[]{temp.getId(), temp.getName(), temp.getNameKhoa(), temp.getIdKhoa()});
        }
    }

    public static ArrayList exportList(DefaultTableModel Model) {
        ArrayList<SinhVien> listSV = new ArrayList<>();

        int rowCount = Model.getRowCount();

        for (int row = 0; row < rowCount; row++) {
            SinhVien sv = new SinhVien();
            sv.setId((String) Model.getValueAt(row, 0));
            sv.setName((String) Model.getValueAt(row, 1));
            sv.setIdKhoa((String) Model.getValueAt(row, 2));
            sv.setNameKhoa((String) Model.getValueAt(row, 3));
            listSV.add(sv);
        }

        return listSV;
    }

    public static SinhVien find(String nameKhoa) {
        Iterator<SinhVien> it = list.iterator();
        while (it.hasNext()) {
            SinhVien temp = it.next();
            if (temp.getNameKhoa().contains(nameKhoa)) {
                return temp;
            }
        }
        return null;
    }

    public static int countKhoa(String nameKhoa) {
        int cnt = 0;
        for (SinhVien sinhVien : list) {
            if (find(nameKhoa) != null) {
                cnt++;
            }
        }
        return cnt;
    }

    public static int soLuong() {
        return list.size();
    }

    public static void importFile(BufferedReader file) throws IOException {
        String line;
        while ((line = file.readLine()) != null) {
            String[] value = line.split("\t");
            list.add(new SinhVien(value[0], value[1], value[2], value[3]));
        }
    }

    public static void exportFile(PrintWriter file) {
        for (SinhVien sv : list) {
            file.write(sv.getId() + "\t" + sv.getName() + "\t" + sv.getNameKhoa() + "\t" + sv.getIdKhoa());
        }
    }

    public static void addList(SinhVien sv) {
        if (!sv.getName().isEmpty() && !sv.getId().isEmpty() && !sv.getNameKhoa().isEmpty()) {
            list.add(sv);
        } else {
            JOptionPane.showMessageDialog(null, "Information is not valid\nPlease enter all fields", "Try again", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static ArrayList outList() {
        return list;
    }

}
