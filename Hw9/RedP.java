import javax.swing.*;

/**
 * Red Potion Object.
 * 
 * @author Johnson
 *
 */

public class RedP extends Creature
{
	private ImageIcon RedP;
	
	/**
	 * Constructor for Red Potion.
	 * 
	 * @param name
	 * @param d
	 * @param h
	 */
	public RedP(String name, int d, int h)
	{
		super(name, d, h);
		RedP = createImageIcon("red.png");
	}
	
	/**
	 * Returns ImageIcon for Red Potion.
	 * 
	 * @return Red Potion's image.
	 */
	public ImageIcon getRedP()
	{
		return RedP;
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