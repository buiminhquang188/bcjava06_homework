package org.cybersoft.buoi11.bai4;

import java.util.Scanner;

public class MainApplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Otos otos = new Otos();
		otos.nhap(scanner);

		scanner.close();
	}
}
