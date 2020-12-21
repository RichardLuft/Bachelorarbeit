package edu.hm.rluft.thesis.complex.javafx.view;

import org.beanfabrics.model.AbstractPM;
import org.beanfabrics.model.PMManager;

import edu.hm.rluft.thesis.complex.javafx.data.AllgemeinData;
import edu.hm.rluft.thesis.complex.javafx.data.BankdatenData;
import edu.hm.rluft.thesis.complex.javafx.view.allgemein.AllgemeinViewerPM;
import edu.hm.rluft.thesis.complex.javafx.view.bankdaten.BankdatenViewerPM;

public class ViewerPM extends AbstractPM {

	private AllgemeinViewerPM allgemein = new AllgemeinViewerPM();
	private BankdatenViewerPM bankdaten = new BankdatenViewerPM();

	public ViewerPM() {
		PMManager.setup(this);
	}

	public void setData(AllgemeinData allgemein, BankdatenData bankdaten) {
		this.allgemein.setData(allgemein);
		this.bankdaten.setData(bankdaten);
	}


}
