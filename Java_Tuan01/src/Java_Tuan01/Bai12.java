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
public class Bai12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương: ");
        int t = sc.nextInt(), dem = 0;
        for (int i = 2; i < t; i++) {
            if (t % i == 0) {
                dem++;
            }
        }
        System.out.println("số lượng các ước số của số " + t + " là " + dem);
    }
}
