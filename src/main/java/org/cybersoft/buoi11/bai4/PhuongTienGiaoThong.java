package org.cybersoft.buoi11.bai4;

import java.util.Scanner;

public class PhuongTienGiaoThong implements IPhuongTienGiaoThong {
    private String tenPhuongTien;
    private String hangSanXuat;
    private int namSanXuat;
    private int vanTocToiDa;

    public PhuongTienGiaoThong() {

    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public String getTenPhuongTien() {
        return tenPhuongTien;
    }

    public void setTenPhuongTien(String tenPhuongTien) {
        this.tenPhuongTien = tenPhuongTien;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public int getVanTocToiDa() {
        return vanTocToiDa;
    }

    public void setVanTocToiDa(int vanTocToiDa) {
        this.vanTocToiDa = vanTocToiDa;
    }

    @Override
    public void nhap(Scanner scanner) {
        System.out.println("Vui lòng nhập tên hãng sản xuất: ");
        scanner.nextLine();
        this.setHangSanXuat(scanner.nextLine());

        System.out.println("Vui lòng nhập tên phương tiện: ");
        this.setTenPhuongTien(scanner.nextLine());

        System.out.print("Vui lòng nhập năm sản xuất: ");
        this.setNamSanXuat(scanner.nextInt());

        System.out.print("Vui lòng nhập vận tốc tối đa: ");
        this.setVanTocToiDa(scanner.nextInt());

    }

    @Override
    public void xuat(Scanner scanner) {
        System.out.println("Tên hãng sản xuất: " + this.getHangSanXuat());
        System.out.println("Tên phương tiện: " + this.getTenPhuongTien());
        System.out.println("Năm sản xuất: " + this.getNamSanXuat());
        System.out.println("Vận tốc tối đa: " + this.getVanTocToiDa());
    }
}
