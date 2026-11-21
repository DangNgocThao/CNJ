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
public class BatDongSan {

    protected String ma;
    protected int dai, rong;

    public BatDongSan() {
        ma = "";
        dai = rong = 0;
    }

    public BatDongSan(String ma, int dai, int rong) {
        this.ma = ma;
        this.dai = dai;
        this.rong = rong;
    }

    public int dienTich() {
        return dai * rong;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã số: ");
        ma = sc.nextLine();
        System.out.print("Nhập chiều dài: ");
        dai = sc.nextInt();
        System.out.print("Nhập chiều rộng: ");
        rong = sc.nextInt();
    }

    public void xuat() {
        System.out.println("Mã số: " + ma);
        System.out.println("Chiều dài: " + dai);
        System.out.println("Chiều rộng: " + rong);
    }
}
