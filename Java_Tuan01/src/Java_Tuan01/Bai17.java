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
public class Bai17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, tong = 0;
        System.out.println("Nhập số nguyên dương n: ");
        n = sc.nextInt();
        while (n != 0) {
            int schan = n % 10;
            if (schan % 2 == 0) {
                tong += schan;
            }
        }
        System.out.println("Tống số lượng chữ số chẵn là: " + tong);
    }
}
