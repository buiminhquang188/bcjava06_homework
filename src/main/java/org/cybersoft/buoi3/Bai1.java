package org.cybersoft.buoi3;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input Altitude: ");
        int altitude = scanner.nextInt();

        System.out.print("Please input Base: ");
        int base = scanner.nextInt();

        double hypotenuse = Math.sqrt(Math.pow(altitude, 2) + Math.pow(base, 2));

        System.out.println("Hypotenuse: " + hypotenuse);
        scanner.close();
    }
}