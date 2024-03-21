package org.cybersoft.buoi3;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input number Celsius: ");

        int celsiusNumber = scanner.nextInt();
        double fahrenheit = (celsiusNumber * 1.8) + 32;

        System.out.println("Result:" + fahrenheit);

        scanner.close();
    }
}
