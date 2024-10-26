package org.poo.cb;

import org.poo.cb.commands.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Commands {
	public static Commands instance = null;
	private ArrayList<String> commands;

	private Commands() {
	}

	public static Commands getInstance() {
		if (instance == null)
			instance = new Commands();
		return instance;
	}

	public ArrayList<String> getCommands() {
		return commands;
	}

	public void start(String path) throws IOException {
		File file = new File(path);
		Scanner scanner = new Scanner(file);
		commands = new ArrayList<>();
		while (scanner.hasNextLine())
			commands.add(scanner.nextLine());
		scanner.close();

		for (String command : commands) {
			String[] parts = command.split(" ");
			Command c = getCommand(parts[0] + " " + parts[1]);
			if (c != null) {
				ArrayList<String> args = new ArrayList<>(Arrays.asList(parts).subList(2, parts.length));
				c.execute(args);
			}
		}
	}

	public Command getCommand(String numeComanda) {
		if (numeComanda.equals("CREATE USER"))
			return new CreateUser();
		if (numeComanda.equals("ADD FRIEND"))
			return new AddFriend();
		if (numeComanda.equals("ADD ACCOUNT"))
			return new AddAccount();
		if (numeComanda.equals("ADD MONEY"))
			return new AddMoney();
		if (numeComanda.equals("EXCHANGE MONEY"))
			return new ExchangeMoney();
		if (numeComanda.equals("TRANSFER MONEY"))
			return new TransferMoney();
		if (numeComanda.equals("BUY STOCKS"))
			return new BuyStocks();
		if (numeComanda.equals("RECOMMEND STOCKS"))
			return new RecommendStocks();
		if (numeComanda.equals("LIST USER"))
			return new ListUser();
		if (numeComanda.equals("LIST PORTFOLIO"))
			return new ListPortfolio();
		return null;
	}
}
