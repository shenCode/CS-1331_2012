import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** 
 * Assignment 6
 * 
 * This class represents the user interface for a calculator.
 * 
 * Bonus: Added tabs to display decimal Results and hex Results.
 * Bonus: Pop dialog if division by 0.
 * 
 * Collaboration statement: I worked on this assignment alone.
 *
 * @author Johnson
 *
 */

public class CalculatorScreenPanel extends JPanel
{
	private JLabel binaryDisplay, decimalDisplay, hexDisplay;
	private JPanel binaryPanel, decimalPanel, hexPanel;
	private JButton one, zero, addition, subtraction, multiplication, division, equals, ca;
	private String userInput = "", first, second;
	private int status;
	private boolean muldiv = false;
	
	/**
	 * Constructor for CalculatorScreenPanel
	 */
	public CalculatorScreenPanel()
	{
		JTabbedPane tp = new JTabbedPane();
		setLayout(new BorderLayout());
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(2,4));
		inputPanel.setPreferredSize(new Dimension(200, 140));
		tp.setPreferredSize(new Dimension(200, 60));
		
		binaryDisplay = new JLabel(userInput);
		decimalDisplay = new JLabel(userInput);
		hexDisplay = new JLabel(userInput);
		binaryDisplay.setLayout(new FlowLayout());
		
		binaryPanel = new JPanel();
		binaryPanel.add(binaryDisplay);
		decimalPanel = new JPanel();
		decimalPanel.add(decimalDisplay);
		hexPanel = new JPanel();
		hexPanel.add(hexDisplay);
		
		one = new JButton("1");
		zero = new JButton("0");
		addition = new JButton("+");
		subtraction = new JButton("-");
		multiplication = new JButton("*");
		division = new JButton("/");
		equals = new JButton("=");
		ca = new JButton("CA");
		
		tp.add("Binary", binaryPanel);
		tp.add("Decimal", decimalPanel);
		tp.add("Hex", hexPanel);
		
		add(tp, BorderLayout.NORTH);
		inputPanel.add(one);
		inputPanel.add(zero);
		inputPanel.add(addition);
		inputPanel.add(subtraction);
		inputPanel.add(multiplication);
		inputPanel.add(division);
		inputPanel.add(equals);
		inputPanel.add(ca);
		add(inputPanel, BorderLayout.SOUTH);
		setPreferredSize(new Dimension(200, 200));

		one.addActionListener(new listener());
		zero.addActionListener(new listener());
		addition.addActionListener(new listener());
		subtraction.addActionListener(new listener());
		multiplication.addActionListener(new listener());
		division.addActionListener(new listener());
		equals.addActionListener(new listener());
		ca.addActionListener(new listener());
	}
	
	/**
	 * Update display
	 */
	public void refresh()
	{
		binaryDisplay.setText(userInput);
		decimalDisplay.setText(Integer.toString(BinaryCalculator.convertToInt(userInput)));
		hexDisplay.setText(Integer.toHexString(BinaryCalculator.convertToInt(userInput)));
	}
	
	public void display()
	{
		binaryDisplay.setText(BinaryCalculator.getBinaryResult());
		decimalDisplay.setText(BinaryCalculator.getDecimalResult());
		hexDisplay.setText(BinaryCalculator.getHexResult());
	}
	/**
	 * Get the event sources and respond accordingly.
	 * 
	 * @author Johnson
	 *
	 */
	private class listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (event.getSource() == one)
			{
				userInput = userInput + "1";
				refresh();
			}
			
			else if (event.getSource() == zero)
			{
				userInput = userInput + "0";
				refresh();
			}
			else if (event.getSource() == addition)
			{
				status = 1;
				if (first == null)
				{
					first = userInput;
				}
				
				else if (first != null)
				{
					second = userInput;
					BinaryCalculator.addition(first, second);
					first = BinaryCalculator.getBinaryResult();
					display();
				}
				userInput = "";
			}
			else if (event.getSource() == subtraction)
			{
				status = 2;
				if (first == null)
				{
					first = userInput;	
				}
				
				else if (first != null)
				{
					second = userInput;
					BinaryCalculator.subtraction(first, second);
					first = BinaryCalculator.getBinaryResult();
					display();
				}
				userInput = "";
			}
			
			else if (event.getSource() == multiplication)
			{
				status = 3;
				if (first == null)
				{
					first = userInput;	
				}
				
				else if (first != null)
				{
					second = userInput;
					BinaryCalculator.multiplication(first, second);
					first = BinaryCalculator.getBinaryResult();
					display();
				}
				muldiv = false;
				userInput = "";
			}
			
			else if (event.getSource() == division)
			{
				status = 4;
				if (first == null)
				{
					first = userInput;	
				}
				
				else if (first != null)
				{
					second = userInput;
					BinaryCalculator.division(first, second);
					first = BinaryCalculator.getBinaryResult();
					display();
				}
				userInput = "";
			}
			
			else if (event.getSource() == equals)
			{
				second = userInput;
				if (status == 1)
				{
					BinaryCalculator.addition(first, second);
				}
				
				if (status == 2)
				{
					BinaryCalculator.subtraction(first, second);
				}
				
				if (status == 3)
				{
					BinaryCalculator.multiplication(first, second);
				}
				
				if (status == 4)
				{
					BinaryCalculator.division(first, second);
				}
				display();
				userInput = "";
				first = null;
				second = null;
				muldiv = false;
				BinaryCalculator.reset();
			}
			
			else if (event.getSource() == ca)
			{
				userInput = "";
				first = null;
				second = null;
				muldiv = false;
				refresh();
				BinaryCalculator.reset();
			}
		}
	}
}
