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
public class Bai7 {

    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        System.out.print("Nhập tháng: ");
        int thang = nhap.nextInt();
        switch (thang) {
            case 1, 3, 5, 7, 8, 10, 12 ->
                System.out.println("Tháng " + thang + " có 31 ngày");
            case 4, 6, 9, 11 ->
                System.out.println("Tháng " + thang + " có 30 ngày");
            case 2 ->
                System.out.println("Tháng " + thang + " có 28 hoặc 29 ngày");
        }
    }
}
