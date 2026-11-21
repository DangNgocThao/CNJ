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
public class KhachSan extends BatDongSan implements phiKinhDoanh {

    int soSao;

    public KhachSan() {
    }

    public KhachSan(int soSao) {
        this.soSao = soSao;
    }

    public KhachSan(int soSao, String ma, int dai, int rong) {
        super(ma, dai, rong);
        this.soSao = soSao;
    }

    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số sao: ");
        soSao = sc.nextInt();
    }

    public void xuat() {
        super.xuat();
        System.out.println("Số sao: " + soSao);
        System.out.println("Giá bán: " + giaBan());
        System.out.println("Phí kinh doanh: " + phiKinhDoanh());
    }

    public int giaBan() {
        return 100000 + soSao * 50000 + phiKinhDoanh();
    }

    public int phiKinhDoanh() {
        return rong * 5000;
    }
}
