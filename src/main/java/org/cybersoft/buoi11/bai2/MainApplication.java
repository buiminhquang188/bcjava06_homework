package org.cybersoft.buoi11.bai2;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        VanDongVien vanDongVien = new VanDongVien();
        VanDongVien vanDongVien2 = new VanDongVien();

        vanDongVien.nhap(scanner);
        vanDongVien2.nhap(scanner);

        VanDongVien ketQua = vanDongVien.soSanh(vanDongVien2);

        if (ketQua != null) {
            ketQua.xuat();
        }

        scanner.close();
    }
}
