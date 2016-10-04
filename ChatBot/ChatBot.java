/**
*	This is a chat bot that interacts with the user. By asking question
*	and using the scanner object, the program is able to get user input
*	and do other actions based on the input.
*
*	@author  Collin Wen
*	@version 1.0
*/
import java.util.Scanner;

public class ChatBot {
	/*
	This is the main method that the java interpreter calls 
	@param args This is a command line argument
	*/
	public static void main(String[] args) {
		//construct/create a new Scanner object
		Scanner kb = new Scanner(System.in);
		
		//find name
		System.out.println("enter name");
		String input = kb.nextLine();
		checkBye(input);
		String name = input;
		
		//how are you doing today?
		System.out.println("hi " + name + "! How are you doing today?");
		input = kb.nextLine();
		checkBye(input);
		
		//how old are you?
		System.out.println("Your answer is " + input);
		System.out.println("How old are you?");
		input = kb.nextLine();
		checkBye(input);
		int age = Integer.parseInt(input);
		if(age > 30) {
			System.out.println(name + ", you are old!");
		} else {
			System.out.println("nice!");
		}
		
		//how tall are you
		System.out.println("How tall are you? ");
		input = kb.nextLine();
		double height = Double.parseDouble(input);
		if(height > 6.0) {
			System.out.println(name + ", you are tall!");
		} else if(height > 5.0) {
			System.out.println("not bad, " + name);
		} else {
			System.out.println(name + ", you're short");
		}
		
		//favorite color
		System.out.print("What is your fav color?");
		String color = kb.nextLine();
		checkBye(color);
		System.out.println(color + " is your fave!");
		
		//story
		System.out.println("Tell me what you did today! Type 'done' when your finished.");
		while(true) {
			input = kb.nextLine();
			checkBye(input);
			if(input.equals("done")) {
				System.out.println("Interesting! Thanks for sharing!");
				break;
			}
			System.out.println("Really! Tell me more!");
		}
		
		
	}
	/**
	*	This method checks if a string equals "bye" or "Bye" and then
	*	quits the program if true.
	*
	*	@param input The string that you want to check
	*	@return nothing
	*/
	
	public static void checkBye(String input) {
		if(input.equals("bye") || input.equals("Bye")) {
			System.exit(0);
		}
	}
}