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
public class Bai13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương: ");
        int t = sc.nextInt();
        boolean kt = false;
        for (int i = 2; i < t; i++) {
            if (t % i == 0 && i % 2 != 0) {
                if (!kt) {
                    kt = true;
                    System.out.print("Các ước số lẻ của " + t + ": ");
                }
                System.out.print(i + " ");
            }
        }
        System.out.println("");
    }
}
