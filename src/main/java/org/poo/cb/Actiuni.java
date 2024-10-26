package org.poo.cb;

public class Actiuni {
	private final String numeCompanie;
	private int numar;

	public Actiuni(Builder builder) {
		this.numeCompanie = builder.numeCompanie;
		this.numar = builder.numar;
	}

	public String getNumeCompanie() {
		return numeCompanie;
	}

	public int getNumar() {
		return numar;
	}

	public void adaugaActiuni(int numar) {
		if (numar > 0)
			this.numar += numar;
	}

	public static class Builder {
		private String numeCompanie;
		private int numar;

		public Builder numeCompanie(String numeCompanie) {
			this.numeCompanie = numeCompanie;
			return this;
		}

		public Builder numar(int numar) {
			this.numar = numar;
			return this;
		}

		public Actiuni build() {
			return new Actiuni(this);
		}
	}
}
