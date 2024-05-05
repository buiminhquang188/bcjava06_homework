package org.cybersoft.buoi12.Manager;

import org.cybersoft.buoi12.Director.Director;
import org.cybersoft.buoi12.Employee.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Manager extends Employee implements IManager {
    private int numberOfEmployee;

    private List<Integer> employees;

    public Manager() {
        this.setSalaryOfOneDay(200);
    }

    public Manager(Employee employee) {
        super(
                employee.getId(),
                employee.getName(),
                employee.getPhoneNumber(),
                employee.getWorkDays(),
                employee.getTotalSalary(),
                null
        );
    }

    public Manager(int id, String name, String phoneNumber, int workDays) {
        super(id, name, phoneNumber, workDays, 200);
        this.numberOfEmployee = 0;
        this.employees = new ArrayList<>();
    }

    @Override
    public void nhap(Scanner scanner, int id) {
        System.out.println("Vui lòng nhập vào tên quản lý: ");
        scanner.nextLine();
        this.setName(scanner.nextLine());
        System.out.println("Vui lòng nhập vào số điện thoại quản lý: ");
        this.setPhoneNumber(scanner.nextLine());
        System.out.println("Vui lòng nhập vào số ngày làm việc của quản lý: ");
        super.validateWorkDays(scanner.nextInt(), scanner);

        this.setId(id);
        this.calcSalary(this.getWorkDays(), this.getSalaryOfOneDay());
    }

    @Override
    public void addEmployeeToManager(Scanner scanner, List<Employee> employees) {
        int userInput;
        System.out.println("Nhập ID của nhân sự sẽ quản lý hoặc nhập 0 để thoát: ");
        userInput = scanner.nextInt();

        if (this.employees == null) {
            this.employees = new ArrayList<>();
        }

        while (userInput != 0) {

            while (userInput > employees.size()) {
                System.out.println("ID không hợp lệ, vui lòng nhập lại hoặc nhập 0 để thoát: ");
                userInput = scanner.nextInt();
            }

            for (Employee employee : employees) {
                if (employee.getId() == userInput && employee instanceof Director) {
                    System.out.println("ID này không hợp lệ do đang sở hữu chức vụ Giám Đốc, vui lòng sử dụng ID khác");
                    break;
                }

                if (employee.getId() == userInput && employee instanceof Manager) {
                    System.out.println("ID này không hợp lệ do đã sở hữu chức vụ Quản Lý, vui lòng sử dụng ID khác");
                    break;
                }

                if (employee.getId() == userInput && this.employees.contains(employee.getId())) {
                    System.out.println("ID đã được thêm vào danh sách quản lý");
                    continue;
                }

                if (employee.getId() == userInput && !this.employees.contains(employee.getId())) {
                    employees.get(userInput - 1)
                            .setManagerId(this.getId());
                    this.employees.add(employee.getId());
                    this.setNumberOfEmployee(++this.numberOfEmployee);
                }
            }

            System.out.println("Nhập ID của nhân sự sẽ quản lý hoặc nhập 0 để thoát");
            userInput = scanner.nextInt();
        }
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setNumberOfEmployee(int numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    public List<Integer> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Integer> employees) {
        this.employees = employees;
    }
}
