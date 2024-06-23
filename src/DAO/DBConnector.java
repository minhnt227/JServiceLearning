/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.sql.DriverManager;

/**
 *
 * @author bom19
 */
public class DBConnector {
    protected Connection con = null;

    public DBConnector() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            String url = "jdbc:sqlserver://localhost;encrypt=true;databaseName=Service_Learning;integratedSecurity=true;trustServerCertificate=true";
            
            con = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println("ERROR IN DBConnector");
            e.printStackTrace();
        }
    }
    
//    public PreparedStatement UpdateKhoa() {
//        
//    }
    
    public Object[] getColunmHeader(ResultSet rS ) throws SQLException{
        ResultSetMetaData result = rS.getMetaData();
        int count = result.getColumnCount();
        Object[] ColHeader = new String[count];
        for (int i=1;i<count;i++){
            ColHeader[i-1] = result.getColumnName(i);
        }
        return ColHeader;
    }
    
}
