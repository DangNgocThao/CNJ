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
public class NhanVienVP extends NhanVien {

    int soNgay;
    double troCap;

    public NhanVienVP() {
    }

    public NhanVienVP(int soNgay, double troCap) {
        this.soNgay = soNgay;
        this.troCap = troCap;
    }

    public NhanVienVP(int soNgay, double troCap, String hoTen, int nam) {
        super(hoTen, nam);
        this.soNgay = soNgay;
        this.troCap = troCap;
    }

    public void nhapNV() {
        super.nhapNV();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số ngày làm việc: ");
        soNgay = sc.nextInt();
        System.out.print("Nhập trợ cấp: ");
        troCap = sc.nextDouble();
    }

    public void xuatNV() {
        super.xuatNV();
        System.out.println("Số ngày làm việc: " + soNgay);
        System.out.println("Trợ cấp: " + troCap);
        System.out.println("Tiền lương: " + tinhTien());
    }

    public double tinhTien() {
        return super.tinhTien() + soNgay * 100000 + troCap;
    }
}
