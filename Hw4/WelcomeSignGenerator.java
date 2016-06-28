/**
 * 
 * Assignment 4.3
 * 
 * Prompt the user for the city and state
 * Create a Location object, using the values collect above
 * Normalize the location
 * Create a WelcomeSign object
 * Show the welcome sign.
 * 
 * Bonus 1: Make the user prompt a dialog box (an actual Swing pop-up).
 * Bonus 2: Make the sign font flash colors on a timer.
 * 
 * @author Johnson
 *
 */

public class WelcomeSignGenerator {

	private static Location location;
	
	public static void main(String[] args)
	{
		WelcomeSign welcome = new WelcomeSign(location);
		welcome.showWelcomeSign();		
	}
}
