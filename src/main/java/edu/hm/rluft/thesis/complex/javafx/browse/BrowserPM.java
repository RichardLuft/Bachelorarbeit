package edu.hm.rluft.thesis.complex.javafx.browse;

import java.util.Map;

import org.beanfabrics.model.AbstractPM;
import org.beanfabrics.model.MapPM;
import org.beanfabrics.model.PMManager;
import org.beanfabrics.support.OnChange;
import org.beanfabrics.support.Validation;

import edu.hm.rluft.thesis.complex.javafx.data.ViewData;
import edu.hm.rluft.thesis.complex.javafx.view.ViewerPM;

public class BrowserPM extends AbstractPM {

	private MapPM<Long,BrowserZeilePM> eintraege = new MapPM<>();
	private ViewerPM viewer = new ViewerPM();

	public BrowserPM() {
		PMManager.setup(this);
	}

	public void setData(Map<Long, ViewData> listOfData) {
		for (Long key: listOfData.keySet()) {
			eintraege.put(key, new BrowserZeilePM(listOfData.get(key)));
		}
	}

	@OnChange(path = "eintraege")
	void updateSelectedRow() {
		BrowserZeilePM selection = eintraege.getSelection().getFirst();
		if(selection != null) {
			viewer.setData(selection.kundenNr.getLong(), selection.getAllgemein(), selection.getBankdaten());
		} else {
			viewer.setData(null,null, null);
		}
	}

	@Validation(path = "viewer.edit")
	public boolean validateEditable() {
		return eintraege.getSelection().getFirst() != null;
	}

}
