package org.cybersoft.buoi5.part1;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input positive integer N: ");
        int n = scanner.nextInt();

        System.out.print("Please input positive integer X: ");
        int x = scanner.nextInt();

        long result = calcSum(n, x);

        System.out.print(result);
        scanner.close();
    }

    public static long calcSum(int n, int x) {
        long result = 0;
        for (int i = 1; i <= n; i++) {
            result += (long) Math.pow(x, i);
        }
        return result;
    }
}
