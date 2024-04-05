package org.cybersoft.buoi7.part1;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        int numberElementOfArray;
        Scanner scanner = new Scanner(System.in);

        numberElementOfArray = getNumberElementOfArray(scanner);
        double[] array = new double[numberElementOfArray];
        addValueToArray(scanner, array);
        double largestNumber = findLargestNumber(array);
        double lowestNumber = findLowestNumber(array);

        System.out.println("Largest number is: " + largestNumber);
        System.out.println("Lowest number is: " + lowestNumber);

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

    public static void addValueToArray(Scanner scanner, double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("Please input number at position " + i + ": ");
            array[i] = scanner.nextDouble();
        }
    }

    public static double findLargestNumber(double[] array) {
        double largestNumber = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largestNumber) {
                largestNumber = array[i];
            }
        }

        return largestNumber;
    }

    public static double findLowestNumber(double[] array) {
        double lowestNumber = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < lowestNumber) {
                lowestNumber = array[i];
            }
        }

        return lowestNumber;
    }
}
