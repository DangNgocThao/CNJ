/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batdongsan;

/**
 *
 * @author DNT
 */
public class DatTrong extends BatDongSan {

    public DatTrong() {
    }

    public DatTrong(String ma, int dai, int rong) {
        super(ma, dai, rong);
    }

    public int giaBan() {
        return dienTich() * 10000;
    }

    public void nhap() {
        super.nhap();
    }

    public void xuat() {
        super.xuat();
        System.out.println("Giá bán: " + giaBan());
    }
}
