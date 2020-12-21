package edu.hm.rluft.thesis.complex.javafx.editor;

import java.io.IOException;

import edu.hm.rluft.thesis.complex.javafx.data.BankdatenData;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BankdatenEditorService {

	public static BankdatenEditorService SERVICE = new BankdatenEditorService();
	private Stage stage;

	private BankdatenEditorService() {
	}

	public void openBankdatenEditor(Long kdNr, BankdatenData data) throws IOException {
		BankdatenEditorController controller = BankdatenEditorController.load();
		controller.setPresentationModel(new BankdatenEditorPM(kdNr, data));
		stage = new Stage();
		Scene scene = new Scene(controller.getParent());
		stage.setScene(scene);
		stage.show();
	}

	public void closeBankdatenEditor() {
		stage.close();
	}

}
