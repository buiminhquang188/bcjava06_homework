package org.cybersoft.buoi9.bai3;

import java.util.Scanner;

public class Game {
    String name;
    int timePlayed;
    String winner;
    int highestScore;
    Scanner scanner;

    public void startGame() {
        scanner = new Scanner(System.in);
        System.out.print("Name game: ");
        name = scanner.next();
        timePlayed++;
    }

    public void endGame() {
        scanner.close();
    }

}
