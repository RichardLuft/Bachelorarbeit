package edu.hm.rluft.thesis.complex.javafx.data;

public class BankdatenData {

	private String iban;
	private String einrichtung;

	public BankdatenData(String iban, String einrichtung) {
		this.iban = iban;
		this.einrichtung = einrichtung;
	}

	public String getIban() {
		return iban;
	}

	public String getEinrichtung() {
		return einrichtung;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((einrichtung == null) ? 0 : einrichtung.hashCode());
		result = prime * result + ((iban == null) ? 0 : iban.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankdatenData other = (BankdatenData) obj;
		if (einrichtung == null) {
			if (other.einrichtung != null)
				return false;
		} else if (!einrichtung.equals(other.einrichtung))
			return false;
		if (iban == null) {
			if (other.iban != null)
				return false;
		} else if (!iban.equals(other.iban))
			return false;
		return true;
	}


}
