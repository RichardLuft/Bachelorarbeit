package edu.hm.rluft.thesis.complex.javafx.data;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataLoader {

	public static List<ViewData> loadData() {
		List<ViewData> result = new ArrayList<>();
		for(int i = 1; i < 1000; i++) {
			long kdNr = i;
			String name = "string-" + i;
			BankdatenData bank = new BankdatenData("DE001023101421421", "Sparkasse So und So");
			AllgemeinData allgemein = new AllgemeinData("vor-" + i, "nach-" + i, Date.from(Instant.now()), "Irgendeine Straße", i + "a", 02341, "Ort");
			ViewData data = new ViewData(kdNr, name, allgemein, bank);
			result.add(data);
		}
		return result;
	}

}
