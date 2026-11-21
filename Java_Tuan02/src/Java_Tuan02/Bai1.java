/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_Tuan02;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Bai1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, a[], cn;
        System.out.print("Nhập n: ");
        n = sc.nextInt();
        a = new int[n];
        do {
            menu();
            System.out.print("Chọn chức năng: ");
            cn = sc.nextInt();
            switch (cn) {
                case 0:
                    System.exit(0);
                case 1: {
                    nhapMang(a, n);
                    break;
                }
                case 2: {
                    xuatMang(a, n);
                    break;
                }
                case 3: {
                    xuatAm(a, n);
                    break;
                }
                case 4: {
                    xuatSNT(a, n);
                    break;
                }
                case 5: {
                    int b, c;
                    do {
                        System.out.print("Nhập a: ");
                        b = sc.nextInt();
                        System.out.print("Nhập b: ");
                        c = sc.nextInt();
                    } while (b > c);
                    xuatDoanAB(a, n, b, c);
                    break;
                }
                case 6: {
                    System.out.println("Tổng giá trị các phần tử là số nguyên tố: " + tongSNT(a, n));
                    break;
                }
                case 7: {
                    System.out.println("Trung bình cộng của các phần tử dương có trong mảng: " + tbDuong(a, n));
                    break;
                }
                case 8: {
                    int x;
                    System.out.print("Nhập x: ");
                    x = sc.nextInt();
                    System.out.println("Số phần tử có giá trị lớn hơn " + x + ": " + demSoLonHonX(a, n, x));
                    break;
                }
                case 9: {
                    System.out.println("Số phần tử có giá trị là số nguyên tố trong mảng: " + demSNT(a, n));
                    break;
                }
                case 10: {
                    ktMangToanSNT(a, n);
                    break;
                }
                case 11: {
                    ktMangTang(a, n);
                    break;
                }
                case 12: {
                    maxMang(a, n);
                    break;
                }
                case 13: {
                    minMang(a, n);
                    break;
                }
                case 14: {
                    amMaxMang(a, n);
                    break;
                }
                case 15: {
                    DaoMang(a, n);
                    xuatMang(a, n);
                    break;
                }
                default:
                    System.out.println("Chưa làm");
                    break;
            }
        } while (true);
    }

    public static void menu() {
        System.out.println("Menu");
        System.out.println("0.Thoát");
        System.out.println("1.Nhập giá trị cho n phần tử mảng từ bàn phím");
        System.out.println("2.Xuất mảng ra màn hình");
        System.out.println("3.Liệt kê các giá trị âm có trong mảng");
        System.out.println("4.Liệt kê các số nguyên tố có trong mảng");
        System.out.println("5.Liệt kê các phần tử có giá trị nằm trong đoạn [a, b] cho trước");
        System.out.println("6.Tính tổng giá trị các phần tử là số nguyên tố");
        System.out.println("7.Tính trung bình cộng của các phần tử dương có trong mảng");
        System.out.println("8.Đếm số phần tử có giá trị lớn hơn x cho trước");
        System.out.println("9.Đếm số phần tử có giá trị là số nguyên tố trong mảng");
        System.out.println("10.Kiểm tra mảng có phải là mảng chứa toàn số nguyên tố");
        System.out.println("11.Kiểm tra mảng có phải là mảng tăng dần");
        System.out.println("12.Tìm giá trị lớn nhất trong mảng");
        System.out.println("13.Tìm giá trị nhỏ nhất trong mảng");
        System.out.println("14.Tìm số âm lớn nhất trong mảng");
        System.out.println("15.Đảo ngược mảng.");
    }

    public static void nhapMang(int a[], int n) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập a[" + i + "]: ");
            a[i] = sc.nextInt();
        }
    }

    public static void xuatMang(int a[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println("");
    }

    public static void xuatAm(int a[], int n) {
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                System.out.print(a[i] + "\t");
            }
        }
        System.out.println("");
    }

    public static boolean ktSNT(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void xuatSNT(int a[], int n) {
        for (int i = 0; i < n; i++) {
            if (ktSNT(a[i])) {
                System.out.print(a[i] + "\t");
            }
        }
        System.out.println("");
    }

    public static void xuatDoanAB(int a[], int n, int b, int c) {
        for (int i = 0; i < n; i++) {
            if (a[i] >= b && a[i] <= c) {
                System.out.print(a[i] + "\t");
            }
        }
        System.out.println("");
    }

    public static int tongSNT(int a[], int n) {
        int tong = 0;
        for (int i = 0; i < n; i++) {
            if (ktSNT(a[i])) {
                tong += a[i];
            }
        }
        return tong;
    }

    public static int tbDuong(int a[], int n) {
        int t = 0, d = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                t += a[i];
                d++;
            }
        }
        if (d == 0) {
            return 0;
        }
        return t / d;
    }

    public static int demSoLonHonX(int a[], int n, int x) {
        int d = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > x) {
                d++;
            }
        }
        return d;
    }

    public static int demSNT(int a[], int n) {
        int d = 0;
        for (int i = 0; i < n; i++) {
            if (ktSNT(a[i])) {
                d++;
            }
        }
        return d;
    }

    public static void ktMangToanSNT(int a[], int n) {
        for (int i = 0; i < n; i++) {
            if (ktSNT(a[i]) == false) {
                System.out.println("Mảng không toàn số nguyên tố");
                return;
            }
        }
        System.out.println("Mảng toàn số nguyên tố");
    }

    public static void ktMangTang(int a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                System.out.println("Mảng không tăng dần");
                return;
            }
        }
        System.out.println("Mảng tăng dần");
    }

    public static void maxMang(int a[], int n) {
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        System.out.println("Max mảng: " + max);
    }

    public static void minMang(int a[], int n) {
        int min = a[0];
        for (int i = 1; i < n; i++) {
            if (min > a[i]) {
                min = a[i];
            }
        }
        System.out.println("Min mảng: " + min);
    }

    public static void amMaxMang(int a[], int n) {
        int vt = -1;
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                vt = i;
                break;
            }
        }
        if (vt == -1) {
            System.out.println("Không có phần tử âm trong mảng");
            return;
        }
        int max = a[vt];
        for (int i = vt; i < n; i++) {
            if (max < a[i] && a[i] < 0) {
                max = a[i];
            }
        }
        System.out.println("Âm Max mảng: " + max);
    }

    public static void DaoMang(int a[], int n) {
        for (int i = 0; i < n / 2; i++) {
            int t = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 - i] = t;
        }
    }
}
