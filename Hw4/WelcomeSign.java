import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/**
 * 
 * Assignment 4.2
 * 
 * Instance variables to store the Location and JFrame
 * Constructor takes in Location parameter
 * In constructor, create JFrame to store instance variable Location and JFrame
 * Set Font and Border
 * showWelcomeSign()
 * 
 * @author Johnson
 *
 */

public class WelcomeSign extends JFrame
{
	// Set instance data
	private Location location;
	private JFrame myFrame;
	private JLabel label1, label2;
	private Color newColor = Color.black;
	private String locationString;
	final int DELAY = 1000;
	
	/**
	 * Constructor of WelcomeSign
	 * @param location
	 */
	public WelcomeSign(Location location)
	{
		String newCity = JOptionPane.showInputDialog(null, "Enter city: ");
		String newState = JOptionPane.showInputDialog(null, "Enter state: ");
		location = new Location(newCity, newState);
		location.normalize();
		locationString = location.toString();
	}
	
	/**
	 * Create myFrame, pack and setVisible
	 */
	public void showWelcomeSign()
	{
		myFrame = new JFrame("Welcome!");
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel myPanel = new Panel();
		myFrame.setPreferredSize(new Dimension(250, 150));
		
		myFrame.add(myPanel);
		myFrame.pack();
		myFrame.setVisible(true);
	}
	
	/**
	 * Timer that generates and sets the color of label2 every DELAY (1) seconds.
	 * @author Johnson
	 *
	 */
	private class TimerListener implements ActionListener
	{		
		/**
		 * Generates color and set color for label2
		 */
		public void actionPerformed(ActionEvent time)
		{
			genColor();
			label2.setForeground(newColor);
		}
	}
	
	/**
	 * Create a new class for panel
	 * @author Johnson
	 *
	 */
	private class Panel extends JPanel
	{
		/**
		 * Constructor for Panel
		 */
		public Panel()
		{
			label1 = new JLabel("Welcome to...", JLabel.CENTER);
			label2 = new JLabel(locationString, JLabel.CENTER); //
			label1.setFont(new Font("Arial", Font.ITALIC, 15));
			label2.setFont(new Font("Times New Roman", Font.BOLD, 25));
			setPreferredSize(new Dimension(200, 100));
			
			setBorder(BorderFactory.createLineBorder(Color.red, 5));
			Timer time = new Timer(DELAY, new TimerListener());
			time.start();
			add(label1);
			add(label2);
		}
	}
	
	/**
	 * Genrates random color
	 */
	public void genColor()
	{
		Random gen = new Random();
			
		int varRed = gen.nextInt(255) + 1;
		int varGreen = gen.nextInt(255) + 1;
		int varBlue = gen.nextInt(255) + 1;
			
		newColor = new Color(varRed, varGreen, varBlue);
	}
}
