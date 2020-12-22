package edu.hm.rluft.thesis.complex.browse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import edu.hm.rluft.thesis.complex.javafx.browse.BrowserPM;
import edu.hm.rluft.thesis.complex.javafx.data.AllgemeinData;
import edu.hm.rluft.thesis.complex.javafx.data.BankdatenData;
import edu.hm.rluft.thesis.complex.javafx.data.BrowseData;
import edu.hm.rluft.thesis.complex.javafx.data.DataLoader;
import edu.hm.rluft.thesis.complex.javafx.data.ViewData;
import edu.hm.rluft.thesis.complex.javafx.view.ViewerPM;

@ExtendWith(MockitoExtension.class)
public class BrowserPMTest {

	@InjectMocks
	BrowserPM underTest;

	@InjectMocks
	ViewerPM viewer;

	private Map<Long, BrowseData> data = new HashMap<>();

	@BeforeEach
	public void init() {
		for(int i = 0; i < 10; i++) {
			long kdNr = i;
			String name = "someone-" + i;
			BankdatenData bankData = new BankdatenData("DE0123456789", "bank-" + i);
			AllgemeinData allgemeinData = new AllgemeinData("vor-" + i, "nach-" + i, Date.from(Instant.now()), "Irgendeine Straße", i + "a", 02341, "Ort");
			ViewData viewData = new ViewData(allgemeinData, bankData);
			data.put(kdNr, new BrowseData(kdNr, name, viewData));
		}
	}

	@Test
	public void testSetData_Normal() {
		// Given:
		underTest.setData(data);
		// When:
		// Then:
		assertEquals(underTest.eintraege.size(), 10);
	}

	@Test
	public void testSetData_Null() {
		// Given:
		underTest.setData(null);
		// When:
		// Then:
		assertEquals(underTest.eintraege.size(), 0);
	}

	@Test
	public void testEditAvailable_OneSelection() {
		// Given:
		underTest.setData(data);
		DataLoader.LOADER.setLoadData(data);
		// When:
		underTest.eintraege.getSelection().setInterval(0, 0);
		// Then:
		assertEquals(viewer.edit.isEnabled(), true);
	}


}
