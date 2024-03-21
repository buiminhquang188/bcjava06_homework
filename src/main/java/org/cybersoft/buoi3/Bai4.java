package org.cybersoft.buoi3;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input 5 number separate with space: ");

        double inputNumber = scanner.nextDouble();
        inputNumber += scanner.nextDouble();
        inputNumber += scanner.nextDouble();
        inputNumber += scanner.nextDouble();
        inputNumber += scanner.nextDouble();

        double result = inputNumber / 5;

        System.out.println("Result:" + result);

        scanner.close();
    }
}
