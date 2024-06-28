/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.logging.*;
import MODEL.DoiTac;
import MODEL.ListDoiTac;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author bom19
 */
public class DAO_DoiTac extends DBConnector {

    public DAO_DoiTac() {
    }

    public boolean existDT(String Name) {
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM DOI_TAC WHERE TenDoiTac LIKE N'" + Name + "'";
            ResultSet rst = stm.executeQuery(sqlSelect);
            if (!rst.first()) {
                stm.close();
                return false;
            }
            stm.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean existID(int ID) {
        try {
            Statement stm = con.createStatement();
            String sqlSelect = "SELECT * FROM DOI_TAC WHERE ID_DoiTac = " + ID;
            ResultSet rst = stm.executeQuery(sqlSelect);
            if (!rst.first()) {
                stm.close();
                return false;
            }
            stm.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean insertDoiTac(DoiTac newData) throws SQLException {
        try {
            Prepstm = con.prepareStatement("INSERT INTO DOI_TAC VALUES (?,?,?,?,'false')");

            Prepstm.setNString(1, newData.getName());
            Prepstm.setNString(2, newData.getNameHost());
            Prepstm.setString(3, newData.getPhone());
            Prepstm.setString(4, newData.getEmail());

            return super.updateDB();
        } catch (SQLException e) {
            e.printStackTrace();
            Prepstm.close();
            return false;
        }
    }

    /**
     * Update an DOI_TAC model to the Database. If a DOI_TAC is already in DB,
     * update its data, if not, insert a new record of DOI_TAC IF UPDATE, DOITAC
     * NEED TO HAVE AN ID
     *
     * @param gv New DoiTac data to add or update to DB
     * @return true if insert or update success, false if operation failed
     */
    public boolean updateDT(DoiTac dt) {
        //null check
        if (dt == null || dt.getName().isBlank()) {
            return false;
        }
        //if not in DB, add it in
        if (!existID(dt.getDtID())) {
            try {
                return insertDoiTac(dt);
            } catch (SQLException ex) {
                Logger.getLogger(DAO_DoiTac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        try {
            Prepstm = con.prepareStatement("UPDATE DOI_TAC "
                    + "SET TenDoiTac = ?, DaiDien = ?, SDT = ?, Email = ?, Hide = 'false' "
                    + "WHERE ID_DoiTac = ?");

            Prepstm.setNString(1, dt.getName());
            Prepstm.setNString(2, dt.getNameHost());
            Prepstm.setString(3, dt.getPhone());
            Prepstm.setString(4, dt.getPhone());
            Prepstm.setInt(5, dt.getDtID());

            return super.updateDB();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getSQLState());
            return false;
        }
    }

    public boolean deleteDoiTac(String name) {
        if (name.isBlank()) {
            return false;
        }
        try {
            Prepstm = con.prepareStatement("UPDATE DOI_TAC SET Hide = 'true' WHERE TenDoiTac LIKE ?");
            Prepstm.setNString(1, name.trim());

            return super.updateDB();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getSQLState());
            return false;
        }
    }

    /**
     *
     * @param Name
     * @return dt from Database
     */
    public DoiTac getSingleByName(final String Name) {
        final DoiTac dt = null;
        try {
            Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                     ResultSet.CONCUR_READ_ONLY);
            String sqlSelect;
            sqlSelect = "SELECT * FROM DOI_TAC WHERE TenDoiTac LIKE N'%" + Name + "%'";
            final ResultSet result = stm.executeQuery(sqlSelect);
            while (result.next()) {
                int iD = result.getInt(1);
                String name = result.getNString(2);
                return new DoiTac(result.getInt(1), result.getNString(2), result.getNString(3), result.getString(4), result.getString(5));
               
            }

            stm.close();
            con.close();
            return dt;
        } catch (Exception e) {
            e.printStackTrace();
            return dt;
        }

    }

    public DoiTac getSingleById(int Id) {
        DoiTac dt = null;
        try {
            Statement stm = con.createStatement();
            String sqlSelect;
            sqlSelect = "SELECT * FROM DOI_TAC WHERE ID_DoiTac = " + Id;
            final ResultSet rst = stm.executeQuery(sqlSelect);
            rst.absolute(1);
            dt = new DoiTac(rst.getInt(1), rst.getNString(2), rst.getNString(3), rst.getString(4), rst.getString(5));
            dt.setHide(rst.getBoolean(6));
            stm.close();
            return dt;
        } catch (Exception e) {
            e.printStackTrace();
            return dt;
        }

    }

    public ListDoiTac getListFromDB(int limit, String name, boolean Hide) throws SQLException {
        ListDoiTac Objs = new ListDoiTac();
        if (limit <= 0) {
            sqlQuery = "SELECT * FROM DOI_TAC WHERE Hide = '" + Hide + "'";
        } else {
            sqlQuery = "SELECT TOP " + limit + " * FROM DOI_TAC WHERE Hide = '" + Hide + "'";
        }

        if (!name.isBlank()) {
            sqlQuery += " AND TenDoiTac LIKE N'%" + name + "%'";
        }

        Statement stm = con.createStatement();
        ResultSet result = stm.executeQuery(sqlQuery);
        while (result.next()) {
            Objs.list.add(new DoiTac(result.getInt(1), result.getNString(2), result.getNString(3), result.getString(4), result.getString(5)));
        }
        Objs.colHeader = getColunmHeader(result);
        stm.close();
        return Objs;
    }

    /**
     *
     * @param idHD
     * @return A ListDoiTac with their HOAT_DONG properties DoiTac in this list
     * have the same index as their ID
     */
    public ListDoiTac getListHD_DoiTac(int idHD) {
        if (DAO_HoatDong.exist(idHD)) {
            try {
                ListDoiTac Objs = new ListDoiTac();
                Objs.setMaHD(idHD);
                //Build a list of DoiTac's ID belong to the HoatDong with idHD
                sqlQuery = "SELECT * FROM HD_DOITAC WHERE MaHD = '" + idHD + "'";
                Statement stm = con.createStatement();
                ResultSet result = stm.executeQuery(sqlQuery);
                while (result.next()) {
                    int idDoiTac = result.getInt(1);
                    DoiTac dt = new DoiTac();
                    //set the first 3 attribute from HD_DOITAC
                    dt.setMaHD(idHD);
                    dt.setDtID(idDoiTac);
                    dt.setNoiDung(result.getNString(3));
                    //find a temporary DoiTac from DOI_TAC Table to fill in the rest attribute
                    DoiTac temp = getSingleById(idDoiTac);
                    if (temp.getHide() || temp == null) {
                        continue;           //don't add to list if DoiTac is deleted or null
                    }
                    dt.setName(temp.getName());
                    dt.setNameHost(temp.getNameHost());
                    dt.setPhone(temp.getPhone());
                    dt.setEmail(temp.getEmail());
                    dt.setHide(Boolean.FALSE);

                    Objs.list.add(idDoiTac, dt); //add DoiTac to list with the same index as ID in DB
                }
                if (Objs.list.size() <= 0) {
                    return null;
                }
                return Objs;
            } catch (SQLException ex) {
                Logger.getLogger(DAO_DoiTac.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    /**
     * Delete all HD_DOITAC with idHD
     *
     * @param idHD
     * @return @true if success or @false when there's no row to delete or fails
     */
    public boolean deleteListHD_DoiTac(int idHD) {
        if (idHD <= 0) {
            return false;
        }
        try {
            Prepstm = con.prepareStatement("DELETE FROM HD_DOITAC WHERE MaHD = ?");
            Prepstm.setInt(1, idHD);

            return super.updateDB();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getSQLState());
            return false;
        }
    }

    /**
     * Update A list of HD_DOITAC to DB by deleting all old record and update
     * the new list. Each DoiTac has to be init with their NoiDung and HDId
     *
     * @param HD_DTs
     * @return
     */
    public boolean updateListHD_DoiTac(ListDoiTac HD_DTs) {
        if (HD_DTs.getMaHD() <= 0 || HD_DTs == null) //ListDoiTac must have HDid
        {
            //System.out.println("There's no HOAT_DONG to add this list to!!! Create a HOAT_DONG and add it's id to this list!");
            return false;
        }
        try {

            //delete old data in HD_DOITAC
            deleteListHD_DoiTac(HD_DTs.getMaHD());
            //loop through the list
            for (DoiTac dt : HD_DTs.list) {
                //update or insert into DOI_TAC
                updateDT(dt);
                //get DoiTac's ID
                int dTId = getSingleByName(dt.getName()).getDtID();
                //Add new HD_DoiTac 
                sqlQuery = "INSERT INTO HD_DOITAC VALUES (?,?,?)";
                Prepstm = con.prepareStatement(sqlQuery);
                Prepstm.setInt(1, dTId);
                Prepstm.setInt(2, HD_DTs.getMaHD());
                Prepstm.setNString(3, dt.getNoiDung());

                return super.updateDB();
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

}
