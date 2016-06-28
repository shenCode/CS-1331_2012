import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Main for the Game.
 * 
 * @author Johnson
 *
 */
public class DisplayPanel extends JFrame
{
	public static void main(String args[])
	{
		JFrame frame = new JFrame("Game");
		Dungeon d = new Dungeon();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(d);
		frame.pack();
		frame.setVisible(true);
	}

}
