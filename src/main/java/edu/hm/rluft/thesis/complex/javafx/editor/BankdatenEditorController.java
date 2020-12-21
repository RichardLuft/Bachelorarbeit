package edu.hm.rluft.thesis.complex.javafx.editor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.beanfabrics.Path;
import org.beanfabrics.javafx.binder.BnFxBinder;
import org.beanfabrics.javafx.controller.BnFxControllerBase;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BankdatenEditorController extends BnFxControllerBase<BankdatenEditorPM>{

	@FXML
	private Parent root;

	@FXML
	private TextField bankTF;
	@FXML
	private TextField ibanTF;
	@FXML
	private Button saveButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Binding
		BnFxBinder.bind(bankTF, getLocalModelProvider(), new Path("einrichtung"));
		BnFxBinder.bind(ibanTF, getLocalModelProvider(), new Path("iban"));
		BnFxBinder.bind(saveButton, getLocalModelProvider(), new Path("save"));

		saveButton.setOnAction((e) -> {
			BankdatenEditorService.SERVICE.closeBankdatenEditor();
		});

	}

	public static BankdatenEditorController load() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BankdatenEditorController.class.getResource("BankdatenEditor.fxml"));
		loader.load();
		return loader.getController();
	}

	public Parent getParent() {
		return root;
	}

}
