package edu.hm.rluft.thesis.complex.javafx.util;

import org.beanfabrics.model.PMManager;
import org.beanfabrics.model.TextPM;
import org.beanfabrics.support.Validation;
import org.beanfabrics.validation.ValidationState;

public class IbanPM extends TextPM {

	public IbanPM() {
		PMManager.setup(this);
	}

	public String getIban() {
		return getText();
	}

	public void setIban(String iban) {
		setText(iban);
	}

	@Validation(path = "this")
	public ValidationState validate() {
		try {
			Integer.parseInt(getText());
		} catch(NumberFormatException e) {
			return new ValidationState("Bitte die IBAN ohne Länderkennung eingeben!");
		}
		if(getText().length() != 10) {
			return new ValidationState("Bitte eine 10-stellige Zahl eingeben!");
		} else {
			return null;
		}
	}

}
