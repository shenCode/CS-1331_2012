import javax.swing.*;

/**
 * Class for WallTile.
 * 
 * @author Johnson
 *
 */

public class WallTile extends Tile
{
	private ImageIcon wall;
	
	/**
	 * Constructor for Wall Tile. Takes in wall's image.
	 * 
	 * @param x
	 * @param y
	 */
	public WallTile(int x, int y)
	{
		super(x,y);
		wall = createImageIcon("wall.jpeg");
	}
	
	/**
	 * Returns ImageIcon of Walltile.
	 * @return wall's image.
	 */
	public ImageIcon getTile()
	{
		return wall;
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
