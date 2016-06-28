/**
 * Homework 2, Problem 1.
 * Task: Write an application that prompts for and reads a double value representing a monetary amount.
 * Then determine the fewest number of each bill and coin needed to represent that amount,
 * starting with the highest.
 * Assume that a twenty dollar bill is the maximum size needed.
 */

// Import Scanner
import java.util.Scanner;

public class ChangeCalculator {

	public static void main(String[] args) {
		
		// Construct scan
		Scanner scan = new Scanner(System.in);
		
		// Asks for input
		System.out.print("Amount: $");
		double totalMoney = scan.nextDouble();
		
		// Get rid of the 2 decimal places
		totalMoney = totalMoney * 100;
		
		// Algorithm
		int twentyDollars = (int)(totalMoney / 2000);
		int tenDollars = (int)(totalMoney % 2000 / 1000);
		int fiveDollars = (int)(totalMoney % 1000 / 500);
		int oneDollars = (int)(totalMoney % 500 / 100);
		int quarters = (int)(totalMoney % 100 / 25);
		int dimes = (int)(totalMoney % 25 / 10);
		int nickels = (int)(totalMoney % 25 % 10 / 5);
		int pennies = (int)(totalMoney % 5);
		
		// Output
		System.out.println(twentyDollars + " twenty dollar bills");
		System.out.println(tenDollars + " ten dollar bills");
		System.out.println(fiveDollars + " five dollar bills");
		System.out.println(oneDollars + " one Dollars bills");
		System.out.println(quarters + " quarters");
		System.out.println(dimes + " dimes");
		System.out.println(nickels + " nickels");
		System.out.println(pennies + " pennies");
		
	} // end main

} // end class ChangeCalculator
