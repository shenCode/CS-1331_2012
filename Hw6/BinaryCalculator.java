import javax.swing.JOptionPane;

/**
 * Assignment 6
 * 
 * This class represents a binary calculator (the brains of your calculator application).
 * 
 * Bonus: Added tabs to display decimal Results and hex Results.
 * Bonus: Pop dialog if division by 0.
 * 
 * Collaboration statement: I worked on this assignment alone.
 * 
 * @author Johnson
 *
 */
public class BinaryCalculator
{
	private static String binaryResult;
	private static String hexResult;
	private static String decimalResult;
	
	/**
	 * Getter for binaryResult
	 * 
	 * @return binaryResult
	 */
	public static String getBinaryResult()
	{
		return binaryResult;
	}
	
	/**
	 * Getter for hexResult
	 * 
	 * @return hexResult
	 */
	public static String getHexResult()
	{
		return hexResult;
	}
	
	/**
	 * Getter for decimalResult;
	 * 
	 * @return decimalResult
	 */
	public static String getDecimalResult()
	{
		return decimalResult;
	}
	
	/**
	 * Addition (add the next input to the current)
	 * 
	 * @param firstInput
	 * @param secondInput
	 */
	public static void addition(String firstInput, String secondInput)
	{
		int firstInt = convertToInt(firstInput);
		int secondInt = convertToInt(secondInput);
		int result = firstInt + secondInt;
		binaryResult = Integer.toBinaryString(result);
		hexResult = Integer.toHexString(result);
		decimalResult = Integer.toString(result);
	}
	
	/**
	 * Subtraction (subtract the next input from the current)
	 * 
	 * @param firstInput
	 * @param secondInput
	 */
	public static void subtraction(String firstInput, String secondInput)
	{
		int firstInt = convertToInt(firstInput);
		int secondInt = convertToInt(secondInput);
		int result = firstInt - secondInt;
		binaryResult = Integer.toBinaryString(result);
		hexResult = Integer.toHexString(result);
		decimalResult = Integer.toString(result);
	}
	
	/**
	 * Multiplication (multiply the current input by the next input)
	 * 
	 * @param firstInput
	 * @param secondInput
	 */
	public static void multiplication(String firstInput, String secondInput)
	{
		int firstInt = convertToInt(firstInput);
		int secondInt = convertToInt(secondInput);
		int result = firstInt * secondInt;
		binaryResult = Integer.toBinaryString(result);
		hexResult = Integer.toHexString(result);
		decimalResult = Integer.toString(result);
	}
	
	/**
	 * Division (divide the current input by the next input)
	 * 
	 * @param firstInput
	 * @param secondInput
	 */
	public static void division(String firstInput, String secondInput)
	{
		int firstInt = convertToInt(firstInput);
		int secondInt = convertToInt(secondInput);
		if (secondInt == 0)
		{
			JOptionPane.showMessageDialog(null,
				    "One does not simply divide by 0.",
				    "An error has occured.",
				    JOptionPane.ERROR_MESSAGE);
			binaryResult="";
			hexResult="";
			decimalResult="";
		}
		
		else
		{
			int result = firstInt / secondInt;
			binaryResult = Integer.toBinaryString(result);
			hexResult = Integer.toHexString(result);
			decimalResult = Integer.toString(result);
		}
	}
	
	/**
	 * Reset the values of results.
	 */
	public static void reset()
	{
		binaryResult="";
		hexResult="";
		decimalResult="";
	}
	
	/**
	 * Convert binary input into integer for calculation purposes
	 * 
	 * @param binaryInput
	 * @return total
	 */
	public static int convertToInt(String binaryInput)
	{
		int total = 0;
		int i = binaryInput.length();
		int count = 0;
		while (i > 0)
		{
			if (binaryInput.charAt(i-1) == '1')
			{
				total = total + (int)Math.pow(2,count);
			}
			i--;
			count++;
		}
		return total;
	}
}
