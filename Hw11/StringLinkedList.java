/**
 * A Singly-Linked-List that can hold strings. It implements the StringList interface.
 * Fill in the methods according to the comments.
 * Don't forget to throw the proper exceptions in the methods that specify it.
 * 
 * @author Johnson
 *
 * Collaboration statement: I did this alone.
 */
public class StringLinkedList
{
	private StringNode head;
	private int size;
	private IndexOutOfBoundsException e = new IndexOutOfBoundsException("Warning: Index out of Bounds.");
	
	/**
	 * Constructor for StringLinkedList
	 */
	public StringLinkedList()
	{
		head = null;
		size = 0;
	}

	/**
	 * Add String, size increase by 1.
	 * 
	 * @param string
	 */
	public void add(String string)
	{
		StringNode temp = new StringNode(string);
		StringNode current = head;
		
		if (head == null)
		{
			head = temp;
		}
		
		else
		{
			while (current.next != null)
			{
				current = current.next;
			}
			
			current.next = temp;
		}
		size++;
	}

	/**
	 * Add string at index
	 * 
	 * @param index
	 * @param string
	 * @throws IndexOutOfBoundsException
	 */
	public void add(int index, String string) throws IndexOutOfBoundsException
	{
		StringNode temp = new StringNode(string);
		StringNode current = head;
			
		if (index > size || index < 0)
		{
			throw e;
		}
		
		else
		{
			if (head == null)
			{
				head = temp;
			}
		
			else
			{
				for (int i = 0; i < index-1; i++)
				{
					current = current.next;
				}
				
			current.next = temp;
			}
			size++;
		}
	}
	
	/**
	 * Get the string at index
	 * 
	 * @param index
	 * @return data of index
	 * @throws IndexOutOfBoundsException
	 */
	public String get(int index) throws IndexOutOfBoundsException
	{
		if (index > size || index < 0)
		{
			throw e;
		}
		
		else
		{
			StringNode current = head;
	
			if (current == null || index <= 0)
			{
				return null;
			}
			else
			{
				for (int i = 0; i < index; i++)
				{
					current = current.next;
				}
				return current.data;
			}
		}
	}
	
	/**
	 * Getter for size
	 * 
	 * @return size
	 */
	public int size()
	{
		return size;
	}
	
	/**
	 * Get index of string
	 * @param e
	 * @return index, -1 if out of bounds
	 */
	public int indexOf(String e)
	{
		StringNode current = head;
			
		for (int i = 0; i < size; i++)
		{
			if (current.data.equals(e))
		{
				return i;
			}
			else
			{
				current = current.next;
			}
		}
		return -1;
	}
	
	/**
	 * Returns true if list contains string
	 * 
	 * @param e
	 * @return true or false
	 */
	public boolean contains(String e)
	{
		StringNode current = head;
		
		for (int i = 0; i < size; i++)
		{
			if (current.data.equals(e))
			{
				return true;
			}
			else
			{
				current = current.next;
			}
		}
		return false;
	}

	/**
	 * Remove the string, size minus 1
	 * 
	 * @param index
	 * @return string that was removed
	 * @throws IndexOutOfBoundsException
	 */
	public String remove(int index) throws IndexOutOfBoundsException
	{
		if (index > size || index < 0)
		{
			throw e;
		}
		
		else
		{
			StringNode current = head;

			for (int i = 0; i < index-1; i++)
			{
				current = current.next;
			}
			StringNode temp = current.next;
			current.next = current.next.next;
			
			size--;
			return temp.data;
			
		}
	}
	
	/**
	 * Clear the list
	 */
	public void clear()
	{
		head = null;
		size = 0;
	}
	
	/**
	 * A StringLinkedList Node for you to fill in.
	 * 
	 * @author Johnson
	 * 
	 */
	public class StringNode
	{
		private String data;
		private StringNode next;
		
		/**
		 * Constructor for string node.
		 * @param e
		 */
		public StringNode(String e)
		{
			data = e;
			next = null;
		}
	}
}
