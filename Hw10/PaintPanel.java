import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Paint panel for drawing
 * 
 * @author Johnson
 *
 */
public class PaintPanel extends JPanel
{
	private Rectangle rec;
	private Oval cir;
	private Line line;
	private int numShape;
	private ArrayList<Shape> Shapes;
	private inputPanel input;
	private Point pointClicked;
	private Point pointDragged;
	
	/**
	 * Constructor for paint panel
	 * 
	 * @param input
	 */
	public PaintPanel(inputPanel input)
	{
		Shapes = new ArrayList<Shape>();
		this.input = input;
		
		setPreferredSize(new Dimension(600,600));
		setBackground(Color.WHITE);
		
		addMouseMotionListener(new ShapeListener());
		addMouseListener(new ShapeListener());
	}

	/**
	 * Paint component	 * 
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent (g);
		
		if (Shapes.size() > 0)
		{
			for(int i = 0; i < Shapes.size(); i++)
			{
				Shapes.get(i).Draw(g);
			}
		}
		
		switch (numShape)
		{
			case 0:
				if (rec != null)
				{
					rec.Draw(g);
				}
				break;
				
			case 1:
				if (cir != null)
				{
					cir.Draw(g);
				}
				break;
				
			case 2:				
				if(line != null)
				{
					line.Draw(g);
				}
				break;
		}
	}

	/**
	 * Listener for mouse movements
	 * 
	 * @author Johnson
	 *
	 */
	private class ShapeListener implements MouseListener, MouseMotionListener
	{

		public void mousePressed(MouseEvent e)
		{	
			pointClicked = e.getPoint();
		}

		public void mouseDragged(MouseEvent e)
		{
		
			numShape = input.getnumShape();
			
			switch(numShape)
			{
				case 0:
					pointDragged = e.getPoint();
					rec = new Rectangle(pointClicked, input.getCurrentColor(), input.getCB());
					rec.setPoint2(pointDragged);
				case 1:
					pointDragged=e.getPoint();
					cir=new Oval(pointClicked,input.getCurrentColor(),input.getCB());
					cir.setPoint2(pointDragged);
				case 2:
					pointDragged=e.getPoint();
					line=new Line(pointClicked,input.getCurrentColor());
					line.setPoint2(pointDragged);
				default:
					repaint();
			}
		}

		public void mouseReleased(MouseEvent e)
		{
			if (numShape == 0)
			{
				Shapes.add(rec);
			}
			
			else if (numShape == 1)
			{
				Shapes.add(cir);
			}
			
			else if (numShape == 2)
			{
				Shapes.add(line);
			}
		}

		public void mouseMoved(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
}
