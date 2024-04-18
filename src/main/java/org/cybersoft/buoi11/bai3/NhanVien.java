package org.cybersoft.buoi11.bai3;

import java.util.Scanner;

public class NhanVien {
	private String hoTen;
	private int ngaySinh;
	
	public NhanVien() {
		
	}
	
	public NhanVien(String hoTen, int ngaySinh) {
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
	}
	
	public void nhap(Scanner scanner) {
		System.out.print("Vui lòng nhập tên nhân viên: ");
		this.setHoTen(scanner.next());
		
		System.out.print("Vui lòng nhập ngày sinh nhân viên: ");
		this.setNgaySinh(scanner.nextInt());
	}
	
	public void xuat() {
		System.out.println("Tên nhân viên: " + this.getHoTen());
		System.out.println("Ngày sinh nhân viên: " + this.getNgaySinh());
	}

	public String getHoTen() {
		return hoTen;
	}
	
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public int getNgaySinh() {
		return ngaySinh;
	}
	
	public void setNgaySinh(int ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
}
