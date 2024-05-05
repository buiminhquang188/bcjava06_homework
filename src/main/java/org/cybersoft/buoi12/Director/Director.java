package org.cybersoft.buoi12.Director;

import org.cybersoft.buoi12.Employee.Employee;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Director extends Employee implements IDirector {
    private double shareCapacity;

    private double totalIncome;

    public Director() {
        this.setSalaryOfOneDay(300);
    }

    public Director(int id, String name, String phoneNumber, int workDays, int shareCapacity) {
        super(id, name, phoneNumber, workDays, 300);
        this.shareCapacity = shareCapacity;
    }

    @Override
    public void nhap(Scanner scanner, int id) {
        System.out.println("Vui lòng nhập vào tên giám đốc: ");
        scanner.nextLine();
        this.setName(scanner.nextLine());
        System.out.println("Vui lòng nhập vào số điện thoại giám đốc: ");
        this.setPhoneNumber(scanner.nextLine());
        System.out.println("Vui lòng nhập vào số ngày làm việc của giám dốc: ");
        super.validateWorkDays(scanner.nextInt(), scanner);
        System.out.println("Vui lòng nhập cổ phần (1-100): ");
        validateShareCapacity(scanner.nextDouble(), scanner);

        this.setId(id);
        this.calcSalary(this.getWorkDays(), this.getSalaryOfOneDay());
    }

    @Override
    public Director calcTotalIncome(Director director, double totalSalary) {
        double salary = this.calcSalary(director.getWorkDays(), director.getSalaryOfOneDay());
        double totalIncome = salary + (this.shareCapacity / 100) * totalSalary;

        director.setTotalIncome(totalIncome);
        return director;
    }

    private void validateShareCapacity(double userInput, Scanner scanner) {
        while (userInput < 0 || userInput > 100) {
            System.out.println("Cổ phần không được nhỏ hơn 0 và lớn hơn 100, vui lòng nhập lại con số khác: ");
            userInput = scanner.nextDouble();
        }

        this.setShareCapacity(userInput);
    }

    public double getShareCapacity() {
        return shareCapacity;
    }

    public void setShareCapacity(double shareCapacity) {
        this.shareCapacity = shareCapacity;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }
}
