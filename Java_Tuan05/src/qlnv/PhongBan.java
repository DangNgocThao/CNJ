/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnv;

import java.util.Vector;

/**
 *
 * @author Administrator
 */
public class PhongBan {

    private String maPhong;
    private String tenPhong;
    Vector<NhanVien> dsNV;

    public PhongBan() {
        dsNV = new Vector<NhanVien>();
    }

    public PhongBan(String maPhong, String tenPhong) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        dsNV = new Vector<NhanVien>();
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public Vector<NhanVien> getDsNV() {
        return dsNV;
    }

    public void setDsNV(Vector<NhanVien> dsNV) {
        this.dsNV = dsNV;
    }

    public void themNV(NhanVien nv) {
        this.dsNV.add(nv);
    }

    public void xoaNV(NhanVien nv) {
        this.dsNV.remove(nv);
    }

    @Override
    public String toString() {
        return getTenPhong();
    }

}
