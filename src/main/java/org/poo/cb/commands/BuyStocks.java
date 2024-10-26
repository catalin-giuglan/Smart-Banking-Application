package org.poo.cb.commands;

import org.poo.cb.Command;
import org.poo.cb.StockValues;
import org.poo.cb.Utilizator;

import java.util.ArrayList;

public class BuyStocks extends Command {
	@Override
	public void execute(ArrayList<String> args) {
		String email = args.get(0);
		String company = args.get(1);
		int noOfStocks = Integer.parseInt(args.get(2));

		Utilizator u = Utilizator.getUtilizator(email);

		double pret = StockValues.getLatestValue(company);
		if (pret * noOfStocks > u.getCont("USD").getSuma())
			System.out.println("Insufficient amount in account for buying stock");
		else {
			u.getCont("USD").retrage(pret * noOfStocks);
			u.getStock(company).adaugaActiuni(noOfStocks);
		}
	}
}
