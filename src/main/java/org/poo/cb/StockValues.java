package org.poo.cb;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StockValues {
	public static StockValues instance = null;
	private ArrayList<String> stockValues;

	private StockValues() {
	}

	public static StockValues getInstance() {
		if (instance == null)
			instance = new StockValues();
		return instance;
	}

	public static double getLatestValue(String stock) {
		StockValues instance = getInstance();

		for (int i = 1; i < instance.getStockValues().size(); i++) {
			String[] values = instance.getStockValues().get(i).split(",");
			if (values[0].equals(stock))
				return Double.parseDouble(values[values.length - 1]);
		}

		return 0;
	}

	public ArrayList<String> getStockValues() {
		return stockValues;
	}

	public void start(String path) throws IOException {
		File file = new File(path);
		Scanner scanner = new Scanner(file);
		stockValues = new ArrayList<>();
		while (scanner.hasNextLine())
			stockValues.add(scanner.nextLine());
		scanner.close();
	}
}
