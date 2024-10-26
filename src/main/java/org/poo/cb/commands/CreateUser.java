package org.poo.cb.commands;

import org.poo.cb.Command;
import org.poo.cb.Utilizator;

import java.util.ArrayList;

public class CreateUser extends Command {
	@Override
	public void execute(ArrayList<String> args) {
		String email = args.get(0);
		String prenume = args.get(1);
		String nume = args.get(2);
		String adresa = String.join(" ", args.subList(3, args.size()));

		Utilizator u = Utilizator.getUtilizator(email);
		if (u != null)
			System.out.println("User with " + email + " already exists");
		else {
			u = new Utilizator.Builder(email, prenume, nume).adresa(adresa).prieteni(new ArrayList<>())
					.conturi(new ArrayList<>()).actiuni(new ArrayList<>()).build();
			u.adaugaUtilizator();
		}
	}
}
