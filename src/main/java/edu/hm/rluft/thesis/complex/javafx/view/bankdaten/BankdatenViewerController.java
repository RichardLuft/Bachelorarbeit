package edu.hm.rluft.thesis.complex.javafx.view.bankdaten;

import java.net.URL;
import java.util.ResourceBundle;

import org.beanfabrics.Path;
import org.beanfabrics.javafx.binder.BnFxBinder;
import org.beanfabrics.javafx.controller.BnFxControllerBase;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BankdatenViewerController extends BnFxControllerBase<BankdatenViewerPM> {

	@FXML
	private TextField bankTF;
	@FXML
	private TextField ibanTF;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Binding
		BnFxBinder.bind(bankTF, getLocalModelProvider(), new Path("einrichtung"));
		BnFxBinder.bind(ibanTF, getLocalModelProvider(), new Path("iban"));
	}

}