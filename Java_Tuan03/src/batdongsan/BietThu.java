/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batdongsan;

/**
 *
 * @author DNT
 */
public class BietThu extends BatDongSan implements phiKinhDoanh {

    public BietThu() {
    }

    public BietThu(String ma, int dai, int rong) {
        super(ma, dai, rong);
    }

    public int giaBan() {
        return dienTich() * 400000 + phiKinhDoanh();
    }

    public void nhap() {
        super.nhap();
    }

    public void xuat() {
        super.xuat();
        System.out.println("Giá bán: " + giaBan());
        System.out.println("Phí kinh doanh: " + phiKinhDoanh());
    }

    public int phiKinhDoanh() {
        return dienTich() * 1000;
    }
}
