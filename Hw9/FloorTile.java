import javax.swing.*;

/**
 * FloorTile Object.
 * 
 * @author Johnson
 *
 */
public class FloorTile extends Tile
{
	private ImageIcon floor;
	
	/**
	 * Constructor of FloorTile. Takes in coordinates.
	 * 
	 * @param x
	 * @param y
	 */
	public FloorTile(int x, int y)
	{
		super(x,y);
		floor = createImageIcon("floor.jpeg");
	}
	
	/**
	 * Returns floor's image.
	 * 
	 */
	public ImageIcon getTile()
	{
		return floor;
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
}
