package edu.hm.rluft.thesis.complex.javafx.browse;

import java.util.Map;

import org.beanfabrics.model.AbstractPM;
import org.beanfabrics.model.MapPM;
import org.beanfabrics.model.PMManager;
import org.beanfabrics.support.OnChange;
import org.beanfabrics.support.Validation;

import com.google.common.annotations.VisibleForTesting;

import edu.hm.rluft.thesis.complex.javafx.data.BrowseData;
import edu.hm.rluft.thesis.complex.javafx.data.DataLoader;
import edu.hm.rluft.thesis.complex.javafx.data.ViewData;
import edu.hm.rluft.thesis.complex.javafx.view.ViewerPM;

public class BrowserPM extends AbstractPM {

	@VisibleForTesting
	public MapPM<Long,BrowserZeilePM> eintraege = new MapPM<>();
	private ViewerPM viewer = new ViewerPM();

	public BrowserPM() {
		PMManager.setup(this);
	}

	public void setData(Map<Long, BrowseData> listOfData) {
		if(listOfData != null) {
			for (Long key: listOfData.keySet()) {
				eintraege.put(key, new BrowserZeilePM(listOfData.get(key)));
			}
		}
	}

	@OnChange(path = "eintraege")
	void updateSelectedRow() {
		BrowserZeilePM selection = eintraege.getSelection().getFirst();
		if(selection != null) {
			Long kdNr = selection.kundenNr.getLong();
			ViewData viewData = DataLoader.LOADER.getViewData(kdNr);
			viewer.setData(kdNr,viewData);
		} else {
			viewer.setData(null,null);
		}
	}

	@Validation(path = "viewer.edit")
	public boolean validateEditable() {
		return eintraege.getSelection().getFirst() != null;
	}

}
