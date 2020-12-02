package edu.hm.rluft.thesis.calculator.swing;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.beanfabrics.ModelProvider;
import org.beanfabrics.Path;
import org.beanfabrics.View;
import org.beanfabrics.swing.BnButton;
import org.beanfabrics.swing.BnTextField;

import edu.hm.rluft.thesis.calculator.CalculatorPM;

public class CalculatorFrame extends JFrame implements View<CalculatorPM> {

	private static final long serialVersionUID = 1L;

	public static final String TITLE = "Taschenrechner";

	private ModelProvider localModelProvider;

	private JPanel headerPanel;
	private BnTextField textField;

	private JPanel centerPanel;
	private BnButton button0;
	private BnButton button1;
	private BnButton button2;
	private BnButton button3;
	private BnButton button4;
	private BnButton button5;
	private BnButton button6;
	private BnButton button7;
	private BnButton button8;
	private BnButton button9;

	private BnButton buttonDivide;
	private BnButton buttonMultiply;
	private BnButton buttonSubtraction;
	private BnButton buttonAddition;

	private BnButton buttonClear;
	private BnButton buttonClearAll;
	private BnButton buttonResult;


	public CalculatorFrame() {
		super();
		this.setTitle(TITLE);
		this.setName(TITLE);
		this.setSize(300, 300);

		this.getContentPane().setLayout(new BorderLayout(0, 0));
		this.getContentPane().add(this.getHeaderPanel(), BorderLayout.NORTH);
		this.getContentPane().add(this.getCenterPanel(), BorderLayout.CENTER);
	}

	public ModelProvider getLocalModelProvider() {
		if (this.localModelProvider == null) {
			this.localModelProvider = new ModelProvider(); // @wb:location=10,430
			this.localModelProvider.setPresentationModelType(CalculatorPM.class);
		}
		return this.localModelProvider;
	}

	@Override
	public CalculatorPM getPresentationModel() {
		return this.getLocalModelProvider().getPresentationModel();
	}

	@Override
	public void setPresentationModel(final CalculatorPM pModel) {
		this.getLocalModelProvider().setPresentationModel(pModel);
	}

	private JPanel getHeaderPanel() {
		if(this.headerPanel == null) {
			this.headerPanel = new JPanel();
			this.headerPanel.setBorder(new EmptyBorder(8, 8, 8, 8));
			this.headerPanel.setLayout(createGBLHeaderPanel());
			this.headerPanel.add(this.getBnTextField(), createGBCTextField());
		}
		return this.headerPanel;
	}

	private GridBagLayout createGBLHeaderPanel() {
		final GridBagLayout gbl_headerPanel = new GridBagLayout();
		gbl_headerPanel.columnWidths = new int[] {0, 0};
		gbl_headerPanel.rowHeights = new int[] {0, 0};
		gbl_headerPanel.columnWeights = new double[] {1.0, Double.MIN_VALUE};
		gbl_headerPanel.rowWeights = new double[] {1.0, Double.MIN_VALUE};
		return gbl_headerPanel;
	}

	private GridBagConstraints createGBCTextField() {
		final GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.SOUTH;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		return gbc_textField;
	}

	private BnTextField getBnTextField() {
		if (this.textField == null) {
			this.textField = new BnTextField();
			this.textField.setHorizontalAlignment(SwingConstants.CENTER);
			this.textField.setPath(new Path("this.resultText"));
			this.textField.setModelProvider(this.getLocalModelProvider());
		}
		return this.textField;
	}

