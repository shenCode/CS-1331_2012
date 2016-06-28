import javax.swing.*;

/**
 * Player Object.
 * 
 * @author Johnson
 *
 */

public class Player extends Creature
{
	private ImageIcon player;
	
	/**
	 * Constructor for player.
	 * 
	 * @param creatureName
	 * @param damage
	 * @param hp
	 */
	public Player(String creatureName, int damage, int hp)
	{
		super(creatureName, damage, hp);
		player = createImageIcon("player.png");
	}
	
	/**
	 * Returns image of player.
	 * 
	 * @return player's image.
	 */
	public ImageIcon getPlayer()
	{
		return player;
	}
	
	/**
	 * Increase the player's health.
	 * 
	 * @param x
	 */
	public void increaseHealth(int x)
	{
		health+=x;
	}
	
	/**
	 * Checks if player is alive. If alive, then attacks the enemy with 50% success rate.
	 */
	public void attack(Creature c)
	{
		if (getAlive())
		{
			if (rand.nextInt(10) <= 5)
			{
				c.setHealth(attack);
				System.out.println(name + " has attacked " + c.getName() + " for " + attack + " damage!");
				System.out.println(c.getName() + " has " + c.getHealth() + " health remaining.");
			}
			else
			{
				System.out.println(name + " has attacked " + c.getName() + " and missed!");
			}
		}
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
