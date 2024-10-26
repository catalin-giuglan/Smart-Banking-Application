package org.poo.cb.commands;

import org.poo.cb.Command;
import org.poo.cb.Utilizator;

import java.util.ArrayList;

public class AddFriend extends Command {
	@Override
	public void execute(ArrayList<String> args) {
		String email1 = args.get(0);
		String email2 = args.get(1);

		Utilizator u1 = Utilizator.getUtilizator(email1);
		if (u1 == null) {
			System.out.println("User with " + email1 + " doesn't exist");
			return;
		}

		Utilizator u2 = Utilizator.getUtilizator(email2);
		if (u2 == null) {
			System.out.println("User with " + email2 + " doesn't exist");
			return;
		}

		if (!u1.getPrieteni().contains(u2)) {
			u1.adaugaPrieten(u2.getEmail());
			u2.adaugaPrieten(u1.getEmail());
		} else {
			System.out.println("User with " + u2.getEmail() + " is already a friend");
		}
	}
}
