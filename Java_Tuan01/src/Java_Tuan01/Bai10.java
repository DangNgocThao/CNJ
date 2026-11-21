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
public class Bai10 {

    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        int d, m, y;
        System.out.print("Nhập ngày: ");
        d = nhap.nextInt();
        System.out.print("Nhập tháng: ");
        m = nhap.nextInt();
        System.out.print("Nhập năm: ");
        y = nhap.nextInt();
        if (y < 0) {
            System.out.println("Năm không hợp lệ");
            return;
        }
        if (m > 12 || m < 1) {
            System.out.println("Tháng không hợp lệ");
            return;
        }
        switch (m) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                if (d > 31 || d < 1) {
                    System.out.println("Ngày không hợp lệ");
                    return;
                } else {
                    System.out.println("Ngày hợp lệ");
                }
            }
            case 4, 6, 9, 11 -> {
                if (d > 30 || d < 1) {
                    System.out.println("Ngày không hợp lệ");
                    return;
                } else {
                    System.out.println("Ngày hợp lệ");
                }
            }
            case 2 -> {
                if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
                    if (d > 29 || d < 1) {
                        System.out.println("Ngày không hợp lệ");
                        return;
                    } else {
                        System.out.println("Ngày hợp lệ");
                    }
                } else if (d > 28 || d < 1) {
                    System.out.println("Ngày không hợp lệ");
                    return;
                } else {
                    System.out.println("Ngày hợp lệ");
                }
            }
            default -> {
            }
        }
    }
}
