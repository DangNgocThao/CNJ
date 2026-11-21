/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class SQLServerProvider {

    private Connection connection;

    public void open() {
        String strServer = "LAPTOP-GIGABYTE";
        String strDatabase = "QL_NHANVIEN";
        try {
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
            String connectionURL = "jdbc:sqlserver://" + strServer + ":1433;databaseName=" + strDatabase + ";user=sa;password=123;encrypt=true;trustServerCertificate=true";
            connection = DriverManager.getConnection(connectionURL);

//            if (connection != null) {
//                System.out.println("Kết nối thành công");
//            } else {
//                System.out.println("Kết nối không thành công");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String sql) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SQLServerProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultSet;
    }

    public int executeUpdate(String sql) {
        int n = -1;
        try {
            Statement statement = connection.createStatement();
            n = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SQLServerProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
