import javax.swing.*;

/**
 * Trap Object.
 * 
 * @author Johnson
 *
 */
public class Trap extends Creature
{
	private ImageIcon trap;
	
	/**
	 * Constructor for Trap.
	 * 
	 * @param name
	 * @param d
	 * @param h
	 */
	public Trap(String name, int d, int h)
	{
		super(name, d, h);
		trap = createImageIcon("trap.png");
	}
	
	/** 
	 * Returns trap's image.
	 * 
	 * @return trap.
	 */
	public ImageIcon getTrap()
	{
		return trap;
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
