package org.cybersoft.buoi12.Employee;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee implements IEmployee {
    private int id;
    private String name;
    private String phoneNumber;
    private int workDays;
    private double salaryOfOneDay = 100;
    private double totalSalary;
    private Integer managerId;

    public Employee() {
    }

    public Employee(int id, String name, String phoneNumber, int workDays, double salaryOfOneDay) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.workDays = workDays;
        this.salaryOfOneDay = salaryOfOneDay;
        this.calcSalary(workDays, salaryOfOneDay);
    }

    public Employee(int id, String name, String phoneNumber, int workDays, Integer managerId) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.workDays = workDays;
        this.managerId = managerId;
        this.calcSalary(workDays, salaryOfOneDay);
    }

    public Employee(int id, String name, String phoneNumber, int workDays, double salaryOfOneDay, Integer managerId) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.workDays = workDays;
        this.salaryOfOneDay = salaryOfOneDay;
        this.managerId = managerId;
    }

    @Override
    public void input(Scanner scanner, int id) {
        System.out.println("Vui lòng nhập vào tên nhân viên: ");
        scanner.nextLine();
        this.setName(scanner.nextLine());
        System.out.println("Vui lòng nhập vào số điện thoại nhân viên: ");
        this.setPhoneNumber(scanner.nextLine());
        System.out.println("Vui lòng nhập vào số ngày làm việc của nhân viên: ");
        this.validateWorkDays(scanner.nextInt(), scanner);

        this.setId(id);
        this.calcSalary(this.workDays, this.salaryOfOneDay);
    }

    @Override
    public void print() {
        System.out.println("ID: " + this.getId());
        System.out.println("Tên nhân viên: " + this.getName());
        System.out.println("SĐT: " + this.getPhoneNumber());
        System.out.println("Số ngày làm việc: " + this.getWorkDays());
    }

    @Override
    public double calcSalary(int workDays, double salaryOfOneDay) {
        double totalSalary = workDays * salaryOfOneDay;
        this.setTotalSalary(totalSalary);
        return totalSalary;
    }

    @Override
    public void validateWorkDays(int userInput, Scanner scanner) {
        while (userInput < 1 || userInput > 31) {
            System.out.println("Số ngày làm việc không được nhỏ hơn 1 và lớn hơn 31, vui lòng nhập lại con số khác: ");
            userInput = scanner.nextInt();
        }

        this.setWorkDays(userInput);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public double getSalaryOfOneDay() {
        return salaryOfOneDay;
    }

    public void setSalaryOfOneDay(double salaryOfOneDay) {
        this.salaryOfOneDay = salaryOfOneDay;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
}
