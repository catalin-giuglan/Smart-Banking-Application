package org.poo.cb.commands;

import org.poo.cb.Command;
import org.poo.cb.Utilizator;

import java.util.ArrayList;

public class ListPortfolio extends Command {
	@Override
	public void execute(ArrayList<String> args) {
		String email = args.get(0);

		Utilizator u = Utilizator.getUtilizator(email);
		if (u == null) {
			System.out.println("User with " + email + " doesn't exist");
			return;
		}

		StringBuilder json = new StringBuilder();
		json.append("{\"stocks\":[");
		for (int i = 0; i < u.getActiuni().size(); i++) {
			json.append("{\"stockName\":\"").append(u.getActiuni().get(i).getNumeCompanie()).append("\",");
			json.append("\"amount\":").append(u.getActiuni().get(i).getNumar()).append("}");
			if (i < u.getActiuni().size() - 1)
				json.append(",");
		}
		json.append("],\"accounts\":[");
		for (int i = 0; i < u.getConturi().size(); i++) {
			json.append("{\"currencyName\":\"").append(u.getConturi().get(i).getTipValuta()).append("\",");
			String suma = String.format("%.2f", u.getConturi().get(i).getSuma());
			json.append("\"amount\":\"").append(suma).append("\"}");
			if (i < u.getConturi().size() - 1)
				json.append(",");
		}
		json.append("]}");
		System.out.println(json);
	}
}
