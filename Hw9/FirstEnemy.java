import javax.swing.*;

/**
 * FirstEnemy object.
 * 
 * @author Johnson
 *
 */

public class FirstEnemy extends Creature
{
	private ImageIcon enemy;
	
	/**
	 * Constructor that takes in enemy's image.
	 * 	
	 * @param creatureName
	 * @param damage
	 * @param hp
	 */
	public FirstEnemy(String creatureName, int damage, int hp)
	{
		super(creatureName, damage, hp);
		enemy = createImageIcon("enemy.png");
	}
	
	/**
	 * Returns enemy's image.
	 * 
	 * @return enemy's image.
	 */
	public ImageIcon getEnemy()
	{
		return enemy;
	}
	
	/**
	 * Checks if alive. If alive, deals damage at 70% success rate.
	 */
	public void attack(Creature c)
	{
		if (getAlive())
		{
			if (rand.nextInt(10)+1 <= 7)
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
