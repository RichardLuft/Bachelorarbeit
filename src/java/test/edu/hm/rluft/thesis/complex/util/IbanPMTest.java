package edu.hm.rluft.thesis.complex.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import edu.hm.rluft.thesis.complex.javafx.util.IbanPM;

@ExtendWith(MockitoExtension.class)
public class IbanPMTest {

	@InjectMocks
	IbanPM underTest;

	@Test
	public void testSetIban_LänderkennungFalsch() {
		// Given:
		underTest = new IbanPM();
		// When:
		underTest.setIban("ae0123456789");
		// Then:
		assertEquals(underTest.isValid(), false);
		assertEquals(underTest.getValidationState().getMessage(), "Länderkennung bitte wie \"DE\" eingeben!");
	}

	@Test
	public void testSetIban_LänderkennungZuLang() {
		// Given:
		underTest = new IbanPM();
		// When:
		underTest.setIban("DEU0123456789");
		// Then:
		assertEquals(underTest.isValid(), false);
		assertEquals(underTest.getValidationState().getMessage(), "Die Länderkennung der IBAN ist zu lang!");
	}

	@Test
	public void testSetIban_ZahlKleiner10() {
		// Given:
		underTest = new IbanPM();
		// When:
		underTest.setIban("DE012345");
		// Then:
		assertEquals(underTest.isValid(), false);
		assertEquals(underTest.getValidationState().getMessage(), "Bitte nach der Länderkennung eine 10-stellige Zahl eingeben!");
	}

	@Test
	public void testSetIban_ZahlGroesser10() {
		// Given:
		underTest = new IbanPM();
		// When:
		underTest.setIban("DE01234567891");
		// Then:
		assertEquals(underTest.isValid(), false);
		assertEquals(underTest.getValidationState().getMessage(), "Bitte nach der Länderkennung eine 10-stellige Zahl eingeben!");
	}

	@Test
	public void testSetIban_Richtig() {
		// Given:
		underTest = new IbanPM();
		// When:
		underTest.setIban("DE0123456789");
		// Then:
		assertEquals(underTest.isValid(), true);
	}

	@Test
	public void testGetIban() {
		// Given:
		underTest = new IbanPM();
		// When:
		underTest.setIban("DE0123456789");
		// Then:
		assertEquals(underTest.getIban(), "DE0123456789");
	}

}
