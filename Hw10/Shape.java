import java.awt.*;

/**
 * Abstract class for Shape
 * 
 * @author Johnson
 *
 */
public abstract class Shape
{
	public Point Point1;
	public Point Point2;

	/**
	 * Super constructor for shape
	 * 
	 * @param points of shape
	 */
	public Shape(Point point)
	{
		Point1 = new Point();
		Point2 = new Point();
		Point1 = point;
	}
	
	/**
	 * Getter for point1
	 * 
	 * @return point1
	 */
	public Point getPoint1()
	{
		return Point1;
	}

	/**
	 * Getter for point2
	 * 
	 * @return point2
	 */
	public Point getPoint2()
	{
		return Point2;
	}

	/**
	 * Setter for point2
	 * 
	 * @param point
	 */
	public void setPoint2(Point point)
	{
		Point2 = point;
	}

	/**
	 * Abstract method for draw
	 * 
	 * @param page
	 */
	public abstract void Draw(Graphics page);
}
