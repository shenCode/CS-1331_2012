import java.awt.*;
import javax.swing.*;

/**
 * Finally, create a class named PetMain with a main method that creates a JFrame, and brings
 * together a Pet object and a PetPanel object:
 * 
 * Create a JFrame, and set the default close operation
 * Create a Pet object.
 * Create a PetPanel object, using the Pet above.
 * Add the PetPanel to the JFrame.
 * Pack, and set the visibility of the JFrame.
 * 
 * @author Johnson
 *
 */

public class PetMain extends JFrame
{
	public static void main(String args[])
	{
		JFrame myFrame = new JFrame("My Pet!");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		Pet myPet = new Pet();
		PetPanel myPanel = new PetPanel(myPet);
	
		myFrame.setPreferredSize(new Dimension(250, 400));
		myFrame.add(myPanel);
		myFrame.pack();
		myFrame.setVisible(true);
	}
}
