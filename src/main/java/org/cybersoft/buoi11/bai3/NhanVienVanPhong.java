package org.cybersoft.buoi11.bai3;

import java.util.Scanner;

public class NhanVienVanPhong extends NhanVien implements INhanVien {
	private int soNgayLam;

	@Override
	public void nhap(Scanner scanner) {
		super.nhap(scanner);

		System.out.print("Vui lòng nhập số ngày làm của nhân viên văn phòng: ");
		this.setSoNgayLam(scanner.nextInt());
	}

	@Override
	public void xuat() {
		super.xuat();

		System.out.println("Số ngày làm của nhân viên văn phòng: " + this.getSoNgayLam());

		this.tinhLuong();
	}

	@Override
	public void tinhLuong() {
		double luong = this.getSoNgayLam() * 100000;
		System.out.print("Lương của nhân viên sản xuất: " + luong);
	}

	public int getSoNgayLam() {
		return soNgayLam;
	}

	public void setSoNgayLam(int soNgayLam) {
		this.soNgayLam = soNgayLam;
	}
}
