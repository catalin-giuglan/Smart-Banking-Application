package org.poo.cb;

public class Cont {
	private final String tipValuta;
	private double suma;

	public Cont(Builder builder) {
		this.tipValuta = builder.tipValuta;
		this.suma = builder.suma;
	}

	public String getTipValuta() {
		return tipValuta;
	}

	public double getSuma() {
		return suma;
	}

	public void depune(double suma) {
		if (suma > 0)
			this.suma += suma;
	}

	public void retrage(double suma) {
		if (suma > 0)
			this.suma -= suma;
	}

	public static class Builder {
		private String tipValuta;
		private double suma;

		public Builder tipValuta(String tipValuta) {
			this.tipValuta = tipValuta;
			return this;
		}

		public Builder suma(double suma) {
			this.suma = suma;
			return this;
		}

		public Cont build() {
			return new Cont(this);
		}
	}
}
