/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Tuan03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class CongTy {

    int nVP, nSX, nQL;
    ArrayList<NhanVienVP> dsVP;
    ArrayList<NhanVienSX> dsSX;
    ArrayList<NhanVienQL> dsQL;

    public CongTy() {
        dsVP = new ArrayList<>();
        dsSX = new ArrayList<>();
        dsQL = new ArrayList<>();
    }

    public CongTy(int nVP, int nSX, int nQL) {
        this.nVP = nVP;
        this.nSX = nSX;
        this.nQL = nQL;
        dsVP = new ArrayList<>();
        dsSX = new ArrayList<>();
        dsQL = new ArrayList<>();
    }

    public void nhapNV() {
        System.out.println("---------------------");
        System.out.println("Nhập nhân viên văn phòng");
        for (int i = 0; i < nVP; i++) {
            System.out.println("---------------------");
            System.out.println("Nhập nhân viên " + (i + 1));
            NhanVienVP vp = new NhanVienVP();
            vp.nhapNV();
            dsVP.add(vp);
        }

        System.out.println("---------------------");
        System.out.println("Nhập nhân viên sản xuất");
        for (int i = 0; i < nSX; i++) {
            System.out.println("---------------------");
            System.out.println("Nhập nhân viên " + (i + 1));
            NhanVienSX sx = new NhanVienSX();
            sx.nhapNV();
            dsSX.add(sx);
        }

        System.out.println("---------------------");
        System.out.println("Nhập nhân viên quản lý");
        for (int i = 0; i < nQL; i++) {
            System.out.println("---------------------");
            System.out.println("Nhập nhân viên " + (i + 1));
            NhanVienQL ql = new NhanVienQL();
            ql.nhapNV();
            dsQL.add(ql);
        }
    }

    public void xuatNV() {
        double tVP = 0, tSX = 0, tQL = 0;

        System.out.println("---------------------");
        System.out.println("Danh sách nhân viên văn phòng");
        for (NhanVienVP item : dsVP) {
            System.out.println("---------------------");
            item.xuatNV();
            tVP += item.tinhTien();
        }
        System.out.println("---------------------");
        System.out.println("Tổng tiền lương: " + tVP);
        System.out.println("---------------------");

        System.out.println("Danh sách nhân viên sản xuất");
        for (NhanVienSX item : dsSX) {
            System.out.println("---------------------");
            item.xuatNV();
            tSX += item.tinhTien();
        }
        System.out.println("---------------------");
        System.out.println("Tổng tiền lương: " + tSX);
        System.out.println("---------------------");

        System.out.println("Danh sách nhân viên quản lý");
        for (NhanVienQL item : dsQL) {
            System.out.println("---------------------");
            item.xuatNV();
            tQL += item.tinhTien();
        }
        System.out.println("---------------------");
        System.out.println("Tổng tiền lương: " + tQL);
        System.out.println("---------------------");

        System.out.println("Tổng lương 3 loại nhân viên: " + (tVP + tSX + tQL));
    }

    public void docFile() {
        try {
            FileReader fr = new FileReader("src\\Java_Tuan03\\NV.txt");
            BufferedReader br = new BufferedReader(fr);
            String[] s;
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                s = line.split(", ");

                if (s[0].startsWith("VP")) {
                    NhanVienVP a = new NhanVienVP(Integer.parseInt(s[3]), Double.parseDouble(s[4]), s[1], Integer.parseInt(s[2]));
                    dsVP.add(a);
                } else if (s[0].startsWith("SX")) {
                    NhanVienSX a = new NhanVienSX(Integer.parseInt(s[3]), s[1], Integer.parseInt(s[2]));
                    dsSX.add(a);
                } else {
                    NhanVienQL a = new NhanVienQL(Integer.parseInt(s[3]), Double.parseDouble(s[4]), s[1], Integer.parseInt(s[2]));
                    dsQL.add(a);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }
    }

    public void ghiFile() {
        try {
            FileWriter fr = new FileWriter("src\\Java_Tuan03\\ghiNV.txt");
            BufferedWriter bw = new BufferedWriter(fr);

            bw.write("Danh sách nhân viên văn phòng\n\n");
            for (NhanVienVP item : dsVP) {
                bw.write("Họ tên nhân viên: " + item.hoTen + "\n");
                bw.write("Năm vào làm nhân viên: " + item.nam + "\n");
                bw.write("Số ngày làm việc: " + item.soNgay + "\n");
                bw.write("Trợ cấp: " + item.troCap + "\n");
                bw.write("Tiền lương: " + item.tinhTien() + "\n");
            }
            bw.write("\n");

            bw.write("Danh sách nhân viên sản xuất\n\n");
            for (NhanVienSX item : dsSX) {
                bw.write("Họ tên nhân viên: " + item.hoTen + "\n");
                bw.write("Năm vào làm nhân viên: " + item.nam + "\n");
                bw.write("Số sản phẩm: " + item.soSP + "\n");
                bw.write("Tiền lương: " + item.tinhTien() + "\n");
            }
            bw.write("\n");

            bw.write("Danh sách nhân viên quản lý\n\n");
            for (NhanVienQL item : dsQL) {
                bw.write("Họ tên nhân viên: " + item.hoTen + "\n");
                bw.write("Năm vào làm nhân viên: " + item.nam + "\n");
                bw.write("Hệ số chức vụ: " + item.heSoCV + "\n");
                bw.write("Thưởng: " + item.thuong + "\n");
                bw.write("Tiền lương: " + item.tinhTien() + "\n");
            }

            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
