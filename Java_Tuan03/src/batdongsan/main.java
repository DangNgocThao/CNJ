/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batdongsan;

import java.util.Scanner;

/**
 *
 * @author DNT
 */
public class main {

    public static void main(String[] args) {
//        int ndt,nno,nbt,nks;
//        Scanner sc=new Scanner(System.in);
//        System.out.print("Nhập số đất trống: ");
//        ndt=sc.nextInt();
//        System.out.print("Nhập số nhà ở: ");
//        nno=sc.nextInt();
//        System.out.print("Nhập số biệt thự: ");
//        nbt=sc.nextInt();
//        System.out.print("Nhập số khách sạn: ");
//        nks=sc.nextInt();
//        CongTy ct=new CongTy(ndt,nno,nbt,nks);
        CongTy ct = new CongTy();
        ct.docFile();
        ct.xuat();
        ct.ghiFile();
    }
}
