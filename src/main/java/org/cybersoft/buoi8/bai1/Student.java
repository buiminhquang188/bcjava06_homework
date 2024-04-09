package org.cybersoft.buoi8.bai1;

import java.util.Scanner;

public class Student {
    String name;
    String ID;
    float math;
    float physics;
    float chemistry;

    public void getInformationStudent() {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Please input student name: ");
        name = scanner.next();

        System.out.print("Please input student ID: ");
        ID = scanner.next();

        System.out.print("Please input student math score: ");
        math = scanner.nextInt();

        System.out.print("Please input student physics score: ");
        physics = scanner.nextInt();

        System.out.print("Please input student chemistry score: ");
        chemistry = scanner.nextInt();

        System.out.println("Student GPA: " + calcGPA());
        System.out.print("Student Capacity is: " + getStudentCapacity());

        scanner.close();
    }

    public float calcGPA() {
        return (math + physics + chemistry) / 3;
    }

    public String getStudentCapacity() {
        float gpa = calcGPA();

        if (gpa >= 9) {
            return "Marvelous";
        }

        if (gpa >= 8 && gpa < 9) {
            return "Excellent";
        }

        if (gpa >= 7 && gpa < 8) {
            return "Good";
        }

        if (gpa >= 6 && gpa < 7) {
            return "Average";
        }

        if (gpa >= 5 && gpa < 6) {
            return "Below Average";
        }

        return "Weak";
    }
}
