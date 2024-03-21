package org.cybersoft.buoi3;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input A: ");
        double a = scanner.nextDouble();

        System.out.print("Please input N: ");
        int n = scanner.nextInt();

        double p = a * Math.pow(8, n);
        System.out.print("Result: " + p);

        scanner.close();
    }
}
