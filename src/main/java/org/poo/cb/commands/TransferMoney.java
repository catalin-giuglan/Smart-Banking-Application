package org.poo.cb.commands;

import org.poo.cb.Command;
import org.poo.cb.Utilizator;

import java.util.ArrayList;

public class TransferMoney extends Command {
	@Override
	public void execute(ArrayList<String> args) {
		String email1 = args.get(0);
		String email2 = args.get(1);
		String currency = args.get(2);
		double amount = Double.parseDouble(args.get(3));

		Utilizator u1 = Utilizator.getUtilizator(email1);
		Utilizator u2 = Utilizator.getUtilizator(email2);

		if (u1.getCont(currency).getSuma() < amount) {
			System.out.println("Insufficient amount in account " + currency + " for transfer");
			return;
		}

		if (u1.getPrieteni().contains(u2.getEmail())) {
			u1.getCont(currency).retrage(amount);
			u2.getCont(currency).depune(amount);
		} else {
			System.out.println("You are not allowed to transfer money to " + u2.getEmail());
		}
	}
}
