package org.cybersoft.buoi7.part1;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        int userInput;
        Scanner scanner = new Scanner(System.in);

        userInput = getUserInput(scanner);
        String numberToString = convertNumberToString(userInput);
        System.out.println(numberToString);

        scanner.close();
    }

    public static int getUserInput(Scanner scanner) {
        int userInput;
        System.out.print("Please input integer from 1 to 10: ");
        userInput = scanner.nextInt();

        while (userInput < 1 || userInput > 10) {
            System.out.print("Invalid number, please input again: ");
            userInput = scanner.nextInt();
        }
        return userInput;
    }

    public static String convertNumberToString(int userInput) {
        switch (userInput) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            default:
                return "Invalid number";
        }
    }
}
