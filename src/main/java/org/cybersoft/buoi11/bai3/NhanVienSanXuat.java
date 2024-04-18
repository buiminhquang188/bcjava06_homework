package org.cybersoft.buoi11.bai3;

import java.util.Scanner;

public class NhanVienSanXuat extends NhanVien implements INhanVien {
	private int soSanPham;
	private double luong;

	@Override
	public void nhap(Scanner scanner) {
		super.nhap(scanner);

		System.out.print("Vui lòng nhập số sản phẩm của nhân viên sản xuất: ");
		this.setSoSanPhan(scanner.nextInt());

		System.out.print("Vui lòng nhập số lương của nhân viên sản xuất: ");
		this.setLuong(scanner.nextDouble());
	}

	@Override
	public void xuat() {
		super.xuat();
		System.out.println("Số sản phẩm nhân viên sản xuất: " + this.getSoSanPham());
		this.tinhLuong();
	}
	
	@Override
	public void tinhLuong() {
		double luong = this.getLuong() + this.getSoSanPham() * 5000;
		System.out.println("Lương của nhân viên sản xuất: " + luong);
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	public int getSoSanPham() {
		return soSanPham;
	}

	public void setSoSanPhan(int soSanPhan) {
		this.soSanPham = soSanPhan;
	}
}
