package org.cybersoft.buoi5.part2;

public class Bai3_Using_While {
    public static void main(String[] args) {
        int totalNumDividerForThree = 0;
        int i = 0;

        while (i <= 1000) {
            if (i % 3 == 0) {
                totalNumDividerForThree++;
            }
            i++;
        }

        System.out.print("Total number divider by 3: " + totalNumDividerForThree);
    }
}
