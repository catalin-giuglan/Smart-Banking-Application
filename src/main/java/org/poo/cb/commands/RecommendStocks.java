package org.poo.cb.commands;

import org.poo.cb.Command;
import org.poo.cb.StockValues;

import java.util.ArrayList;

public class RecommendStocks extends Command {
	@Override
	public void execute(ArrayList<String> args) {
		ArrayList<String> stocks = new ArrayList<String>();

		for (int i = 1; i < StockValues.getInstance().getStockValues().size(); i++) {
			String[] values = StockValues.getInstance().getStockValues().get(i).split(",");

			double sma5 = 0;
			for (int j = 10; j > 5; j--)
				sma5 += Double.parseDouble(values[j]);
			double medie5 = sma5 / 5;

			double sma10 = 0;
			for (int j = 10; j > 0; j--)
				sma10 += Double.parseDouble(values[j]);
			double medie10 = sma10 / 10;

			if (medie10 < medie5)
				stocks.add(values[0]);
		}

		StringBuilder json = new StringBuilder();
		json.append("{\"stockstobuy\":[");
		for (int i = 0; i < stocks.size(); i++) {
			json.append("\"" + stocks.get(i) + "\"");
			if (i < stocks.size() - 1)
				json.append(",");
		}
		json.append("]}");
		System.out.println(json);
	}
}
