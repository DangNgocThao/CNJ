/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package batdongsan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author DNT
 */
public class CongTy {
    
    int ndt, nno, nbt, nks;
    ArrayList<DatTrong> dsdt;
    ArrayList<NhaO> dsno;
    ArrayList<KhachSan> dsks;
    ArrayList<BietThu> dsbt;
    
    public CongTy() {
        dsdt = new ArrayList<>();
        dsno = new ArrayList<>();
        dsks = new ArrayList<>();
        dsbt = new ArrayList<>();
    }
    
    public CongTy(int ndt, int nno, int nbt, int nks) {
        this.ndt = ndt;
        this.nno = nno;
        this.nbt = nbt;
        this.nks = nks;
        dsdt = new ArrayList<>();
        dsno = new ArrayList<>();
        dsks = new ArrayList<>();
        dsbt = new ArrayList<>();
    }
    
    public void nhap() {
        System.out.println("---------------------");
        System.out.println("Nhập thông tin đất trống");
        for (int i = 0; i < ndt; i++) {
            System.out.println("---------------------");
            System.out.println("Nhập đất trống " + (i + 1));
            DatTrong dt = new DatTrong();
            dt.nhap();
            dsdt.add(dt);
        }
        
        System.out.println("---------------------");
        System.out.println("Nhập thông tin nhà ở");
        for (int i = 0; i < nno; i++) {
            System.out.println("---------------------");
            System.out.println("Nhập nhà ở " + (i + 1));
            NhaO no = new NhaO();
            no.nhap();
            dsno.add(no);
        }
        
        System.out.println("---------------------");
        System.out.println("Nhập thông tin biệt thự");
        for (int i = 0; i < nbt; i++) {
            System.out.println("---------------------");
            System.out.println("Nhập biệt thự " + (i + 1));
            BietThu bt = new BietThu();
            bt.nhap();
            dsbt.add(bt);
        }
        
        System.out.println("---------------------");
        System.out.println("Nhập thông tin khách sạn");
        for (int i = 0; i < nks; i++) {
            System.out.println("---------------------");
            System.out.println("Nhập khách sạn " + (i + 1));
            KhachSan ks = new KhachSan();
            ks.nhap();
            dsks.add(ks);
        }
    }
    
    public void xuat() {
        double tdt = 0, tno = 0, tbt = 0, tks = 0;
        
        System.out.println("---------------------");
        System.out.println("Danh sách đất trồng");
        for (DatTrong item : dsdt) {
            System.out.println("---------------------");
            item.xuat();
            tdt += item.giaBan();
        }
        System.out.println("---------------------");
        System.out.println("Tổng giá bán: " + tdt);
        System.out.println("---------------------");
        
        System.out.println("Danh sách nhà ở");
        for (NhaO item : dsno) {
            System.out.println("---------------------");
            item.xuat();
            tno += item.giaBan();
        }
        System.out.println("---------------------");
        System.out.println("Tổng giá bán: " + tno);
        System.out.println("---------------------");
        
        System.out.println("Danh sách biệt thự");
        for (BietThu item : dsbt) {
            System.out.println("---------------------");
            item.xuat();
            tbt += item.giaBan();
        }
        System.out.println("---------------------");
        System.out.println("Tổng giá bán: " + tbt);
        System.out.println("---------------------");
        
        System.out.println("Danh sách khách sạn");
        for (KhachSan item : dsks) {
            System.out.println("---------------------");
            item.xuat();
            tks += item.giaBan();
        }
        System.out.println("---------------------");
        System.out.println("Tổng giá bán: " + tks);
        System.out.println("---------------------");
        
        System.out.println("Tổng giá bán 4 loại bất động sản: " + (tdt + tno + tbt + tks));
    }
    
    public void docFile() {
        try {
            FileReader fr = new FileReader("src\\batdongsan\\BDS.txt");
            BufferedReader br = new BufferedReader(fr);
            String[] str;
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                str = line.split(", ");
                
                if (str[0].startsWith("DT")) {
                    DatTrong a = new DatTrong(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]));
                    dsdt.add(a);
                } else if (str[0].startsWith("NO")) {
                    NhaO a = new NhaO(Integer.parseInt(str[3]), str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]));
                    dsno.add(a);
                } else if (str[0].startsWith("BT")) {
                    BietThu a = new BietThu(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]));
                    dsbt.add(a);
                } else {
                    KhachSan a = new KhachSan(Integer.parseInt(str[3]), str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]));
                    dsks.add(a);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }
    }
    
    public void ghiFile() {
        try {
            FileWriter fr = new FileWriter("src\\batdongsan\\ghiBDS.txt");
            BufferedWriter bw = new BufferedWriter(fr);
            
            bw.write("Danh sách đất trồng\n\n");
            for (DatTrong item : dsdt) {
                bw.write("Mã số: " + item.ma + "\n");
                bw.write("Chiều dài: " + item.dai + "\n");
                bw.write("Chiều rộng: " + item.rong + "\n");
                bw.write("Giá bán: " + item.giaBan() + "\n");
            }
            bw.write("\n");
            
            bw.write("Danh sách nhà ở\n\n");
            for (NhaO item : dsno) {
                bw.write("Mã số: " + item.ma + "\n");
                bw.write("Chiều dài: " + item.dai + "\n");
                bw.write("Chiều rộng: " + item.rong + "\n");
                bw.write("Số lầu: " + item.soLau + "\n");
                bw.write("Giá bán: " + item.giaBan() + "\n");
            }
            bw.write("\n");
            
            bw.write("Danh sách biệt thự\n\n");
            for (BietThu item : dsbt) {
                bw.write("Mã số: " + item.ma + "\n");
                bw.write("Chiều dài: " + item.dai + "\n");
                bw.write("Chiều rộng: " + item.rong + "\n");
                bw.write("Giá bán: " + item.giaBan() + "\n");
                bw.write("Phí kinh doanh: " + item.phiKinhDoanh() + "\n");
            }
            bw.write("\n");
            
            bw.write("Danh sách khách sạn\n\n");
            for (KhachSan item : dsks) {
                bw.write("Mã số: " + item.ma + "\n");
                bw.write("Chiều dài: " + item.dai + "\n");
                bw.write("Chiều rộng: " + item.rong + "\n");
                bw.write("Số sao: " + item.soSao + "\n");
                bw.write("Giá bán: " + item.giaBan() + "\n");
                bw.write("Phí kinh doanh: " + item.phiKinhDoanh() + "\n");
            }
            
            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
