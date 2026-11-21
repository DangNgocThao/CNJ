/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import pojo.PhieuGoiMon;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jamas008
 */
public class PhieuGoiMonDAO {

    public static ArrayList<PhieuGoiMon> getPhieuGoiMonByMaBan(String maBan) {
        try {
            String sql = "select * from PHIEUGOIMON P,MONAN M where MABAN='" + maBan + "' AND P.MAMONAN=M.MAMONAN";
            SQLServerProvider serverProvider = new SQLServerProvider();
            serverProvider.open();
            ResultSet resultSet = serverProvider.executeQuery(sql);
            ArrayList<PhieuGoiMon> dsPhieu = new ArrayList<>();
            while (resultSet.next()) {
                PhieuGoiMon phieuGoiMon = new PhieuGoiMon();
                //phieuGoiMon.setMaBan();
                phieuGoiMon.setMaMonAn(resultSet.getInt("MAMONAN"));
                //phieuGoiMon.setMaNhanVien(maBan);
                phieuGoiMon.setSoLuong(resultSet.getInt("SOLUONG"));
                phieuGoiMon.setTenMonAn(resultSet.getString("TENMONAN"));
                phieuGoiMon.setDonGia(Float.parseFloat(resultSet.getString("DONGIA")));
                dsPhieu.add(phieuGoiMon);
            }
            return dsPhieu;
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean themPhieuGoiMon(PhieuGoiMon x) {
        try {
            SQLServerProvider serverProvider = new SQLServerProvider();
            serverProvider.open();
            String sql = "insert PHIEUGOIMON(MABAN,MAMONAN,SOLUONG,MANV) values('" + x.getMaBan() + "','" + x.getMaMonAn() + "','" + x.getSoLuong() + "','" + x.getMaNhanVien() + "');";
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

    public static boolean updatePhieuGoiMon(PhieuGoiMon x) {
        try {
            SQLServerProvider serverProvider = new SQLServerProvider();
            serverProvider.open();
            String sql = "update PHIEUGOIMON SET SOLUONG='" + x.getSoLuong() + "' WHERE MAMONAN='" + x.getMaMonAn() + "' AND MABAN='" + x.getMaBan() + "'";
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

    public static boolean xoaPhieuGoiMon(PhieuGoiMon x) {
        try {
            SQLServerProvider serverProvider = new SQLServerProvider();
            String sql = "delete from PHIEUGOIMON WHERE MABAN= '" + x.getMaBan() + "' AND MAMONAN= '" + x.getMaMonAn() + "'";
            serverProvider.open();
            boolean kq = serverProvider.executeUpdate(sql);
            serverProvider.close();
            return kq;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteAllPhieuGoiMonByMaBan(String maBan) {
        try {
            SQLServerProvider serverProvider = new SQLServerProvider();
            serverProvider.open();
            //DISABLE TRIGGER DELETE PHIEUMONAN
            String sqlCallDisable="{call disableTrigger}";
            boolean kq= serverProvider.excuteCallable(sqlCallDisable);
            
            String sqlDeletePhieuGoiMon = "delete from PHIEUGOIMON where MABAN='" + maBan + "'";
            kq = serverProvider.executeUpdate(sqlDeletePhieuGoiMon);
            
             //ENABLE TRIGGER DELETE PHIEUMONAN
            String sqlCallEnable="{call enableTrigger}";
            kq= serverProvider.excuteCallable(sqlCallEnable);
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int findFootQuantityInPhieuGoiMon(PhieuGoiMon x) {
        //TÌM SỐ LƯỢNG MÓN ĂN MÀ BÀN ĐÓ ĐÃ GỌI (TÌM SỐ LƯỢNG MÓN ĂN ĐÓ TRONG PHIẾU GỌI MÓN)
        try {
            SQLServerProvider serverProvider = new SQLServerProvider();
            String sql = "select * from PHIEUGOIMON where MABAN='" + x.getMaBan() + "' and MAMONAN='" + x.getMaMonAn() + "'";
            serverProvider.open();
            ResultSet resultSet = serverProvider.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getInt("SOLUONG");
            }
            serverProvider.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return -1;
    }

    public static boolean checkBanAnHasChecked(String maBan) {
        //KIỂM TRA BÀN ĂN CÓ GỌI MÓN HAY CHƯA (KIỂM TRA PHIẾU GỌI MÓN)
        try {
            String sql = "select * from PHIEUGOIMON where MABAN='" + maBan + "'";
            SQLServerProvider serverProvider = new SQLServerProvider();
            serverProvider.open();
            ResultSet rs = serverProvider.executeQuery(sql);
            if (rs.next()) {
                serverProvider.close();
                return true;
            }
            serverProvider.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }
}
