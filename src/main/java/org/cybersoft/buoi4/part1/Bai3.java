package org.cybersoft.buoi4.part1;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentYear = 2024;
        String MALE = "Male";
        String FEMALE = "Female";

        // First person

        System.out.print("Please input name of the first person: ");
        String firstPersonName = scanner.next();

        System.out.print("Please input gender of the first person (Male/Female): ");
        String firstPersonGender = scanner.next();

        if (!firstPersonGender.equals(MALE) && !firstPersonGender.equals(FEMALE)) {
            System.out.println("Invalid gender");
            scanner.close();
            return;
        }

        System.out.print("Please input the first person birth year: ");
        int firstBirthYear = scanner.nextInt();

        if (firstBirthYear >= currentYear) {
            System.out.println("Invalid year, the person must be born before " + currentYear);
            scanner.close();
            return;
        }

        // Initialize the youngest person variables

        String youngestPersonName = "";
        int youngestPersonBirthYear = 0;

        // Second person

        System.out.print("Please input name of the second person: ");
        String secondPersonName = scanner.next();

        System.out.print("Please input gender of the first person (Male/Female): ");
        String secondPersonGender = scanner.next();

        if (!secondPersonGender.equals(MALE) && !secondPersonGender.equals(FEMALE)) {
            System.out.println("Invalid gender");
            scanner.close();
            return;
        }

        System.out.print("Please input the second person birth year: ");
        int secondBirthYear = scanner.nextInt();

        if (secondBirthYear >= currentYear) {
            System.out.println("Invalid year, the person must be born before " + currentYear);
            scanner.close();
            return;
        }

        // Third person

        System.out.print("Please input name of the third person: ");
        String thirdPersonName = scanner.next();

        System.out.print("Please input gender of the first person (Male/Female): ");
        String thirdPersonGender = scanner.next();

        if (!thirdPersonGender.equals(MALE) && !thirdPersonGender.equals(FEMALE)) {
            System.out.println("Invalid gender");
            scanner.close();
            return;
        }

        System.out.print("Please input the third person birth year: ");
        int thirdBirthYear = scanner.nextInt();

        if (thirdBirthYear >= currentYear) {
            System.out.println("Invalid year, the person must be born before " + currentYear);
            scanner.close();
            return;
        }

        if (firstPersonGender.equalsIgnoreCase(MALE) && firstBirthYear > youngestPersonBirthYear) {
            youngestPersonBirthYear = firstBirthYear;
            youngestPersonName = firstPersonName;
        }

        if (secondPersonGender.equalsIgnoreCase(MALE) && secondBirthYear > youngestPersonBirthYear) {
            youngestPersonBirthYear = secondBirthYear;
            youngestPersonName = secondPersonName;
        }

        if (thirdPersonGender.equalsIgnoreCase(MALE) && thirdBirthYear > youngestPersonBirthYear) {
            youngestPersonBirthYear = thirdBirthYear;
            youngestPersonName = thirdPersonName;
        }

        System.out.println("The youngest person is " + youngestPersonName + " born in " + youngestPersonBirthYear);

        scanner.close();
    }
}
