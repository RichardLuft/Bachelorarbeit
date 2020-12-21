package edu.hm.rluft.thesis.complex.javafx.data;

public class ViewData {

	private long kundenNr;
	private String name;
	private AllgemeinData allgemein;
	private BankdatenData bankdaten;

	public ViewData(long kundenNr, String name, AllgemeinData allgemein, BankdatenData bankdaten) {
		this.kundenNr = kundenNr;
		this.name = name;
		this.allgemein = allgemein;
		this.bankdaten = bankdaten;
	}

	public long getKundenNr() {
		return kundenNr;
	}

	public String getName() {
		return name;
	}

	public AllgemeinData getAllgemein() {
		return allgemein;
	}

	public BankdatenData getBankdaten() {
		return bankdaten;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allgemein == null) ? 0 : allgemein.hashCode());
		result = prime * result + ((bankdaten == null) ? 0 : bankdaten.hashCode());
		result = prime * result + (int) (kundenNr ^ (kundenNr >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ViewData other = (ViewData) obj;
		if (allgemein == null) {
			if (other.allgemein != null)
				return false;
		} else if (!allgemein.equals(other.allgemein))
			return false;
		if (bankdaten == null) {
			if (other.bankdaten != null)
				return false;
		} else if (!bankdaten.equals(other.bankdaten))
			return false;
		if (kundenNr != other.kundenNr)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
