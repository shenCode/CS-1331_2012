import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;

/**
 * Dungeon Panel. Includes listeners and other validation.
 * 
 * Bonus: 2 different item. Red Potion - Adds 100 hp. Blue Potion - Adds 20 attack.
 * Bonus: Timer - Monster and First Enemy moves every second towards player.
 * 
 * Player has 100 hp and 80 damage. 50% accuracy.
 * First Enemy has 100 hp and 20 damage, 70% accuracy.
 * Monster has 70 hp, 90 damage and 20% accuracy.
 * 
 * Trap causes 20 damage to whoever walks on it.
 * 
 * Win when player reaches exit.
 * 
 * @author Johnson
 *
 */
public class Dungeon extends JPanel
{
	protected static char[][] map;
	private int xPosition = 50;
	private int yPosition = 50;
	private final int square = 50;
	private ExitTile exit;
	private BlueP blue;
	private RedP red;
	private Trap trap;
	private FirstEnemy fenemy;
	private Player player;
	private boolean win = false;
	private Timer timer;
	private int DELAY = 1000;
	private Monster monster;
	private static Tile[][] newMap;
	
	public Dungeon()
	{
		timer = new Timer(DELAY, new MoveListener());
		map = MapGenerator.generateMap(2, 3, 5, true, '+', '-');
		newMap = new Tile[map.length][map[0].length];
		newMap();
		exit = new ExitTile("exit", 0, 0);
		blue = new BlueP("blue", 0, 0);
		red = new RedP("red", 0, 0);
		trap = new Trap("trap", 0, 0);
		setPreferredSize(new Dimension(map.length * square, map[0].length * square));
		player = new Player("Player", 80, 100);
		fenemy = new FirstEnemy("First Enemy", 20, 100);
		monster = new Monster("MONSTER", 90, 70);
		addKeyListener(new DirectionListener());
		setFocusable(true);
		timer.start();
		// Ensure they don't start on same tile.
		while (newMap[player.getX()][player.getY()].getCreature() instanceof Creature || newMap[player.getX()][player.getY()].getCreature() instanceof ExitTile
				|| newMap[fenemy.getX()][fenemy.getY()].getCreature() instanceof Creature
				|| newMap[monster.getX()][monster.getY()].getCreature() instanceof Creature)
		{
			player.setLocation();
			fenemy.setLocation();
			exit.setLocation();
			monster.setLocation();
			blue.setLocation();
			red.setLocation();
			trap.setLocation();
		}
	}
	
	/**
	 * Makes a new map that contains tiles of floor and wall instead of + and -.
	 */
	public static void newMap()
	{
		for (int y = 0; y < map[0].length; y++) {
			for (int x = 0; x < map.length; x++) {
				if (map[x][y] == '+')
				{
					newMap[x][y] = new WallTile(x,y);
				}
				else
				{
					newMap[x][y] = new FloorTile(x,y);
				}
			}
		}
	}
	
	/**
	 * Get the new map.
	 * 
	 * @return newMap.
	 */
	public static Tile[][] getNew()
	{
		return newMap;
	}
	
	/**
	 * Get the map that was generated.
	 * 
	 * @return map
	 */
	public static char[][] getMap()
	{
		return map;
	}
	
	/**
	 * Check if player has won.
	 */
	public void checkWin()
	{
		if (win)
		{
			JOptionPane.showMessageDialog(this, "You Win!");
			System.exit(1);
		}
	}
	
	/**
	 * Check if player is alive and if enemies are alive. Remove enemeis if they are dead.
	 */
	public void checkAlive()
	{
		if (!player.getAlive())
		{
			JOptionPane.showMessageDialog(this, "You died.");
			System.exit(1);
		if (!fenemy.getAlive())
		{
			for (int y = 0; y < newMap[0].length; y++) {
				for (int x = 0; x < newMap.length; x++) {
					if (newMap[x][y].getCreature() instanceof FirstEnemy)
					{
						newMap[x][y].removeCreature();
					}
				}
			}
		}
		if (!monster.getAlive())
		{
			for (int y = 0; y < newMap[0].length; y++) {
				for (int x = 0; x < newMap.length; x++) {
					if (newMap[x][y].getCreature() instanceof Monster)
					{
						newMap[x][y].removeCreature();
					}
				}
			}
		}
	}
	}
	
	/**
	 * Paint the tiles.
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for (int y = 0; y < map[0].length; y++) {
			for (int x = 0; x < map.length; x++) {
				g.drawImage(newMap[x][y].getTile().getImage(), x*xPosition, y*yPosition, square, square, null);
				if (x == exit.getX() && y == exit.getY())
				{
					g.drawImage(exit.getExitTile().getImage(), x*xPosition, y*yPosition, square, square, null);
				}
				if (x == blue.getX() && y == blue.getY())
				{
					g.drawImage(blue.getBlueP().getImage(), blue.getX()*xPosition, blue.getY()*yPosition, square, square, null);
				}
				if (x == red.getX() && y == red.getY())
				{
					g.drawImage(red.getRedP().getImage(), red.getX()*xPosition, red.getY()*yPosition, square, square, null);
				}
				if (x == trap.getX() && y == trap.getY())
				{
					g.drawImage(trap.getTrap().getImage(), trap.getX()*xPosition, trap.getY()*yPosition, square, square, null);
				}
				if (x == player.getX() && y == player.getY() && player.getAlive())
				{
					g.drawImage(player.getPlayer().getImage(), player.getX()*xPosition, player.getY()*yPosition, square, square, null);
				}
				if (x == monster.getX() && y == monster.getY() && monster.getAlive())
				{
					g.drawImage(monster.getEnemy().getImage(),  monster.getX()*xPosition,  monster.getY()*yPosition,  square,  square,  null);
				}
				if (x == fenemy.getX() && y == fenemy.getY() && fenemy.getAlive())
				{
					g.drawImage(fenemy.getEnemy().getImage(), fenemy.getX()*xPosition, fenemy.getY()*yPosition, square, square, null);
				}
			}
		}
	}
	
	/**
	 * Direction Listener that reacts to up down left right.
	 * 
	 * @author Johnson
	 *
	 */
	private class DirectionListener implements KeyListener
	{
		public void keyPressed(KeyEvent event)
		{
			switch (event.getKeyCode())
			{
				case KeyEvent.VK_UP:
					player.update("UP");
					break;
				case KeyEvent.VK_DOWN:
					player.update("DOWN");
					break;
				case KeyEvent.VK_LEFT:
					player.update("LEFT");
					break;
				case KeyEvent.VK_RIGHT:
					player.update("RIGHT");
					break;
			}
			if (newMap[player.getX()][player.getY()].getCreature() instanceof ExitTile)
			{
				win = true;
			}
			
			if (newMap[player.getX()][player.getY()].getCreature() instanceof Trap)
			{
				System.out.println("You are injured by a trap and lost 20 hp.");
				player.setHealth(20);
			}
			checkWin();
			checkAlive();
			fenemy.EnemyMove(player);
			monster.EnemyMove(player);

			repaint();
		}
		public void keyTyped(KeyEvent event) {}
		public void keyReleased(KeyEvent event) {}
	}
	
	/**
	 * Time listener that moves enemy player every second.
	 * 
	 * @author Johnson
	 *
	 */
	private class MoveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			fenemy.EnemyMove(player);
			monster.EnemyMove(player);
			checkAlive();
			repaint();
		}
	}
}
