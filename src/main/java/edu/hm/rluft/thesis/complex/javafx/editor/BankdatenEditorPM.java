package edu.hm.rluft.thesis.complex.javafx.editor;

import org.beanfabrics.model.AbstractPM;
import org.beanfabrics.model.OperationPM;
import org.beanfabrics.model.PMManager;
import org.beanfabrics.model.TextPM;
import org.beanfabrics.support.Operation;
import org.beanfabrics.support.Validation;

import edu.hm.rluft.thesis.complex.javafx.data.BankdatenData;
import edu.hm.rluft.thesis.complex.javafx.data.BankdatenEditorData;
import edu.hm.rluft.thesis.complex.javafx.data.DataLoader;
import edu.hm.rluft.thesis.complex.javafx.util.IbanPM;

public class BankdatenEditorPM extends AbstractPM {


	private TextPM einrichtung = new TextPM();
	private IbanPM iban = new IbanPM();

	private OperationPM save = new OperationPM();
	private Long kdNr;

	public BankdatenEditorPM(BankdatenEditorData data) {
		kdNr = data.getKdNr();
		setData(data.getBankdaten());
		PMManager.setup(this);
	}

	public void setData(BankdatenData data) {
		einrichtung.setText(data.getEinrichtung());
		iban.setIban(data.getIban());
	}

	@Operation
	public void save() {
		DataLoader.LOADER.changeData(kdNr, new BankdatenData(einrichtung.getText(), iban.getIban()));
	}

	@Validation(path = "save", message = "Es liegen Eingabefehler vor")
	public boolean canSave() {
		return isValid();
	}

	@Validation(path = "save", message = "Es liegen keine Änderungen vor")
	public boolean isModified() {
		return einrichtung.isModified() ||  iban.isModified();
	}

}
