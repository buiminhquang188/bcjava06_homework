package org.cybersoft.buoi5.part1;

public class Bai2_Using_Loop {
    public static void main(String[] args) {
        int THRESHOLD = 10000;
        int total = 0;
        int startNumber = 1;

        while (total < THRESHOLD) {
            total += startNumber;

            if (total < THRESHOLD) {
                startNumber++;
            }
        }

        System.out.println("The minimum positive integer N is: " + startNumber);
    }
}
