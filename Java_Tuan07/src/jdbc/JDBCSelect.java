/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class JDBCSelect {

    Connection connection = null;
    Statement statement = null;
    String strServer = "LAPTOP-GIGABYTE";
    String strDatabase = "dbKhachHang";
    private ResultSet resultSet;

    public JDBCSelect() {
        KetNoiCSDL();
        hienThiCSDL();
        themCSDL("KH7", "Nguyễn Quan Vinh", 2002, "n1");
        capNhatCSDL("KH7", "Nguyễn Nhựt Tân", 2002);
        xoaCSDL("KH7");
    }

    private void KetNoiCSDL() {
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

    public void hienThiCSDL() {
        try {
            try {
                statement = (Statement) connection.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(JDBCSelect.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sql = "Select MaKH,TenKH,NamSinh from KhachHang";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String ma = resultSet.getString("MaKH");
                String ten = resultSet.getString("TenKH");
                String nam = resultSet.getString("NamSinh");
                System.out.println("Mã Khách Hàng: " + ma + "\nTên Khách hàng: " + ten + "\nNăm sinh: " + nam + "\n");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new JDBCSelect();
    }

    private void themCSDL(String ma, String ten, int nam, String n) {
        try {
            String sql = "insert into KhachHang values('" + ma + "',N'" + ten + "','" + String.valueOf(nam) + "','" + n + "')";
            int x = statement.executeUpdate(sql);
            if (x >= 1) {
                System.out.println("Thêm thành công");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void capNhatCSDL(String ma, String ten, int nam) {
        try {
            String sql = "update KhachHang set TenKH=N'" + ten + "',NamSinh='" + String.valueOf(nam) + "' where MaKH='" + ma + "'";
            int x = statement.executeUpdate(sql);
            if (x >= 1) {
                System.out.println("Cập nhật thành công");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void xoaCSDL(String ma) {
        try {
            String sql = "delete from KhachHang where MaKH='" + ma + "'";
            int x = statement.executeUpdate(sql);
            if (x >= 1) {
                System.out.println("Số dòng đã xóa: " + x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
