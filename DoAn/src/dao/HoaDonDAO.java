/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import pojo.ChiTietHoaDon;
import pojo.HoaDon;

/**
 *
 * @author jamas008
 */
public class HoaDonDAO {

    public static boolean themHoaDon(HoaDon x) {
        try {
            Date currentDay = new Date();
            SQLServerProvider serverProvider = new SQLServerProvider();
            serverProvider.open();
            String sql = "insert into HOADON values(1,'" + x.getMaNhanVien() + "','" + new SimpleDateFormat("yyyy/MM/dd").format(currentDay) + "',N'Thanh toán','" + x.getTongTien() + "')";
            if (serverProvider.executeUpdate(sql)) {
                serverProvider.close();
                return true;
            }
            serverProvider.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getLastInsertMaHoaDon() {
        try {
            SQLServerProvider serverProvider = new SQLServerProvider();
            serverProvider.open();
            String sql = "select * from HOADON";
            ResultSet resultSet = serverProvider.executeQuery(sql);
            if (resultSet.last()) {
                return resultSet.getString("MAHD");
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<HoaDon> layDanhSachHoaDon() {
        ArrayList<HoaDon> dsHoaDon = new ArrayList<>();
        try {
            String sql = "Select * from HOADON";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while (resultSet.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(resultSet.getInt(1));
                hd.setMaKhachHang(resultSet.getInt(2));
                hd.setMaNhanVien(resultSet.getInt(3));
                hd.setNgayThanhToan(resultSet.getDate(4));
                hd.setTrangThai(resultSet.getString(5));
                hd.setTongTien(resultSet.getInt(6));
                dsHoaDon.add(hd);
            }
            provider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsHoaDon;
    }

    public static ArrayList<ChiTietHoaDon> layDanhSachCTHoaDon(String ma) {
        ArrayList<ChiTietHoaDon> dsCTHoaDon = new ArrayList<>();
        try {
            String sql = "Select * from CHITIETHOADON, MONAN  WHERE  CHITIETHOADON.MAMONAN = MONAN.MAMONAN AND MAHD=" + ma;
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while (resultSet.next()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setMaHoaDon(resultSet.getInt("MAHD"));
                //cthd.setMaMonAn(resultSet.getInt(2));
                cthd.setSoLuong(resultSet.getInt("SOLUONG"));
                cthd.setTenMonAn(resultSet.getString("TENMONAN"));
                dsCTHoaDon.add(cthd);
            }
            provider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsCTHoaDon;
    }
}
