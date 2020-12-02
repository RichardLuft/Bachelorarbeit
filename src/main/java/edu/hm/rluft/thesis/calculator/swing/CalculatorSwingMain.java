package edu.hm.rluft.thesis.calculator.swing;

import edu.hm.rluft.thesis.calculator.CalculatorPM;

public class CalculatorSwingMain {

	public static void main(String[] args) {
		CalculatorFrame calculator = new CalculatorFrame();
		calculator.setPresentationModel(new CalculatorPM());
		calculator.setVisible(true);
	}

}
