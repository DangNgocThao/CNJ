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
public class Bai11 {

    public static int layNgay(int thang, int nam) {
        switch (thang) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return 31;
            }
            case 4, 6, 9, 11 -> {
                return 30;
            }
            case 2 -> {
                if (nam % 400 == 0 || (nam % 4 == 0 && nam % 100 != 0)) {
                    return 29;
                } else {
                    return 28;
                }
            }
        }
        return 0;
    }

    public static void tangNgay(int ngay, int thang, int nam) {
        int ngayCuaThang = layNgay(thang, nam);
        ngay++;
        if (ngay > ngayCuaThang) {
            ngay = 1;
            thang++;
            if (thang > 12) {
                nam++;
                thang = 1;
            }
        }

        System.out.println("Ngày đã tăng: " + ngay + "/" + thang + "/" + nam);
    }

    public static void giamNgay(int ngay, int thang, int nam) {
        ngay--;
        if (ngay < 1) {
            thang--;
            if (thang < 1) {
                thang = 12;
                nam--;
            }
            ngay = layNgay(thang, nam);
        }
        System.out.println("Ngày đã giam: " + ngay + "/" + thang + "/" + nam);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ngày: ");
        int ngay = sc.nextInt();
        System.out.print("Nhập tháng: ");
        int thang = sc.nextInt();
        System.out.print("Nhập năm: ");
        int nam = sc.nextInt();
        tangNgay(ngay, thang, nam);
        giamNgay(ngay, thang, nam);
    }
}
