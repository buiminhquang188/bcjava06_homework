package org.cybersoft.buoi4;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat numberFormat = new DecimalFormat("###,###,###.##");

        float DISCOUNT_RATE_8_PERCENT = (float) 8 / 100;
        float DISCOUNT_RATE_12_PERCENT = (float) 12 / 100;

        System.out.print("Please enter price of the product: ");
        double priceOfProduct = scanner.nextDouble();

        if (priceOfProduct <= 0) {
            System.out.print("Product price must be greater than zero");
        }

        System.out.print("Please input amount you want to buy: ");
        int buyerAmount = scanner.nextInt();

        double totalPriceAmount = buyerAmount * priceOfProduct;

        if (buyerAmount <= 0) {
            System.out.println("The amount must be positive");
            scanner.close();
            return;
        }

        if (buyerAmount >= 50 && buyerAmount <= 100) {
            totalPriceAmount = totalPriceAmount - (totalPriceAmount * DISCOUNT_RATE_8_PERCENT);
        } else if (buyerAmount > 100) {
            totalPriceAmount = totalPriceAmount - (totalPriceAmount * DISCOUNT_RATE_12_PERCENT);
        }

        System.out.println("Customer have to pay: " + numberFormat.format(totalPriceAmount));
        scanner.close();
    }
}
