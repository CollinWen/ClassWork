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
*	switch. This simulation is the class version.
*
*	@author  Collin Wen
*	@version 1.1
*/
import java.util.Scanner;

public class MontyHall1 {
	public static void main(String[] args) {
		welcome();
		game2();
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
	*	This method is the main body of the Monty Hall program. It first selects the
	*	car location and gets the user location. Then using the doorToRevel function,
	*	it reveals the location of one of the goats. After that the method prompts the
	*	user by asking if they want to swtich. Depending on the outcome, the method will 
	*	print "you win" and "you lose" respectively.
	*	
	*	@param None.
	*	@return Nothing.
	*/
	public static void game2() {
		System.out.println("You chose door (1,2,or 3): ") ;
		Scanner keyboard = new Scanner(System.in);
		int user_pick = keyboard.nextInt();
		keyboard.nextLine();
		
		int car = (int)(Math.random() * 3 +1);
		
		System.out.println("You chose door #: " + user_pick);
		
		int reveal = doorToReveal1(car, user_pick);
		System.out.println("Open door #: " + reveal);
		
		System.out.print("Do you want to switch?");
		String answer = keyboard.nextLine();
		
		if(answer.equals("yes")) {
			user_pick = doorToReveal(user_pick, reveal);
		} 
		if(user_pick == car) {
			System.out.println("You Win!");
		} else {
			System.out.println("You lose!");
		}
	}
	/**
	*	This method chooses a door to revel based on the location of the
	*	car and the location of the user pick using a for loops.
	*
	*	@param c The location of the car
	*	@param u The location of the user pick
	*	@return int the location of the door that should be revealed
	*/
	public static int doorToReveal(int c, int u) {
		for(int i = 1; i < 4; i++) {
			if(i != c && i != u) {
				return i;
			}
		}
		return -1;
	}
	/**
	*	This method chooses a door to revel based on the location of the
	*	car and the location of the user pick using a while loops. Instead
	*	going through all the possible locations, the method randomly
	*	generates locations until one is valid.
	*
	*	@param c The location of the car
	*	@param u The location of the user pick
	*	@return int the location of the door that should be revealed
	*/
	public static int doorToReveal1(int c, int u) {
		int r = (int)(Math.random() * 3 + 1);
		while(r == c || r == u) {
			r = (int)(Math.random() * 3 + 1);
		}
		return r;
	}
}