package edu.hm.rluft.thesis.calculator;

import java.text.DecimalFormat;
import org.beanfabrics.model.AbstractPM;
import org.beanfabrics.model.IntegerPM;
import org.beanfabrics.model.OperationPM;
import org.beanfabrics.model.PMManager;
import org.beanfabrics.support.Operation;
import org.beanfabrics.support.Validation;

public class CalculatorPM extends AbstractPM {

  private OperationPM zero = new OperationPM();
  private OperationPM one = new OperationPM();
  private OperationPM two = new OperationPM();
  private OperationPM three = new OperationPM();
  private OperationPM four = new OperationPM();
  private OperationPM five = new OperationPM();
  private OperationPM six = new OperationPM();
  private OperationPM seven = new OperationPM();
  private OperationPM eight = new OperationPM();
  private OperationPM nine = new OperationPM();

  private OperationPM divide = new OperationPM();
  private OperationPM multiply = new OperationPM();
  private OperationPM minus = new OperationPM();
  private OperationPM plus = new OperationPM();

  private OperationPM clear = new OperationPM();
  private OperationPM clearAll = new OperationPM();

  private IntegerPM resultText = new IntegerPM();
  private OperationPM result = new OperationPM();

  private int speicher = 0;
  private MathematicalOperation currentOperation;

  public CalculatorPM() {
    resultText.setEditable(false);
    resultText.setInteger(0);
    resultText.setFormat(new IntegerPM.Format(new DecimalFormat("#")));
    PMManager.setup(this);
  }

  @Operation
  public void zero() {
    addToResult(0);
  }

  @Operation
  public void one() {
    addToResult(1);
  }

  @Operation
  public void two() {
    addToResult(2);
  }

  @Operation
  public void three() {
    addToResult(3);
  }

  @Operation
  public void four() {
    addToResult(4);
  }

  @Operation
  public void five() {
    addToResult(5);
  }

  @Operation
  public void six() {
    addToResult(6);
  }

  @Operation
  public void seven() {
    addToResult(7);
  }

  @Operation
  public void eight() {
    addToResult(8);
  }

  @Operation
  public void nine() {
    addToResult(9);
  }

  private void addToResult(int number) {
    if (resultText.getInteger() != 0) {
      resultText.setInteger(resultText.getInteger() * 10 + number);
    } else {
      resultText.setInteger(number);
    }
  }

  @Operation
  public void clear() {
    if (resultText.getInteger() < 10) {
      resultText.setInteger(0);
    } else {
      int neueZahl = resultText.getInteger() - resultText.getInteger() % 10; // entfernen der letzten Zahl
      neueZahl = neueZahl / 10; // entfernen der null-Zahl
      resultText.setInteger(neueZahl);
    }
  }

  @Validation(path = "clear")
  public boolean isClearActive() {
    if (resultText.getInteger() != 0) {
      return true;
    }
    return false;
  }

  @Operation
  public void clearAll() {
    resultText.setInteger(0);
    currentOperation = null;
    speicher = 0;
  }

  @Operation
  public void plus() {
    currentOperation = MathematicalOperation.Addition;
    speicher = resultText.getInteger();
    resultText.setInteger(0);
  }

  @Operation
  public void minus() {
    currentOperation = MathematicalOperation.Subtraction;
    speicher = resultText.getInteger();
    resultText.setInteger(0);
  }

  @Operation
  public void multiply() {
    currentOperation = MathematicalOperation.Multiplication;
    speicher = resultText.getInteger();
    resultText.setInteger(0);
  }

  @Operation
  public void divide() {
    currentOperation = MathematicalOperation.Division;
    speicher = resultText.getInteger();
    resultText.setInteger(0);
  }

  @Operation
  public void result() {
    switch (currentOperation) {
      case Addition:
        resultText.setInteger(speicher + resultText.getInteger());
        break;
      case Subtraction:
        resultText.setInteger(speicher - resultText.getInteger());
        break;
      case Multiplication:
        resultText.setInteger(speicher * resultText.getInteger());
        break;
      case Division:
        if (resultText.getInteger() != 0) {
          resultText.setInteger(speicher / resultText.getInteger());
        } else {
          clearAll();
        }
        break;
      default:
        break;
    }
  }

  @Validation(path = "result")
  public boolean isResultActive() {
    if (currentOperation != null) {
      return true;
    }
    return false;
  }

}
