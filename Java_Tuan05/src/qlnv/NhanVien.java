/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlnv;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class NhanVien {

    private String maSo;
    private String hoTen;
    private Date ngayVL;
    private Date ngaySinh;
    private PhongBan phong;

    public NhanVien() {
    }

    public NhanVien(String maSo, String hoTen, Date ngayVL, Date ngaySinh) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.ngayVL = ngayVL;
        this.ngaySinh = ngaySinh;
    }

    public NhanVien(String maSo, String hoTen, Date ngayVL, Date ngaySinh, PhongBan phong) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.ngayVL = ngayVL;
        this.ngaySinh = ngaySinh;
        this.phong = phong;
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgayVL() {
        return ngayVL;
    }

    public void setNgayVL(Date ngayVL) {
        this.ngayVL = ngayVL;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public PhongBan getPhong() {
        return phong;
    }

    public void setPhong(PhongBan phong) {
        this.phong = phong;
    }

    @Override
    public String toString() {
        return getHoTen();
    }

}
