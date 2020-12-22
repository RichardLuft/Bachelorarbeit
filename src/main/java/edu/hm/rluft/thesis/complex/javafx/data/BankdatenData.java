package edu.hm.rluft.thesis.complex.javafx.data;

public class BankdatenData {

	private String iban;
	private String einrichtung;

	public BankdatenData(String iban, String einrichtung) {
		this.iban = iban;
		this.einrichtung = einrichtung;
	}

	public String getIban() {
		return iban;
	}

	public String getEinrichtung() {
		return einrichtung;
	}

}
