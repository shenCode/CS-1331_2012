import java.awt.*;

public class Oval extends Shape
{
	private boolean filled;
	private int width;
	private int height;
	private Color c;

	/**
	 * Constructor for Oval
	 * 
	 * @param point
	 * @param c
	 * @param filled
	 */
	public Oval(Point point,Color c,boolean filled)
	{
		super(point);
		this.filled=filled;
		this.c=c;
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
	 * Reverse the oval so the points can go negative
	 */
	public void reverse()
	{
		if (Point1.x > Point2.x || Point2.y < Point1.y)
		{
			Point temp = null;
			temp = Point1;
			Point1 = Point2;
			Point2 = temp;
		}
	}
	
	/**
	 * Draw method
	 */
	public void Draw(Graphics page)
	{
		page.setColor(c);
		reverse();
		width = Math.abs(Point1.x  - Point2.x);
		height = Math.abs(Point1.y - Point2.y);
		
		page.drawOval(Point1.x, Point1.y, width, height);
		if (filled)
		{
			page.fillOval(Point1.x, Point1.y, width, height);
		}
	}
}
