package org.cybersoft.buoi6.part1;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input number: ");

        int userInput = scanner.nextInt();

        String result = isEvenOrOdd(userInput);

        System.out.print("Number is: " + result);

        scanner.close();
    }

    public static String isEvenOrOdd(int userInput) {
        return userInput % 2 == 0 ? "Even" : "Odd";
    }
}
