/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

/**
 *
 * @author jamas008
 */
public class PhieuGoiMon {

    private int maMonAn;
    private int maBan;
    private String maNhanVien;
    private int soLuong;
    private String tenMonAn;
    private float donGia;

    public PhieuGoiMon() {
    }

    public PhieuGoiMon(int maMonAn, int maBan, String maNhanVien, int soLuong) {
        this.maMonAn = maMonAn;
        this.maBan = maBan;
        this.maNhanVien = maNhanVien;
        this.soLuong = soLuong;
    }

    public PhieuGoiMon(int maMonAn, int maBan) {
        this.maMonAn = maMonAn;
        this.maBan = maBan;
    }

    public int getMaMonAn() {
        return maMonAn;
    }

    public void setMaMonAn(int maMonAn) {
        this.maMonAn = maMonAn;
    }

    public int getMaBan() {
        return maBan;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

}
