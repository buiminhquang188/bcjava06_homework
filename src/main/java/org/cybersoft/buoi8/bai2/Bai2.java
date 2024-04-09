package org.cybersoft.buoi8.bai2;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User(scanner);
        int userOption = user.getUserOption();
        user.processUserOption(userOption);
    }
}
