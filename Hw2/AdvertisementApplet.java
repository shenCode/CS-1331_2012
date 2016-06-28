/*
 * Homework 2, Problem 2
 * Create a java applet that draws an advertisement for some real or fictitious product.
 */

import javax.swing.JApplet;
import java.awt.*;


public class AdvertisementApplet extends JApplet{

	public void paint (Graphics ad) {
		
		// Create custom color named "coolcolor"
		Color coolcolor = new Color(250, 55, 250);
								
		// Write the sentence
		ad.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ad.drawString("Georgia Tech", 200, 50);
		ad.drawString("College of Computing", 180, 70);
		
		// Draw Rectangle
		ad.setColor(Color.yellow);
		ad.fillRect(0, 100, 500, 300);
		
		// Draw Eyes
		ad.setColor(coolcolor);
		ad.fillOval(100, 175, 50, 50);
		ad.drawOval(100, 175, 50, 50);
		ad.setColor(Color.blue);
		ad.fillRect(350, 175, 50, 50);
		ad.drawOval(350, 175, 50, 50);
		
		// Draw Mouth
		ad.drawArc(200,300,80,40,180,180);

	}

} // end class AdvertisementApplet
