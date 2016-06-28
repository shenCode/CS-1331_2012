import java.util.*;

/**
 * Abstract class for Creatures
 * 
 * @author Johnson
 *
 */

abstract public class Creature extends DungeonElement
{
	protected String name;
	protected int attack;
	protected int health;
	protected boolean alive, moved;
	protected Random rand = new Random();
		
	/**
	 * Constructor
	 * 
	 * @param creatureName
	 * @param damage
	 * @param hp
	 */
	public Creature(String creatureName, int damage, int hp)
	{
		name = creatureName;
		attack = damage;
		health = hp;
		alive = true;
		setLocation();
	}
	
	/**
	 * Returns damage.
	 * 
	 * @return attack
	 */
	public int getAttack()
	{
		return attack;
	}
	
	/**
	 * Returns X position.
	 * 
	 * @return X
	 */
	public int getX()
	{
		return position_X;
	}
	
	/**
	 * Returns Y position
	 * 
	 * @return Y
	 */
	public int getY()
	{
		return position_Y;
	}
	
	/**
	 * Returns name of current creature.
	 * 
	 * @return creature's name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Decreases health by damage.
	 * 
	 * @param damage
	 */
	public void setHealth(int damage)
	{
		health=health-damage;
		if (health <= 0)
		{
			alive = false;
		}
	}
	
	/**
	 * Abstract method for attack.
	 * 
	 * @param c
	 */
	abstract void attack(Creature c);
	
	/**
	 * Return the creature's state.
	 * 
	 * @return alive.
	 */
	public boolean getAlive()
	{
		return alive;
	}
	
	/**
	 * Set the new X position of creature.
	 * 
	 * @param X
	 */
	public void setX(int X)
	{
		position_X+=X;
	}
	
	/**
	 * Set the new Y position of creature.
	 * 
	 * @param Y
	 */
	public void setY(int Y)
	{
		position_Y+=Y;
	}
	
	/**
	 * Returns the health of creature. Check if dead. If dead, alive = false and remove from Tile.
	 * 
	 * @return health.
	 */
	public int getHealth()
	{
		if (health <= 0)
		{
			alive = false;
			Dungeon.getNew()[position_X][position_Y].setCreature(null);
		}
		return health;
	}
	
