package Java_Tuan01;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class Bai3 {

    public static void main(String[] args) {
        Scanner nhap = new Scanner(System.in);
        int a, b;
        System.out.print("Nhap a: ");
        a = nhap.nextInt();
        System.out.print("Nhap b: ");
        b = nhap.nextInt();
        if (b > a) {
            System.out.println("số nhỏ hơn: " + a + " và số lớn hơn: " + b);
        } else {
            System.out.println("số nhỏ hơn: " + b + " và số lớn hơn: " + a);
        }
    }
}
