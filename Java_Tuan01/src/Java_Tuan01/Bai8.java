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
public class Bai8 {

    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhập điểm: ");
        double diem = Double.parseDouble(nhap.nextLine());
        if (diem >= 8.5) {
            System.out.println("A");
        } else if (diem >= 7) {
            System.out.println("B");
        } else if (diem >= 5.5) {
            System.out.println("C");
        } else if (diem >= 4) {
            System.out.println("D");
        } else {
            System.out.println("E");
        }
    }
}
