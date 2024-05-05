package org.cybersoft.buoi12.Employee;

import java.util.Scanner;

public interface IEmployee {
    double calcSalary(int workDays, double salaryOfOneDay);

    void validateWorkDays(int userInput, Scanner scanner);

    void nhap(Scanner scanner, int id);

    void xuat();
}
