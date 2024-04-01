package org.cybersoft.buoi5.part1;

import java.util.Scanner;

public class Bai3_Using_Formula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter positive integer number: ");
        int userInput = scanner.nextInt();

        while (userInput < 0) {
            System.out.print("Number must be greater than 0: ");
            userInput = scanner.nextInt();
        }

        int result = (int) Math.pow((double) (userInput + 1) / 2, 2);
        System.out.println("Sum of Odd: " + result);

        scanner.close();
    }
}
