package org.cybersoft.buoi7.part1;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        double userInput;
        double resultArea;
        double resultPerimeter;
        Scanner scanner = new Scanner(System.in);

        userInput = getLengthOfSquare(scanner);
        resultArea = calcArea(userInput);
        resultPerimeter = calcPerimeter(userInput);

        System.out.println("Area of square is: " + resultArea);
        System.out.println("Perimeter of square is: " + resultPerimeter);
        scanner.close();
    }

    public static double getLengthOfSquare(Scanner scanner) {
        double userInput;

        System.out.print("Please input length of square: ");
        userInput = scanner.nextDouble();

        while (userInput < 0) {
            System.out.print("Invalid number, try again: ");
            userInput = scanner.nextDouble();
        }

        return userInput;
    }

    public static double calcArea(double length) {
        return length * length;
    }

    public static double calcPerimeter(double length) {
        return length * 4;
    }
}
