/**
*	This program simulates the real-life Monty Hall game. The player is first given 3 
*	doors. In two of the doors, there are both goats in them, but a car is in the 
*	third door. The location of the car is unknown by the player, and their objective
*	is to open the door with the car. The user first picks a door, then a separate door 
*	is revealed with a goat. The player must then make a choice to open the door that 
*	they originally selected, or to switch to the last unopened door. However, it is 
*	more likely win a car if you switch doors, since there is a 2/3 chance that you 
*	have selected a goat on your first try regardless if another door is opened with 
*	a goat. If you are more likely to have currently selected a goat, it is better to
*	switch. This simulation is my own version.
*
*	@author  Collin Wen
*	@version 1.1
*/

import java.util.Scanner;

public class MontyHall {
	public static void main(String[] args) {
		welcome();
		game();
	}
	/**
	*	This method is to welcome the user and explain the game to them. The 
	*	method first prints out a brief game description then three doors so
	*	the user will understand.
	*
	*	@param None.
	*	@return Nothing.
	*/
	public static void welcome() {
		System.out.println("------------------");
		System.out.println("| Monty Hall Game |");
		System.out.println("------------------");
		System.out.println("Pick a door number first. Inside two random doors is a goat. In the other one there is a car");
		System.out.println("---------   ---------   ---------");
		System.out.println("|       |   |       |   |       |");
		System.out.println("|   1   |   |   2   |   |   3   |");
		System.out.println("|       |   |       |   |       |");
		System.out.println("|       |   |       |   |       |");
	}
	/**
	*	This method forms the entire Monty Hall game. First, the method gets the user pick
	*	and the car location. Then, depending on whether the user has first selected the car
	*	the program will go down two separate paths, both revealing a door and prompting the
	*	user to switch. Then, the system will print out whether you have won or lost. 
	*
	*	@param None.
	*	@return Nothing.
	*/
	public static void game() {
		Scanner input = new Scanner(System.in); //user input
		int car = (int)(Math.random()*3+1);
		
		String[] doors = {"", "", "", ""};
		doors[car] = "car";
		
		//user guesses car
		int firstGuess = Integer.parseInt(input.nextLine());
		if(doors[firstGuess] == "car") {
			System.out.println("You selected door " + firstGuess + ".");
			for(int i = 1; i <= 3; i++) {
				if(doors[i] == "") { //door to reveal
					System.out.println("There is a goat in door " + i + ". Would you like to switch to the other door or stay? Type 'yes' or 'no'.");
					if(input.nextLine().equals("yes")) {
						System.out.println("Sorry, the car was in door " + car + ". Better luck next time!");
						break;
					} else {
						System.out.println("Congrats you won a car in door " + car + "!!");
						break;
					}
				}
			}
		} else if(doors[firstGuess] == "") { //user guesses goat
			doors[firstGuess] = "goat";
			System.out.println("You selected door " + firstGuess + ".");
			for(int i = 1; i <= 3; i++) {
				if(doors[i] == "") {
					System.out.println("There is a goat in door " + i + ". Would you like to switch to the other door or stay? Type 'yes' or 'no'.");
					if(input.nextLine().equals("yes")) {
						System.out.println("Congrats you won a car in door " + car + "!!");
						break;
					} else {
						System.out.println("Sorry, the car was in door " + car + ". Better luck next time!");
						break;
					}
				}
			}
		}
	}
}