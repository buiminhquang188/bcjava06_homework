package org.cybersoft.buoi7.part1;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        int userInput;
        Scanner scanner = new Scanner(System.in);

        userInput = getUserInput(scanner);
        String isPositiveOrNegative = isPositiveOrNegative(userInput);
        System.out.println("The number is " + isPositiveOrNegative + " integer");

        String isEvenOrOdd = isEvenOrOdd(userInput);
        System.out.println("The number is " + isEvenOrOdd);

        String isPrime = isPrime(userInput);
        System.out.println("The number is " + isPrime);
        scanner.close();
    }

    public static int getUserInput(Scanner scanner) {
        System.out.print("Please input integer number: ");
        return scanner.nextInt();
    }

    public static String isPositiveOrNegative(int userInput) {
        if (userInput > 0) {
            return "positive";
        }
        return "negative";
    }

    public static String isEvenOrOdd(int userInput) {
        return userInput % 2 == 0 ? "even" : "odd";
    }

    public static String isPrime(int userInput) {
        if (userInput < 2) {
            return "not a prime";
        }

        for (int i = 2; i < userInput; ++i) {
            if (userInput % i == 0) {
                return "not a prime";
            }
        }
        return "a prime";
    }

}
