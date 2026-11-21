/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Administrator
 */
public class PhongBan {
    private int maPhong;
    private String tenPhong;

    public PhongBan() {
    }

    public PhongBan(int maPhong, String tenPhong) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }
    
}
