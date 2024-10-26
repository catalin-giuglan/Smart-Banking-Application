package org.poo.cb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ExchangeRates {
	public static ExchangeRates instance = null;
	private ArrayList<String> exchangeRates;

	private ExchangeRates() {
	}

	public static ExchangeRates getInstance() {
		if (instance == null)
			instance = new ExchangeRates();
		return instance;
	}

	public static double getExchangeRate(String currency1, String currency2) {
		ExchangeRates instance = ExchangeRates.getInstance();
		int index = -1;

		for (String exchangeRate : instance.getExchangeRates().get(0).split(","))
			if (exchangeRate.equals(currency1))
				index = Arrays.stream(instance.getExchangeRates().get(0).split(",")).toList().indexOf(currency1);

		for (String exchangeRate : instance.getExchangeRates()) {
			String[] parts = exchangeRate.split(",");
			if (parts[0].equals(currency2))
				return Double.parseDouble(parts[index]);
		}

		return -1;
	}

	public ArrayList<String> getExchangeRates() {
		return exchangeRates;
	}

	public void start(String path) throws IOException {
		File file = new File(path);
		Scanner scanner = new Scanner(file);
		exchangeRates = new ArrayList<>();
		while (scanner.hasNextLine())
			exchangeRates.add(scanner.nextLine());
		scanner.close();
	}
}
