package org.cybersoft.buoi7.part2;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);

        number = getNumberElementArray(scanner);

        int[] array = new int[number];

        inputValueArray(array, scanner);
        printValueArray(array, scanner);
        
        findLargestValue(array);
        findFirstNegativeValue(array);
        findLargestNegativeValue(array);
        sumEvenOfArray(array);
        countNegativeNumber(array);
        findNumber(array, scanner);

        scanner.close();
    }

    public static int getNumberElementArray(Scanner scanner) {
        System.out.print("Please input number of element in array: ");
        return scanner.nextInt();
    }

    public static void inputValueArray(int[] array, Scanner scanner) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("Please input value of index " + i + ": ");
            array[i] = scanner.nextInt();
        }
    }

    public static void printValueArray(int[] array, Scanner scanner) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Value at index " + i + ": " + array[i]);
        }
    }

    public static void findLargestValue(int[] array) {
        int largestValueIndex = 0;
        int largestValue = array[largestValueIndex];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largestValue) {
                largestValue = array[i];
                largestValueIndex = i;
            }
        }
        System.out.println("Largest value: " + largestValue + " with index " + largestValueIndex);
    }

    public static int findFirstNegativeValue(int[] array) {
        int firstNegativeIndex = 0;
        int firstNegativeValue = array[firstNegativeIndex];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                firstNegativeValue = array[i];
                firstNegativeIndex = i;
                break;
            }
        }
        System.out.println("First negative value: " + firstNegativeValue + " with index " + firstNegativeIndex);
        return firstNegativeIndex;
    }

    public static void findLargestNegativeValue(int[] array) {
        int largestValueNegativeIndex = 0;
        int largestValueNegative = array[largestValueNegativeIndex];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0 && array[i] > largestValueNegative) {
                largestValueNegative = array[i];
                largestValueNegativeIndex = i;
            }
        }

        if (largestValueNegative > 0) {
            System.out.println("There is no negative value");
        } else {
            System.out.println("Largest negative value: " + largestValueNegative + " with index " + largestValueNegativeIndex);
        }
    }

    public static void findLargestNegativeValue_2(int[] array) {
        int position = findFirstNegativeValue(array);
        int max = array[position];

        for (int i = position; i < array.length; i++) {
            if (array[i] < 0 && array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("Largest negative value: " + max + " with index " + max);
    }

    public static void sumEvenOfArray(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                result += array[i];
            }
        }

        System.out.println("Sum of even value in array: " + result);
    }

    public static void countNegativeNumber(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                count++;
            }
        }

        System.out.println("Negative number: " + count);
    }

    public static void sumOfNegativeNumber(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                result += array[i];
            }
        }

        System.out.println("Sum of negative number: " + result);
    }

    public static void findNumber(int[] array, Scanner scanner) {
        boolean hasValue = false;
        int index = 0;
        System.out.print("Please input number you want to find in array: ");
        int userInput = scanner.nextInt();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == userInput) {
                hasValue = true;
                index = i;
                break;
            }
        }

        if (hasValue) {
            System.out.println("Found " + array[index] + " at position " + index);
        } else {
            System.out.println("Value not found in array");
        }
    }
}
