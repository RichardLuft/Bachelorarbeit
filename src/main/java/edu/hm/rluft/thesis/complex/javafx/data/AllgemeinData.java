package edu.hm.rluft.thesis.complex.javafx.data;

import java.util.Date;

public class AllgemeinData {

	private String vorname;
	private String nachname;
	private Date geburtstag;
	private String straﬂe;
	private String nummer;
	private int plz;
	private String ort;

	public AllgemeinData(String vorname, String nachname, Date geburtstag, String straﬂe, String nummer, int plz,
			String ort) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtstag = geburtstag;
		this.straﬂe = straﬂe;
		this.nummer = nummer;
		this.plz = plz;
		this.ort = ort;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public Date getGeburtstag() {
		return geburtstag;
	}

	public String getStraﬂe() {
		return straﬂe;
	}

	public String getNummer() {
		return nummer;
	}

	public int getPlz() {
		return plz;
	}

	public String getOrt() {
		return ort;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((geburtstag == null) ? 0 : geburtstag.hashCode());
		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((nummer == null) ? 0 : nummer.hashCode());
		result = prime * result + ((ort == null) ? 0 : ort.hashCode());
		result = prime * result + plz;
		result = prime * result + ((straﬂe == null) ? 0 : straﬂe.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
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
		AllgemeinData other = (AllgemeinData) obj;
		if (geburtstag == null) {
			if (other.geburtstag != null)
				return false;
		} else if (!geburtstag.equals(other.geburtstag))
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (nummer == null) {
			if (other.nummer != null)
				return false;
		} else if (!nummer.equals(other.nummer))
			return false;
		if (ort == null) {
			if (other.ort != null)
				return false;
		} else if (!ort.equals(other.ort))
			return false;
		if (plz != other.plz)
			return false;
		if (straﬂe == null) {
			if (other.straﬂe != null)
				return false;
		} else if (!straﬂe.equals(other.straﬂe))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}

}
