package org.cybersoft.buoi12;

import org.cybersoft.buoi12.Company.Company;
import org.cybersoft.buoi12.Director.Director;
import org.cybersoft.buoi12.Employee.Employee;
import org.cybersoft.buoi12.Manager.Manager;
import org.cybersoft.buoi12.User.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MainApplication {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);

        User user = new User();
        int userOption = user.getUserOption();

        Company company = new Company("Cybersoft", "123321", 300000000, new ArrayList<>());
        Employee employee = new Employee(atomicInteger.getAndIncrement(), "Trân", "01232323", 12, null);
        Employee employee1 = new Employee(atomicInteger.getAndIncrement(), "Khánh", "01232323", 9, null);
        Director director = new Director(atomicInteger.getAndIncrement(), "Quang", "023122321", 30, 15);
        Employee employee2 = new Employee(atomicInteger.getAndIncrement(), "Mai", "01232323", 31, null);
        Employee employee3 = new Employee(atomicInteger.getAndIncrement(), "Thành", "01232323", 18, null);
        Manager manager = new Manager(atomicInteger.getAndIncrement(), "Dũng", "012332131", 27);
        Employee employee4 = new Employee(atomicInteger.getAndIncrement(), "Huy Anh", "01232323", 24, null);

        user.setCompany(company);
        user.getCompany()
                .getEmployees()
                .addAll(Arrays.asList(employee, employee1, director, employee2, employee3, manager, employee4));

//        user.getCompany()
//                .getEmployees()
//                .addAll(Arrays.asList(employee));

//        user.printAll(company.getEmployees());
        user.processOption(userOption, atomicInteger);
    }
}
