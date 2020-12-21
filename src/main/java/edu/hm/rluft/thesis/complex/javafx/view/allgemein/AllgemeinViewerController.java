package edu.hm.rluft.thesis.complex.javafx.view.allgemein;

import java.net.URL;
import java.util.ResourceBundle;

import org.beanfabrics.Path;
import org.beanfabrics.javafx.binder.BnFxBinder;
import org.beanfabrics.javafx.controller.BnFxControllerBase;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class AllgemeinViewerController extends BnFxControllerBase<AllgemeinViewerPM> {

	@FXML
	private Parent root;

	@FXML
	private TextField vornameTF;
	@FXML
	private TextField geburtstagTF;
	@FXML
	private TextField nachnameTF;
	@FXML
	private TextField straﬂeTF;
	@FXML
	private TextField hausnrTF;
	@FXML
	private TextField plzTF;
	@FXML
	private TextField ortTF;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Binding
		BnFxBinder.bind(vornameTF, getLocalModelProvider(), new Path("vorname"));
		BnFxBinder.bind(nachnameTF, getLocalModelProvider(), new Path("nachname"));
		BnFxBinder.bind(geburtstagTF, getLocalModelProvider(), new Path("geburtstag"));
		BnFxBinder.bind(straﬂeTF, getLocalModelProvider(), new Path("straﬂe"));
		BnFxBinder.bind(hausnrTF, getLocalModelProvider(), new Path("nummer"));
		BnFxBinder.bind(plzTF, getLocalModelProvider(), new Path("plz"));
		BnFxBinder.bind(ortTF, getLocalModelProvider(), new Path("ort"));
	}

}
