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
public class NhanVienSX extends NhanVien {

    int soSP;

    public NhanVienSX() {
    }

    public NhanVienSX(int soSP) {
        this.soSP = soSP;
    }

    public NhanVienSX(int soSP, String hoTen, int nam) {
        super(hoTen, nam);
        this.soSP = soSP;
    }

    public void nhapNV() {
        super.nhapNV();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số sản phẩm: ");
        soSP = sc.nextInt();
    }

    public void xuatNV() {
        super.xuatNV();
        System.out.println("Số sản phẩm: " + soSP);
        System.out.println("Tiền lương: " + tinhTien());
    }

    public double tinhTien() {
        return super.tinhTien() + soSP * 2000;
    }
}