	private JPanel getCenterPanel() {
		if(this.centerPanel == null) {
			this.centerPanel = new JPanel();
			this.centerPanel.setBorder(new EmptyBorder(8, 8, 8, 8));
			GridBagLayout gbl_centerPanel = new GridBagLayout();
			gbl_centerPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_centerPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
			gbl_centerPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
			gbl_centerPanel.rowHeights = new int[] {0, 0, 0, 0};
			this.centerPanel.setLayout(gbl_centerPanel);
			this.centerPanel.add(this.getBnButton0(), createGBCButton0());
			this.centerPanel.add(this.getBnButton1(), createGBCButton1());
			this.centerPanel.add(this.getBnButton2(), createGBCButton2());
			this.centerPanel.add(this.getBnButton3(), createGBCButton3());
			this.centerPanel.add(this.getBnButton4(), createGBCButton4());
			this.centerPanel.add(this.getBnButton5(), createGBCButton5());
			this.centerPanel.add(this.getBnButton6(), createGBCButton6());
			this.centerPanel.add(this.getBnButton7(), createGBCButton7());
			this.centerPanel.add(this.getBnButton8(), createGBCButton8());
			this.centerPanel.add(this.getBnButton9(), createGBCButton9());
			this.centerPanel.add(this.getBnButtonDivide(), createGBCButtonDivide());
			this.centerPanel.add(this.getBnButtonMultiplication(), createGBCButtonMultiplication());
			this.centerPanel.add(this.getBnButtonSubtraction(), createGBCButtonSubtraction());
			this.centerPanel.add(this.getBnButtonAddition(), createGBCButtonAddition());
			this.centerPanel.add(this.getBnButtonClear(), createGBCButtonClear());
			this.centerPanel.add(this.getBnButtonClearAll(), createGBCButtonClearAll());
			this.centerPanel.add(this.getBnButtonResult(), createGBCButtonResult());
		}
		return this.centerPanel;
	}

	private GridBagConstraints createGBCButton0() {
		final GridBagConstraints gbc_button0 = new GridBagConstraints();
		gbc_button0.fill = GridBagConstraints.BOTH;
		gbc_button0.gridwidth = 3;
		gbc_button0.gridx = 0;
		gbc_button0.gridy = 3;
		return gbc_button0;
	}

	private BnButton getBnButton0() {
		if (this.button0 == null) {
			this.button0 = new BnButton();
			this.button0.setText("0");
			this.button0.setPath(new Path("this.zero"));
			this.button0.setModelProvider(this.getLocalModelProvider());
		}
		return this.button0;
	}


	private GridBagConstraints createGBCButton1() {
		final GridBagConstraints gbc_button1 = new GridBagConstraints();
		gbc_button1.fill = GridBagConstraints.BOTH;
		gbc_button1.gridx = 0;
		gbc_button1.gridy = 2;
		return gbc_button1;
	}

	private BnButton getBnButton1() {
		if (this.button1 == null) {
			this.button1 = new BnButton();
			this.button1.setText("1");
			this.button1.setPath(new Path("this.one"));
			this.button1.setModelProvider(this.getLocalModelProvider());
		}
		return this.button1;
	}

	private GridBagConstraints createGBCButton2() {
		final GridBagConstraints gbc_button2 = new GridBagConstraints();
		gbc_button2.fill = GridBagConstraints.BOTH;
		gbc_button2.gridx = 1;
		gbc_button2.gridy = 2;
		return gbc_button2;
	}

	private BnButton getBnButton2() {
		if (this.button2 == null) {
			this.button2 = new BnButton();
			this.button2.setText("2");
			this.button2.setPath(new Path("this.two"));
			this.button2.setModelProvider(this.getLocalModelProvider());
		}
		return this.button2;
	}

	private GridBagConstraints createGBCButton3() {
		final GridBagConstraints gbc_button3 = new GridBagConstraints();
		gbc_button3.fill = GridBagConstraints.BOTH;
		gbc_button3.gridx = 2;
		gbc_button3.gridy = 2;
		return gbc_button3;
	}

	private BnButton getBnButton3() {
		if (this.button3 == null) {
			this.button3 = new BnButton();
			this.button3.setText("3");
			this.button3.setPath(new Path("this.three"));
			this.button3.setModelProvider(this.getLocalModelProvider());
		}
		return this.button3;
	}

	private GridBagConstraints createGBCButton4() {
		final GridBagConstraints gbc_button4 = new GridBagConstraints();
		gbc_button4.fill = GridBagConstraints.BOTH;
		gbc_button4.gridx = 0;
		gbc_button4.gridy = 1;
		return gbc_button4;
	}

