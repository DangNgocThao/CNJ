/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import pojo.BanAn;

/**
 *
 * @author jamas008
 */
public class BanAnDAO {

//    public static ResultSet loadBanAn() {
//        try {
//            SQLServerProvider serverProvider = new SQLServerProvider();
//            serverProvider.open();
//            String sql = "select * from BANAN";
//            ResultSet resultSet = serverProvider.executeQuery(sql);
//            return resultSet;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    public static ArrayList loadBanAn() {
        try {
            ArrayList<BanAn> list = new ArrayList<>();
            SQLServerProvider serverProvider = new SQLServerProvider();
            serverProvider.open();
            String sql = "select * from BANAN";
            ResultSet resultSet = serverProvider.executeQuery(sql);
            while (resultSet.next()) {
                BanAn x = new BanAn();
                x.setMaBan(resultSet.getString("MABAN"));
                x.setTenBan(resultSet.getString("TENBAN"));
                list.add(x);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
