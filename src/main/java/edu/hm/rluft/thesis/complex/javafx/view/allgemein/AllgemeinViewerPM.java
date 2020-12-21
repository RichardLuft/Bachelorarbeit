package edu.hm.rluft.thesis.complex.javafx.view.allgemein;

import org.beanfabrics.model.AbstractPM;
import org.beanfabrics.model.DatePM;
import org.beanfabrics.model.IntegerPM;
import org.beanfabrics.model.PMManager;
import org.beanfabrics.model.TextPM;

import edu.hm.rluft.thesis.complex.javafx.data.AllgemeinData;

public class AllgemeinViewerPM extends AbstractPM {

	private TextPM vorname = new TextPM();
	private TextPM nachname = new TextPM();
	private DatePM geburtstag = new DatePM();
	private TextPM straﬂe = new TextPM();
	private TextPM nummer = new TextPM();
	private IntegerPM plz = new IntegerPM();
	private TextPM ort = new TextPM();

	public AllgemeinViewerPM() {
		vorname.setEditable(false);
		nachname.setEditable(false);
		geburtstag.setEditable(false);
		straﬂe.setEditable(false);
		nummer.setEditable(false);
		plz.setEditable(false);
		ort.setEditable(false);
		PMManager.setup(this);
	}

	public void setData(AllgemeinData data) {
		if(data != null) {
			vorname.setText(data.getVorname());
			nachname.setText(data.getNachname());
			geburtstag.setDate(data.getGeburtstag());
			straﬂe.setText(data.getStraﬂe());
			nummer.setText(data.getNummer());
			plz.setInteger(data.getPlz());
			ort.setText(data.getOrt());
		} else {
			vorname.setText(null);
			nachname.setText(null);
			geburtstag.setDate(null);
			straﬂe.setText(null);
			nummer.setText(null);
			plz.setInteger(null);
			ort.setText(null);
		}
	}

}
