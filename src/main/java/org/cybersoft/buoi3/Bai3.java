package org.cybersoft.buoi3;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input two digits number: ");

        int twoDigits = scanner.nextInt();
        int tens = twoDigits / 10;
        int ones = twoDigits % 10;
        int totalTwoDigits = tens + ones;

        System.out.println("Result: " + totalTwoDigits);

        scanner.close();
    }
}
