package org.cybersoft.buoi4.part1;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Please input longitude and latitude of the University: ");
        double longitude = scanner.nextDouble();
        double latitude = scanner.nextDouble();

        System.out.print("Please input first student name: ");
        String firstStudentName = scanner.next();

        System.out.print("Please input longitude and latitude of the first student: ");
        double longitudeFirstStudent = scanner.nextDouble();
        double latitudeFirstStudent = scanner.nextDouble();
        double distanceOfFirstStudent = Math.sqrt(Math.pow((longitude - longitudeFirstStudent), 2) + Math.pow((latitude - latitudeFirstStudent), 2));

        String farestStudentName = firstStudentName;
        double farestStudentDistance = distanceOfFirstStudent;

        System.out.print("Please input second student name: ");
        String secondStudentName = scanner.next();

        System.out.print("Please input longitude and latitude of the second student: ");
        double longitudeSecondStudent = scanner.nextDouble();
        double latitudeSecondStudent = scanner.nextDouble();
        double distanceOfSecondStudent = Math.sqrt(Math.pow((longitude - longitudeSecondStudent), 2) + Math.pow((latitude - latitudeSecondStudent), 2));

        System.out.print("Please input third student name: ");
        String thirdStudentName = scanner.next();

        System.out.print("Please input longitude and latitude of the third student: ");
        double longitudeThirdStudent = scanner.nextDouble();
        double latitudeThirdStudent = scanner.nextDouble();
        double distanceOfThirdStudent = Math.sqrt(Math.pow((longitude - longitudeThirdStudent), 2) + Math.pow((latitude - latitudeThirdStudent), 2));


        if (distanceOfSecondStudent > distanceOfFirstStudent && distanceOfSecondStudent > distanceOfThirdStudent) {
            farestStudentName = secondStudentName;
            farestStudentDistance = distanceOfSecondStudent;
        } else if (distanceOfThirdStudent > distanceOfFirstStudent && distanceOfThirdStudent > distanceOfSecondStudent) {
            farestStudentName = thirdStudentName;
            farestStudentDistance = distanceOfThirdStudent;
        } else if (distanceOfFirstStudent == distanceOfSecondStudent && distanceOfFirstStudent != distanceOfThirdStudent) {
            System.out.println("There are two student have the same farthest distance " + farestStudentName + " and " + secondStudentName + " with distance " + farestStudentDistance);
            scanner.close();
            return;
        } else if (distanceOfSecondStudent == distanceOfThirdStudent && distanceOfThirdStudent != distanceOfFirstStudent) {
            System.out.println("There are two student have the same farthest distance " + secondStudentName + " and " + thirdStudentName + " with distance " + distanceOfSecondStudent);
            scanner.close();
            return;
        } else if (distanceOfThirdStudent == distanceOfFirstStudent && distanceOfThirdStudent != distanceOfSecondStudent) {
            System.out.println("There are two student have the same farthest distance " + distanceOfThirdStudent + " and " + thirdStudentName + " with distance " + distanceOfSecondStudent);
            scanner.close();
            return;
        } else if (distanceOfFirstStudent == distanceOfSecondStudent && distanceOfSecondStudent == distanceOfThirdStudent && distanceOfThirdStudent == distanceOfFirstStudent) {
            System.out.println("Three student distance is the same " + farestStudentDistance);
            scanner.close();
            return;
        }

        System.out.println("The farthest student is " + farestStudentName + " with distance " + farestStudentDistance);
        scanner.close();
    }
}
