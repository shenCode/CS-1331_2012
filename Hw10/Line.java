import java.awt.*;

public class Line extends Shape
{
	public Color c;

	/**
	 * Constructor for line
	 * 
	 * @param point
	 * @param c
	 */
	public Line(Point point,Color c)
	{
		super(point);
		this.c = c;
	}

	/**
	 * Getter for color
	 * 
	 * @return
	 */
	public Color getColor()
	{
		return c;
	}

	/**
	 * Draw method
	 */
	public void Draw(Graphics page) 
	{
		page.setColor(c);
		page.drawLine(Point1.x, Point1.y, Point2.x, Point2.y);
	}

}
