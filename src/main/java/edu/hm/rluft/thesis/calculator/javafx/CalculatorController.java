package edu.hm.rluft.thesis.calculator.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.beanfabrics.Path;
import org.beanfabrics.javafx.binder.BnFxBinder;
import org.beanfabrics.javafx.controller.BnFxControllerBase;

import edu.hm.rluft.thesis.calculator.CalculatorPM;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CalculatorController extends BnFxControllerBase<CalculatorPM> {

	@FXML
	private GridPane parent;

	@FXML
	private Button buttonZero;
	@FXML
	private Button buttonOne;
	@FXML
	private Button buttonTwo;
	@FXML
	private Button buttonThree;
	@FXML
	private Button buttonFour;
	@FXML
	private Button buttonFive;
	@FXML
	private Button buttonSix;
	@FXML
	private Button buttonSeven;
	@FXML
	private Button buttonEight;
	@FXML
	private Button buttonNine;

	@FXML
	private Button buttonDivide;
	@FXML
	private Button buttonMultiply;
	@FXML
	private Button buttonMinus;
	@FXML
	private Button buttonPlus;

	@FXML
	private Button buttonClear;
	@FXML
	private Button buttonClearAll;

	@FXML
	private TextField textfieldResult;
	@FXML
	private Button buttonResult;


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		setPresentationModel(new CalculatorPM());

		// Binding (Numbers)
		BnFxBinder.bind(buttonZero, getLocalModelProvider(), new Path("zero"));
		BnFxBinder.bind(buttonOne, getLocalModelProvider(), new Path("one"));
		BnFxBinder.bind(buttonTwo, getLocalModelProvider(), new Path("two"));
		BnFxBinder.bind(buttonThree, getLocalModelProvider(), new Path("three"));
		BnFxBinder.bind(buttonFour, getLocalModelProvider(), new Path("four"));
		BnFxBinder.bind(buttonFive, getLocalModelProvider(), new Path("five"));
		BnFxBinder.bind(buttonSix, getLocalModelProvider(), new Path("six"));
		BnFxBinder.bind(buttonSeven, getLocalModelProvider(), new Path("seven"));
		BnFxBinder.bind(buttonEight, getLocalModelProvider(), new Path("eight"));
		BnFxBinder.bind(buttonNine, getLocalModelProvider(), new Path("nine"));

		// Binding (Operations)
		BnFxBinder.bind(buttonDivide, getLocalModelProvider(), new Path("divide"));
		BnFxBinder.bind(buttonMultiply, getLocalModelProvider(), new Path("multiply"));
		BnFxBinder.bind(buttonMinus, getLocalModelProvider(), new Path("minus"));
		BnFxBinder.bind(buttonPlus, getLocalModelProvider(), new Path("plus"));

		// Binding (Support)
		BnFxBinder.bind(buttonClear, getLocalModelProvider(), new Path("clear"));
		BnFxBinder.bind(buttonClearAll, getLocalModelProvider(), new Path("clearAll"));

		// Binding (Result)
		BnFxBinder.bind(textfieldResult, getLocalModelProvider(), new Path("resultText"));
		BnFxBinder.bind(buttonResult, getLocalModelProvider(), new Path("result"));

	}

	public static CalculatorController load() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CalculatorController.class.getResource("Calculator.fxml"));
		loader.load();
		return loader.getController();
	}

	public Parent getParent() {
		return parent;
	}

}
