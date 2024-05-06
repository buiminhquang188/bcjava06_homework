package org.cybersoft.buoi12.User;

import org.cybersoft.buoi12.Company.Company;
import org.cybersoft.buoi12.Director.Director;
import org.cybersoft.buoi12.Employee.Employee;
import org.cybersoft.buoi12.Manager.Manager;
import org.cybersoft.buoi12.Utils.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class User {
    private Scanner scanner;
    private Company company;

    public User() {
        this.scanner = new Scanner(System.in);
    }

    public int getUserOption() {
        int userOptions;

        printMenu();
        System.out.print("Choose options: ");
        userOptions = scanner.nextInt();

        while (userOptions < 0 || userOptions > 12) {
            printMenu();
            System.out.print("Lựa chọn không hợp lệ, vui lòng thử lại: ");
            userOptions = scanner.nextInt();
        }

        return userOptions;
    }

    private void printMenu() {
        System.out.println("0. Thoát");
        System.out.println("1. Nhập thông tin công ty");
        System.out.println("2. Phân bổ nhân viên vào trưởng phòng");
        System.out.println("3. Thêm thông tin nhân sự");
        System.out.println("4. Xóa thông tin nhân sự");
        System.out.println("5. In toàn bộ nhân viên trong công ty");
        System.out.println("6. In tổng lương nhân viên công ty");
        System.out.println("7. In nhân viên thường có lương cao nhất");
        System.out.println("8. In trưởng phòng có nhiều nhân viên dưới quyền nhất");
        System.out.println("9. Sắp xếp nhân viên theo thứ tự abc");
        System.out.println("10. Sắp xếp nhân viên theo thứ tự lương giảm dần");
        System.out.println("11. In giám đốc có số lượng cổ phần nhiều nhất");
        System.out.println("12. In tổng lương thu nhập của các giám đốc");
    }

    private int getUserConfirmExit() {
        int userConfirmExit;

        this.printConfirmExit();
        System.out.print("Bạn có muốn thoát?: ");
        userConfirmExit = scanner.nextInt();

        while (userConfirmExit != 0) {
            this.printConfirmExit();
            System.out.print("Lựa chọn không hợp lệ, vui lòng thử lại: ");
            userConfirmExit = scanner.nextInt();
        }
        return userConfirmExit;
    }

    private void printConfirmExit() {
        System.out.println("=========================================================");
        System.out.println("0. Thoát");
    }

    public void processOption(int userOption, AtomicInteger atomicInteger) {
        while (userOption > 0 && userOption < 13) {
            switch (userOption) {
                case 1:
                    this.processOptionCompany();
                    break;
                case 2:
                    validationCompany();
                    validationEmployees();

                    if (this.company != null && this.company.getEmployees() != null && !this.company.getEmployees()
                            .isEmpty()) {
                        this.processOptionEmployeeToManager();
                    }
                    break;
                case 3:
                    validationCompany();

                    if (this.company != null && this.company.getEmployees() != null) {
                        this.processOptionInsertEmployee(atomicInteger, scanner);
                    }
                    break;
                case 4:
                    validationCompany();
                    validationEmployees();

                    if (this.company != null && this.company.getEmployees() != null && !this.company.getEmployees()
                            .isEmpty()) {
                        this.processOptionDeleteEmployee();
                    }
                    break;
                case 5:
                    validationCompany();
                    validationEmployees();

                    if (this.company != null && this.company.getEmployees() != null && !this.company.getEmployees()
                            .isEmpty()) {
                        this.company.printAllEmployeeRole(this.company.getEmployees());
                        this.company.printAllManagerRole(this.company.getEmployees());
                        this.company.printAllDirectorRole(this.company.getEmployees());
                        getUserConfirmExit();

                    }
                    break;
                case 6:
                    validationCompany();
                    validationEmployees();

                    if (this.company != null && this.company.getEmployees() != null && !this.company.getEmployees()
                            .isEmpty()) {
                        this.processOptionSalaryEmployees();
                    }
                    break;
                case 7:
                    validationCompany();
                    validationEmployees();

                    if (this.company != null && this.company.getEmployees() != null && !this.company.getEmployees()
                            .isEmpty()) {
                        this.processOptionFindEmployeeHighestSalary();
                    }
                    break;
                case 8:
                    validationCompany();
                    validationEmployees();

                    if (this.company != null && this.company.getEmployees() != null && !this.company.getEmployees()
                            .isEmpty()) {
                        this.processOptionFindManagerHaveHighestEmployee();
                    }
                    break;
                case 9:
                    validationCompany();
                    validationEmployees();

                    if (this.company != null && this.company.getEmployees() != null && !this.company.getEmployees()
                            .isEmpty()) {
                        this.processOptionSortEmployeeNameASC();
                    }
                    break;
                case 10:
                    validationCompany();
                    validationEmployees();

                    if (this.company != null && this.company.getEmployees() != null && !this.company.getEmployees()
                            .isEmpty()) {
                        this.processOptionSortEmployeeSalaryDESC();
                    }
                    break;
                case 11:
                    validationCompany();
                    validationEmployees();

                    if (this.company != null && this.company.getEmployees() != null && !this.company.getEmployees()
                            .isEmpty()) {
                        this.processOptionFindDirectorHaveHighestShareCapacity();
                    }
                    break;
                case 12:
                    validationCompany();
                    validationEmployees();

                    if (this.company != null && this.company.getEmployees() != null && !this.company.getEmployees()
                            .isEmpty()) {
                        this.processOptionCalcDirectorIncome();
                    }
                    break;
                default:
                    scanner.close();
                    return;
            }
            userOption = getUserOption();
        }
    }

    private void processOptionCompany() {
        if (this.company != null) {
            System.out.println("Thông tin công ty đã được nhập, vui lòng sử dụng các chức năng khác");
            getUserConfirmExit();
            return;
        }

        this.setCompany(new Company());
        this.company
                .inputCompany(scanner);
        this.company
                .printCompany();

        this.company
                .setEmployees(new ArrayList<>());
        getUserConfirmExit();
    }

    public void validationCompany() {
        if (this.company == null) {
            System.out.println("Bạn cần thêm công ty để có thể sử dụng chức năng này");
            getUserConfirmExit();
        }
    }

    public void validationEmployees() {
        if (this.company == null) return;
        List<Employee> employees = this.company.getEmployees();
        if (employees == null || employees.isEmpty()) {
            System.out.println("Bạn cần thêm nhân viên mới có thể sử dụng chức năng này");
            getUserConfirmExit();
        }
    }

    private void processOptionEmployeeToManager() {
        int userInputIdEmployee;

        System.out.println("Vui lòng nhập ID của nhân sự muốn bổ nhiệm vào trưởng phòng: ");
        userInputIdEmployee = scanner.nextInt();

        Manager manager = this.company.promoteEmployeeToManager(userInputIdEmployee);

        while (manager == null) {
            userInputIdEmployee = scanner.nextInt();
            manager = this.company.promoteEmployeeToManager(userInputIdEmployee);
        }

        manager.addEmployeeForManager(scanner, this.getCompany()
                .getEmployees());
    }

    public void processOptionInsertEmployee(AtomicInteger atomicInteger, Scanner scanner) {
        int userInput;

        System.out.println("0. Thoát");
        System.out.println("1. Nhập thông tin nhân viên");
        System.out.println("2. Nhập thông tin quản lý");
        System.out.println("3. Nhập thông tin giám đốc");
        System.out.println("Vui lòng chọn thông tin mà bạn muốn nhập");
        userInput = scanner.nextInt();

        while (userInput < 0 || userInput > 3) {
            System.out.print("Lựa chọn không hợp lệ, vui lòng thử lại: ");
            userInput = scanner.nextInt();
        }

        switch (userInput) {
            case 1:
                this.company.inputEmployee(scanner, atomicInteger.getAndIncrement());
                break;
            case 2:
                this.company.inputManager(scanner, atomicInteger.getAndIncrement());
                break;
            case 3:
                this.company.inputDirector(scanner, atomicInteger.getAndIncrement());
                break;
            default:
                return;
        }
    }

    private void processOptionDeleteEmployee() {
        int userInputIdEmployee;

        System.out.println("Vui lòng nhập ID của nhân sự: ");
        userInputIdEmployee = scanner.nextInt();

        this.company
                .deleteEmployee(userInputIdEmployee);
        this.company.printAllEmployee(this.company.getEmployees());
        getUserConfirmExit();
    }

    private void processOptionSalaryEmployees() {
        this.company.printAllEmployee(this.company
                .getEmployees());

        double totalSalary = this.company.getTotalSalary();

        System.out.println("Tổng lương của công ty: " + Helper.formatCurrency(totalSalary));
        getUserConfirmExit();
    }

    private void processOptionFindEmployeeHighestSalary() {
        Employee employee = this.company.findEmployeeHighestSalary();
        if (employee == null) {
            System.out.println("Không tồn tại nhân viên lương cao nhất");
            getUserConfirmExit();
            return;
        }

        this.company.printAllEmployee(List.of(employee));
        getUserConfirmExit();
    }

    private void processOptionFindManagerHaveHighestEmployee() {
        Manager manager = this.company.findManagerHaveMostEmployee();

        if (manager == null) {
            System.out.println("Không tồn tại quản lý có nhiều nhân viên nhất");
            getUserConfirmExit();
            return;
        }

        this.company.printAllManagerRole(List.of(manager));
        getUserConfirmExit();
    }

    private void processOptionSortEmployeeNameASC() {
        List<Employee> employees = this.company.sortEmployeeByNameASC();
        this.company.printAllEmployee(employees);
        getUserConfirmExit();
    }

    private void processOptionSortEmployeeSalaryDESC() {
        List<Employee> employees = this.company.sortEmployeeBySalaryDESC();
        this.company.printAllEmployee(employees);
        getUserConfirmExit();
    }

    public void processOptionFindDirectorHaveHighestShareCapacity() {
        Director director = this.company.findHighestShareCapacityDirector();

        if (director == null) {
            System.out.println("Không tồn tại giám đốc có số lượng cổ phần nhiều nhất");
            getUserConfirmExit();
            return;
        }

        this.company.printAllDirectorTotalIncome(List.of(director));
        getUserConfirmExit();
    }

    public void processOptionCalcDirectorIncome() {
        List<Director> directors = this.company.calcDirectorIncome();

        if (directors == null || directors.isEmpty()) {
            System.out.println("Không tồn tại giám đốc có lương cao nhất");
            getUserConfirmExit();
            return;
        }

        this.company.printAllDirectorTotalIncome(directors);
        getUserConfirmExit();
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
