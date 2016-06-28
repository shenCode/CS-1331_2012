/**
 * A Singly-Linked-List that can hold strings. It implements the StringList interface.
 * Fill in the methods according to the comments.
 * Don't forget to throw the proper exceptions in the methods that specify it.
 * 
 * @author Johnson
 *
 * Collaboration statement: I did this alone.
 */
public class Test
{
	public static void main(String args[])
	{
		StringLinkedList sll = new StringLinkedList();
		sll.add("hello");
		sll.add("world");
		sll.add("fun");
		sll.add(3, "is");
		System.out.println(sll.size());
		System.out.println(sll.get(2));
		System.out.println(sll.indexOf("hello"));
		System.out.println(sll.contains("nothing"));
		System.out.println(sll.remove(2));
		
		sll.clear();
	}
}