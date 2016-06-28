import javax.swing.*;

/**
 * Assignment 10
 * 
 * Paint Panel
 * 
 * Collaboration: I did this alone.
 * 
 * @author Johnson
 *
 */
public class paintFrame
{

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Paint");
		AllPanel p = new AllPanel();
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(p);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
}
