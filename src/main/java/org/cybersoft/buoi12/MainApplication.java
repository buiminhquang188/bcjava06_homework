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
        user.processOption(userOption, atomicInteger);
    }
}