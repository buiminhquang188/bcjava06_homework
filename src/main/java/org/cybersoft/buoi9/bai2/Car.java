package org.cybersoft.buoi9.bai2;

import java.util.Scanner;

public class Car {
    String brand;
    String color;
    int yearInvented;

    public void getCarInformation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input car brand: ");
        brand = scanner.next();

        System.out.print("Please input car color: ");
        color = scanner.next();

        System.out.print("Please input year invented the car: ");
        yearInvented = scanner.nextInt();

        scanner.close();
    }

    public void printCarInformation() {
        System.out.println("Car Information");
        System.out.println("Brand: " + brand);
        System.out.println("Color: " + color);
        System.out.println("Year Invented: " + yearInvented);
    }
}
