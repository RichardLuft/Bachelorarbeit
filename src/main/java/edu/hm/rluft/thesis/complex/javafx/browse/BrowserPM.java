package edu.hm.rluft.thesis.complex.javafx.browse;

import java.util.List;

import org.beanfabrics.model.AbstractPM;
import org.beanfabrics.model.MapPM;
import org.beanfabrics.model.PMManager;
import org.beanfabrics.support.OnChange;

import edu.hm.rluft.thesis.complex.javafx.data.ViewData;
import edu.hm.rluft.thesis.complex.javafx.view.ViewerPM;

public class BrowserPM extends AbstractPM {

	private MapPM<Long,BrowserZeilePM> eintraege = new MapPM<>();
	private ViewerPM viewer = new ViewerPM();

	public BrowserPM() {
		PMManager.setup(this);
	}

	public void setData(List<ViewData> listOfData) {
		for (ViewData data: listOfData) {
			eintraege.put(data.getKundenNr(), new BrowserZeilePM(data));
		}
	}

	@OnChange(path = "eintraege")
	void updateSelectedRow() {
		BrowserZeilePM selection = eintraege.getSelection().getFirst();
		if(selection != null) {
			viewer.setData(selection.getAllgemein(), selection.getBankdaten());
		}
	}

}
