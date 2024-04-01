package org.cybersoft.buoi5.part2;

import java.util.Scanner;

public class Bai2_Using_For {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        System.out.print("Please input positive integer number: ");
        int n = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }

        System.out.println("Sum even: " + sum);

        scanner.close();
    }
}
