package org.cybersoft.buoi12.Company;

import org.cybersoft.buoi12.Director.Director;
import org.cybersoft.buoi12.Employee.Employee;
import org.cybersoft.buoi12.Manager.Manager;

import java.util.List;
import java.util.Scanner;

public interface ICompany {
    void nhapThongTinCongty(Scanner scanner);

    void xuatThongTinCongTy();

    void nhapThongTinNhanVien(Scanner scanner, int id);

    void nhapThongTinQuanLy(Scanner scanner, int id);

    void nhapThongTinGiamDoc(Scanner scanner, int id);

    void printAllEmployee(List<Employee> employees);

    void printAllManager(List<Employee> managers);

    void printAllDirector(List<Employee> directors);

    void printAllDirectorTotalIncome(List<Director> directors);

    double calcAllEmployeeSalary();

    Manager promoteEmployeeToManager(Integer employeeId);

    void deleteEmployee(Integer employeeId);

    List<Employee> sortEmployeeByNameASC();

    List<Employee> sortEmployeeBySalaryDESC();

    Employee findEmployeeHighestSalary();

    Manager findManagerHaveMostEmployee();

    Director findHighestShareCapacityDirector();

    List<Director> calcDirectorIncome();
}
