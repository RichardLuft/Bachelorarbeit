package edu.hm.rluft.thesis.complex.javafx.browse;

import org.beanfabrics.model.AbstractPM;
import org.beanfabrics.model.IntegerPM;
import org.beanfabrics.model.PMManager;
import org.beanfabrics.model.TextPM;

import edu.hm.rluft.thesis.complex.javafx.data.BrowseData;

public class BrowserZeilePM extends AbstractPM {

	IntegerPM kundenNr = new IntegerPM();
	TextPM name = new TextPM();

	public BrowserZeilePM(BrowseData data) {
		loadData(data);
		PMManager.setup(this);
	}

	private void loadData(BrowseData data) {
		kundenNr.setLong(data.getKundenNr());
		name.setText(data.getName());
	}

}
