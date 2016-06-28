import java.awt.event.*;
import javax.swing.*;

/**
 * Assignment 5.2
 * 
 * Create a class called PetPanel that extends JPanel. This will display the pet and provide
 * buttons for the user to interact with.
 * 
 * @author Johnson
 *
 */

public class PetPanel extends JPanel
{
	private Pet myPet;
	private JLabel displayHunger, displayPet, petNumLabel;
	private JButton feed, poke, watch, kill, revive, switchPet, addNewPet;
	private Pet[] petList = new Pet[1];
	private int count = 1, petNum = 0;
	
	/**
	 * Constructor for PetPanel.
	 */
	public PetPanel(Pet newPet)
	{
		myPet = new Pet();
		petList[0] = myPet;
		displayPet = new JLabel(myPet.getCurrentIcon(), JLabel.CENTER);
		displayHunger = new JLabel("Hunger: " + Integer.toString(myPet.getHunger()));
		petNumLabel = new JLabel("Pet Number: " + Integer.toString(petNum+1));
		feed = new JButton("Feed");
		poke = new JButton("Poke");
		watch = new JButton("Watch");
		kill = new JButton("Kill");
		revive = new JButton("Revive");
		switchPet = new JButton("Switch");
		addNewPet = new JButton("Add Pet");
		
		feed.addActionListener(new listener());
		poke.addActionListener(new listener());
		watch.addActionListener(new listener());
		kill.addActionListener(new listener());
		revive.addActionListener(new listener());
		switchPet.addActionListener(new listener());
		addNewPet.addActionListener(new listener());
		
		add(displayHunger);
		add(petNumLabel);
		add(displayPet);
		add(feed);
		add(poke);
		add(watch);
		add(kill);
		add(revive);
		add(addNewPet);
		add(switchPet);
	}
	
	/** Add new pet and append to petList */
	private void addPet()
	{
		increaseSize();
		petList[count] = new Pet();
		count++;
	}
	/** Increase size of petList */
	private void increaseSize()
	{
		Pet[] temp = new Pet[count+1];
		
		for (int i = 0; i < count; i++)
		{
			temp[i] = petList[i];
		}
		petList = temp;
		
		
	}
	
	/**
	 * Refresh and update the imageicon and hungerLevel.
	 */
	public void refresh()
	{
		displayPet.setIcon(myPet.getCurrentIcon());
		displayHunger.setText("Hunger: " + Integer.toString(myPet.getHunger()));
		petNumLabel.setText("Pet Number: " + Integer.toString(petNum+1));
	}
	
	/**
	 * ActionListener to get the event of source
	 * 
	 * @author Johnson
	 *
	 */
	private class listener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (event.getSource() == feed)
			{
				myPet.feed();
			}
			
			else if (event.getSource() == poke)
			{
				myPet.poke();
			}
			
			else if (event.getSource() == watch)
			{
				myPet.watch();
			}
			
			else if (event.getSource() == revive)
			{
				myPet.revive();
			}
			
			else if (event.getSource() == kill)
			{
				myPet.kill();
			}
			
			else if (event.getSource() == addNewPet)
			{
				addPet();
			}
			
			else
			{
				myPet = petList[petNum];
				if (petNum < count-1)
				{
					petNum++;
				}
				else
				{
					petNum = 0;
				}
			}
			refresh();
		}
	}
}
