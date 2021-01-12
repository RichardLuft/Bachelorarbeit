package edu.hm.rluft.thesis.complex.javafx.data;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Diese Klasse ist als Hilfsklasse für das Laden und Verändern von Daten.
 * Sie wurde erstellt als Singleton, so dass zur Laufzeit nur eine Instanz vorhanden ist.
 */
public class DataLoader {

	public static DataLoader LOADER = new DataLoader();

	private DataLoader() {
		data = loadBrowseData();
	}

	private Map<Long, BrowseData> data = new HashMap<>();

	private Map<Long, BrowseData> loadBrowseData() {
		for(int i = 0; i < 1000; i++) {
			long kdNr = i;
			String name = "string-" + i;
			ViewData viewData = createViewData(i);
			BrowseData browseData = new BrowseData(kdNr, name, viewData);
			data.put(kdNr,browseData);
		}
		return data;
	}

	private ViewData createViewData(int i) {
		BankdatenData bank = new BankdatenData("DE0010231014", "Sparkasse So und So");
		AllgemeinData allgemein = new AllgemeinData("vor-" + i, "nach-" + i, Date.from(Instant.now()), "Irgendeine Straße", i + "a", 02341, "Ort");
		return new ViewData(allgemein, bank);
	}

	public Map<Long, BrowseData> getBrowseData() {
		return data;
	}

	public ViewData getViewData(Long kdNr) {
		BrowseData browseData = data.get(kdNr);
		return browseData.getViewData();
	}

	/**
	 * Ändert die Bankdaten eines Kunden.
	 *
	 * @param kdNr
	 * @param bankData
	 */
	public void changeData(long kdNr, BankdatenData bankData) {
		BrowseData browseData = data.get(kdNr);
		ViewData oldViewData = browseData.getViewData();
		oldViewData.setBankdaten(bankData);
		browseData.setViewData(oldViewData);
	}

}
