package org.cybersoft.buoi5.part2;

public class Bai1_Using_For {
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println("Even: " + i);
            } else {
                System.out.println("Odd: " + i);
            }
        }
    }
}
