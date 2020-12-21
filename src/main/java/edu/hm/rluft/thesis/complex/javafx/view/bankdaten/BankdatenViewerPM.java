package edu.hm.rluft.thesis.complex.javafx.view.bankdaten;

import org.beanfabrics.model.AbstractPM;
import org.beanfabrics.model.PMManager;
import org.beanfabrics.model.TextPM;

import edu.hm.rluft.thesis.complex.javafx.data.BankdatenData;

public class BankdatenViewerPM extends AbstractPM {

	private TextPM iban = new TextPM();
	private TextPM einrichtung = new TextPM();

	public BankdatenViewerPM() {
		iban.setEditable(false);
		einrichtung.setEditable(false);
		PMManager.setup(this);
	}

	public void setData(BankdatenData data) {
		if(data != null) {
			iban.setText(data.getIban());
			einrichtung.setText(data.getEinrichtung());
		}
	}

}
