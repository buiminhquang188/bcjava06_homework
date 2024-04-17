package org.cybersoft.buoi9.bai1;

import java.util.Scanner;

public class Student {
    String name;
    int age;
    float math;
    float physics;
    float chemistry;

    public void getInformationStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input student name: ");
        name = scanner.next();

        System.out.print("Please input student age: ");
        age = scanner.nextInt();

        System.out.print("Please input student math score: ");
        math = scanner.nextInt();

        System.out.print("Please input student physics score: ");
        physics = scanner.nextInt();

        System.out.print("Please input student chemistry score: ");
        chemistry = scanner.nextInt();

        System.out.println("Student GPA: " + calcGPA());

        scanner.close();
    }

    public float calcGPA() {
        return (math + physics + chemistry) / 3;
    }
}
