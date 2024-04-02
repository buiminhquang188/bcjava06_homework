package org.cybersoft.buoi6.part1;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printMenu();
        double userInput = getUserInput(scanner);

        System.out.print("Please choose option: ");
        int userOption = scanner.nextInt();

        double result = 0;

        while (userOption != 5) {
            if (userOption != 1 && userOption != 2 && userOption != 3 && userOption != 4) {
                System.out.print("\n");
                printMenu();
                System.out.print("Invalid options, please choose again: ");
                userOption = scanner.nextInt();
            } else if (userInput == 0) {
                System.out.print("\n");
                printMenu();
                System.out.print("Invalid input number, please input again: ");
                userInput = scanner.nextDouble();
            } else {
                result = calcNumber(userOption, userInput, result);
                System.out.println("Result: " + result);

                printMenu();
                System.out.print("Please choose option: ");
                userOption = scanner.nextInt();
                if (userOption == 5) break;

                System.out.print("Please input number: ");
                userInput = scanner.nextInt();
            }
        }

        System.out.println("Final result: " + result);
        scanner.close();
    }

    public static double getUserInput(Scanner scanner) {
        System.out.print("Please input number: ");
        double userInput = scanner.nextDouble();

        while (userInput == 0) {
            System.out.print("\n");
            printMenu();
            System.out.print("Invalid input number, please input again: ");
            userInput = scanner.nextDouble();
        }

        return userInput;
    }

    public static void printMenu() {
        System.out.println("=========================================================");
        System.out.println("1. + \n2. - \n3. * \n4. / \n5. Exit");
    }

    public static double calcNumber(int userOption, double userInput, double result) {
        switch (userOption) {
            case 1:
                result += userInput;
                return result;
            case 2:
                result -= userInput;
                return result;
            case 3:
                result *= userInput;
                return result;
            case 4:
                result /= userInput;
                return result;
            default:
                return result;
        }
    }
}
