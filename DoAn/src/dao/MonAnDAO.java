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
import pojo.MonAn;

/**
 *
 * @author DNT
 */
public class MonAnDAO {

    public static ArrayList<MonAn> showMonAn(String key) {
        ArrayList<MonAn> dsMA = new ArrayList<>();
        try {
            String sql;
            if (key.isEmpty()) {
                sql = "SELECT * FROM MONAN, LOAIMON WHERE MONAN.MALOAI=LOAIMON.MALOAI";
            } else {
                sql = "SELECT * FROM MONAN, LOAIMON WHERE MONAN.MALOAI=LOAIMON.MALOAI AND (MAMONAN LIKE '%" + key + "%' OR TENLOAI LIKE '%" + key + "%' OR TENMONAN LIKE '%" + key + "%' OR SOLUONG LIKE '%" + key + "%' OR DONVITINH LIKE '%" + key + "%' OR DONGIA LIKE '%" + key + "%' OR MONAN.MOTA LIKE '%" + key + "%')";
            }
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while (resultSet.next()) {
                MonAn ma = new MonAn();
                ma.setMaMonAn(resultSet.getInt("MAMONAN"));
                ma.setTenLoai(resultSet.getString(2));
                ma.setTenMonAn(resultSet.getString("TENMONAN"));
                ma.setSoLuong(resultSet.getInt("SOLUONG"));
                ma.setDonViTinh(resultSet.getString("DONVITINH"));
                ma.setDonGia(resultSet.getDouble("DONGIA"));
                ma.setMoTa(resultSet.getString("MOTA"));
                ma.setHinh(resultSet.getString("HINH"));

                dsMA.add(ma);
            }
            provider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsMA;
    }

    public static boolean themCSDL(MonAn m) {
        boolean kq = false;
        String sql = "INSERT INTO MONAN VALUES(" + m.getMaLoai() + ", N'" + m.getTenMonAn() + "', " + m.getSoLuong() + ", N'" + m.getHinh() + "', N'" + m.getDonViTinh() + "', " + m.getDonGia() + ", N'" + m.getMoTa() + "')";
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }

    public static boolean capNhatCSDL(MonAn m) {
        boolean kq = false;
        String sql = "UPDATE MONAN SET MALOAI=" + m.getMaLoai() + ", TENMONAN=N'" + m.getTenMonAn() + "', SOLUONG=" + m.getSoLuong() + ", HINH=N'" + m.getHinh() + "', DONVITINH=N'" + m.getDonViTinh() + "', DONGIA=" + m.getDonGia() + ", MOTA=N'" + m.getMoTa() + "' where MAMONAN=" + m.getMaMonAn();
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }

    public static boolean xoaCSDL(MonAn m) {
        boolean kq = false;
        String sql = "DELETE FROM MONAN WHERE MAMONAN=" + m.getMaMonAn();
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        if (provider.executeUpdate(sql)) {
            kq = true;
        }
        provider.close();
        return kq;
    }

    public static ArrayList<MonAn> loadMonAn() {
        try {
            SQLServerProvider serverProvider = new SQLServerProvider();
            serverProvider.open();
            String sql = "select * from MONAN";
            ResultSet resultSet = serverProvider.executeQuery(sql);
            ArrayList<MonAn> dsMonAn = new ArrayList<>();
            while (resultSet.next()) {
                MonAn monAn = new MonAn();
                monAn.setMaMonAn(resultSet.getInt("MAMONAN"));
                monAn.setMaLoai(resultSet.getInt("MALOAI"));
                monAn.setTenMonAn(resultSet.getString("TENMONAN"));
                monAn.setHinh(resultSet.getString("HINH"));
                monAn.setDonGia(resultSet.getDouble("DONGIA"));
                dsMonAn.add(monAn);
            }
            return dsMonAn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MonAn getOneMonAnByMaMonAn(String maMonAn) {
        try {
            String sql = "select * from MONAN where MAMONAN='" + maMonAn + "'";
            SQLServerProvider serverProvider = new SQLServerProvider();
            serverProvider.open();
            ResultSet resultSet = serverProvider.executeQuery(sql);
            if (resultSet.next()) {
                MonAn x = new MonAn();
                x.setMaMonAn((resultSet.getInt("MAMONAN")));
                x.setMaLoai(resultSet.getInt("MALOAI"));
                x.setTenMonAn(resultSet.getString("TENMONAN"));
                x.setHinh(resultSet.getString("HINH"));
                x.setDonGia(resultSet.getDouble("DONGIA"));

                serverProvider.close();
                return x;
            }
            serverProvider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getSoLuongByMaMonAn(String maMonAn) {
        try {
            String sql = "select * from MONAN where MAMONAN='" + maMonAn + "'";
            SQLServerProvider serverProvider = new SQLServerProvider();
            serverProvider.open();
            ResultSet resultSet = serverProvider.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getInt("SOLUONG");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static ArrayList getThongKeTienBanDuoc(Date s, Date f) {
        try {
            SQLServerProvider serverProvider = new SQLServerProvider();
            serverProvider.open();
//           String s1 = new SimpleDateFormat("yyyy/MM/dd").format(s);
//           String s2 = new SimpleDateFormat("dd/MM/yyyy").format(s);

            String sql = "SELECT * FROM  F_TK_TienTungSanPham('" + new SimpleDateFormat("yyyy/MM/dd").format(s) + "','" + new SimpleDateFormat("yyyy/MM/dd").format(f) + "')";
            ResultSet resultSet = serverProvider.executeQuery(sql);
            ArrayList<MonAn> dsMonAn = new ArrayList<>();
            while (resultSet.next()) {
                MonAn monAn = new MonAn();
                monAn.setMaMonAn(resultSet.getInt("MASP"));
                monAn.setTenMonAn(resultSet.getString("TENSP"));
                monAn.setDonGia(resultSet.getDouble("THANHTIEN"));
                dsMonAn.add(monAn);
            }
            return dsMonAn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList getThongKeSoLuongBanDuoc(Date s, Date f) {
        try {
            SQLServerProvider serverProvider = new SQLServerProvider();
            serverProvider.open();
//           String s1 = new SimpleDateFormat("yyyy/MM/dd").format(s);
//           String s2 = new SimpleDateFormat("dd/MM/yyyy").format(s);

            String sql = "SELECT * FROM  F_TK_SLTungSanPham('" + new SimpleDateFormat("yyyy/MM/dd").format(s) + "','" + new SimpleDateFormat("yyyy/MM/dd").format(f) + "')";
            ResultSet resultSet = serverProvider.executeQuery(sql);
            ArrayList<MonAn> dsMonAn = new ArrayList<>();
            while (resultSet.next()) {
                MonAn monAn = new MonAn();
                monAn.setMaMonAn(resultSet.getInt("MASP"));
                monAn.setTenMonAn(resultSet.getString("TENSP"));
                monAn.setSoLuong(resultSet.getInt("SOLUONG"));
                dsMonAn.add(monAn);
            }
            return dsMonAn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getIndexMonAn(String maMonAn) {
        try {
            String sql;
            sql = "SELECT * FROM MONAN, LOAIMON WHERE MONAN.MALOAI=LOAIMON.MALOAI";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while (resultSet.next()) {
                if(maMonAn.equals(resultSet.getString("MAMONAN")))
                    return resultSet.getRow()-1;
            }
            provider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
