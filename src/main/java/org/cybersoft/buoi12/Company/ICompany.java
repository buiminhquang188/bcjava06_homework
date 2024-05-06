package org.cybersoft.buoi12.Company;

import org.cybersoft.buoi12.Director.Director;
import org.cybersoft.buoi12.Employee.Employee;
import org.cybersoft.buoi12.Manager.Manager;

import java.util.List;
import java.util.Scanner;

public interface ICompany {
    void inputCompany(Scanner scanner);

    void printCompany();

    void inputEmployee(Scanner scanner, int id);

    void inputManager(Scanner scanner, int id);

    void inputDirector(Scanner scanner, int id);

    void printAllEmployee(List<Employee> employees);

    void printAllEmployeeRole(List<Employee> employees);

    void printAllManagerRole(List<Employee> managers);

    void printAllDirectorRole(List<Employee> directors);

    void printAllDirectorTotalIncome(List<Director> directors);

    Manager promoteEmployeeToManager(int employeeId);

    void deleteEmployee(int employeeId);

    List<Employee> sortEmployeeByNameASC();

    List<Employee> sortEmployeeBySalaryDESC();

    Employee findEmployeeHighestSalary();

    Manager findManagerHaveMostEmployee();

    Director findHighestShareCapacityDirector();

    List<Director> calcDirectorIncome();
}
