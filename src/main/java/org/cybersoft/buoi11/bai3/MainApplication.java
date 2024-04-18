package org.cybersoft.buoi11.bai3;

import java.util.Scanner;

public class MainApplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		NhanVienSanXuat nhanVienSanXuat = new NhanVienSanXuat();
		NhanVienVanPhong nhanVienVanPhong = new NhanVienVanPhong();
		
		nhanVienSanXuat.nhap(scanner);
		nhanVienSanXuat.xuat();
		
		nhanVienVanPhong.nhap(scanner);
		nhanVienVanPhong.xuat();
	}
}
