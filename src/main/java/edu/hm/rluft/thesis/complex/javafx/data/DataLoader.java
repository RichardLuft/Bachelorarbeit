package edu.hm.rluft.thesis.complex.javafx.data;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DataLoader {

	public static DataLoader LOADER = new DataLoader();

	private DataLoader() {
		browseData = loadBrowseData();
	}

	private Map<Long, BrowseData> browseData = new HashMap<>();

	private Map<Long, BrowseData> loadBrowseData() {
		for(int i = 1; i < 1000; i++) {
			long kdNr = i;
			String name = "string-" + i;
			ViewData viewData = createViewData(i);
			BrowseData data = new BrowseData(kdNr, name, viewData);
			browseData.put(kdNr,data);
		}
		return browseData;
	}

	private ViewData createViewData(int i) {
		BankdatenData bank = new BankdatenData("DE0010231014", "Sparkasse So und So");
		AllgemeinData allgemein = new AllgemeinData("vor-" + i, "nach-" + i, Date.from(Instant.now()), "Irgendeine Straße", i + "a", 02341, "Ort");
		return new ViewData(allgemein, bank);
	}

	public void setLoadData(Map<Long, BrowseData> data) {
		browseData = new HashMap<>(data);
	}

	public Map<Long, BrowseData> getBrowseData() {
		return browseData;
	}

	public void changeData(Long kdNr, BankdatenData bank) {
		//		BrowseData browseData = browseData.get(kdNr);
		//		browseData = new BrowseData(kdNr, browseData.getName(), browseData.getAllgemein(), bank);
	}

	public ViewData getViewData(Long kdNr) {
		BrowseData data = browseData.get(kdNr);
		return data.getViewData();
	}

}
