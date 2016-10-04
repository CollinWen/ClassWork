/**
*	This is a simulation of the original Monty Hall problem where the 
*	computer randomly generates a door to pick and always switches. The
*	purpose of this program is to show how your odds of winning a car are
*	increased when you switch. The program prompts the user for the number
*	of simulated games, then prints out the win percentage.
*
*	@author  Collin Wen
*	@version 1.1
*/
import java.util.Scanner;

public class MontyHallSimulation {
	public static void main(String[] args) {
		if(1 == (int)1.2 && false) {
			System.out.println("true");
		}
		
		int numGames = Integer.parseInt(args[0]);
		int switchWin = 0;
		
		for(int i = 0; i < numGames; i++) {
			switchWin += game2();
		}
		
		double percentSwitchWin = format((double) switchWin/numGames);
		
		System.out.println("Wins: " + switchWin);
		System.out.println("Loses: " + (numGames-switchWin));
		System.out.println("Win Percentage " + percentSwitchWin*100 + "%");
		System.out.println("Lose Percentage: " + (100-(percentSwitchWin*100)) + "%");
		
	}
	
	/**
	*	This method simulates one game by randomly selecting a car
	*	location and randomly selecting the user door pick. The program
	*	will always switch. This was my version of simulating the game, 
	*	but it is not as efficient as the game2() method
	*
	*	@param None.
	*	@return int Returns 1 for win and 0 for loss
	*/
	public static int game() {
		int car = (int)(Math.random()*3+1);

		
		String[] doors = {"", "", "", ""};
		doors[car] = "car";
		
		//user guesses car
		int firstGuess = (int)(Math.random()*3+1);
		if(doors[firstGuess] == "car") {
			return 0;
		} else if(doors[firstGuess] == "") { //user guesses goat
			doors[firstGuess] = "goat";
			return 1;
		}
		
		return -1;
	}
	/**
	*	This method is the class version of the Monty Hall Simulation game. It
	*	simulates the game once with a randomly generated car and randomly 
	*	generated user door pick.
	*
	*	@param None.
	*	@return int Returns 1 for win and 0 for loss
	*/
	public static int game2() {
		int car = (int)(Math.random()*3+1);
		int userPick = (int)(Math.random()*3+1);
		
		if(car == userPick) {
			return 0;
		} else {
			return 1;
		}
	}
	/**
	*	This method take a double and truncates the number
	*	down to hundredths so that it can be turned into a percentage.
	*
	*	@param d The double that you want to formate
	*	@return double Returns the formatted double of d
	*/
	public static double format(double d) {
		int twoDigits = (int)(d*100);
		return twoDigits/100.0;
	}
}