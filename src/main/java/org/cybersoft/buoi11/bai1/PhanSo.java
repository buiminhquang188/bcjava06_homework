package org.cybersoft.buoi11.bai1;

import java.util.Scanner;

public class PhanSo {
	private double tuSo;
	private double mauSo;

	public void nhap(Scanner scanner) {
		System.out.print("Vui lòng nhập tử số: ");
		this.tuSo = scanner.nextDouble();

		System.out.print("Vui lòng nhập mẫu số: ");
		this.mauSo = scanner.nextDouble();
	}

	public void xuat() {
		System.out.println("Phân số: " + this.tuSo + "/" + this.mauSo);
	}

	public PhanSo cong(PhanSo phanSo) {
		double tongTuSo = (this.tuSo * phanSo.mauSo) + (phanSo.tuSo * this.mauSo);
		double mauSoChung = this.mauSo * phanSo.mauSo;
		System.out.println("Tổng phân số là: " + tongTuSo + "/" + mauSoChung);
		
		PhanSo phanSo1 = new PhanSo();
		phanSo1.setMauSo(tongTuSo);
		phanSo1.setMauSo(mauSoChung);
		
		return phanSo1;
	}

	public void tru(PhanSo phanSo2) {
		double hieuTuSo = (this.tuSo * phanSo2.mauSo) - (phanSo2.tuSo * this.mauSo);
		double mauSoChung = this.mauSo * phanSo2.mauSo;
		System.out.println("Hiệu phân số là: " + hieuTuSo + "/" + mauSoChung);
	}

	public void nhan(PhanSo phanSo) {
		double tichTuSo = this.tuSo * phanSo.tuSo;
		double tichMauSo = this.mauSo * phanSo.mauSo;
		System.out.println("Tích phân số là: " + tichTuSo + "/" + tichMauSo);
	}
	
	public void chia(PhanSo phanSo) {
		double thuongTuSo = this.tuSo * phanSo.mauSo;
		double thuongMauSo = this.mauSo * phanSo.tuSo;
		System.out.println("Thương phân số là: " + thuongTuSo + "/" + thuongMauSo);
	}

	public double getTuSo() {
		return tuSo;
	}

	public double getMauSo() {
		return mauSo;
	}

	public void setTuSo(double tuSo) {
		this.tuSo = tuSo;
	}

	public void setMauSo(double mauSo) {
		this.mauSo = mauSo;
	}
}
