package org.poo.cb.commands;

import org.poo.cb.Command;
import org.poo.cb.Utilizator;

import java.util.ArrayList;

public class AddMoney extends Command {
	@Override
	public void execute(ArrayList<String> args) {
		String email = args.get(0);
		String currency = args.get(1);
		double amount = Double.parseDouble(args.get(2));

		Utilizator u = Utilizator.getUtilizator(email);
		u.adaugaSuma(currency, amount);
	}
}
