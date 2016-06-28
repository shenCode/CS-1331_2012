import java.awt.*;
import javax.swing.JApplet;
import java.util.Random;
import java.awt.event.*;

/**
 * Assignment 3.2: Mood Ring
 * 
 * Draw a Ring
 *
 * Ring's color should be completely random 
 * Ring displayed with random diameter
 * Color and diameter change every time resized or ran
 * Ring should not extend beyond edge of applet window
 * Ring should always be visible
 * 
 * @author Shen Yang
 * 
 */ 

public class MoodRingApplet extends JApplet implements Runnable, ComponentListener {

	Thread timer;
	
	int height;
	int width;
	int RING_SIZE;
	double SIZE_CONSTANT = 0.08;
	boolean hasChanged = true;
	
	// Generating random
	Random gen = new Random();
	
	// Override
	public void componentHidden(ComponentEvent e) {}
	public void componentShown(ComponentEvent e) {}
	public void componentMoved(ComponentEvent e) {}
	public void componentResized(ComponentEvent e) {}
	
	public void init() {
	
	// Size change when applet is resized
	addComponentListener(new ComponentAdapter() {
		public void componentResized(ComponentEvent e) {
			hasChanged = true;
			repaint();
			}
		});
	} // end init()
		
	public void start() {
	
		// Start timer
		timer = new Thread (this);
		timer.start();
		
	} // end start()
	
	public void run() {
		
		while (true) {
			try
			{	
				repaint(); // Repaint the ring
				timer.sleep(1000); // 1000 milliseconds = 1 second
			} catch(InterruptedException e) {}
		}
	} // end run()

	// Get a random Ring Size
	public void getRingSize() {
		if (width <= height) {
			RING_SIZE = gen.nextInt((int)(0.9*width)) + (int)(SIZE_CONSTANT*width);
		} // end if

		else {
			RING_SIZE = gen.nextInt((int)(0.9*height)) + (int)(SIZE_CONSTANT*height);
		} // end else
		
	} // end getRingSize()
	
	
	public void paint(Graphics ring) {
	
		// Retrieve the width and height of Applet
		width = this.getWidth();
		height = this.getHeight();
		
		// Set background to black
		setBackground(Color.black);
		
		if (hasChanged) {
		getRingSize();
		hasChanged = false; // Does NOT change Ring Size until applet is resized again
		}
		
		// Getting random colors within the range of 1 to 255
		int varRed = gen.nextInt(255) + 1;
		int varGreen = gen.nextInt(255) + 1;
		int varBlue = gen.nextInt(255) + 1;
		
		// Ensuring that the Ring is always in the middle
		int X_MID = (width - RING_SIZE)/2;
		int Y_MID = (height - RING_SIZE)/2;
		
		// Set the size of the ring. The larger the value, the thinner the ring.
		double PERCENT = 0.85;
		
		// The values for the smaller circle inside the bigger circle
		int SMALL_X = (int)((width - PERCENT * RING_SIZE) / 2);
		int SMALL_Y = (int)((height - PERCENT * RING_SIZE) / 2);
		int SMALL_SIZE = (int)(RING_SIZE * PERCENT);
				
		// Clearing the previous circles
		ring.clearRect(0, 0, width, height);
		
		// Creating a random color
		Color randomColor = new Color(varRed, varGreen, varBlue);
		
		// Drawing the circles thus forming a Ring
		ring.setColor(randomColor);
		ring.fillOval(X_MID, Y_MID, RING_SIZE, RING_SIZE);
		ring.setColor(Color.black);
		ring.fillOval(SMALL_X, SMALL_Y, SMALL_SIZE, SMALL_SIZE);
		

	} // end paint

} // end class MoodRingApplet
