import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class inputPanel extends JPanel
{
	private JButton Rectangle;
	private JButton Circle;
	private JButton Line;
	private JButton Color2;
	private JButton Quit;
	private JLabel Color1;
	private JPanel showColor;
	private Color currentColor;
	private boolean state;
	private Checkbox CB;
	private int numShape;

	/**
	 * Constructor for input Panel
	 */
	public inputPanel()
	{
		currentColor = Color.black;
		Rectangle = new JButton("Rectangle");
		Circle = new JButton("Circle");
		Line = new JButton("Line");
		Color2 = new JButton("Color");
		Color1 = new JLabel("Current Color: ");
		showColor = new JPanel();
		CB = new Checkbox("filled");
		Quit = new JButton("Quit");
		
		setLayout(new GridLayout(8,1));
		
		add(Rectangle);
		add(Circle);
		add(Line);
		add(CB);
		add(Color2);
		add(Color1);
		
		showColor.setPreferredSize(new Dimension(40,40));
		showColor.setBackground(currentColor);
		add(showColor);
		add(Quit);
		Quit.addActionListener(new buttonListener());
		CB.addItemListener(new ItListener());
		Rectangle.addActionListener(new buttonListener());
		Circle.addActionListener(new buttonListener());
		Line.addActionListener(new buttonListener());
		Color2.addActionListener(new colorListener());
		Quit.addActionListener(new buttonListener());
	}

	/**
	 * Getter for current color
	 * 
	 * @return current color
	 */
	public Color getCurrentColor()
	{
		return currentColor;
	}

	/**
	 * Getter for numShape
	 * 
	 * @return numShape
	 */
	public int getnumShape()
	{
		return numShape;
	}

	/**
	 * Getter for CB
	 * 
	 * @return CB
	 */
	public boolean getCB()
	{
		return state;
	}

	/**
	 * Listener for Item
	 * 
	 * @author Johnson
	 *
	 */
	private class ItListener implements ItemListener
	{
		public void itemStateChanged(ItemEvent e)
		{
			state=CB.getState();
		}
	}

	/**
	 * Listener for button
	 * 
	 * @author Johnson
	 *
	 */
	private class buttonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource().equals(Quit))
			{
				System.exit(0);
			}
			if (e.getSource().equals(Rectangle))
			{
				numShape = 0;
			}
			if (e.getSource().equals(Circle))
			{
				numShape = 1;
			}
			if (e.getSource().equals(Line))
			{
				numShape = 2;
			}
		}
	}

	/**
	 * Listener for color
	 * 
	 * @author Johnson
	 *
	 */
	private class colorListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			currentColor=JColorChooser.showDialog(new JColorChooser(),"Pick a color",Color.BLACK);
			showColor.setBackground(currentColor);
		}
	}
}
