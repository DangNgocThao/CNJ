/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

/**
 *
 * @author DNT
 */
public class LoaiMon {

    private int maLoai;
    private String tenLoai;
    private String moTaLoai;

    public LoaiMon() {
    }

    public LoaiMon(int maLoai, String tenLoai, String moTaLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.moTaLoai = moTaLoai;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getMoTaLoai() {
        return moTaLoai;
    }

    public void setMoTaLoai(String moTaLoai) {
        this.moTaLoai = moTaLoai;
    }

    @Override
    public String toString() {
        return getTenLoai();
    }

}
