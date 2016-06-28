import java.util.*;

import javax.swing.ImageIcon;

/**
 * Abstract class for Tiles.
 * 
 * @author Johnson
 *
 */

abstract class Tile extends DungeonElement
{
	protected Creature creature;
	
	/**
	 * Constructor for Tiles.
	 * 
	 * @param x
	 * @param y
	 */
	public Tile(int x, int y)
	{
		position_X = x;
		position_Y = y;
		creature = null;
	}
	
	/**
	 * Returns X position of Tile.
	 * @return X
	 */
	public int getX()
	{
		return position_X;
	}
	
	/**
	 * Returns Y position of Tile.
	 * @return Y
	 */
	public int getY()
	{
		return position_Y;
	}
	
	/**
	 * Set the creature on current tile to c.
	 * 
	 * @param c
	 */
	public void setCreature(Creature c)
	{
		creature = c;
	}
	
	/**
	 * Returns current creature on current tile.
	 * 
	 * @return creature.
	 */
	public Creature getCreature()
	{
		return creature;
	}
	
	/**
	 * Remove the creature that's on the tile.
	 */
	public void removeCreature()
	{
		creature = null;
	}
	
	abstract ImageIcon getTile();
}
