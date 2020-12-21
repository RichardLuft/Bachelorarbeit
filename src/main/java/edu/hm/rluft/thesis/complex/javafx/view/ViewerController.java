package edu.hm.rluft.thesis.complex.javafx.view;

import java.net.URL;
import java.util.ResourceBundle;

import org.beanfabrics.Path;
import org.beanfabrics.javafx.binder.BnFxBinder;
import org.beanfabrics.javafx.controller.BnFxControllerBase;

import edu.hm.rluft.thesis.complex.javafx.view.allgemein.AllgemeinViewerController;
import edu.hm.rluft.thesis.complex.javafx.view.bankdaten.BankdatenViewerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;

public class ViewerController extends BnFxControllerBase<ViewerPM> {

	@FXML
	private TabPane tabPane;
	@FXML
	private Button editButton;

	@FXML
	private AllgemeinViewerController allgemeinController;
	@FXML
	private BankdatenViewerController bankdatenController;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Binding
		BnFxBinder.bind(editButton, getLocalModelProvider(), new Path("edit"));
		BnFxBinder.bind(allgemeinController, getLocalModelProvider(), new Path("allgemein"));
		BnFxBinder.bind(bankdatenController, getLocalModelProvider(), new Path("bankdaten"));
	}

}
