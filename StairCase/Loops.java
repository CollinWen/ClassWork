/**
*	This program has methods that will print a staircase going up and down.
*	These two methods are to show how to use nested loops in a method. 
*
*	@author  Collin Wen
*	@version 1.0
*/
import java.util.Scanner;

public class Loops {
	int counter = 0;
	public static void main(String[] args) {
		System.out.println("Please enter the amount of steps in your staircase.");
		Scanner user_input = new Scanner(System.in);
		int num = user_input.nextInt();
		Upstaircase(num);
		System.out.println("-------------------");
		Downstaircase(num);
	} 
	/**
	*	This method prints a "staircase" where the first row will 
	*	have 1 star and then increase by one. The first for loop will 
	*	establish the number of stars in a specific row, then the second
	*	one will print that amount of stars.
	*	
	*	@param num The amount of levels in the staircase
	*	@return Nothing.
	*/
	public static void Upstaircase(int num) {
		for(int i = 1; i <= num; i++) {
			for(int a = 0; a < i; a++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	/**
	*	This method is the same as the Upstaircase() method, but it starts
	*	with the maximum amount of starts, but then decreases by one after
	*	each row. Similar to Upstaircase(), the first for loop is to 
	*	establish the amount of stars in a given row, then the nested for
	*	loop is to print that amount of stars. 
	*
	*	@param num The amount of levels in the staircase
	*	@return Nothing.
	*/
	public static void Downstaircase(int num) {
		for(int i = num; i > 0; i--) {
			for(int a = 0; a < i; a++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}