package org.cybersoft.buoi12;

import org.cybersoft.buoi12.User.User;

import java.util.concurrent.atomic.AtomicInteger;

public class MainApplication {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        User user = new User();

        int userOption = user.getUserOption();
        user.processOption(userOption, atomicInteger);
    }
}