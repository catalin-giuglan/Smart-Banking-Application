package org.poo.cb.commands;

import org.poo.cb.Command;
import org.poo.cb.Utilizator;

import java.util.ArrayList;

public class AddAccount extends Command {
	@Override
	public void execute(ArrayList<String> args) {
		String email = args.get(0);
		String currency = args.get(1);

		Utilizator u = Utilizator.getUtilizator(email);
		u.adaugaCont(currency);
	}
}
