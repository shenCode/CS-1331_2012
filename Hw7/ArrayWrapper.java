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

public class ArrayWrapper
{
	private int[] myArray;
	private int length;
	
	/**
	 * A constructor that takes in a variable number of integers, as shown above.
	 * 
	 * @param list
	 */
	public ArrayWrapper(int ... list)
	{
		myArray = list;
		length = list.length;
	}
	
	/**
	 * A toString() method that takes in no parameters and returns a string of the array.
	 */
	public String toString()
	{
		String result = "[";
		for (int i = 0; i <= myArray.length - 1; i++)
		{
			result = result + myArray[i];
			if (i != myArray.length - 1)
			{
				result = result + ", ";
			}
		}
		
		result = result + "]";
		return result;
	}
	
	/**
	 * Return the index of the first occurrence of i in the array. If there is no occurrence, return -1.
	 * @param i
	 * @return j or -1;
	 */
	public int indexOf(int i)
	{
		for (int j : myArray)
		{
			if (i == j)
			{
				return j;
			}
		}
		return -1;
	}
	
	/**
	 * Return the number of elements in the array.
	 * @return myArray.length;
	 */
	public int size()
	{
		return myArray.length;
	}
	
	/**
	 * Insert element at the given index.
	 * 
	 * @param index
	 * @param element
	 */
	public void insert(int index, int element)
	{
		int[] temp = myArray;
		myArray = new int[temp.length + 1];
		
		if (index >= temp.length)
		{
			index = temp.length;
		}
		
		else if (index < 0)
		{
			index = 0;
		}
		for (int i = 0; i < index; i++)
		{
			myArray[i] = temp[i];
		}
		
		myArray[index] = element;
		
		for (int j = index; j <= temp.length - 1; j++)
		{
			myArray[j+1] = temp[j];
		}
	}
	
	/**
	 * This method takes as a parameter another ArrayWrapper, and adds every element in that
	 * ArrayWrapper to the end of the backing array.
	 * 
	 * @param newArrayWrapper
	 */
	public void concatenate(ArrayWrapper newArrayWrapper)
	{
		int[] temp = myArray;
		myArray = new int[temp.length + newArrayWrapper.length];
		for (int i = 0; i <= temp.length - 1; i++)
		{
			myArray[i] = temp[i];
		}
		
		for (int j = 0; j < newArrayWrapper.length; j++) 
		{
			myArray[temp.length+j] = newArrayWrapper.get(j);
		}
	}
	
	/**
	 * This method will add some number of integers to the back of the array.
	 * 
	 * @param n
	 */
	public void addToEnd(int ... n)
	{
		int[] temp = myArray;
		myArray = new int[temp.length + n.length];
		
		for (int i = 0; i <= temp.length-1; i++)
		{
			myArray[i] = temp[i];
		}
		
		for (int j = 0; j <= n.length-1; j++)
		{
			myArray[j+temp.length] = n[j];
		}
	}
	
	/**
	 * Remove the element at the given index, and return it.
	 * 
	 * @param index
	 * @return temp[index]
	 */
	public int removeIndex(int index)
	{
		int[] temp = myArray;
		myArray = new int[temp.length - 1];
		
		if (index >= temp.length)
		{
			index = temp.length-1;
		}
		
		else if (index < 0)
		{
			index = 0;
		}
		
		for (int i = 0; i <= index-1; i++)
		{
			myArray[i] = temp[i];
		}
		
		for (int j = index; j <= temp.length-2; j++)
		{
			myArray[j] = temp[j+1]; 
		}
		
		return temp[index];
	}
	
	/**
	 * Remove the first occurence of the element from the array and return it.
	 * 
	 * @param element
	 * @return element
	 */
	public int removeElement(int element)
	{
		int[] temp = myArray;
		myArray = new int[temp.length-1];
		
		for (int i = 0; i <= temp.length - 1; i++)
		{
			if (element == temp[i])
			{
				for (int k = 0; k <= i-1; k++)
				{
					myArray[k] = temp[k];
				}
				
				for (int j = i; j <= temp.length - 2; j++)
				{
					myArray[j] = temp[j+1];
				}
								
				break;
			}
		}
		return element;
	}
	
	/**
	 * Removes all the elements in the array.
	 */
	public void clear()
	{
		myArray = new int[0];
	}
	
	/**
	 * Get the element at the given index. You don't have to worry about instances where the index
	 * is out-of-bounds.
	 * 
	 * @param index
	 * @return myArray[index]
	 */
	public int get(int index)
	{
		return myArray[index];
	}
	
   /**
	* Calculate and return the average of all the elements. You don't need to worry about the case
	* where the array is empty.
	* 
 	* @return mean
 	*/
	public double mean()
	{
		double total = 0;
		for (int i = 0; i <= myArray.length - 1; i++)
		{
			total += myArray[i];
		}
		double mean = total/ (myArray.length-1);
		return mean;
	}
	
	/**
	 * Getter for myArray.
	 * 
	 * @return myArray
	 */
	public int[] getArray()
	{
		return myArray;
	}
	
	public void shift(int a)
	{
		int[] temp = myArray;
		myArray = new int[temp.length];
		
		for (int i = 0; i <= myArray.length - 1; i++)
		{
			if (a >= 0)
			{
				if (i + a < myArray.length)
				{
					myArray[i+a] = temp[i];
				}
				
				else
				{
					myArray[i-a] = temp[i];
				}
			}
			else
			{
				if (-a > i)
				{
					myArray[temp.length+a+i] = temp[i];
				}
				
				else
				{
					myArray[i+a] = temp[i];
				}
			}
		}
	}
	
	/**
	 * Sort the array using quicksort.
	 */
	public void sort()
	{
		if (myArray.length == 0)
		{
			return;
		}
		quicksort(0, myArray.length-1);
	}
	
	/**
	 * Quicksort recursion.
	 * 
	 * @param low
	 * @param high
	 */
	private void quicksort(int low, int high)
	{
		int i = low, j = high;
		int pivot = myArray[low + (high-low)/2];
		
		while (i <= j)
		{
			while (myArray[i] < pivot)
			{
				i++;
			}
			
			while (myArray[j] > pivot)
			{
				j--;
			}
			
			if (i <= j)
			{
				int temp = myArray[i];
				myArray[i] = myArray[j];
				myArray[j] = temp;
				i++;
				j--;
			}
		}
		if (low < j)
		{
			quicksort(low, j);
		}
		
		if (i < high)
		{
			quicksort(i, high);
		}
	}
}
