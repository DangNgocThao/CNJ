/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Java_Tuan01;

import java.util.Scanner;

/**
 *
 * @author DNT
 */
public class Bai21 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập h: ");
        int h = sc.nextInt();
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= h + i - 1; j++) {
                if (j == h - i + 1 || j == h + i - 1 || i == h) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}
