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
public class NhanVienQL extends NhanVien {

    int heSoCV;
    double thuong;

    public NhanVienQL() {
    }

    public NhanVienQL(int heSoCV, double thuong) {
        this.heSoCV = heSoCV;
        this.thuong = thuong;
    }

    public NhanVienQL(int heSoCV, double thuong, String hoTen, int nam) {
        super(hoTen, nam);
        this.heSoCV = heSoCV;
        this.thuong = thuong;
    }

    public void nhapNV() {
        super.nhapNV();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập hệ số chức vụ: ");
        heSoCV = sc.nextInt();
        System.out.print("Nhập thưởng: ");
        thuong = sc.nextDouble();
    }

    public void xuatNV() {
        super.xuatNV();
        System.out.println("Hệ số chức vụ: " + heSoCV);
        System.out.println("Thưởng: " + thuong);
        System.out.println("Tiền lương: " + tinhTien());
    }

    public double tinhTien() {
        return super.tinhTien() * heSoCV + thuong;
    }
}
