import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * 
 * @author Anam Iqbal
 * @version 1.0
 * @since 5/19/2020
 *
 * 
 * Summary: Write a console program (character based) to do simple
 *        	calculations (addition, subtraction, multiplication and division) of
 *       	two numbers.
 **/

public class Calculator {
	
	/** Adding method getUserChoice and giving return type as integer
	 * 
	 * @param readInput:
	 * 					Scanner passed from main method
	 */
	
	public static char userChoice;
	public static float firstFloat;
	public static float secondFloat;
	
	public static int getUserChoice(Scanner readInput) {

		int inputInt;// declaring integer variable for users input

		do { // Loop until we have correct input
			System.out.print("What would you like to do? ");
			try {
				inputInt = readInput.nextInt();
				// waits for user input
				if (inputInt >= 1 && inputInt <= 5) {
					break; // Got it, done
				} else {
					System.out.println("You have not entered a number between 1 and 5. Try again.");
					// continue looping as it is wrong number
				}
			} catch (final InputMismatchException e) {
				System.out.println("You have entered an invalid choice. Try again.");
				readInput.nextLine(); // discard non-integer input
				// keep looping until you found right one
			}
		} while (true);
		// if you are here you got the correct choice
		return inputInt;
	} // end of getUserChoice
	
	/**Adding method getTwoFloats 
	 * 
	 * @param userChoice:
	 * 					Gets users choice from the menu i.e. 1 to 5
	 * @param myFloats:
	 * 					Assigns two floats from user into the array elements
	 * @param readInput:
	 * 					Scanner passed from main method
	 */	
	public static void getTwoFloats(int userChoice, float[] myFloats, Scanner readInput) {

		do { // Loop until we have correct input
			if (userChoice == 1) {// if user chooses addition
				// prompts user to enter two floats, separated by space
				System.out.printf("\nPlease enter two floats to %s, separated by a space:", "add");
			} else if (userChoice == 2) {// if user chooses subtraction
				// prompts user to enter two floats, separated by space
				System.out.printf("\nPlease enter two floats to %s, separated by a space:", "subtract");
			} else if (userChoice == 3) {// if user chooses multiplication
				// prompts user to enter two floats, separated by space
				System.out.printf("\nPlease enter two floats to %s, separated by a space:", "multiply");
			} else if (userChoice == 4) {// if user chooses division
				// prompts user to enter two floats, separated by space
				System.out.printf("\nPlease enter two floats to %s, separated by a space:", "divide");
			} else if (userChoice == 5) {// if user chooses to exit
				System.out.println("\nThank you for using Anam Iqbal's Handy Calculator");
			}
			try {
				firstFloat = readInput.nextFloat();// waits for user input
				secondFloat = readInput.nextFloat();// waits for user input
				// if you are here, the floats were good, you
				// are done, bread out from loop
				if (secondFloat == 0 && (userChoice == 4)) {// catching the divide by zero issue
					// In the case of a division choice, the second number
					// should not be a zero.
					System.out.printf("You can't divide by zero" + ". Try again.");
			}else
				break;// continue forward if second float is non-zero input for division and continue forward for all other menu choices regardless
			}
				catch (final InputMismatchException e) {
				System.out.printf("You have entered invalid floats." + "Try again. \n");
				readInput.nextLine(); // discard non-float input
				// keep looping until you found right one
			}
		} while (true);
//		 clear the input buffer for next read
		 readInput.nextLine();
	} // end of askTwoValue
				

	/** Adding method getResult and giving return type as integer
	 * 
	 * @param userInput:
	 * 					 Gets users choice from the menu i.e. 1 to 5
	 * @param readInput:
	 * 					 Scanner passed from main method
	 * @param myFloats:
	 * 					 Assigns two floats from user into the array elements
	 */	
	public static int getResult(int userInput, Scanner readInput, float[] myFloats) {

		// performing according to users integer input
		switch (userInput) {//
		case 1: // when user choice is 1
			System.out.printf("Result of adding %5.2f and %5.2f is %5.2f.", myFloats[0], myFloats[1],
					myFloats[0] + myFloats[1]);
			break;
		case 2:// when user choice is 2
			System.out.printf("Result of subtracting %5.2f and %5.2f is %5.2f.", myFloats[0], myFloats[1],
					myFloats[0] - myFloats[1]);
			break;
		case 3:// when user choice is 3
			System.out.printf("Result of multiplying %5.2f and %5.2f is %5.2f.", myFloats[0], myFloats[1],
					myFloats[0] * myFloats[1]);
			break;
		case 4:// when user choice is 4
			System.out.printf("Result of dividing %5.2f and %5.2f is %5.2f.", myFloats[0], myFloats[1],
					myFloats[0] / myFloats[1]);
			break;
		}
		return userInput;
	}// end of getResult
	
	/**
	 * 
	 * @param args:
	 * 				Not used in this program
	 * 
	 * The main method creates the Scanner object, and declares an
	 * integer for choice. Sends the scanner to the getUserChoice.
	 * When the getUserChoice, it is guaranteed that that the choice
	 * is between 1 to 5 which is displayed to the screen.
	 *
	 * The main method creates the Scanner
	 * object, declares an array of two floats, and sends both of
	 * these objects along with user choice to getTwoFloats method. When
	 * the getTwoFloats returns, it is guaranteed that two valid
	 * floats are in the array which is displayed to the screen.
	 * 
	 * The main method creates the Scanner
	 * object, declares an array of two floats, and sends both of
	 * these objects along with user choice are to getResult method. When
	 * the getResult returns, we get the final output result statement of users chosen input.
	 */

	public static void main(String args[]) {

		// Declare Scanner Here and passed where it is needed
		Scanner readInput = new Scanner(System.in); // Creating scanner that will read the user inputs for all methods i.e. getUserChoice, getTwoFloats & getResult
		
		do {// Loop until user decides to exit
			System.out.println("Welcome to Anam Iqbal's Handy Calculator\n");
			System.out.println("\t1. Addition \n\t2. Subtraction\n\t3. Multiplication\n\t4. Division\n\t5. Exit\n");// displaying the menu
																													
			int userChoice;// declaring integer to get users choice of calculation from 1-5
			userChoice = getUserChoice(readInput);// getting user choice by reading input from method getUserChoice

			float[] myFloats = new float[2];//get the valid two floats
			getTwoFloats(userChoice, myFloats, readInput);// calling method to get the two floats user entered

			int inputInt;// getting users input
			inputInt = getResult(userChoice, readInput, myFloats); //calling method getResult
																	//since you are sending the array, you will receive new value in array itself

			System.out.println("\n\nPress enter key to continue... ");// continue as long as user presses enter
		} while (readInput.hasNextLine());// checking if user pressed enter
		  readInput.close(); //you are done with scanner, now you can safely close it.

	} // end of main

} // end of class Calculator
