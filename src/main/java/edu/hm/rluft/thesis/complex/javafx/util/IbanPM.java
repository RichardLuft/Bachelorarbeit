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
		if(getText().length() >= 2) {
			char a = getText().charAt(0);
			char b = getText().charAt(1);
			if( (a < 65 || a > 90) || (b < 65 || b > 90) ) {
				return new ValidationState("Länderkennung bitte wie \"DE\" eingeben!");
			}
		}
		try {
			Integer.parseInt(getText().substring(2));
		} catch(NumberFormatException e) {
			return new ValidationState("Die Länderkennung der IBAN ist zu lang!");
		}
		if(getText().length() != 12) {
			return new ValidationState("Bitte nach der Länderkennung eine 10-stellige Zahl eingeben!");
		} else {
			return null;
		}
	}

}
