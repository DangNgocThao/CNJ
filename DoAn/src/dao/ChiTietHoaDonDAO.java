/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jamas008
 */
public class ChiTietHoaDonDAO {

    public static boolean themChiTietHoaDon(String maHoaDon, String maBan) {
        try {
            String sql = "select * from PHIEUGOIMON where MABAN='" + maBan + "'";
            SQLServerProvider serverProvider = new SQLServerProvider();
            serverProvider.open();
            ResultSet resultSet = serverProvider.executeQuery(sql);
            while (resultSet.next()) {
                String sqlCTHD = "insert into CHITIETHOADON values('" + maHoaDon + "','" + resultSet.getString("MAMONAN") + "','" + resultSet.getString("SOLUONG") + "')";
                serverProvider.executeUpdate(sqlCTHD);
            }
//            String sqlDeletePhieuGoiMon = "delete from PHIEUGOIMON where MABAN='" + maBan + "'";
//            serverProvider.executeUpdate(sqlDeletePhieuGoiMon);
            serverProvider.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
