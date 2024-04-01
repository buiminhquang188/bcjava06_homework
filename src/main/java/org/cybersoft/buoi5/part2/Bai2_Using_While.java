package org.cybersoft.buoi5.part2;

import java.util.Scanner;

public class Bai2_Using_While {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int i = 0;

        System.out.print("Please input positive integer number: ");
        int n = scanner.nextInt();

        while (i <= n) {
            if (i % 2 == 0) {
                sum += i;
            }
            i++;
        }

        System.out.println("Sum even: " + sum);

        scanner.close();
    }
}
