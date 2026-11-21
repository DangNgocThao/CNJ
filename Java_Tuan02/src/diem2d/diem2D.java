/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diem2d;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class diem2D {

    private int x, y;

    public diem2D() {
        x = y = 0;
    }

    public diem2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void nhapDiem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập x: ");
        x = sc.nextInt();
        System.out.print("Nhập y: ");
        y = sc.nextInt();
    }

    public void hienThi() {
        System.out.println("(" + x + ", " + y + ")");
    }

    public void doiDiem(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public int giaTriX() {
        return x;
    }

    public int giaTriY() {
        return y;
    }

    public float tinhKhoangCach() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public float tinhKhoangCach(diem2D d) {
        return (float) Math.sqrt(Math.pow(x - d.giaTriX(), 2) + Math.pow(y - d.giaTriY(), 2));
    }
}
