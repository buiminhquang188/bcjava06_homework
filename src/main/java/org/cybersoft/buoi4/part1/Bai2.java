package org.cybersoft.buoi4.part1;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countEven = 0;
        int countOdd = 0;

        System.out.print("Please input first integer number: ");
        int firstInteger = scanner.nextInt();

        if (firstInteger % 2 == 0) {
            ++countEven;
        } else {
            ++countOdd;
        }

        System.out.print("Please input second integer number: ");
        int secondInteger = scanner.nextInt();

        if (secondInteger % 2 == 0) {
            ++countEven;
        } else {
            ++countOdd;
        }

        System.out.print("Please input second integer number: ");
        int thirdInteger = scanner.nextInt();

        if (thirdInteger % 2 == 0) {
            ++countEven;
        } else {
            ++countOdd;
        }

        System.out.println("Even: " + countEven + " - " + "Odd: " + countOdd);
        scanner.close();
    }
}
