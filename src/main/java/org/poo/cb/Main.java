package org.poo.cb;

import java.util.ArrayList;

public class Main {
	public static ArrayList<Utilizator> utilizatori;

	public static void main(String[] args) {
		if (args == null) {
			System.out.println("Running Main");
			return;
		}

		utilizatori = new ArrayList<>();

		try {
			ExchangeRates.getInstance().start("src/main/resources/" + args[0]);
			StockValues.getInstance().start("src/main/resources/" + args[1]);
			Commands.getInstance().start("src/main/resources/" + args[2]);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}