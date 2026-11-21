/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tamgiac;

import diem2d.diem2D;

/**
 *
 * @author Administrator
 */
public class tamGiac {

    diem2D a, b, c;

    public void setA(diem2D a) {
        this.a = a;
    }

    public void setB(diem2D b) {
        this.b = b;
    }

    public void setC(diem2D c) {
        this.c = c;
    }

    public diem2D getA() {
        return a;
    }

    public diem2D getB() {
        return b;
    }

    public diem2D getC() {
        return c;
    }

    public tamGiac(diem2D a, diem2D b, diem2D c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public tamGiac(tamGiac x) {
        a = x.a;
        b = x.b;
        c = x.c;
    }

    public tamGiac() {
        a = new diem2D();
        b = new diem2D();
        c = new diem2D();
    }

    public void nhap() {
        System.out.println("Nhập điểm A");
        a.nhapDiem();
        System.out.println("Nhập điểm B");
        b.nhapDiem();
        System.out.println("Nhập điểm C");
        c.nhapDiem();
    }

    public void xuat() {
        System.out.println("Điểm A");
        a.hienThi();
        System.out.println("Điểm B");
        b.hienThi();
        System.out.println("Điểm C");
        c.hienThi();
    }

    public float dienTich() {
        float p = chuVi() / 2;
        return (float) Math.sqrt(p * (p - a.tinhKhoangCach(b)) * (p - b.tinhKhoangCach(c)) * (p - c.tinhKhoangCach(a)));
    }

    public float chuVi() {
        return a.tinhKhoangCach(b) + b.tinhKhoangCach(c) + c.tinhKhoangCach(a);
    }
}
