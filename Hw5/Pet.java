import javax.swing.*;
import java.util.*;

/**
 * Assignment 5.1
 * 
 * Create a class called Pet, which will represent our pet.
 * 
 * @author Johnson
 *
 */
public class Pet
{
	private int hungerLevel;
	private State currentState;
	private ImageIcon deadIcon;
	private ImageIcon eatingIcon;
	private ImageIcon laughingIcon;
	private ImageIcon normalIcon;
	private ImageIcon sleepingIcon;
	private ImageIcon currentIcon;
	final int FULL = 10;
	
	public enum State
	{
		SLEEPING, EATING, DEAD, LAUGHING, NORMAL
	}
	
	/** 
	 * Constructor for Pet.
	 * Initialize all the icons.
	 * Sets initial Icon to NormalIcon.
	 * Sets initial hungerLevel to FULL.
	 */
	public Pet()
	{
		currentState = State.NORMAL;
		hungerLevel = FULL;
		deadIcon = createImageIcon("dead.png", "dead pet");
		eatingIcon = createImageIcon("eating.png", "eating pet");
		laughingIcon = createImageIcon("laughing.png", "laughing pet");
		normalIcon = createImageIcon("normal.png", "normal pet");
		sleepingIcon = createImageIcon("sleeping.png", "sleeping pet");
		currentIcon = getCurrentIcon();
	}
	
	/**
	 * Getting for currentState
	 * @return currentState
	 */
	public State getState()
	{
		return currentState;
	}
	
	/** 
	 * Getter for hungleLevel
	 * @return hungerLevel
	 */
	
	public int getHunger()
	{
		return hungerLevel;
	}
	
	/** 
	 * Setter for State
	 * @param state
	 */
	public void setState(State state)
	{
		currentState = state;
	}
	
	/**
	 * Setter for hungerLevel
	 * @param hunger
	 */
	public void setHunger(int hunger)
	{
		hungerLevel = hunger;
	}
	
	/** 
	 * Get the ImageIcon that corresponds with the state.
	 * @return the respective icons.
	 */
	public ImageIcon getCurrentIcon()
	{
		if (currentState == State.SLEEPING)
		{
			return sleepingIcon;
		}
		
		else if (currentState == State.EATING)
		{
			return eatingIcon;
		}
		
		else if (currentState == State.DEAD)
		{
			return deadIcon;
		}
		
		else if (currentState == State.LAUGHING)
		{
			return laughingIcon;
		}
		
		else
		{
			return normalIcon;
		}
	}
	
	/** 
	 * Check if pet is dead.
	 * If bird is not dead, set state to LAUGHING and hungerLevel decrease by 1.
	 */
	public void poke()
	{
		checkForStarvation();
		if (currentState != State.DEAD)
		{
			currentState = State.LAUGHING;
			hungerLevel--;
		}
	}
	
	/** 
	 * Feed the pet.
	 * If already EATING, pet is DEAD
	 * If not EATING and not DEAD, set state to EATING and hungerLevel to FULL (10)
	 */
	public void feed()
	{
		if (currentState == State.EATING)
		{
			currentState = State.DEAD;
		}
		
		else if (currentState != State.DEAD)
		{
			currentState = State.EATING;
			hungerLevel = FULL;
		}
	}
	
	/** Set the state to SLEEP if not DEAD */
	public void sleep()
	{
		if (currentState != State.DEAD)
		{
			currentState = State.SLEEPING;
		}
	}
	
	/** 
	 * Ask the pet to sit. If it is dead, do nothing.
	 * If it is not dead, decrease hunger by 1 and set state to NORMAL.
	 */
	public void sit()
	{
		checkForStarvation();
		if (currentState != State.DEAD)
		{
			hungerLevel--;
			currentState = State.NORMAL;
		}
	}
	
	/** Do a random action. */
	public void watch()
	{
		Random gen = new Random();
		int rand = gen.nextInt(3) + 1;
		
		if (rand == 1)
		{
			poke();
		}
		
		else if (rand == 2)
		{
			sleep();
		}
		
		else
		{
			sit();
		}
	}
	
	/** Kill the pet. Set state to DEAD. */
	public void kill()
	{
		currentState = State.DEAD;
	}
	
	/** Checks hunger, if hunger is 0, the pet is dead. */
	public void checkForStarvation()
	{
		if (hungerLevel == 0)
		{
			currentState = State.DEAD;
		}
	}
	
	/** Revives the pet. */
	public void revive()
	{
		if (currentState == State.DEAD)
		{
			currentState = State.NORMAL;
			hungerLevel = FULL;
		}
	}
	
	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path,
	                                           String description) {
	    java.net.URL imgURL = getClass().getResource(path);
	    
	    if (imgURL != null)
	    {
	        return new ImageIcon(imgURL, description);
	    }
	    
	    else
	    {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	}
}
