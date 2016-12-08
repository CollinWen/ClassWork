/**
* This is a simulated version of two player Tic Tac Toe with customizable board sizes. 
* @author Collin Wen
* @version 1.0
*/
import java.util.Scanner;


public class TTT {
	public static String empty = " "; //This global variable is used every time a blank space is needed (for efficiency)
	public static String[] playChip = {"X", "O"};  //The string "chip" that will be played 
	public static int turn = 0; //Int serving as a reference for the index of playChip (determines which chip will be played --> whose turn it is)
	
	public static void main (String[] args) {
		int size;
		Scanner user_input = new Scanner(System.in);
		
		System.out.println("Welcome to TicTacToe! Please enter your board size.");
		//makes sure the Board size input is valid
		while(true) {
			String userSize = user_input.nextLine();
			if(isInteger(userSize)) {
				size = Integer.parseInt(userSize);
				break;
			} else {
				System.out.println("Invalid input, please enter again.");
			}
		}
		
		//creates the board
		String[][] theBoard = createBoard(size);
		drawBoard(theBoard);
		
		//repeats each round until game is over
		while(true) {
			System.out.println("Player " + playChip[turn] + "'s turn");
			
			//checks for valid board input
			while(true) {
				if(playChip(user_input.nextLine(), theBoard)) {
					break;
				} else {
					System.out.println("Invalid input, please enter again.");
				}
			}
			
			//checks if the game is finished
			drawBoard(theBoard);
			if(checkWin(theBoard) == 1) {
				System.out.println("Player X has won!");
				break;
			} else if(checkWin(theBoard) == 2) {
				System.out.println("Player O has won!");
				break;
			} else if(checkWin(theBoard) == 3) {
				System.out.println("Tie game!");
				break;
			}
			
			//switches players
			turn = togglePlayer(turn);
		}
	}
	/**
	* This method makes a two-dimensional "square" array representing the 
	* tic-tac-toe board
	* 
	* @param size The size/dimension of the board (board will be size x size)
	* @return String[][] the board with the appropriate dimensions
	*/
	public static String[][] createBoard (int size) {
		String[][] theBoard = new String[size][size];
		for(int i = 0; i < theBoard.length; i++) {
			for(int a = 0; a < theBoard[i].length; a++) {
				theBoard[i][a] = empty;
			}
		}
		return theBoard;
	}
	/**
	* This method prints out the tic tac toe board with [] around each slot
	*
	* @param theBoard The board to be printed out
	*/
	public static void drawBoard (String[][] theBoard) {
		for(int i = 0; i < theBoard.length; i++) {
			for(int a = 0; a < theBoard[i].length; a++) {
				System.out.print("[" + theBoard[i][a] + "]");
			}
			System.out.println("");
		}
	}
	/**
	* This method is supposed to take in the global turn variable an switch it between
	* 0 and 1 (the indexes of the playChip array)
	*
	* @param player The turn variable that will be toggled
	* @return int The player variable that has been switched
	*/
	public static int togglePlayer (int player) {
		if(player == 0) {
			return 1;
		}
		return 0;
	}
	/**
	* This method plays the chip and returns a boolean depending whether the chip was 
	* successfully placed in the appropriate slot. 
	*
	* @param slot The desired slot for the chip to be placed
	* @param theBoard The board in which the chip will be placed
	* @return boolean True if chip was placed, and false if it wasn't (invalid input)
	*/
	public static boolean playChip (String slot, String[][] theBoard) {
		if(!isInteger(slot)) {
			return false;
		}
		int slotNum = Integer.parseInt(slot);
		int length = theBoard.length;
		
		if(isInteger(slot)) {
			if(slotNum < length*length && slotNum >= 0 && theBoard[slotNum/length][slotNum % length].equals(empty)) {
				theBoard[slotNum/length][slotNum % length] = playChip[turn];
				return true;
			}
		}
		return false;
	}
	/**
	* This method checks the ASCII values of each character in a string to see if 
	* every character is a number, which means that the input will have a valid number.
	*
	* @param input The string to test if it an integer
	* @return boolean True if the input is an integer and false otherwise
	*/
	public static boolean isInteger (String input) {	
		int counter = 0;
		for(int i = 0; i < input.length(); i++) {
			if((int)input.charAt(i) >= 48 && (int)input.charAt(i) <= 57) {
				counter++;
			}
		}
		
		if(counter == input.length()) {
			return true;
		}
		return false;
	}
	/**
	* This method checks to see if either player has won by having a counter and checking horizontally
	* vertically, and diagonally.
	*
	* @param theBoard The board to check if the game has finished
	* @return int 0 = tie 1 = X wins 2 = O wins 3 = tie
	*/
	public static int checkWin (String[][] theBoard) { // 0 = tie 1 = X wins 2 = O wins 3 = tie
		String player = empty;
		int counter = 0;
		
		//horizontal check
		for(int i = 0; i < theBoard.length; i++) {
			if(theBoard[i][0].equals(empty)) {
				player = null;
			} else {
				player = theBoard[i][0];
			}
			
			for(int a = 0; a < theBoard[i].length; a++) {
				if(theBoard[i][a].equals(player)) {
					counter++;
				}
			}
			if(counter == theBoard.length) {
				if(player.equals("X")) {
					return 1;
				} else {
					return 2;
				}
			}
			counter = 0;
		}
		counter = 0;
		
		//vertical check
		for(int i = 0; i < theBoard.length; i++) {
			if(theBoard[0][i].equals(empty)) {
				player = null;
			} else {
				player = theBoard[0][i];
			}

			for(int a = 0; a < theBoard.length; a++) {
				if(theBoard[a][i].equals(player)) {
					counter++;
				}
			}
			if(counter == theBoard.length) {
				if(player.equals("X")) {
					return 1;
				} else {
					return 2;
				}
			}
			counter = 0;
		}
		
		counter = 0;
		//diagonals check
		for(int i = 0; i < theBoard.length; i++) {
			if(theBoard[0][0].equals(empty)) {
				player = null;
			} else {
				player = theBoard[0][0];
			}

			if(theBoard[i][i].equals(player)) {
				counter++;
			}
		}
		if(counter == theBoard.length) {
			if(player.equals("X")) {
				return 1;
			} else {
				return 2;
			}
		}
		counter = 0;
		for(int i = theBoard.length - 1; i >= 0; i--) {
			if(theBoard[0][theBoard.length - 1].equals(empty)) {
				player = null;
			} else {
				player = theBoard[0][theBoard.length - 1];
			}

			if(theBoard[Math.abs(i-(theBoard.length-1))][i].equals(player)) {
				counter++;
			}
		}
		if(counter == theBoard.length) {
			if(player.equals("X")) {
				return 1;
			} else {
				return 2;
			}
		}
		
		for(int i = 0; i < theBoard.length; i++) {	
			for(int a = 0; a < theBoard[i].length; a++) {
				if(theBoard[i][a] == empty) {
					return 0;
				}
			}
		}
		
		return 3;
		
	}
}
