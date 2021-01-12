package edu.hm.rluft.thesis.complex.javafx.data;

public class ViewData {

	private AllgemeinData allgemein;
	private BankdatenData bankdaten;

	public ViewData(AllgemeinData allgemein, BankdatenData bankdaten) {
		this.allgemein = allgemein;
		this.bankdaten = bankdaten;
	}

	public AllgemeinData getAllgemein() {
		return allgemein;
	}

	public BankdatenData getBankdaten() {
		return bankdaten;
	}

	public void setBankdaten(BankdatenData bankdaten) {
		this.bankdaten = bankdaten;
	}

}
