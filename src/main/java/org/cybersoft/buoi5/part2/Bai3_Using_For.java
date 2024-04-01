package org.cybersoft.buoi5.part2;

public class Bai3_Using_For {
    public static void main(String[] args) {
        int totalNumDividerForThree = 0;
        for (int i = 0; i <= 1000; i++) {
            if (i % 3 == 0) {
                totalNumDividerForThree++;
            }
        }

        System.out.print("Total number divider by 3: " + totalNumDividerForThree);
    }
}
