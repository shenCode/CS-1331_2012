import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * Assignment 6
 * 
 * This is just a driver class. It contains a main method that generates your GUI. It should create a JFrame,
 * and add a CalculatorScreenPanel to it.
 * 
 * Bonus: Added tabs to display decimal Results and hex Results.
 * Bonus: Pop dialog if division by 0.
 * 
 * Collaboration statement: I worked on this assignment alone.
 * 
 * @author Johnson
 *
 */
public class HW6Driver
{
	public static void main(String args[])
	{
		CalculatorScreenPanel inputPanel = new CalculatorScreenPanel();
		JFrame frame = new JFrame("test");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(inputPanel);
		frame.pack();
		frame.setVisible(true);
	}

}
