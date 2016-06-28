import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * Assignment 8:
 * 
 * Point-and-Click Adventure
 * 
 * @author Johnson
 * 
 * Bonus: Save and Load
 * Bonus: Puzzle (Needs password to end.)
 * Bonus: Clickable Inventory.
 *
 */

public class displayPanel extends JPanel
{
	private Point point;
	private ImageIcon scene1 = createImageIcon("scene1item.png", "Scene One");
	private ImageIcon scene2 = createImageIcon("scene2item.png", "Scene Two");
	private ImageIcon scene3 = createImageIcon("scene3item.png", "Scene Three");
	private ImageIcon actualScene;
	private ImageIcon oneitem = createImageIcon("1item.png", "One item");
	private ImageIcon twoitem = createImageIcon("2item.png", "Two item");
	private ImageIcon threeitem = createImageIcon("3item.png", "Three item");
	private ImageIcon empty = createImageIcon("empty.png", "Null");
	private ImageIcon empty2 = createImageIcon("empty2.png", "Null");
	private ImageIcon victory = createImageIcon("victory.png", "Victory");
	private JLabel itemLabel1, itemLabel2, itemLabel3;
	private JButton button, save, load;
	private boolean itemOne = true, itemTwo = true, itemThree = true, finish = false;
	
	/**
	 * Constructor for Panel.
	 */
	public displayPanel()
	{
		itemLabel1 = new JLabel(empty);
		itemLabel2 = new JLabel(empty);
		itemLabel3 = new JLabel(empty);
		button = new JButton("Click to go back.");
		save = new JButton("Save");
		load = new JButton("Load");
		button.addActionListener(new ButtonListener());
		save.addActionListener(new SaveListener());
		load.addActionListener(new LoadListener());
		add(save);
		add(load);
		add(button);
		add(itemLabel1);
		add(itemLabel2);
		add(itemLabel3);
		addMouseListener(new PanelListener());
		actualScene = scene1;
		setPreferredSize(new Dimension(819, 460));
	}
	/**
	 * Check if item is picked up or not.
	 */
	public void check()
	{
		if (itemOne == false)
		{
			itemLabel1.setIcon(oneitem);
			scene1 = createImageIcon("scene1.png", "Scene One");
		}
		
		if (itemTwo == false)
		{
			itemLabel2.setIcon(twoitem);
			scene2 = createImageIcon("scene2.png", "Scene Two");
		}
		
		if (itemThree == false)
		{
			itemLabel3.setIcon(threeitem);
			scene3 = createImageIcon("scene3.png", "Scene Three");
		}
	}
	
	/**
	 * Paint component
	 */
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		actualScene.paintIcon(this, page, 0, 0);
	}
	
	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path, String description)
	{
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
	/**
	 * Panel Listener that checks where the user click and which scene to switch to.
	 * 
	 * @author Johnson
	 */
	private class PanelListener implements MouseListener
	{
		public void mousePressed(MouseEvent event)
		{
			point = event.getPoint();
			if (((point.x < 183 && point.x > 113) && (point.y < 289 && point.y > 143)) && (actualScene.equals(scene1) && !finish))
			{
				actualScene = scene3;
			}
			
			else if (((point.x < 605 && point.x > 533) && (point.y < 287 && point.y > 145)) && (actualScene.equals(scene1) && !finish))
			{
				actualScene = scene2;
			}
			
			else if (((point.x < 790 && point.x > 700) && (point.y < 356 && point.y > 320)) && (actualScene.equals(scene1) && !finish))
			{
				itemOne = false;
				check();
				actualScene = scene1;
			}
			
			else if (((point.x < 216 && point.x > 164) && (point.y < 264 && point.y > 182)) && (actualScene.equals(scene2) && !finish))
			{
				itemTwo = false;
				check();
				actualScene = scene2;
			}
			
			else if (((point.x < 498 && point.x > 302) && (point.y < 280 && point.y > 130)) && (actualScene.equals(scene3) && !finish))
			{
				itemThree = false;
				check();
				actualScene = scene3;
			}
						
			else if (((point.x < 542 && point.x > 486) && (point.y < 115 && point.y > 26)) && (itemTwo == false) && !finish)
			{
				JOptionPane.showMessageDialog(null, "Password: 110/100");
			}
			
			else if (((point.x < 720 && point.x > 561) && (point.y < 131 && point.y > 16)) && (itemThree == false) && !finish)
			{
				String answer = JOptionPane.showInputDialog("Password: ");
				
				try
				{
				if (answer.equals("110/100"))
				{
					actualScene = victory;
					itemLabel1.setIcon(empty2);
					itemLabel2.setIcon(empty2);
					itemLabel3.setIcon(empty2);
					finish = true;
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Try again.");
				}
				} catch(NullPointerException exception)
				{
					JOptionPane.showMessageDialog(null, "You won't complete if you cancel.");
				}
			}
			
			repaint();
		}
		
		public void mouseClicked(MouseEvent event) {}
		public void mouseReleased(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
	}
	
	/**
	 * Button listener for going back scene.
	 * 
	 * @author Johnson
	 */
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (!finish)
			{
				actualScene = scene1;
				repaint();
			}
		}
	}
	
	/**
	 * Button listener for saving.
	 * 
	 * @author Johnson
	 */
	private class SaveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			File outputFile = new File("Data.txt");
			try
			{
				outputFile.createNewFile();
				
				FileWriter out = new FileWriter(outputFile);
				
				out.write("begin" + "\n");
				if (itemOne == false)
				{
					out.write("1f" + "\n");
				}
				
				if (itemTwo == false)
				{
					out.write("2f" + "\n");
				}
				
				if (itemThree == false)
				{
					out.write("3f" + "\n");
				}
				if (actualScene.equals(scene1))
				{
					out.write("s1" + "\n");
				}
				
				if (actualScene.equals(scene2))
				{
					out.write("s2" + "\n");
				}
				
				if (actualScene.equals(scene3))
				{
					out.write("s3" + "\n");
				}
				
				if (finish)
				{
					out.write("f" + "\n");
				}
				
				out.close();
				
			} catch (IOException exception)
			{exception.printStackTrace();}
			
		}
	}
	
	/**
	 * Button listener for loading.
	 * 
	 * @author Johnson
	 */
	private class LoadListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			File inputFile = new File("Data.txt");
			try
			{
				String s;
				FileReader in = new FileReader(inputFile);
				BufferedReader br = new BufferedReader(in); 
				s = br.readLine();
				while (s != null)
				{
					if (s.equals("1f"))
					{
						itemOne = false;
						check();
					}
					else if (s.equals("2f"))
					{
						itemTwo = false;
						check();
					}
					else if (s.equals("3f"))
					{
						itemThree = false;
						check();
					}
					else if (s.equals("s1"))
					{
						actualScene = scene1;
						check();
					}
					else if (s.equals("s2"))
					{
						actualScene = scene2;
						check();
					}
					else if (s.equals("s3"))
					{
						actualScene = scene3;
						check();
					}
					else if (s.equals("f"))
					{
						actualScene = victory;
						itemLabel1.setIcon(empty2);
						itemLabel2.setIcon(empty2);
						itemLabel3.setIcon(empty2);
						finish = true;						
					}
					check();
					s = br.readLine();
					}
				
				repaint();				
				in.close();
				}
				
		catch (IOException exception)
		{exception.printStackTrace();}
	}
}
}
