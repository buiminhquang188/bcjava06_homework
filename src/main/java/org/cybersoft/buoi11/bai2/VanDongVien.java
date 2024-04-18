package org.cybersoft.buoi11.bai2;

import java.util.Scanner;

public class VanDongVien {
    private String hoTen;
    private int tuoi;
    private String monThiDau;
    private double canNang;
    private double chieuCao;

    public VanDongVien() {

    }

    public VanDongVien(String hoTen, int tuoi, String monThiDau, double canNang, double chieuCao) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.monThiDau = monThiDau;
        this.canNang = canNang;
        this.chieuCao = chieuCao;
    }

    public void nhap(Scanner scanner) {
        System.out.print("Vui lòng nhập họ và tên: ");
        hoTen = scanner.next();

        System.out.print("Vui lòng nhập tuổi: ");
        tuoi = scanner.nextInt();

        System.out.print("Vui lòng nhập môn thi đấu: ");
        monThiDau = scanner.next();

        System.out.print("Vui lòng nhập cân nặng: ");
        canNang = scanner.nextDouble();

        System.out.print("Vui lòng nhập chiều cao: ");
        chieuCao = scanner.nextDouble();
    }

    public void xuat() {
        System.out.println("Họ tên: " + this.getHoTen());
        System.out.println("Tuổi: " + this.getTuoi());
        System.out.println("Môn thi đấu: " + this.getMonThiDau());
        System.out.println("Cân nặng: " + this.getCanNang());
        System.out.println("Chiều cao: " + this.getChieuCao());
    }

    public VanDongVien soSanh(VanDongVien vanDongVien2) {
        if (this.getChieuCao() > vanDongVien2.getChieuCao()) {
            return this;
        } else if (this.getChieuCao() < vanDongVien2.getChieuCao()) {
            return vanDongVien2;
        } else if (this.getChieuCao() == vanDongVien2.getChieuCao() && this.getCanNang() > vanDongVien2.getCanNang()) {
            return this;
        } else if (this.getChieuCao() == vanDongVien2.getChieuCao() && this.getCanNang() < vanDongVien2.getCanNang()) {
            return vanDongVien2;
        } else {
            System.out.println("Không có vận động viên nào cân nặng lớn hơn");
            return null;
        }
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getMonThiDau() {
        return monThiDau;
    }

    public void setMonThiDau(String monThiDau) {
        this.monThiDau = monThiDau;
    }

    public double getCanNang() {
        return canNang;
    }

    public void setCanNang(double canNang) {
        this.canNang = canNang;
    }

    public double getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(double chieuCao) {
        this.chieuCao = chieuCao;
    }

}
