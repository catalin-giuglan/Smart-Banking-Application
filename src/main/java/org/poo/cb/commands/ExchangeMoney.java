package org.poo.cb.commands;

import org.poo.cb.Command;
import org.poo.cb.ExchangeRates;
import org.poo.cb.Utilizator;

import java.util.ArrayList;

public class ExchangeMoney extends Command {
	@Override
	public void execute(ArrayList<String> args) {
		String email = args.get(0);
		String currency1 = args.get(1);
		String currency2 = args.get(2);
		double amount = Double.parseDouble(args.get(3));

		Utilizator u = Utilizator.getUtilizator(email);

		double exchangeRate = ExchangeRates.getExchangeRate(currency1, currency2);
		if (exchangeRate * amount > u.getCont(currency1).getSuma()) {
			System.out.println("Insufficient amount in account " + currency1 + " for exchange");
			return;
		}

		if (exchangeRate * amount > u.getCont(currency1).getSuma() / 2)
			u.getCont(currency1).retrage(exchangeRate * amount + 0.01 * exchangeRate * amount);
		else
			u.getCont(currency1).retrage(exchangeRate * amount);
		u.getCont(currency2).depune(amount);
	}
}
