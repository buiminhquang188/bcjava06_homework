package org.cybersoft.buoi7.part1;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        int userInput;
        int result;
        Scanner scanner = new Scanner(System.in);

        userInput = getUserInput(scanner);
        result = calcSumOfEvenNumber(userInput);

        System.out.println("Total of even from 0 to " + userInput + " is " + result);
    }

    public static int getUserInput(Scanner scanner) {
        int userInput;
        System.out.print("Please input positive integer: ");
        userInput = scanner.nextInt();

        while (userInput < 0) {
            System.out.print("Invalid number, please input again: ");
            userInput = scanner.nextInt();
        }
        return userInput;
    }

    public static int calcSumOfEvenNumber(int userInput) {
        int result = 0;
        for (int i = 0; i <= userInput; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }
}

