/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batdongsan;

import java.util.Scanner;

/**
 *
 * @author DNT
 */
public class NhaO extends BatDongSan {

    int soLau;

    public NhaO() {
    }

    public NhaO(int soLau) {
        this.soLau = soLau;
    }

    public NhaO(int soLau, String ma, int dai, int rong) {
        super(ma, dai, rong);
        this.soLau = soLau;
    }

    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lầu: ");
        soLau = sc.nextInt();
    }

    public void xuat() {
        super.xuat();
        System.out.println("Số lầu: " + soLau);
        System.out.println("Giá bán: " + giaBan());
    }

    public int giaBan() {
        return dienTich() * 10000 + soLau * 100000;
    }
}
