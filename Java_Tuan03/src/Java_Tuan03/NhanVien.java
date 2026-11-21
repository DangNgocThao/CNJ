/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Tuan03;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class NhanVien {

    protected String hoTen;
    protected int nam;
    public static double LCB = 1490000;

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public NhanVien() {
        hoTen = "";
        nam = 0;
    }

    public NhanVien(String hoTen, int nam) {
        this.hoTen = hoTen;
        this.nam = nam;
    }

    public void nhapNV() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập họ tên nhân viên: ");
        hoTen = sc.nextLine();
        System.out.print("Nhập năm vào làm nhân viên: ");
        nam = sc.nextInt();
    }

    public void xuatNV() {
        System.out.println("Họ tên nhân viên: " + hoTen);
        System.out.println("Năm vào làm nhân viên: " + nam);
    }

    public double tinhTien() {
        return this.LCB;
    }
}
