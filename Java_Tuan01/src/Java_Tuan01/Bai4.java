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
public class Bai4 {

    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        int a, b, c, max, min;
        System.out.print("Nhap a: ");
        a = nhap.nextInt();
        System.out.print("Nhap b: ");
        b = nhap.nextInt();
        System.out.print("Nhap c: ");
        c = nhap.nextInt();
        if (a > b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }
        if (max < c) {
            max = c;
        }
        if (min > c) {
            min = c;
        }
        System.out.println("số nhỏ hơn: " + min + " và số lớn hơn: " + max);
    }
}
