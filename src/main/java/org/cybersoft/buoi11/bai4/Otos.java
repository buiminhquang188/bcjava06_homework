package org.cybersoft.buoi11.bai4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Otos {
    private List<Oto> otos;
    private List<Oto> danhSachOtoCungVanToc;

    public Otos() {
        this.otos = new ArrayList<Oto>();
    }

    public void nhap(Scanner scanner) {
        int userOptions = getUserOption(scanner);

        while (userOptions != 2) {
            switch (userOptions) {
                case 1:
                    System.out.println("Vui lòng nhập vào oto thứ " + (this.otos.size() + 1));
                    Oto oto = new Oto();
                    oto.nhap(scanner);

                    this.otos.add(oto);
                    break;
                case 3:
                    this.inOtos(this.otos);
                    break;
                case 4:
                    this.layOtoCoCungVanToc();
                    this.inOtos(this.danhSachOtoCungVanToc);
                    break;
                default:
                    scanner.close();
                    break;
            }
            userOptions = getUserOption(scanner);
        }
    }

    public int getUserOption(Scanner scanner) {
        int userOptions;
        inMenu();

        System.out.print("Vui lòng chọn: ");
        userOptions = scanner.nextInt();

        while (userOptions < 1 || (this.otos.isEmpty() && userOptions > 2) || (!this.otos.isEmpty() && (userOptions > 4))) {
            System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại");
            inMenu();
            System.out.print("Vui lòng chọn: ");
            userOptions = scanner.nextInt();
        }

        return userOptions;
    }

    public void inMenu() {
        System.out.println("1. TIếp tục nhập oto");
        System.out.println("2. Thoát");

        if (!this.otos.isEmpty()) {
            System.out.println("3. Xem danh sách oto");
            System.out.println("4. Xem danh sách oto có cùng vận tốc");
        }
    }

    public void inOtos(List<Oto> otos) {
        String leftAlignFormat = "| %-19s | %-17s | %-16s | %-18s | %-15s | %-16s |%n";

        System.out.format("+---------------------+-------------------+------------------+--------------------+-----------------+------------------+%n");
        System.out.format("| Tên phương tiện     | Hãng sản xuất     | Năm sản xuất     | Vận tốc tối đa     | Số chỗ ngồi     | Kiểu động cơ     |%n");
        System.out.format("+---------------------+-------------------+------------------+--------------------+-----------------+------------------+%n");
        for (int i = 0; i < otos.size(); i++) {
            if (otos.get(i) != null) {
                System.out.format(leftAlignFormat,
                        otos.get(i)
                                .getTenPhuongTien(), otos.get(i)
                                .getHangSanXuat(), otos.get(i)
                                .getNamSanXuat(), otos.get(i)
                                .getVanTocToiDa(), otos.get(i)
                                .getSoChoNgoi(), otos.get(i)
                                .getKieuDongCo());
            }
        }
        System.out.format("+---------------------+-------------------+------------------+--------------------+-----------------+------------------+%n");
    }

    public void layOtoCoCungVanToc() {
        this.danhSachOtoCungVanToc = new ArrayList<Oto>();
        for (int i = 0; i < this.otos.size() - 1; i++) {
            for (int j = i + 1; j < this.otos.size(); j++) {
                if (this.otos.get(i)
                        .getVanTocToiDa() == this.otos.get(j)
                        .getVanTocToiDa()) {

                    if (!this.danhSachOtoCungVanToc.contains(this.otos.get(i))) {
                        this.danhSachOtoCungVanToc.add(this.otos.get(i));
                    }

                    if (!this.danhSachOtoCungVanToc.contains(this.otos.get(j))) {
                        this.danhSachOtoCungVanToc.add(this.otos.get(j));
                    }
                }
            }
        }
    }
}
