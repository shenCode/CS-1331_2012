import java.util.Random;

/**
 * DungeonElement class. Sets location for each DungeonElement.
 * 
 * @author Johnson
 *
 */
abstract public class DungeonElement
{
	protected int position_X;
	protected int position_Y;
	protected String name;
	protected char[][] map = Dungeon.getMap();
	
	/**
	 * Sets location.
	 */
	public void setLocation()
	{
		Random rand = new Random();
		position_X = rand.nextInt(map.length-2)+1;
		position_Y = rand.nextInt(map[0].length-2)+1;
		while (Dungeon.getNew()[position_X][position_Y] instanceof WallTile)
		{
			position_X = rand.nextInt(map.length-2)+1;
			position_Y = rand.nextInt(map[0].length-2)+1;
		}
	}
}
