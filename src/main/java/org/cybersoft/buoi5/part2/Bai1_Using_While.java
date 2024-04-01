package org.cybersoft.buoi5.part2;

public class Bai1_Using_While {
    public static void main(String[] args) {
        int i = 0;
        while (i <= 100) {
            if (i % 2 == 0) {
                System.out.println("Even: " + i);
            } else {
                System.out.println("Odd: " + i);
            }
            i++;
        }
    }
}
