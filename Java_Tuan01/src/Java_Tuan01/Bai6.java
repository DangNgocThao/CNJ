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
public class Bai6 {

    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhập năm: ");
        int nam = nhap.nextInt();
        if (nam % 400 == 0 || (nam % 4 == 0 && nam % 100 != 0)) {
            System.out.println("Năm " + nam + " là năm nhuận");
        } else {
            System.out.println("Năm " + nam + " không là năm nhuận");
        }
    }
}
