/**
 * A Singly-Linked-List that can hold strings. It implements the StringList interface.
 * Fill in the methods according to the comments.
 * Don't forget to throw the proper exceptions in the methods that specify it.
 * 
 * @author
 * @version
 */
public class StringLinkedList implements StringList {
	
	/**
	 * The head node of the linked list.
	 */
	private StringNode head;
	
	/**
	 * # of elements in list.
	 */
	private int size;
	
	public StringLinkedList() {
		
		//empty list.
		head = null;
		size = 0;
	}
	
	@Override
	public void add(String string) {
		
	}
	
	@Override
	public void add(int index, String string) throws IndexOutOfBoundsException {
		
	}
	
	@Override
	public String get(int index) {
		return null;
	}
	
	@Override
	public int size() {
		return -1;
	}
	
	@Override
	public int indexOf(String e) {
		return -1;
	}
	
	@Override
	public boolean contains(String e) {
		return false;
	}
	
	@Override
	public String remove(int index) throws IndexOutOfBoundsException {
		return null;
	}
	
	@Override
	public void clear() {
		
	}
	
	/**
	 * A StringLinkedList Node for you to fill in.
	 * 
	 * @author
	 * @version
	 * 
	 */
	private class StringNode {
		private String data;
		private StringNode next;
		
		// Change this class any way you like
		
	}
}
