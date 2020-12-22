package edu.hm.rluft.thesis.complex.javafx.view;

import java.io.IOException;

import org.beanfabrics.model.AbstractPM;
import org.beanfabrics.model.OperationPM;
import org.beanfabrics.model.PMManager;
import org.beanfabrics.support.Operation;

import edu.hm.rluft.thesis.complex.javafx.data.BankdatenEditorData;
import edu.hm.rluft.thesis.complex.javafx.data.ViewData;
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

	public void setData(Long kdNr, ViewData data) {
		this.kdNr = kdNr;
		if(data == null) {
			allgemein.setData(null);
			bankdaten.setData(null);
		} else {
			allgemein.setData(data.getAllgemein());
			bankdaten.setData(data.getBankdaten());
		}
	}

	@Operation
	public void edit() {
		try {
			BankdatenEditorData editorData = new BankdatenEditorData(kdNr, bankdaten.getData());
			BankdatenEditorService.SERVICE.openBankdatenEditor(editorData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
