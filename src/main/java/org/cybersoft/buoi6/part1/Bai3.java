package org.cybersoft.buoi6.part1;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input three number: ");

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double sum = sum(a, b, c);

        System.out.print("Sum: " + sum);
        scanner.close();
    }

    public static double sum(double a, double b, double c) {
        return a + b + c;
    }
}
