/**
 * Assignment 7
 * In this homework, you'll be wrapping an array in a class called ArrayWrapper. This class will allow us
 * to perform some complex functions on our arrays.
 * 
 * Bonus: void shift(int a)
 * Bonus: void sort() using quicksort
 * 
 * Collaboration: I did this assignment on my own with sorting algorithm from:
 * http://www.vogella.com/articles/JavaAlgorithmsQuicksort/article.html
 * 
 * @author Johnson
 *
 */

public class AWTest {

	public static void main(String[] args)
	{
		ArrayWrapper a = new ArrayWrapper(5,4,3,2,1,0);
		System.out.println("Index of 3: " + a.indexOf(3));
		System.out.println("Length of a: " + a.size());
		a.insert(4, 6);
		ArrayWrapper b = new ArrayWrapper(-1,0,-3,-4);
		a.concatenate(b);
		a.addToEnd(9,8,7,6,5);
		a.removeIndex(4);
		a.removeElement(1);
		b.clear();
		a.get(4);
		System.out.println("Average of a: " + a.mean());
		a.getArray();
		a.shift(-2);
		a.sort();
		System.out.println("a: " + a.toString());
	}

}
