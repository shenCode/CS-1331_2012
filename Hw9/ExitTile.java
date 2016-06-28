import javax.swing.*;

/**
 * ExitTile Object.
 * 
 * @author Johnson
 *
 */
public class ExitTile extends Creature
{
	private ImageIcon ExitTile;
	
	/**
	 * Constructor for Exit Tile.
	 * 
	 * @param name
	 * @param d
	 * @param h
	 */
	public ExitTile(String name, int d, int h)
	{
		super(name, d, h);
		ExitTile = createImageIcon("ladder.png");
	}
	
	/**
	 * Get Exit Tile's image.
	 * 
	 * @return Exit Tile's image.
	 */
	public ImageIcon getExitTile()
	{
		return ExitTile;
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
