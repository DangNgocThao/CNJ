/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Tuan03;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class main {

    public static void main(String[] args) {
//        int nvp, nsx, nql;
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhập số nhân viên văn phòng: ");
//        nvp = sc.nextInt();
//        System.out.print("Nhập số nhân viên sản xuất: ");
//        nsx = sc.nextInt();
//        System.out.print("Nhập số nhân viên quản lý: ");
//        nql = sc.nextInt();
        CongTy ct = new CongTy();
        ct.docFile();
        ct.xuatNV();
        ct.ghiFile();
    }
}
