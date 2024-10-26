package org.poo.cb;

import java.util.ArrayList;

public class Utilizator {
	private final String email;
	private final String prenume;
	private final String nume;
	private final String adresa;
	private final ArrayList<String> prieteni;
	private final ArrayList<Cont> conturi;
	private final ArrayList<Actiuni> actiuni;

	private Utilizator(Builder builder) {
		this.email = builder.email;
		this.prenume = builder.prenume;
		this.nume = builder.nume;
		this.adresa = builder.adresa;
		this.prieteni = builder.prieteni;
		this.conturi = builder.conturi;
		this.actiuni = builder.actiuni;
	}

	public static Utilizator getUtilizator(String email) {
		for (Utilizator utilizator : Main.utilizatori)
			if (utilizator.getEmail().equals(email))
				return utilizator;
		return null;
	}

	public void adaugaUtilizator() {
		Main.utilizatori.add(this);
	}

	public void adaugaPrieten(String email) {
		prieteni.add(email);
	}

	public void adaugaCont(String currency) {
		for (Cont cont : conturi)
			if (cont.getTipValuta().equals(currency)) {
				System.out.println("Account in currency " + currency + " already exists for user");
				return;
			}
		conturi.add(new Cont.Builder().tipValuta(currency).suma(0).build());
	}

	public void adaugaSuma(String currency, double suma) {
		for (Cont cont : conturi)
			if (cont.getTipValuta().equals(currency))
				cont.depune(suma);
	}

	public Cont getCont(String currency) {
		for (Cont cont : conturi)
			if (cont.getTipValuta().equals(currency))
				return cont;
		return null;
	}

	public Actiuni getStock(String company) {
		for (Actiuni actiune : actiuni)
			if (actiune.getNumeCompanie().equals(company))
				return actiune;
		Actiuni a = new Actiuni.Builder().numeCompanie(company).numar(0).build();
		actiuni.add(a);
		return a;
	}

	public String getEmail() {
		return email;
	}

	public String getPrenume() {
		return prenume;
	}

	public String getNume() {
		return nume;
	}

	public String getAdresa() {
		return adresa;
	}

	public ArrayList<String> getPrieteni() {
		return prieteni;
	}

	public ArrayList<Cont> getConturi() {
		return conturi;
	}

	public ArrayList<Actiuni> getActiuni() {
		return actiuni;
	}

	public static class Builder {
		private final String email;
		private final String prenume;
		private final String nume;
		private String adresa;
		private ArrayList<String> prieteni;
		private ArrayList<Cont> conturi;
		private ArrayList<Actiuni> actiuni;

		public Builder(String email, String prenume, String nume) {
			this.email = email;
			this.prenume = prenume;
			this.nume = nume;
		}

		public Builder adresa(String adresa) {
			this.adresa = adresa;
			return this;
		}

		public Builder prieteni(ArrayList<String> prieteni) {
			this.prieteni = prieteni;
			return this;
		}

		public Builder conturi(ArrayList<Cont> conturi) {
			this.conturi = conturi;
			return this;
		}

		public Builder actiuni(ArrayList<Actiuni> actiuni) {
			this.actiuni = actiuni;
			return this;
		}

		public Utilizator build() {
			return new Utilizator(this);
		}
	}
}
