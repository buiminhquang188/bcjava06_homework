package org.cybersoft.buoi12.Company;

import org.cybersoft.buoi12.Director.Director;
import org.cybersoft.buoi12.Employee.Employee;
import org.cybersoft.buoi12.Employee.IEmployee;
import org.cybersoft.buoi12.Manager.Manager;
import org.cybersoft.buoi12.Utils.Helper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Company implements ICompany {
    private String name;
    private String taxId;
    private double revenue;
    private double profit;
    private double totalSalary;
    private List<Employee> employees;

    public Company() {
    }

    public Company(String name, String taxId, double revenue, List<Employee> employees) {
        this.name = name;
        this.taxId = taxId;
        this.revenue = revenue;
        this.employees = employees;
    }

    @Override
    public void nhapThongTinCongty(Scanner scanner) {
        System.out.println("Vui lòng nhập vào tên công ty: ");
        scanner.nextLine();
        this.name = scanner.nextLine();
        System.out.println("Vui lòng nhập vào mã số thuế: ");
        this.taxId = scanner.nextLine();
        System.out.println("Vui lòng nhập vào doanh thu của công ty");
        validationRevenue(scanner.nextDouble(), scanner);
    }

    @Override
    public void xuatThongTinCongTy() {
        System.out.println("=========================================================");
        System.out.println("Tên công ty: " + this.name);
        System.out.println("Mã số thuế: " + this.taxId);
        System.out.println("Doanh thu: " + Helper.formatCurrency(this.revenue));
        System.out.println("Tổng lương nhân viên: " + Helper.formatCurrency(this.totalSalary));
        System.out.println("Lợi nhuận: " + Helper.formatCurrency(this.calcCompanyProfit()));
    }

    @Override
    public void nhapThongTinNhanVien(Scanner scanner, int id) {
        Employee employee = new Employee();
        employee.nhap(scanner, id);
        this.employees.add(employee);

        double employeeTotalSalary = employee.getTotalSalary();
        this.totalSalary += employeeTotalSalary;
        this.profit = this.revenue - this.totalSalary;
    }

    @Override
    public void nhapThongTinQuanLy(Scanner scanner, int id) {
        Manager manager = new Manager();
        manager.nhap(scanner, id);
        this.employees.add(manager);
        manager.addEmployeeForManager(scanner, this.employees);

        double managerTotalSalary = manager.getTotalSalary();
        this.totalSalary += managerTotalSalary;
        this.profit = this.revenue - this.totalSalary;
    }

    @Override
    public void nhapThongTinGiamDoc(Scanner scanner, int id) {
        Director director = new Director();
        director.nhap(scanner, id);
        this.employees.add(director);

        double directorTotalSalary = director.getTotalSalary();
        this.totalSalary += directorTotalSalary;
        this.profit = this.revenue - this.totalSalary;

        director.calcTotalIncome(this.revenue, this.totalSalary);
    }

    @Override
    public void printAllEmployee(List<Employee> employees) {
        String leftAlignFormat = "| %-6s | %-7s | %-11s | %-13s | %-16.2f | %-14s | %-11s |%n";

        System.out.println("=========================================== NHÂN VIÊN ==============================================");
        System.out.format("+--------+---------+-------------+---------------+------------------+----------------+-------------+%n");
        System.out.format("| ID     | Tên     | SĐT         | Ngày làm việc | Lương cơ bản     | Tổng lương     | Chức vụ     |%n");
        System.out.format("+--------+---------+-------------+---------------+------------------+----------------+-------------+%n");

        for (Employee employee : employees) {
            System.out.format(leftAlignFormat,
                    employee.getId(),
                    employee.getName(),
                    employee.getPhoneNumber(),
                    employee.getWorkDays(),
                    employee.getSalaryOfOneDay(),
                    Helper.formatCurrency(employee.getTotalSalary()),
                    employee.getClass()
                            .getSimpleName()
            );
        }

        System.out.format("+--------+---------+-------------+---------------+------------------+----------------+-------------+%n");
    }

    @Override
    public void printAllEmployeeRole(List<Employee> employees) {
        String leftAlignFormat = "| %-6s | %-7s | %-11s | %-13s | %-16.2f | %-14s | %-11s |%n";

        System.out.println("=========================================== NHÂN VIÊN ==============================================");
        System.out.format("+--------+---------+-------------+---------------+------------------+----------------+-------------+%n");
        System.out.format("| ID     | Tên     | SĐT         | Ngày làm việc | Lương cơ bản     | Tổng lương     | ID Quản Lý  |%n");
        System.out.format("+--------+---------+-------------+---------------+------------------+----------------+-------------+%n");

        for (Employee employee : employees) {
            if (!(employee instanceof Manager) && !(employee instanceof Director)) {
                System.out.format(leftAlignFormat,
                        employee.getId(),
                        employee.getName(),
                        employee.getPhoneNumber(),
                        employee.getWorkDays(),
                        employee.getSalaryOfOneDay(),
                        Helper.formatCurrency(employee.getTotalSalary()),
                        employee.getManagerId()
                );
            }
        }

        System.out.format("+--------+---------+-------------+---------------+------------------+----------------+-------------+%n");
    }

    @Override
    public void printAllManagerRole(List<Employee> employees) {
        List<Manager> managers = employees
                .stream()
                .filter(manager -> manager instanceof Manager)
                .map(manager -> (Manager) manager)
                .toList();

        String leftAlignFormat = "| %-6s | %-7s | %-11s | %-13s | %-16.2f | %-14s | %-18s | %-22s |%n";

        System.out.println("================================================================= QUẢN LÝ ==========================================================");
        System.out.format("+--------+---------+-------------+---------------+------------------+----------------+--------------------+------------------------+%n");
        System.out.format("| ID     | Tên     | SĐT         | Ngày làm việc | Lương cơ bản     | Tổng lương     | Số lượng nhân viên | ID nhân viên quản lý   |%n");
        System.out.format("+--------+---------+-------------+---------------+------------------+----------------+--------------------+------------------------+%n");

        if (!managers.isEmpty()) {
            for (Manager manager : managers) {
                System.out.format(leftAlignFormat,
                        manager.getId(),
                        manager.getName(),
                        manager.getPhoneNumber(),
                        manager.getWorkDays(),
                        manager.getSalaryOfOneDay(),
                        Helper.formatCurrency(manager.getTotalSalary()),
                        manager.getNumberOfEmployee(),
                        manager.getEmployees()
                                .toString()
                );
            }
        } else {
            System.out.format("|                                                      KHÔNG CÓ DỮ LIỆU                                                            |%n");
        }

        System.out.format("+--------+---------+-------------+---------------+------------------+----------------+--------------------+------------------------+%n");
    }

    @Override
    public void printAllDirectorRole(List<Employee> employees) {
        List<Director> directors = employees.stream()
                .filter(element -> element instanceof Director)
                .map(element -> (Director) element)
                .toList();

        String leftAlignFormat = "| %-6s | %-7s | %-11s | %-13s | %-16s | %-14s | %-7s |%n";

        System.out.println("======================================== GIÁM ĐỐC =============================================");
        System.out.format("+--------+---------+-------------+---------------+------------------+----------------+---------+%n");
        System.out.format("| ID     | Tên     | SĐT         | Ngày làm việc | Lương cơ bản     | Tổng lương     | Cổ phần |%n");
        System.out.format("+--------+---------+-------------+---------------+------------------+----------------+---------+%n");

        if (!directors.isEmpty()) {
            for (Director director : directors) {
                System.out.format(leftAlignFormat,
                        director.getId(),
                        director.getName(),
                        director.getPhoneNumber(),
                        director.getWorkDays(),
                        director.getSalaryOfOneDay(),
                        Helper.formatCurrency(director.getTotalSalary()),
                        director.getShareCapacity(),
                        Helper.formatCurrency(director.getTotalIncome())
                );
            }
        } else {
            System.out.format("|                                         KHÔNG CÓ DỮ LIỆU                                     |%n");
        }


        System.out.format("+--------+---------+-------------+---------------+------------------+----------------+---------+%n");
    }

    @Override
    public void printAllDirectorTotalIncome(List<Director> directors) {
        String leftAlignFormat = "| %-6s | %-7s | %-11s | %-17s | %-16.2f | %-14s | %-24s | %-11s |%n";

        System.out.println("================================================================= GIÁM ĐỐC =======================================================");
        System.out.format("+--------+---------+-------------+-------------------+------------------+----------------+--------------------------+-------------+%n");
        System.out.format("| ID     | Tên     | SĐT         | Ngày làm việc     | Lương cơ bản     | Tổng lương     | Tổng thu nhập            | Cổ phần     |%n");
        System.out.format("+--------+---------+-------------+-------------------+------------------+----------------+--------------------------+-------------+%n");
        for (Director director : directors) {
            System.out.format(leftAlignFormat,
                    director.getId(),
                    director.getName(),
                    director.getPhoneNumber(),
                    director.getWorkDays(),
                    director.getSalaryOfOneDay(),
                    Helper.formatCurrency(director.getTotalSalary()),
                    Helper.formatCurrency(director.getTotalIncome()),
                    director.getShareCapacity() + "%"
            );
        }

        System.out.format("+--------+---------+-------------+-------------------+------------------+----------------+--------------------------+-------------+%n");
    }

    @Override
    public Manager promoteEmployeeToManager(int employeeId) {
        Manager manager = null;
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i)
                    .getId() == employeeId && this.employees.get(i) instanceof Director) {
                System.out.println("ID này không hợp lệ do đang sở hữu chức vụ Giám Đốc, vui lòng sử dụng ID khác");
                break;
            }

            if (this.employees.get(i)
                    .getId() == employeeId && this.employees.get(i) instanceof Manager) {
                System.out.println("ID này không hợp lệ do đã sở hữu chức vụ Quản Lý, vui lòng sử dụng ID khác");
                break;
            }

            if (this.employees.get(i)
                    .getId() == employeeId) {
                Employee employee = this.getEmployees()
                        .get(i);
                manager = new Manager(employee.getId(), employee.getName(), employee.getPhoneNumber(), employee.getWorkDays());
                this.employees.set(i, manager);
                break;
            }
        }
        return manager;
    }

    @Override
    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < this.employees.size(); i++) {
            if (this.employees.get(i)
                    .getId() == employeeId) {

                if (this.employees.get(i)
                        .getManagerId() != null) {
                    this.removeEmployeeRefId(i, employeeId);
                }
                
                if (this.employees.get(i) instanceof Manager && !(((Manager) this.employees.get(i)).getEmployees()
                        .isEmpty())) {
                    this.removeManagerRefId(i);
                }

                this.employees.remove(i);
            }
        }
    }

    @Override
    public Employee findEmployeeHighestSalary() {
        Employee highestEmployeeSalary = null;

        for (Employee employee : this.employees) {
            if (!(employee instanceof Director) && !(employee instanceof Manager)) {
                if (highestEmployeeSalary == null) {
                    highestEmployeeSalary = employee;
                }

                if (highestEmployeeSalary != null && highestEmployeeSalary.getTotalSalary() < employee.getTotalSalary()) {
                    highestEmployeeSalary = employee;
                }
            }
        }

        return highestEmployeeSalary;
    }

    @Override
    public Manager findManagerHaveMostEmployee() {
        Manager highestManager = null;

        for (Employee employee : this.employees) {
            if (highestManager == null && employee instanceof Manager && ((Manager) employee).getNumberOfEmployee() > 0) {
                highestManager = (Manager) employee;
            }

            if (highestManager != null && employee instanceof Manager && highestManager.getNumberOfEmployee() < ((Manager) employee).getNumberOfEmployee()) {
                highestManager = (Manager) employee;
            }
        }

        return highestManager;
    }

    @Override
    public List<Employee> sortEmployeeByNameASC() {
        List<Employee> sortEmployeeByNameASC = new ArrayList<>(this.employees);
        sortEmployeeByNameASC.sort(Comparator.comparing(Employee::getName));
        return sortEmployeeByNameASC;
    }

    @Override
    public List<Employee> sortEmployeeBySalaryDESC() {
        List<Employee> sortEmployeeBySalaryDESC = new ArrayList<>(this.employees);
        sortEmployeeBySalaryDESC.sort(Comparator.comparingDouble(Employee::getTotalSalary)
                .reversed());
        return sortEmployeeBySalaryDESC;
    }

    @Override
    public Director findHighestShareCapacityDirector() {
        Director highestDirectorShareCapacity = null;

        for (Employee director : this.employees) {
            if (highestDirectorShareCapacity == null && director instanceof Director) {
                highestDirectorShareCapacity = (Director) director;
            }

            if (director instanceof Director && highestDirectorShareCapacity.getShareCapacity() < ((Director) director).getShareCapacity()) {
                highestDirectorShareCapacity = (Director) director;
            }
        }

        return highestDirectorShareCapacity;
    }

    @Override
    public List<Director> calcDirectorIncome() {
        List<Director> directors = new ArrayList<>();
        double totalSalary = this.totalSalary;

        for (Employee employee : this.employees) {
            if (employee instanceof Director) {
                Director director = ((Director) employee).calcTotalIncome(this.revenue, totalSalary);
                directors.add(director);
            }
        }

        return directors;
    }

    private double calcCompanyProfit() {
        double companyProfit = this.revenue - this.totalSalary;
        this.profit = companyProfit;
        return companyProfit;
    }

    private void validationRevenue(double userInput, Scanner scanner) {
        while (userInput < 1) {
            System.out.println("Doanh thu công ty phải lớn hơn 0, vui lòng nhập lại: ");
            userInput = scanner.nextDouble();
        }

        this.revenue = userInput;
    }

    private Employee findEmployeeById(int id) {
        Employee result = null;

        for (Employee employee : this.employees) {
            if (employee.getId() == id) {
                result = employee;
                break;
            }
        }

        return result;
    }

    private void removeEmployeeRefId(int employeeIndex, Integer employeeId) {
        int managerId = this.employees.get(employeeIndex)
                .getManagerId();
        Manager manager = (Manager) this.findEmployeeById(managerId);

        List<Integer> employeeRefIds = manager.getEmployees();
        Integer employeeRefId = null;
        for (Integer refId : employeeRefIds) {
            if (refId.intValue() == employeeId.intValue()) {
                employeeRefId = refId;
                break;
            }
        }
        employeeRefIds.remove(employeeRefId);
        manager.setNumberOfEmployee(manager.getNumberOfEmployee() - 1);
    }

    private void removeManagerRefId(int employeeIndex) {
        for (int j = 0; j < ((Manager) this.employees.get(employeeIndex)).getEmployees()
                .size(); j++) {
            Integer managerRefId = ((Manager) this.employees.get(employeeIndex)).getEmployees()
                    .get(j);

            Employee employee = this.findEmployeeById(managerRefId);
            employee.setManagerId(null);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
