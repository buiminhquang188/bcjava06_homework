package org.cybersoft.buoi7.part1;

import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        int numberElementOfArray;
        Scanner scanner = new Scanner(System.in);

        numberElementOfArray = getNumberElementOfArray(scanner);
        int[] array = new int[numberElementOfArray];
        addValueToArray(scanner, array);
        printArray(array);

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
            System.out.print("Please input number at position " + i + ": ");
            array[i] = scanner.nextInt();
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Value at position " + i + ": " + array[i]);
        }
    }
}
