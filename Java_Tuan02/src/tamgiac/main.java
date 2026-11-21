/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tamgiac;

/**
 *
 * @author Administrator
 */
public class main {

    public static void main(String[] args) {
        tamGiac tg = new tamGiac();
        tg.nhap();
        tg.xuat();
        System.out.println("Diện tích: " + tg.dienTich());
        System.out.println("Chu vi: " + tg.chuVi());
    }
}
