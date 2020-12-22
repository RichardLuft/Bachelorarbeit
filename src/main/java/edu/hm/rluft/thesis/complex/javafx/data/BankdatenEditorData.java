package edu.hm.rluft.thesis.complex.javafx.data;

public class BankdatenEditorData {

	private long kdNr;
	private BankdatenData bankdaten;

	public BankdatenEditorData(long kdNr, BankdatenData bankdaten) {
		this.kdNr = kdNr;
		this.bankdaten = bankdaten;
	}

	public long getKdNr() {
		return kdNr;
	}
	public BankdatenData getBankdaten() {
		return bankdaten;
	}

}
