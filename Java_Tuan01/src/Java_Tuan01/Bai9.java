/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Tuan01;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Bai9 {

    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        int sdc, sdm, tien;
        do {
            System.out.print("Nhập số điện cũ: ");
            sdc = nhap.nextInt();
            System.out.print("Nhập số điện mới: ");
            sdm = nhap.nextInt();
        } while (sdc > sdm);
        int t = sdm - sdc;
        if (t <= 50) {
            tien = t * 1480;
        } else if (t <= 100) {
            tien = (t - 50) * 1533 + 50 * 1480;
        } else if (t <= 200) {
            tien = (t - 100) * 1786 + 50 * 1533 + 50 * 1480;
        } else if (t <= 300) {
            tien = (t - 200) * 2242 + 100 * 1786 + 50 * 1533 + 50 * 1480;
        } else {
            tien = (t - 300) * 2503 + 100 * 2242 + 100 * 1786 + 50 * 1533 + 50 * 1480;
        }
        System.out.println("Tiền điện: " + tien);
    }
}
