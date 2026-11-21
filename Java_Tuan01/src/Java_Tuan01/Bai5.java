/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Tuan01;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Bai5 {

    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        int a, b, c;
        System.out.print("Nhap a: ");
        a = nhap.nextInt();
        System.out.print("Nhap b: ");
        b = nhap.nextInt();
        System.out.print("Nhap c: ");
        c = nhap.nextInt();
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("PT có vô số nghiệm");
                } else {
                    System.out.println("PT vô nghiệm");
                }
            } else {
                float x = -c / (float) b;
                System.out.println("PT có 1 nghiệm: " + x);
            }
        } else {
            double d = b * b - 4 * a * c;
            if (d < 0) {
                System.out.println("PT vô nghiệm");
            } else if (d == 0) {
                float x = -b / (a * 2);
                System.out.println("PT có 1 nghiệm kép: " + x);
            } else {
                double x1 = (-b + sqrt(d)) / (2 * a);
                double x2 = (-b - sqrt(d)) / (2 * a);
                System.out.println("PT có 2 nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2);
            }
        }
    }
}
