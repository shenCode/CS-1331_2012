import javax.swing.*;

/**
 * Blue Potion for the game.
 * 
 * @author Johnson
 *
 */

public class BlueP extends Creature
{
	private ImageIcon BlueP;
	
	/**
	 * Constructor. Takes in the image.
	 * 
	 * @param name
	 * @param d
	 * @param h
	 */
	public BlueP(String name, int d, int h)
	{
		super(name, d, h);
		BlueP = createImageIcon("blue.png");
	}
	
	/**
	 * returns the object.
	 * 
	 * @return BluePotion
	 */
	public ImageIcon getBlueP()
	{
		return BlueP;
	}
	
	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path)
	{
	    java.net.URL imgURL = getClass().getResource(path);
	    if (imgURL != null)
	    {
	        return new ImageIcon(imgURL);
	    } 
	    
	    else
	    {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	}

	@Override
	void attack(Creature c) {
		// TODO Auto-generated method stub
		
	}
}