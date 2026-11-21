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
public class Bai14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương: ");
        int n = sc.nextInt();
        if (n < 2) {
            System.out.println(n + " không phải số nguyên tố");
        }
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                System.out.println(n + " không phải số nguyên tố");
                return;
            }
        }
        System.out.println(n + " là số nguyên tố");
    }
}
