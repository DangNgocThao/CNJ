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
public class Bai15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n, tong = 0;
        do {
            System.out.print("Nhập số thực: ");
            n = Double.parseDouble(sc.nextLine());
            tong += n;
        } while (n != 0);
        System.out.println("tổng các số đã nhập: " + tong);
    }
}
