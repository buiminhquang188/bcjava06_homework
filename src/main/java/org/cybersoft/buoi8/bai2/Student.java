package org.cybersoft.buoi8.bai2;

import java.util.Scanner;

public class Student {
    String name;
    String ID;
    float math;
    float physics;
    float chemistry;

    float gpa;

    public Student() {
    }

    public Student(String name, String ID, float math, float physics, float chemistry) {
        this.name = name;
        this.ID = ID;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        calcGPA();
    }

    public void getInformationStudent(Student[] students, Scanner scanner) {
        System.out.print("Please input student name: ");
        name = scanner.next();

        System.out.print("Please input student ID: ");
        ID = scanner.next();
        boolean isContainStudentID = Students.isContainStudentID(students, ID);
        while (isContainStudentID) {
            System.out.print("ID must be unique, please try again: ");
            ID = scanner.next();
            isContainStudentID = Students.isContainStudentID(students, ID);
        }

        System.out.print("Please input student math score: ");
        math = scanner.nextInt();

        System.out.print("Please input student physics score: ");
        physics = scanner.nextInt();

        System.out.print("Please input student chemistry score: ");
        chemistry = scanner.nextInt();

        calcGPA();
    }

    public float calcGPA() {
        gpa = (math + physics + chemistry) / 3;
        return gpa;
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
            return "Poor";
        }

        return "Weak";
    }

    public void printStudent(Student student) {
        String leftAlignFormat = "| %-6s | %-8s | %-8.2f | %-11.2f | %-13.2f | %-7.2f | %-12s |%n";

        System.out.format("+--------+----------+----------+-------------+---------------+---------+--------------+%n");
        System.out.format("| ID     | Name     | Math     | Physics     | Chemistry     | GPA     | Capacity     |%n");
        System.out.format("+--------+----------+----------+-------------+---------------+---------+--------------+%n");
        System.out.format(leftAlignFormat, student.ID, student.name, student.math, student.physics, student.chemistry, student.gpa, student.getStudentCapacity());
        System.out.format("+--------+----------+----------+-------------+---------------+---------+--------------+%n");
    }
}
