package edu.hm.rluft.thesis.complex.javafx.data;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DataLoader {

	public static DataLoader LOADER = new DataLoader();

	private DataLoader() {

	}

	private Map<Long, ViewData> data = new HashMap<>();

	public Map<Long, ViewData> loadData() {
		for(int i = 1; i < 1000; i++) {
			long kdNr = i;
			String name = "string-" + i;
			BankdatenData bank = new BankdatenData("DE001023101421421", "Sparkasse So und So");
			AllgemeinData allgemein = new AllgemeinData("vor-" + i, "nach-" + i, Date.from(Instant.now()), "Irgendeine Straße", i + "a", 02341, "Ort");
			ViewData viewData = new ViewData(kdNr, name, allgemein, bank);
			data.put(kdNr,viewData);
		}
		return data;
	}

	public void changeData(Long kdNr, BankdatenData bank) {
		ViewData viewData = data.get(kdNr);
		viewData = new ViewData(kdNr, viewData.getName(), viewData.getAllgemein(), bank);
	}

}
