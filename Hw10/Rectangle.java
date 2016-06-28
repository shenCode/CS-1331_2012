import java.awt.*;

/**
 * Class for Rectangle
 * 
 * @author Johnson
 *
 */
public class Rectangle extends Shape
{
	private boolean filled;
	private Point Point3;
	private Point Point4;
	private Color c;
	
	/**
	 * Constructor for Rectangle
	 * 
	 * @param point
	 * @param Color
	 * @param filled
	 */
	public Rectangle(Point point, Color c, boolean filled)
	{
		super(point);
		this.c = c;
		this.filled = filled;
	}

	/**
	 * Draw the points.
	 */
	public void Draw(Graphics g)
	{
		g.setColor(c);
		Point3=new Point(Point1.x, Point2.y);
		Point4=new Point(Point2.x, Point1.y);
		
		int[] xPoints = {Point1.x,Point3.x,Point2.x,Point4.x};
		int[] yPoints = {Point1.y,Point3.y,Point2.y,Point4.y};
		g.drawPolygon(xPoints, yPoints, 4);
		
		if (filled)
		{
			g.fillPolygon(xPoints, yPoints, 4);
		}
	}

	/**
	 * Getter for color
	 * 
	 * @return color
	 */
	public Color getColor()
	{
		return c;
	}

	
}	
	

