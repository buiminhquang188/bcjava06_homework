package org.cybersoft.buoi3;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        DecimalFormat currencyFormat = new DecimalFormat("###,###,###.##");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input money (USD) you want convert to (VND): ");

        float currencyUSD = scanner.nextFloat();
        int rate = 23500;
        float currencyVN = currencyUSD * rate;

        System.out.println("Result: " + currencyFormat.format(currencyVN) + " VND");

        scanner.close();
    }
}
