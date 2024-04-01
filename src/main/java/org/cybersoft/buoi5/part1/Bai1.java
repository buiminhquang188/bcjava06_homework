package org.cybersoft.buoi5.part1;

import java.util.Random;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] options = {"Rock", "Paper", "Scissors"};
        Random option = new Random();

        int userWin = 0, computerWin = 0, total = 0;

        printOptions();
        System.out.print("Please choose options: ");
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput != 1 && userInput != 2 && userInput != 3) {
                System.out.print("\n\n");
                printOptions();
                System.out.print("Invalid options, please choose again: ");
                userInput = scanner.nextInt();
            } else {
                int randomIndex = option.nextInt(options.length);
                System.out.println(randomIndex);
                String computerOption = options[randomIndex];

                String userOption = options[userInput - 1];

                if ((userOption.equalsIgnoreCase("Rock") && computerOption.equalsIgnoreCase("Paper")) || (userOption.equalsIgnoreCase("Paper") && computerOption.equalsIgnoreCase("Scissors")) || (userOption.equalsIgnoreCase("Scissors") && computerOption.equalsIgnoreCase("Rock"))) {
                    System.out.println("=========================================================");
                    System.out.println(userOption + " vs " + computerOption);
                    System.out.println("Winner is Computer");
                    computerWin++;

                    printOptions();
                    System.out.print("Please choose options: ");
                    userInput = scanner.nextInt();
                } else if (userOption.equalsIgnoreCase(computerOption)) {
                    System.out.println("=========================================================");
                    System.out.println(userOption + " vs " + computerOption);
                    System.out.println("Draw");

                    printOptions();
                    System.out.print("Please choose options: ");
                    userInput = scanner.nextInt();
                } else {
                    System.out.println("=========================================================");
                    System.out.println(userOption + " vs " + computerOption);
                    System.out.println("Winner is You");
                    userWin++;

                    printOptions();
                    System.out.print("Please choose options: ");
                    userInput = scanner.nextInt();
                }
                total++;
            }
        }

        System.out.println("=========================================================");
        System.out.println("Total games played: " + total);
        calcPersonWin(userWin, computerWin);

        scanner.close();
    }

    public static void printOptions() {
        System.out.println("=========================================================");
        System.out.println("1. Rock.\n2. Paper.\n3. Scissors\n0. Exit");
    }

    public static void calcPersonWin(int userWin, int computerWin) {
        if (computerWin > userWin) {
            System.out.println("The winner is Computer with total win: " + computerWin);
        } else if (computerWin == userWin) {
            System.out.println("Draw: " + computerWin);
        } else {
            System.out.println("The winner is YOU with total win: " + userWin);
        }
    }
}
