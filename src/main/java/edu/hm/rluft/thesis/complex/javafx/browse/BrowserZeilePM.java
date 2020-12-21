package edu.hm.rluft.thesis.complex.javafx.browse;

import org.beanfabrics.model.AbstractPM;
import org.beanfabrics.model.IntegerPM;
import org.beanfabrics.model.PMManager;
import org.beanfabrics.model.TextPM;

import edu.hm.rluft.thesis.complex.javafx.data.AllgemeinData;
import edu.hm.rluft.thesis.complex.javafx.data.BankdatenData;
import edu.hm.rluft.thesis.complex.javafx.data.ViewData;

public class BrowserZeilePM extends AbstractPM {

	IntegerPM kundenNr = new IntegerPM();
	TextPM name = new TextPM();

	private BankdatenData bankdaten;
	private AllgemeinData allgemein;

	public BrowserZeilePM(ViewData data) {
		loadData(data);
		PMManager.setup(this);
	}

	private void loadData(ViewData data) {
		kundenNr.setLong(data.getKundenNr());
		name.setText(data.getName());
		allgemein = data.getAllgemein();
		bankdaten = data.getBankdaten();
	}

	public BankdatenData getBankdaten() {
		return bankdaten;
	}

	public AllgemeinData getAllgemein() {
		return allgemein;
	}

}
