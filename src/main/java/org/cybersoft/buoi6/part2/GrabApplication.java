package org.cybersoft.buoi6.part2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class GrabApplication {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
        Scanner scanner = new Scanner(System.in);
        int userOption, waitingTime;
        double kmDistance;

        userOption = getUserOption(scanner);
        kmDistance = getDistanceFromUser(scanner);
        waitingTime = getWaitingTimeFromUser(scanner);
        double price = calcPrice(userOption, kmDistance, waitingTime);


        System.out.println("Total price: " + decimalFormat.format(price) + " VND");
        scanner.close();
    }

    public static int getUserOption(Scanner scanner) {
        System.out.println("=========================================================");
        System.out.println("1. Grab Car.\n2. Grab SUV.\n3. Grab Black\n0. Exit");
        System.out.print("Please choose option: ");
        int userOption = scanner.nextInt();

        while (userOption != 1 && userOption != 2 && userOption != 3 && userOption != 0) {
            System.out.print("Invalid option, please choose again: ");
            userOption = scanner.nextInt();
        }

        return userOption;
    }

    public static double getDistanceFromUser(Scanner scanner) {
        System.out.print("Please input distance (km): ");
        double kmDistance = scanner.nextDouble();

        while (kmDistance < 0) {
            System.out.print("Distance cannot be smaller than 0, please input again: ");
            kmDistance = scanner.nextDouble();
        }

        return kmDistance;
    }

    public static int getWaitingTimeFromUser(Scanner scanner) {
        System.out.print("Please input waiting time (minutes): ");
        int waitingTime = scanner.nextInt();

        while (waitingTime < 0) {
            System.out.print("Waiting time cannot be smaller than 0, please input again: ");
            waitingTime = scanner.nextInt();
        }

        return waitingTime;
    }

    public static double calcPrice(int userOption, double kmDistance, int waitingTime) {
        double price = 0;
        switch (userOption) {
            case 1:
                price = calcGrabCarPrice(kmDistance, waitingTime);
                break;
            case 2:
                price = calcGrabSUVPrice(kmDistance, waitingTime);
                break;
            case 3:
                price = calcGrabBlackPrice(kmDistance, waitingTime);
                break;
            default:
                break;
        }
        return price;
    }

    public static double calcGrabCarPrice(double kmDistance, int waitingTime) {
        double DEFAULT_PRICE = 8000;
        double ONE_TO_NINETEEN_KM = 7500;
        double UPPER_NINETEEN_KM = 7000;
        double DEFAULT_WAITING_PRICE = 2000;

        double distancePrice = getDistancePrice(DEFAULT_PRICE, ONE_TO_NINETEEN_KM, UPPER_NINETEEN_KM, kmDistance);
        double waitingPrice = getWaitingPrice(DEFAULT_WAITING_PRICE, waitingTime);

        return distancePrice + waitingPrice;
    }

    public static double calcGrabSUVPrice(double kmDistance, int waitingTime) {
        double DEFAULT_PRICE = 9000;
        double ONE_TO_NINETEEN_KM = 8500;
        double UPPER_NINETEEN_KM = 8000;
        double DEFAULT_WAITING_PRICE = 3000;

        double distancePrice = getDistancePrice(DEFAULT_PRICE, ONE_TO_NINETEEN_KM, UPPER_NINETEEN_KM, kmDistance);
        double waitingPrice = getWaitingPrice(DEFAULT_WAITING_PRICE, waitingTime);

        return distancePrice + waitingPrice;
    }

    public static double calcGrabBlackPrice(double kmDistance, int waitingTime) {
        double DEFAULT_PRICE = 10000;
        double ONE_TO_NINETEEN_KM = 9500;
        double UPPER_NINETEEN_KM = 9000;
        double DEFAULT_WAITING_PRICE = 3500;

        double distancePrice = getDistancePrice(DEFAULT_PRICE, ONE_TO_NINETEEN_KM, UPPER_NINETEEN_KM, kmDistance);
        double waitingPrice = getWaitingPrice(DEFAULT_WAITING_PRICE, waitingTime);

        return distancePrice + waitingPrice;
    }

    public static double getDistancePrice(double DEFAULT_PRICE, double ONE_TO_NINETEEN_KM, double UPPER_NINETEEN_KM, double kmDistance) {
        double totalPrice = 0;

        if (kmDistance >= 1) {
            totalPrice = DEFAULT_PRICE * 1;
        }

        if (kmDistance >= 1 && kmDistance <= 19) {
            totalPrice += ONE_TO_NINETEEN_KM * (kmDistance - 1);
        }

        if (kmDistance > 19) {
            totalPrice += UPPER_NINETEEN_KM * (kmDistance - 20);
        }

        return totalPrice;
    }

    public static double getWaitingPrice(double DEFAULT_WAITING_PRICE, int waitingTime) {
        if (waitingTime <= 3) return 0;
        int total = waitingTime / 3;
        return total * DEFAULT_WAITING_PRICE;
    }
}
