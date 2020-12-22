package edu.hm.rluft.thesis.complex.javafx.editor;

import java.io.IOException;

import edu.hm.rluft.thesis.complex.javafx.data.BankdatenEditorData;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BankdatenEditorService {

	public static BankdatenEditorService SERVICE = new BankdatenEditorService();
	private Stage stage;

	private BankdatenEditorService() {
	}

	public void openBankdatenEditor(BankdatenEditorData data) throws IOException {
		BankdatenEditorController controller = BankdatenEditorController.load();
		controller.setPresentationModel(new BankdatenEditorPM(data));
		stage = new Stage();
		Scene scene = new Scene(controller.getParent());
		stage.setScene(scene);
		stage.show();
	}

	public void closeBankdatenEditor() {
		stage.close();
	}

}
