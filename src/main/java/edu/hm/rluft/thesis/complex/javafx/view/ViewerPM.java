package edu.hm.rluft.thesis.complex.javafx.view;

import java.io.IOException;

import org.beanfabrics.model.AbstractPM;
import org.beanfabrics.model.OperationPM;
import org.beanfabrics.model.PMManager;
import org.beanfabrics.support.Operation;

import com.google.common.annotations.VisibleForTesting;

import edu.hm.rluft.thesis.complex.javafx.data.BankdatenData;
import edu.hm.rluft.thesis.complex.javafx.data.DataLoader;
import edu.hm.rluft.thesis.complex.javafx.data.ViewData;
import edu.hm.rluft.thesis.complex.javafx.editor.BankdatenEditorPM;
import edu.hm.rluft.thesis.complex.javafx.editor.BankdatenEditorService;
import edu.hm.rluft.thesis.complex.javafx.view.allgemein.AllgemeinViewerPM;
import edu.hm.rluft.thesis.complex.javafx.view.bankdaten.BankdatenViewerPM;

public class ViewerPM extends AbstractPM {

	@VisibleForTesting
	public OperationPM edit = new OperationPM();

	private AllgemeinViewerPM allgemein = new AllgemeinViewerPM();
	private BankdatenViewerPM bankdaten = new BankdatenViewerPM();

	private BankdatenEditorPM pm = new BankdatenEditorPM(new BankdatenEditorPM.Callback() {
		@Override
		public void changeData(BankdatenData data) {
			bankdaten.setData(data);
			DataLoader.LOADER.changeData(kdNr,data);
		}
	});
	private long kdNr;

	public ViewerPM() {
		PMManager.setup(this);
	}

	public void setData(long kdNr, ViewData data) {
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
			pm.setData(bankdaten.getData());
			BankdatenEditorService.SERVICE.openBankdatenEditor(pm);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
