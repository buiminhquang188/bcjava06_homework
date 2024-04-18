package org.cybersoft.buoi11.bai1;

import java.util.Scanner;

public class MainApplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		PhanSo phanSo1 = new PhanSo();
		phanSo1.nhap(scanner);
		phanSo1.xuat();
		
		PhanSo phanSo2 = new PhanSo();
		phanSo2.nhap(scanner);
		phanSo2.xuat();
		
		phanSo1.cong(phanSo2);
		phanSo1.tru(phanSo2);
		phanSo1.nhan(phanSo2);
		phanSo1.chia(phanSo2);
		
		scanner.close();
	}
}
