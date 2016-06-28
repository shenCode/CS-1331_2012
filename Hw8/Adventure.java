import javax.swing.*;

/**
 * Assignment 8:
 * 
 * Point-and-Click Adventure
 * 
 * @author Johnson
 * 
 * Bonus: Save and Load
 * Bonus: Puzzle (Needs password to end.)
 * Bonus: Clickable Inventory.
 *
 */

public class Adventure extends JFrame
{
	public static void main(String args[])
	{
		JFrame frame = new JFrame("Le Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		displayPanel panel = new displayPanel();
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
