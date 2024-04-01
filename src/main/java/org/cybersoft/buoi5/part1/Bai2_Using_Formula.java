package org.cybersoft.buoi5.part1;

public class Bai2_Using_Formula {
    public static void main(String[] args) {
        int THRESHOLD = 10000;
        int result = 0;

        double x1 = (-1 + Math.sqrt(Math.pow(1, 2) - 4 * -2 * THRESHOLD)) / (2 * 1);
        double x2 = (-1 - Math.sqrt(Math.pow(1, 2) - 4 * -2 * THRESHOLD)) / (2 * 1);

        x1 = Math.abs(x1);
        x2 = Math.abs(x2);

        result = (int) Math.max(x1, x2);

        System.out.println("The minimum positive integer N is: " + Math.round(result));
    }
}
