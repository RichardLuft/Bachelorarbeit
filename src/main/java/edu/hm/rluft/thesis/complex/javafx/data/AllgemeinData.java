package edu.hm.rluft.thesis.complex.javafx.data;

import java.util.Date;

public class AllgemeinData {

	private String vorname;
	private String nachname;
	private Date geburtstag;
	private String stra�e;
	private String nummer;
	private int plz;
	private String ort;

	public AllgemeinData(String vorname, String nachname, Date geburtstag, String stra�e, String nummer, int plz,
			String ort) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtstag = geburtstag;
		this.stra�e = stra�e;
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

	public String getStra�e() {
		return stra�e;
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

}
