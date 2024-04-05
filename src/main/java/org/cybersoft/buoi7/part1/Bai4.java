package org.cybersoft.buoi7.part1;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        int numberElementOfArray;
        Scanner scanner = new Scanner(System.in);

        numberElementOfArray = getNumberElementOfArray(scanner);
        int[] array = new int[numberElementOfArray];
        addValueToArray(scanner, array);
        double meanOfArray = calcMeanOfArray(array);

        System.out.println("Mean of Array: " + meanOfArray);

        scanner.close();
    }

    public static int getNumberElementOfArray(Scanner scanner) {
        int elementOfArray;

        System.out.print("Please input number of element in array: ");
        elementOfArray = scanner.nextInt();

        while (elementOfArray < 0) {
            System.out.print("Invalid number, try again: ");
            elementOfArray = scanner.nextInt();
        }
        return elementOfArray;
    }

    public static void addValueToArray(Scanner scanner, int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("Please input positive integer at position " + i + ": ");
            array[i] = scanner.nextInt();
            validatePositiveInteger(scanner, array[i]);
        }
    }

    public static void validatePositiveInteger(Scanner scanner, int userInput) {
        while (userInput < 0) {
            System.out.print("Invalid number, try again: ");
            userInput = scanner.nextInt();
        }
    }

    public static double calcMeanOfArray(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return (double) (result) / array.length;
    }
}
