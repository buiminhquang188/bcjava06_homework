package org.cybersoft.buoi11.bai4;

import java.util.Scanner;

public class Oto extends PhuongTienGiaoThong {

	private byte soChoNgoi;
	private String kieuDongCo;

	@Override
	public void nhap(Scanner scanner) {
		// TODO Auto-generated method stub
		super.nhap(scanner);

		System.out.print("Vui lòng nhập số chỗ ngồi: ");
		this.setSoChoNgoi(scanner.nextByte());

		System.out.println("Vui lòng nhập kiểu động cơ: ");
		scanner.nextLine();
		this.setKieuDongCo(scanner.nextLine());
	}

	@Override
	public void xuat(Scanner scanner) {
		// TODO Auto-generated method stub
		super.xuat(scanner);
	}

	public byte getSoChoNgoi() {
		return soChoNgoi;
	}

	public void setSoChoNgoi(byte soChoNgoi) {
		this.soChoNgoi = soChoNgoi;
	}

	public String getKieuDongCo() {
		return kieuDongCo;
	}

	public void setKieuDongCo(String kieuDongCo) {
		this.kieuDongCo = kieuDongCo;
	}

}