	/**
	 * Takes in direction and checks for wall and creatures (each type).
	 * This part is not totally working and contains bugs.
	 * React accordingly when any creature is encountered.
	 * 
	 * @param direction
	 */
	public void update(String direction)
	{
		moved = false;
		if (direction.equals("UP"))
		{
			if (!(Dungeon.getNew()[position_X][position_Y-1] instanceof WallTile))
			{
				System.out.println("Pass 1");
				if (Dungeon.getNew()[position_X][position_Y-1].getCreature() instanceof Creature)
				{
					System.out.println("Pass enemy");
					if (Dungeon.getNew()[position_X][position_Y-1].getCreature().getAlive())
					{
						this.attack(Dungeon.getNew()[position_X][position_Y-1].getCreature());
					}
					
					else if (!Dungeon.getNew()[position_X][position_Y-1].getCreature().getAlive())
					{
						System.out.println("Pass alive");
						System.out.println(name + " has died.");
						Dungeon.getNew()[position_X][position_Y-1].removeCreature();
					}
				}
				else if ((Dungeon.getNew()[position_X][position_Y-1].getCreature() instanceof Creature))
				{
					System.out.println("Pass 2");
					health+=100;
					Dungeon.getNew()[position_X][position_Y-1].removeCreature();
					Dungeon.getNew()[position_X][position_Y].removeCreature();
					position_Y-=1;
					Dungeon.getNew()[position_X][position_Y].setCreature(this);
				}
				else if (Dungeon.getNew()[position_X][position_Y-1].getCreature() instanceof Creature)
				{
					System.out.println("Pass 3");
					attack+=20;
					Dungeon.getNew()[position_X][position_Y-1].removeCreature();
					Dungeon.getNew()[position_X][position_Y].removeCreature();
					position_Y-=1;
					Dungeon.getNew()[position_X][position_Y].setCreature(this);
				}
				else if (Dungeon.getNew()[position_X][position_Y-1].getCreature() instanceof Creature)
				{
					System.out.println("Pass 4");
					
					health-=20;
					Dungeon.getNew()[position_X][position_Y].removeCreature();
					position_Y-=1;
					Dungeon.getNew()[position_X][position_Y].setCreature(this);
					
				}
				else
				{
					System.out.println("Pass 5");
					System.out.println((Dungeon.getNew()[position_X][position_Y-1].getCreature() instanceof Creature
							|| (Dungeon.getNew()[position_X][position_Y-1].getCreature() instanceof Creature)));
						System.out.println((Dungeon.getNew()[position_X][position_Y-1].getCreature() instanceof Creature));
						System.out.println((Dungeon.getNew()[position_X][position_Y-1].getCreature() instanceof Creature));
						System.out.println((Dungeon.getNew()[position_X][position_Y-1].getCreature() instanceof Creature));
				Dungeon.getNew()[position_X][position_Y].removeCreature();
				position_Y-=1;
				moved = true;
				Dungeon.getNew()[position_X][position_Y].setCreature(this);
				}
			}
		}
		else if (direction.equals("DOWN"))
		{
			if (!(Dungeon.getNew()[position_X][position_Y+1] instanceof WallTile))
			{
				System.out.println("Pass 1");
				if (Dungeon.getNew()[position_X][position_Y+1].getCreature() instanceof Creature)
				{
					System.out.println("Pass enemy");
					if (Dungeon.getNew()[position_X][position_Y+1].getCreature().getAlive())
					{
						this.attack(Dungeon.getNew()[position_X][position_Y+1].getCreature());
					}
					
					else if (!Dungeon.getNew()[position_X][position_Y+1].getCreature().getAlive())
					{
						System.out.println("Pass alive");
						System.out.println(name + " has died.");
						Dungeon.getNew()[position_X][position_Y+1].removeCreature();
					}
				}
				else if ((Dungeon.getNew()[position_X][position_Y+1].getCreature() instanceof Creature))
				{
					System.out.println("Pass 2");
					health+=100;
					Dungeon.getNew()[position_X][position_Y+1].removeCreature();
					Dungeon.getNew()[position_X][position_Y].removeCreature();
					position_Y+=1;
					Dungeon.getNew()[position_X][position_Y].setCreature(this);
				}
				else if (Dungeon.getNew()[position_X][position_Y+1].getCreature() instanceof Creature)
				{
					System.out.println("Pass 3");
					attack+=20;
					Dungeon.getNew()[position_X][position_Y+1].removeCreature();
					Dungeon.getNew()[position_X][position_Y].removeCreature();
					position_Y+=1;
					Dungeon.getNew()[position_X][position_Y].setCreature(this);
				}
				else if (Dungeon.getNew()[position_X][position_Y+1].getCreature() instanceof Creature)
				{
					System.out.println("Pass 4");
					
					health-=20;
					Dungeon.getNew()[position_X][position_Y].removeCreature();
					position_Y+=1;
					Dungeon.getNew()[position_X][position_Y].setCreature(this);
					
				}
				else
				{
					System.out.println("Pass 5");
					System.out.println((Dungeon.getNew()[position_X][position_Y+1].getCreature() instanceof Creature
							|| (Dungeon.getNew()[position_X][position_Y+1].getCreature() instanceof Creature)));
						System.out.println((Dungeon.getNew()[position_X][position_Y+1].getCreature() instanceof Creature));
						System.out.println((Dungeon.getNew()[position_X][position_Y+1].getCreature() instanceof Creature));
						System.out.println((Dungeon.getNew()[position_X][position_Y+1].getCreature() instanceof Creature));
				Dungeon.getNew()[position_X][position_Y].removeCreature();
				position_Y+=1;
				moved = true;
				Dungeon.getNew()[position_X][position_Y].setCreature(this);
				}
			}
		}
		
		else if (direction.equals("LEFT"))
		{
			if (!(Dungeon.getNew()[position_X-1][position_Y] instanceof WallTile))
			{
				System.out.println("Pass 1");
				if (Dungeon.getNew()[position_X-1][position_Y].getCreature() instanceof Creature)
				{
					System.out.println("Pass enemy");
					if (Dungeon.getNew()[position_X-1][position_Y].getCreature().getAlive())
					{
						this.attack(Dungeon.getNew()[position_X-1][position_Y].getCreature());
					}
					
					else if (!Dungeon.getNew()[position_X-1][position_Y].getCreature().getAlive())
					{
						System.out.println("Pass alive");
						System.out.println(name + " has died.");
						Dungeon.getNew()[position_X-1][position_Y].removeCreature();
					}
				}
				else if ((Dungeon.getNew()[position_X-1][position_Y].getCreature() instanceof Creature))
				{
					System.out.println("Pass 2");
					health+=100;
					Dungeon.getNew()[position_X-1][position_Y].removeCreature();
					Dungeon.getNew()[position_X][position_Y].removeCreature();
					position_X-=1;
					Dungeon.getNew()[position_X][position_Y].setCreature(this);
				}
				else if (Dungeon.getNew()[position_X-1][position_Y].getCreature() instanceof Creature)
				{
					System.out.println("Pass 3");
					attack+=20;
					Dungeon.getNew()[position_X-1][position_Y].removeCreature();
					Dungeon.getNew()[position_X][position_Y].removeCreature();
					position_X-=1;
					Dungeon.getNew()[position_X][position_Y].setCreature(this);
				}
				else if (Dungeon.getNew()[position_X-1][position_Y].getCreature() instanceof Creature)
				{
					System.out.println("Pass 4");
					
					health-=20;
					Dungeon.getNew()[position_X][position_Y].removeCreature();
					position_X-=1;
					Dungeon.getNew()[position_X][position_Y].setCreature(this);
					
				}
				else
				{
					System.out.println("Pass 5");
					System.out.println((Dungeon.getNew()[position_X-1][position_Y].getCreature() instanceof Creature
							|| (Dungeon.getNew()[position_X-1][position_Y].getCreature() instanceof Creature)));
						System.out.println((Dungeon.getNew()[position_X-1][position_Y].getCreature() instanceof Creature));
						System.out.println((Dungeon.getNew()[position_X-1][position_Y].getCreature() instanceof Creature));
						System.out.println((Dungeon.getNew()[position_X-1][position_Y].getCreature() instanceof Creature));
				Dungeon.getNew()[position_X][position_Y].removeCreature();
				position_X-=1;
				moved = true;
				Dungeon.getNew()[position_X][position_Y].setCreature(this);
				}
			}
		}
		
		else if (direction.equals("RIGHT"))
		{
			if (!(Dungeon.getNew()[position_X+1][position_Y] instanceof WallTile))
			{
				System.out.println("Pass 1");
				if (Dungeon.getNew()[position_X+1][position_Y].getCreature() instanceof Creature)
				{
					System.out.println("Pass enemy");
					if (Dungeon.getNew()[position_X+1][position_Y].getCreature().getAlive())
					{
						this.attack(Dungeon.getNew()[position_X+1][position_Y].getCreature());
					}
					
					else if (!Dungeon.getNew()[position_X+1][position_Y].getCreature().getAlive())
					{
						System.out.println("Pass alive");
						System.out.println(name + " has died.");
						Dungeon.getNew()[position_X+1][position_Y].removeCreature();
					}
				}
				else if ((Dungeon.getNew()[position_X+1][position_Y].getCreature() instanceof Creature))
				{
					System.out.println("Pass 2");
					health+=100;
					Dungeon.getNew()[position_X+1][position_Y].removeCreature();
					Dungeon.getNew()[position_X][position_Y].removeCreature();
					position_X+=1;
					Dungeon.getNew()[position_X][position_Y].setCreature(this);
				}
				else if (Dungeon.getNew()[position_X+1][position_Y].getCreature() instanceof Creature)
				{
					System.out.println("Pass 3");
					attack+=20;
					Dungeon.getNew()[position_X+1][position_Y].removeCreature();
					Dungeon.getNew()[position_X][position_Y].removeCreature();
					position_X+=1;
					Dungeon.getNew()[position_X][position_Y].setCreature(this);
				}
				else if (Dungeon.getNew()[position_X+1][position_Y].getCreature() instanceof Creature)
				{
					System.out.println("Pass 4");
					
					health-=20;
					Dungeon.getNew()[position_X][position_Y].removeCreature();
					position_X+=1;
					Dungeon.getNew()[position_X][position_Y].setCreature(this);
					
				}
				else
				{
					System.out.println("Pass 5");
					System.out.println((Dungeon.getNew()[position_X+1][position_Y].getCreature() instanceof Creature
							|| (Dungeon.getNew()[position_X+1][position_Y].getCreature() instanceof Creature)));
						System.out.println((Dungeon.getNew()[position_X+1][position_Y].getCreature() instanceof Creature));
						System.out.println((Dungeon.getNew()[position_X+1][position_Y].getCreature() instanceof Creature));
						System.out.println((Dungeon.getNew()[position_X+1][position_Y].getCreature() instanceof Creature));
				Dungeon.getNew()[position_X][position_Y].removeCreature();
				position_X+=1;
				moved = true;
				Dungeon.getNew()[position_X][position_Y].setCreature(this);
				}
			}
		}
	}
	
	/**
	 * Movement control for enemies, they move towards the player.
	 * 
	 * @param c
	 */
	public void EnemyMove(Creature c)
	{
		int X = position_X - c.getX();
		int Y = position_Y - c.getY();
		if ((X == 0 && Y == 1) || (X == 1 && Y == 0))
		{
			this.attack(c);
		}
		else
		{
			if (X > 0)
			{
				update("LEFT");
				if (!moved)
				{
					if (Y > 0)
					{
						update("UP");
					}
					else
					{
						update("DOWN");
					}
				}
			}
			
			else if (X < 0)
			{
				update("RIGHT");
				if (!moved)
			{
					
					if (Y > 0)
					{
						update("UP");
					}
					else
					{
						update("DOWN");
					}
				}
			}
			
			else if (Y > 0)
			{
				update("UP");
				if (!moved)
				{
					
					if (X > 0)
					{
						update("LEFT");
					}
					else
					{
						update("RIGHT");
					}
				}
			}
			
			else if (Y < 0)
			{
				update("DOWN");
				if (!moved)
				{
					
					if (X > 0)
					{
						update("LEFT");
					}
					else
					{
						update("RIGHT");
					}
				}
			}
		}
	}
}
