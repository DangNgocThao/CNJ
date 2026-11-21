/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import pojo.PhongBan;

/**
 *
 * @author Administrator
 */
public class phongBanDao {

    public static ArrayList<PhongBan> layDanhSachPhongBan() {
        ArrayList<PhongBan> dsPB = new ArrayList<PhongBan>();
        try {
            String sql = "SELECT * FROM PhongBan";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while (rs.next()) {
                PhongBan pb = new PhongBan();
                pb.setMaPhong(rs.getInt("MaPHG"));
                pb.setTenPhong(rs.getString("TenPHG"));
                dsPB.add(pb);
            }
            provider.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPB;
    }

    public static ArrayList<PhongBan> timkiemPhongBanTheoTen(String tenPB) {
        ArrayList<PhongBan> dsPB = new ArrayList<PhongBan>();
        try {
            String sql = "SELECT * FROM PhongBan WHERE TenPHG LIKE '%" + tenPB + "%'";
            SQLServerProvider provider = new SQLServerProvider();
            ResultSet rs = provider.executeQuery(sql);
            while (rs.next()) {
                PhongBan pb = new PhongBan();
                pb.setMaPhong(rs.getInt("MaPHG"));
                pb.setTenPhong(rs.getString("TenPHG"));
                dsPB.add(pb);
            }
            provider.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPB;
    }

    public static boolean themPhongBan(PhongBan pb) {
        boolean kq = false;
        String sql = String.format("INSERT INTO PhongBan(TenPHG) VALUES('%s');", pb.getTenPhong());
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int n = provider.executeUpdate(sql);
        if (n == 1) {
            kq = true;
        }
        provider.close();
        return kq;
    }

    public static PhongBan layPhongBan(int maPB) {
        PhongBan pb = null;
        try {
            String sql = "SELECT * FROM PhongBan WHERE MaPHG = " + maPB;
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            if (rs.next()) {
                pb = new PhongBan();
                pb.setMaPhong(rs.getInt("MaPHG"));
                pb.setTenPhong(rs.getString("TenPHG"));
            }
            provider.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pb;
    }

    public static boolean capNhatPhongBan(PhongBan pb) {
        boolean kq = false;
        String sql = String.format("UPDATE PHONGBAN SET TENPHG = '%s' WHERE MaPHG=%d", pb.getTenPhong(), pb.getMaPhong());
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int n = provider.executeUpdate(sql);
        if (n == 1) {
            kq = true;
        }
        provider.close();
        return kq;
    }

    public static boolean xoaPhongBan(PhongBan pb) {
        boolean kq = false;
        String sql = String.format("DELETE FROM PHONGBAN WHERE MaPHG=%d", pb.getMaPhong());
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int n = provider.executeUpdate(sql);
        if (n == 1) {
            kq = true;
        }
        provider.close();
        return kq;
    }
}
