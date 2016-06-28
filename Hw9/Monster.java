import javax.swing.*;

/**
 * Monster Object.
 * 
 * @author Johnson
 *
 */
public class Monster extends Creature
{
	private ImageIcon enemy;
	
	/**
	 * Constructor for Monster.
	 * 
	 * @param creatureName
	 * @param damage
	 * @param hp
	 */
	public Monster(String creatureName, int damage, int hp)
	{
		super(creatureName, damage, hp);
		enemy = createImageIcon("monster1.png");
	}
	
	/**
	 * Returns the image of monster.
	 * 
	 * @return monster's image.
	 */
	public ImageIcon getEnemy()
	{
		return enemy;
	}
	
	/**
	 * Attacks the enemy. If alive, deals damage at 20% chance. 
	 */
	public void attack(Creature c)
	{
		if (getAlive())
		{
			if (rand.nextInt(10)+1 <= 2)
			{
				System.out.println(name + " has attacked " + c.getName() + " for " + attack + " damage!");
				System.out.println(c.getName() + " has " + c.getHealth() + " health remaining.");
				c.setHealth(attack);
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
