package edu.hm.rluft.thesis.calculator.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import org.beanfabrics.ModelProvider;
import org.beanfabrics.Path;
import org.beanfabrics.javafx.binder.BnFxBinder;
import edu.hm.rluft.thesis.calculator.CalculatorPM;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CalculatorController implements Initializable {

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

    // Init ModelProvider & setPM
    ModelProvider localModelProvider = new ModelProvider();
    localModelProvider.setPresentationModel(new CalculatorPM());

    // Binding (Numbers)
    BnFxBinder.bind(buttonZero, localModelProvider, new Path("zero"));
    BnFxBinder.bind(buttonOne, localModelProvider, new Path("one"));
    BnFxBinder.bind(buttonTwo, localModelProvider, new Path("two"));
    BnFxBinder.bind(buttonThree, localModelProvider, new Path("three"));
    BnFxBinder.bind(buttonFour, localModelProvider, new Path("four"));
    BnFxBinder.bind(buttonFive, localModelProvider, new Path("five"));
    BnFxBinder.bind(buttonSix, localModelProvider, new Path("six"));
    BnFxBinder.bind(buttonSeven, localModelProvider, new Path("seven"));
    BnFxBinder.bind(buttonEight, localModelProvider, new Path("eight"));
    BnFxBinder.bind(buttonNine, localModelProvider, new Path("nine"));

    // Binding (Operations)
    BnFxBinder.bind(buttonDivide, localModelProvider, new Path("divide"));
    BnFxBinder.bind(buttonMultiply, localModelProvider, new Path("multiply"));
    BnFxBinder.bind(buttonMinus, localModelProvider, new Path("minus"));
    BnFxBinder.bind(buttonPlus, localModelProvider, new Path("plus"));

    // Binding (Support)
    BnFxBinder.bind(buttonClear, localModelProvider, new Path("clear"));
    BnFxBinder.bind(buttonClearAll, localModelProvider, new Path("clearAll"));

    // Binding (Result)
    BnFxBinder.bind(textfieldResult, localModelProvider, new Path("resultText"));
    BnFxBinder.bind(buttonResult, localModelProvider, new Path("result"));

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
