package org.cybersoft.buoi5.part1;

import java.util.Scanner;

public class Bai3_Using_Loop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter positive integer number: ");
        int userInput = scanner.nextInt();
        int result = 0;

        while (userInput < 0) {
            System.out.print("Number must be greater than 0: ");
            userInput = scanner.nextInt();
        }

        for (int i = 0; i <= userInput; i++) {
            if (i % 2 != 0) {
                result += i;
            }
        }

        System.out.println("Sum of Odd: " + result);

        scanner.close();
    }
}
