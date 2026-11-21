/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diem2d;

/**
 *
 * @author Administrator
 */
public class main {

    public static void main(String[] args) {
        diem2D a = new diem2D(3, 4);
        a.hienThi();
        diem2D b = new diem2D();
        b.nhapDiem();
        b.hienThi();
        diem2D c = new diem2D(-b.giaTriX(), -b.giaTriY());
        c.hienThi();
        System.out.println("Khoảng cách từ B đến gốc tọa độ: " + b.tinhKhoangCach());
        System.out.println("Khoảng cách từ A đến B: " + a.tinhKhoangCach(b));
    }

}
