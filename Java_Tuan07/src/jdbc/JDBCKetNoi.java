/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Administrator
 */
public class JDBCKetNoi {

    Connection connection = null;
    Statement statement = null;
    String strServer = "LAPTOP-GIGABYTE";
    String strDatabase = "dbKhachHang";

    public JDBCKetNoi() {
        KetNoiCSDL();
    }

    private void KetNoiCSDL() {
        try {
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
            String connectionURL = "jdbc:sqlserver://" + strServer + ":1433;databaseName=" + strDatabase + ";user=sa;password=123;encrypt=true;trustServerCertificate=true";
            connection = DriverManager.getConnection(connectionURL);
            //statement = (Statement) connection.createStatement();
            if (connection != null) {
                System.out.println("Kết nối thành công");
            } else {
                System.out.println("Kết nối không thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JDBCKetNoi();
    }
}
