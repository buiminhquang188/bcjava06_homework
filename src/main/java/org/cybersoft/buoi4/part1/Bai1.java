package org.cybersoft.buoi4.part1;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentYear = 2024;

        System.out.print("Please input name of the first student: ");
        String firstStudentName = scanner.next();

        System.out.print("Please input the first student birth year: ");
        int firstBirthYear = scanner.nextInt();

        if (firstBirthYear >= currentYear) {
            System.out.println("Invalid year, student must be born before " + currentYear);
            scanner.close();
            return;
        }

        String youngestStudentName = firstStudentName;
        int youngestStudentBirthYear = firstBirthYear;

        System.out.print("Please input name of the second student: ");
        String secondStudentName = scanner.next();

        System.out.print("Please input the second student birth year: ");
        int secondBirthYear = scanner.nextInt();

        if (secondBirthYear >= currentYear) {
            System.out.println("Invalid year, student must be born before " + currentYear);
            scanner.close();
            return;
        }

        System.out.print("Please input name of the third student: ");
        String thirdStudentName = scanner.next();

        System.out.print("Please input the third student birth year: ");
        int thirdBirthYear = scanner.nextInt();

        if (thirdBirthYear >= currentYear) {
            System.out.println("Invalid year, student must be born before " + currentYear);
            scanner.close();
            return;
        }

        if (secondBirthYear > firstBirthYear && secondBirthYear > thirdBirthYear) {
            youngestStudentBirthYear = secondBirthYear;
            youngestStudentName = secondStudentName;
        } else if (thirdBirthYear > firstBirthYear && thirdBirthYear > secondBirthYear) {
            youngestStudentBirthYear = thirdBirthYear;
            youngestStudentName = thirdStudentName;
        } else if (firstBirthYear == secondBirthYear && firstBirthYear != thirdBirthYear) {
            System.out.println("Two youngest student age is the same " + youngestStudentName + " and " + secondStudentName + " born in " + youngestStudentBirthYear);
            scanner.close();
            return;
        } else if (secondBirthYear == thirdBirthYear && thirdBirthYear != firstBirthYear) {
            System.out.println("Two youngest student age is the same " + secondStudentName + " and " + thirdStudentName + " born in " + secondBirthYear);
            scanner.close();
            return;
        } else if (thirdBirthYear == firstBirthYear && thirdBirthYear != secondBirthYear) {
            System.out.println("Two youngest student age is the same " + thirdStudentName + " and " + firstStudentName + " born in " + thirdBirthYear);
            scanner.close();
            return;
        } else if (firstBirthYear == secondBirthYear && secondBirthYear == thirdBirthYear && thirdBirthYear == firstBirthYear) {
            System.out.println("Three student age is the same " + youngestStudentBirthYear);
            scanner.close();
            return;
        }

        System.out.println("The youngest student is " + youngestStudentName + " born in " + youngestStudentBirthYear);

        scanner.close();
    }
}
