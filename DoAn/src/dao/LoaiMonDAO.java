/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pojo.LoaiMon;

/**
 *
 * @author DNT
 */
public class LoaiMonDAO {

    public static ArrayList<LoaiMon> loadLoai() {
        ArrayList<LoaiMon> dsLM = new ArrayList<>();
        try {
            String sql = "SELECT * FROM LOAIMON";
            SQLServerProvider provider = new SQLServerProvider();
            provider.open();
            ResultSet resultSet = provider.executeQuery(sql);
            while (resultSet.next()) {
                LoaiMon l = new LoaiMon(resultSet.getInt("MALOAI"), resultSet.getString("TENLOAI"), resultSet.getString("MOTA"));
                dsLM.add(l);
            }
            provider.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsLM;
    }
}