	private BnButton getBnButton4() {
		if (this.button4 == null) {
			this.button4 = new BnButton();
			this.button4.setText("4");
			this.button4.setPath(new Path("this.four"));
			this.button4.setModelProvider(this.getLocalModelProvider());
		}
		return this.button4;
	}

	private GridBagConstraints createGBCButton5() {
		final GridBagConstraints gbc_button5 = new GridBagConstraints();
		gbc_button5.fill = GridBagConstraints.BOTH;
		gbc_button5.gridx = 1;
		gbc_button5.gridy = 1;
		return gbc_button5;
	}

	private BnButton getBnButton5() {
		if (this.button5 == null) {
			this.button5 = new BnButton();
			this.button5.setText("5");
			this.button5.setPath(new Path("this.five"));
			this.button5.setModelProvider(this.getLocalModelProvider());
		}
		return this.button5;
	}

	private GridBagConstraints createGBCButton6() {
		final GridBagConstraints gbc_button6 = new GridBagConstraints();
		gbc_button6.fill = GridBagConstraints.BOTH;
		gbc_button6.gridx = 2;
		gbc_button6.gridy = 1;
		return gbc_button6;
	}

	private BnButton getBnButton6() {
		if (this.button6 == null) {
			this.button6 = new BnButton();
			this.button6.setText("6");
			this.button6.setPath(new Path("this.six"));
			this.button6.setModelProvider(this.getLocalModelProvider());
		}
		return this.button6;
	}

	private GridBagConstraints createGBCButton7() {
		final GridBagConstraints gbc_button7 = new GridBagConstraints();
		gbc_button7.fill = GridBagConstraints.BOTH;
		gbc_button7.gridx = 0;
		gbc_button7.gridy = 0;
		return gbc_button7;
	}

	private BnButton getBnButton7() {
		if (this.button7 == null) {
			this.button7 = new BnButton();
			this.button7.setText("7");
			this.button7.setPath(new Path("this.seven"));
			this.button7.setModelProvider(this.getLocalModelProvider());
		}
		return this.button7;
	}

	private GridBagConstraints createGBCButton8() {
		final GridBagConstraints gbc_button8 = new GridBagConstraints();
		gbc_button8.fill = GridBagConstraints.BOTH;
		gbc_button8.gridx = 1;
		gbc_button8.gridy = 0;
		return gbc_button8;
	}

	private BnButton getBnButton8() {
		if (this.button8 == null) {
			this.button8 = new BnButton();
			this.button8.setText("8");
			this.button8.setPath(new Path("this.eight"));
			this.button8.setModelProvider(this.getLocalModelProvider());
		}
		return this.button8;
	}

	private GridBagConstraints createGBCButton9() {
		final GridBagConstraints gbc_button9 = new GridBagConstraints();
		gbc_button9.fill = GridBagConstraints.BOTH;
		gbc_button9.gridx = 2;
		gbc_button9.gridy = 0;
		return gbc_button9;
	}

	private BnButton getBnButton9() {
		if (this.button9 == null) {
			this.button9 = new BnButton();
			this.button9.setText("9");
			this.button9.setPath(new Path("this.nine"));
			this.button9.setModelProvider(this.getLocalModelProvider());
		}
		return this.button9;
	}

	private GridBagConstraints createGBCButtonDivide() {
		final GridBagConstraints gbc_buttonDivide = new GridBagConstraints();
		gbc_buttonDivide.fill = GridBagConstraints.BOTH;
		gbc_buttonDivide.gridx = 3;
		gbc_buttonDivide.gridy = 0;
		return gbc_buttonDivide;
	}

	private BnButton getBnButtonDivide() {
		if (this.buttonDivide == null) {
			this.buttonDivide = new BnButton();
			this.buttonDivide.setText("/");
			this.buttonDivide.setPath(new Path("this.divide"));
			this.buttonDivide.setModelProvider(this.getLocalModelProvider());
		}
		return this.buttonDivide;
	}

	private GridBagConstraints createGBCButtonMultiplication() {
		final GridBagConstraints gbc_buttonMulitplication = new GridBagConstraints();
		gbc_buttonMulitplication.fill = GridBagConstraints.BOTH;
		gbc_buttonMulitplication.gridx = 3;
		gbc_buttonMulitplication.gridy = 1;
		return gbc_buttonMulitplication;
	}

