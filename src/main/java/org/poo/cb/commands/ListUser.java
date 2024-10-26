package org.poo.cb.commands;

import org.poo.cb.Command;
import org.poo.cb.Utilizator;

import java.util.ArrayList;

public class ListUser extends Command {
	@Override
	public void execute(ArrayList<String> args) {
		String email = args.get(0);

		Utilizator u = Utilizator.getUtilizator(email);
		if (u == null) {
			System.out.println("User with " + email + " doesn't exist");
			return;
		}

		StringBuilder json = new StringBuilder();
		json.append("{\"email\":\"").append(u.getEmail()).append("\",");
		json.append("\"firstname\":\"").append(u.getPrenume()).append("\",");
		json.append("\"lastname\":\"").append(u.getNume()).append("\",");
		json.append("\"address\":\"").append(u.getAdresa()).append("\",");
		json.append("\"friends\":[");
		for (int i = 0; i < u.getPrieteni().size(); i++) {
			json.append("\"").append(u.getPrieteni().get(i)).append("\"");
			if (i < u.getPrieteni().size() - 1)
				json.append(",");
		}
		json.append("]}");
		System.out.println(json);
	}
}
