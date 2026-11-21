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
public class Bai16 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số nguyên dương: ");
        int n = sc.nextInt(), dem = 0, m = n;
        while (n != 0) {
            if (n % 10 % 2 != 0) {
                dem++;
            }
            n = n / 10;
        }
        System.out.println("số lượng các chữ số lẻ của " + m + " là " + dem);
    }
}
