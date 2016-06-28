import java.util.Scanner;

/**
 * Assignment 3.1: Leetspeaker Translator
 * "@" = "a"
 * "3" = "e"
 * "1" = "i"
 * "$" = "s"
 * "0" = "o"
 *
 * Enter "1" to convert from Normal to Leet
 * Enter "2" to convert from Leet to Normal 
 *
 * @author Shen Yang
 *
 */

public class LeetTranslator {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
	
		// Acquire input
		System.out.print("Enter string to translate: ");
		String toTranslate = scan.nextLine();
		
		System.out.println("Which type of conversion would you like to do?");
		System.out.print("Type 1 for convert to Leet, 2 for normal: ");
		int choice = scan.nextInt();
		
		// If chose convert to Leet
		
		if (choice == 1) {
		
		// Translate to Leet
		toTranslate = toTranslate.replace("a", "@");
		toTranslate = toTranslate.replace("e", "3");
		toTranslate = toTranslate.replace("i", "1");
		toTranslate = toTranslate.replace("s", "$");
		toTranslate = toTranslate.replace("o", "0");
		
		// Print output
		System.out.println(toTranslate);
		
		} // end if
		
		// If chose convert to normal
		
		else if (choice == 2) {
			
		// Translate to Normal
		toTranslate = toTranslate.replace("@", "a");
		toTranslate = toTranslate.replace("3", "e");
		toTranslate = toTranslate.replace("1", "i");
		toTranslate = toTranslate.replace("$", "s");
		toTranslate = toTranslate.replace("0", "o");
		
		// Print output
		System.out.println(toTranslate);
		
		} // end else if
		
		// Invalid Option
		
		else {
			
		System.out.println("Invalid choice, I'm just gonna ignore you.");
		
		} // end else
	
	} // end main()

} // end class
