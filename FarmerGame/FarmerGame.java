/**
*	The Farmer Game program is a game simulation. There are four characters: 
*	a cabbage, a sheep, a wolf, and a human. The objective is to bring all four
*	characters across a river with only one boat. The boat can only hold two 
*	characters at once, and the human must always be on the boat when traveling
*	across. Only on animal can be brought over at a time. However, if the sheep
*	cabbage are left on the same side of the river without the human, the sheep
*	will eat the cabbage. If the wolf and the sheep are left on the same side 
*	of the river without the human, the wolf will eat the sheep. If any of the
*	two situations occurs, you will lose. Otherwise, if you successfully bring 
*	all four characters to one side, then you will win.
*	
*	@author	 Collin Wen
*	@version 1.0
*/
import java.util.Scanner;
public class FarmerGame {
	public static boolean cabbage;
	public static boolean sheep;
	public static boolean wolf;
	public static boolean human;
	
	/**
	*	This is the main method that puts together welcome(), printBoard(), checkLose(),
	* 	and game() methods to form the structure of the game. 
	*
	*	@param args Unused.
	*	@return Nothing.
	*/
	public static void main(String[] args) {
		welcome();
		printBoard();
		Scanner user_input = new Scanner(System.in);
		
		while(true) {
			String input = user_input.next();			
			while(true) {
				if(game(input)) {
					break;
				}
				input = user_input.next();
			}
			
			printBoard();
			
			if(checkLose() == 1) {
				System.out.println("You won!");
				break;
			} else if(checkLose() == -1) {
				System.out.println("You lost");
				break;
			}
			System.out.print("Enter 'C', 'S', 'W', or 'H' : ");
		}
		
	}
	/**
	*	This method welcomes the user when they first run the program and explains the game.
	*
	*	@param None.
	*	@return Nothing.
	*/
	public static void welcome() {
		System.out.println("Welcome to the Farmer Game!");
		System.out.println("There are four characters: a cabbage, a sheep, a wolf,and a human. The objective is to bring all four characters across a river with only one boat. The boat can only hold two characters at once, and the human must always be on the boat when traveling across. Only on animal can be brought over at a time. However, if the sheep and cabbage are left on the same side of the river without the human, the sheep will eat the cabbage. If the wolf and the sheep are left on the same side of the river without the human, the wolf will eat the sheep. If any of the two situations occurs, you will lose. Otherwise, if you successfully bring all four characters to one side, then you will win.");
		System.out.println("\n");
		System.out.println("Please enter 'C' for cabbage, 'S' for sheep, 'W' for wolf, and 'H' for human");
	}
	
	/**
	*	This method prints the board at its most current state. This includes the characters
	*	(their symbols) and where they are located in position to the river. 
	*	
	*	@param None.
	*	@return Nothing.
	*/
	public static void printBoard() {
		String bank0 = "     ";
		String bank1 = "     ";
		
		if(!cabbage) {
			bank0 += "C     ";
		} else {
			bank1 += "C     ";
		}
		if(!sheep) {
			bank0 += "S     ";
		} else {
			bank1 += "S     ";
		}
		if(!wolf) {
			bank0 += "W     ";
		} else {
			bank1 += "W     ";
		}
		if(!human) {
			bank0 += "H     ";
		} else {
			bank1 += "H     ";
		}
		
		System.out.println(bank0);
		System.out.println("-------------------------------");
		System.out.println("\n \n \n");
		System.out.println("-------------------------------");
		System.out.println(bank1);
	}
	
	/**
	*	This method checks if the booleans of certain characters are the same to see
	*	if they are on the same side of the river. The method also checks if all the 
	*	characters are on the same side, in which the user will win.
	*
	*	@param None.
	*	@return int Returns 1 if won, -1 if lost, and 0 if unfinished
	*/
	public static int checkLose() {
		// 0 - Unfinished, 1 - Won, -1 - Lost
		if(cabbage == sheep && cabbage != human) {
			System.out.println("The sheep ate the cabbage!");
			return -1;
		} else if(wolf == sheep && wolf != human) {
			System.out.println("The wolf ate the sheep!");
			return -1;
		} else if(cabbage == true && sheep == true && wolf == true && human == true) {
			return 1;
		}
		return 0;
		
	}
	
	/**
	*	This method will take the input of the user as the argument and then move the
	*	the characters accordingly by checking the booleans and changing the booleans. 
	*	If the input is not a valid symbol or the move can not be made, then the method
	*	will return false and prompt the user again. Otherwise, the method wil return true.
	*
	*	@param input takes the user's input and moves the characters accordingly
	*	@return boolean Returns true if valid input, and false if invalid 
	*/
	public static boolean game(String input) {
		if(input.equals("H")) {
			human = !human;
			return true;
		} else if(input.equals("C") || input.equals("c") && (cabbage == human)) {
			cabbage = !cabbage;
			human = !human;
			return true;
		} else if(input.equals("S") || input.equals("s")  && (sheep == human)) {
			sheep = !sheep;
			human = !human;
			return true;
		} else if(input.equals("W") || input.equals("w")  && (wolf == human)) {
			wolf = !wolf;
			human = !human;
			return true;
		} else {
			System.out.println("Sorry, that's not possible move. Please enter again");
			return false;
		}
	}
	public static String getInput() {
		Scanner kb = new Scanner(System.in);
		String user_input = kb.nextLine();
		if(user_input == "H" || user_input == "C" || user_input == "S" || user_input == "W") {
			return user_input;
		} else {
			System.out.println("Invalid input. Please enter 'C', 'S', 'W', or 'H'");
			return getInput();
		}
	}
}