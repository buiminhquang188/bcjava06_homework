package org.cybersoft.buoi6.part1;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b, c;

        a = getInputNumber('a', scanner);
        b = getInputNumber('b', scanner);
        c = getInputNumber('c', scanner);

        double largestNumber = findLargestNumber(a, b, c);

        System.out.println("Largest number is " + largestNumber);

        scanner.close();
    }

    public static double getInputNumber(char name, Scanner scanner) {
        System.out.print("Please input number " + name + " : ");
        return scanner.nextDouble();
    }

    public static double findLargestNumber(double a, double b, double c) {
        double largestNumber = 0;

        if (a > largestNumber) {
            largestNumber = a;
        }

        if (b > largestNumber) {
            largestNumber = b;
        }

        if (c > largestNumber) {
            largestNumber = c;
        }

        return largestNumber;
    }
}