	private BnButton getBnButtonMultiplication() {
		if (this.buttonMultiply == null) {
			this.buttonMultiply = new BnButton();
			this.buttonMultiply.setText("*");
			this.buttonMultiply.setPath(new Path("this.multiply"));
			this.buttonMultiply.setModelProvider(this.getLocalModelProvider());
		}
		return this.buttonMultiply;
	}

	private GridBagConstraints createGBCButtonSubtraction() {
		final GridBagConstraints gbc_buttonSubtraction = new GridBagConstraints();
		gbc_buttonSubtraction.fill = GridBagConstraints.BOTH;
		gbc_buttonSubtraction.gridx = 3;
		gbc_buttonSubtraction.gridy = 2;
		return gbc_buttonSubtraction;
	}

	private BnButton getBnButtonSubtraction() {
		if (this.buttonSubtraction == null) {
			this.buttonSubtraction = new BnButton();
			this.buttonSubtraction.setText("-");
			this.buttonSubtraction.setPath(new Path("this.minus"));
			this.buttonSubtraction.setModelProvider(this.getLocalModelProvider());
		}
		return this.buttonSubtraction;
	}

	private GridBagConstraints createGBCButtonAddition() {
		final GridBagConstraints gbc_buttonAddition = new GridBagConstraints();
		gbc_buttonAddition.fill = GridBagConstraints.BOTH;
		gbc_buttonAddition.gridx = 3;
		gbc_buttonAddition.gridy = 3;
		return gbc_buttonAddition;
	}

	private BnButton getBnButtonAddition() {
		if (this.buttonAddition == null) {
			this.buttonAddition = new BnButton();
			this.buttonAddition.setText("+");
			this.buttonAddition.setPath(new Path("this.plus"));
			this.buttonAddition.setModelProvider(this.getLocalModelProvider());
		}
		return this.buttonAddition;
	}

	private GridBagConstraints createGBCButtonClear() {
		final GridBagConstraints gbc_buttonClear = new GridBagConstraints();
		gbc_buttonClear.fill = GridBagConstraints.BOTH;
		gbc_buttonClear.gridx = 4;
		gbc_buttonClear.gridy = 0;
		return gbc_buttonClear;
	}

	private BnButton getBnButtonClear() {
		if (this.buttonClear == null) {
			this.buttonClear = new BnButton();
			this.buttonClear.setText("<-");
			this.buttonClear.setPath(new Path("this.clear"));
			this.buttonClear.setModelProvider(this.getLocalModelProvider());
		}
		return this.buttonClear;
	}

	private GridBagConstraints createGBCButtonClearAll() {
		final GridBagConstraints gbc_buttonClearAll = new GridBagConstraints();
		gbc_buttonClearAll.fill = GridBagConstraints.BOTH;
		gbc_buttonClearAll.gridx = 4;
		gbc_buttonClearAll.gridy = 1;
		return gbc_buttonClearAll;
	}

	private BnButton getBnButtonClearAll() {
		if (this.buttonClearAll == null) {
			this.buttonClearAll = new BnButton();
			this.buttonClearAll.setText("C");
			this.buttonClearAll.setPath(new Path("this.clearAll"));
			this.buttonClearAll.setModelProvider(this.getLocalModelProvider());
		}
		return this.buttonClearAll;
	}

	private GridBagConstraints createGBCButtonResult() {
		final GridBagConstraints gbc_buttonResult = new GridBagConstraints();
		gbc_buttonResult.fill = GridBagConstraints.BOTH;
		gbc_buttonResult.gridheight = 2;
		gbc_buttonResult.gridx = 4;
		gbc_buttonResult.gridy = 2;
		return gbc_buttonResult;
	}

	private BnButton getBnButtonResult() {
		if (this.buttonResult == null) {
			this.buttonResult = new BnButton();
			this.buttonResult.setText("=");
			this.buttonResult.setPath(new Path("this.result"));
			this.buttonResult.setModelProvider(this.getLocalModelProvider());
		}
		return this.buttonResult;
	}


}
