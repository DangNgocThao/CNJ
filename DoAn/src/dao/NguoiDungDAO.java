/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class NguoiDungDAO {

    public static boolean kiemTraDangNhap(String user, String pass) {
        boolean kq = false;
        try {
            String sql = String.format("SELECT * FROM NguoiDung WHERE TAIKHOAN = '%s' AND MATKHAU = '%s'", user, pass);
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            if (rs.next()) {
                kq = true;
            }
            provider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }

    public static String getMaNV(String user) {
        try {
            SQLServerProvider serverProvider = new SQLServerProvider();
            serverProvider.open();
            String sql = "select MANV from NguoiDung WHERE TAIKHOAN ='" + user + "'";
            ResultSet resultSet = serverProvider.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getString("MANV");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
