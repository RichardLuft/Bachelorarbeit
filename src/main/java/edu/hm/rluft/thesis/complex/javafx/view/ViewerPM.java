package edu.hm.rluft.thesis.complex.javafx.view;

import java.io.IOException;

import org.beanfabrics.model.AbstractPM;
import org.beanfabrics.model.OperationPM;
import org.beanfabrics.model.PMManager;
import org.beanfabrics.support.Operation;

import edu.hm.rluft.thesis.complex.javafx.data.AllgemeinData;
import edu.hm.rluft.thesis.complex.javafx.data.BankdatenData;
import edu.hm.rluft.thesis.complex.javafx.editor.BankdatenEditorService;
import edu.hm.rluft.thesis.complex.javafx.view.allgemein.AllgemeinViewerPM;
import edu.hm.rluft.thesis.complex.javafx.view.bankdaten.BankdatenViewerPM;

public class ViewerPM extends AbstractPM {

	private OperationPM edit = new OperationPM();

	private AllgemeinViewerPM allgemein = new AllgemeinViewerPM();
	private BankdatenViewerPM bankdaten = new BankdatenViewerPM();

	private Long kdNr;

	public ViewerPM() {
		PMManager.setup(this);
	}

	public void setData(Long kdNr, AllgemeinData allgemein, BankdatenData bankdaten) {
		this.kdNr = kdNr;
		this.allgemein.setData(allgemein);
		this.bankdaten.setData(bankdaten);
	}

	@Operation
	public void edit() {
		try {
			BankdatenEditorService.SERVICE.openBankdatenEditor(kdNr, bankdaten.getData());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
