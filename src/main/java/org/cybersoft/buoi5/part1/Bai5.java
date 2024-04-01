package org.cybersoft.buoi5.part1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
        Scanner scanner = new Scanner(System.in);

        float savingRate = 4.7f;
        float monthToSave = 0;

        System.out.print("Please input the money you want to save: ");
        double userSavingInput = scanner.nextDouble();

        System.out.print("The total amount you want after saving?: ");
        double userExpectedInput = scanner.nextDouble();

        while (userSavingInput > userExpectedInput) {
            System.out.print("The expected amount cannot be smaller than first money saving: ");
            userExpectedInput = scanner.nextDouble();
        }

        double savingMoney = userExpectedInput - userSavingInput;
        monthToSave = (float) (1 / (userSavingInput * savingRate / 100 / 12 / savingMoney));
        formatNumberToMonthAndYears(monthToSave);
        System.out.println("Saving rate: " + savingRate + "%");
        System.out.println("Your saving: " + decimalFormat.format(savingMoney));

        scanner.close();
    }

    public static void formatNumberToMonthAndYears(float numberOfMonths) {
        float years = numberOfMonths / 12;
        float remainingMonths = numberOfMonths % 12;

        System.out.println(numberOfMonths);
        System.out.println("You have to wait approximately " + (int) years + " years" + " and " + (int) remainingMonths + " months");
    }
}
