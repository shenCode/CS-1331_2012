/**
 * 
 * Assignment 4.1
 * 
 * City instance, State instance
 * Constructor
 * 2 Getters
 * normalize() Change any string to firstChar = toUpperCase, the rest = toLowerCase
 * toString() City, State
 * isSameState() Compare and check if same
 * 
 * @author Johnson
 *
 */

public class Location
{
	// 2 String instance variables
	private String city, state;
	
	/**
	 * Location Constructor
	 * @param city
	 * @param state
	 */
	public Location(String city, String state)
	{
		this.city = city;
		this.state = state;
	}
	
	/**
	 * Getter for City
	 * @return city
	 */
	public String getCity()
	{
		return city;
	}
	
	/**
	 * Getter for State
	 * @return state
	 */
	public String getState()
	{
		return state;
	}
	
	/**
	 * Setter for City
	 * @param city
	 */
	public void setCity(String city)
	{
		this.city = city;
	}
	
	/**
	 * Setter for State
	 * @param state
	 */
	public void setState(String state)
	{
		this.state = state;
	}
	
	/**
	 * Normalize City and State
	 * Uppercase first letter of City and lowercase the rest
	 * Uppercase first and last letter of State
	 */
	public void normalize()
	{
		// Uppercase the first letter and lowercase the rest
		String cityFirstLetter = city.substring(0,1);
		String cityRest = city.substring(1, city.length());
		cityFirstLetter = cityFirstLetter.toUpperCase();
		cityRest = cityRest.toLowerCase();
		
		// Take the first and last letter and uppercase them
		String stateFirstLetter = state.substring(0,1);
		String stateLastLetter = state.substring(state.length()-1, state.length());
		state = stateFirstLetter + stateLastLetter;
		
		// City = First letter(upper) + Rest of letters(lower)
		city = cityFirstLetter + cityRest;
		
		// State = First and last letter(upper)
		state = state.toUpperCase();
	}
	
	/**
	 * Combine City and State
	 * @return abbrev
	 */
	public String toString()
	{
		String abbrev = city + ", " + state;
		return abbrev;
	}
	
	/**
	 * Compare the state of previous location and this location
	 * Return true if same, false if not smae
	 * @param location
	 * @return true or false
	 */
	public boolean isSameState(Location location)
	{
		// Change both location1.state and location2.state to lowecase, then compare them.
		String state1 = location.state;
		state1 = state1.toLowerCase();
		String state2 = state;
		state2 = state2.toLowerCase();
		if (state1.equals(state2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
}
