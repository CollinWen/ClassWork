public class TwoDArrayPractice {
	public static void main (String[] args) {
		int[][] arr = new int[3][4];
		printArray(arr);
		
		String[][] arr1 = new String[3][3];
		printArray(arr1);
		
		
		printArray(create2D());
		printArray(getGrid(10));
		
	}
	/**
	* This method initiates a 2d array with incrementing numbers as the index increases. 
	* This is done by first instantiating an int[][] with dimensions of 4 and 4. Then, with
	* two for loops, all indexes of the array are accessed and the counter value is put in.
	* After a counter value is put in to the arr[][], then the counter is incremented.
	*
	* @return int[][] The two-dimensional integer array with incrementing numbers
	*/
	public static int[][] create2D () {
		int[][] arr = new int[4][4];
		int counter = 1;
		
		for(int i = 0; i < arr.length; i++) {
			for(int a = 0; a < arr[i].length; a++) {
				arr[i][a] = counter;
				counter++;
			}
		}
		return arr;
	}
	/**
	* This method takes in a given dimension, then returns a 2d array (dimension x dimension)
	* with incrementing numbers in each slot. I did this by first instantiating a new 2d array
	* with the two dimensions (they are the same because it is a square grid), and then repeating
	* the code from the create2d method, which has a nested for loop and a counter.
	*
	* @param dimension The dimension of the two dimensional array/grid
	* @return int[][] The 2d array/grid with incrementing numbers
	*/
	public static int[][] getGrid (int dimension) {
		int[][] arr = new int[dimension][dimension];
		int counter = 1;
		
		for(int i = 0; i < arr.length; i++) {
			for(int a = 0; a < arr[i].length; a++) {
				arr[i][a] = counter;
				counter++;
			}
		}
		return arr;
	}
	/**
	* This method takes in a two dimensional integer array and prints it out, using the first
	* dimension as rows, and the second dimension as columns. With two for loops, one nested
	* within another, each array of the array is printed out on its separate row.
	*
	* @param arr The two-dimensional array to be printed
	*/
	public static void printArray (int[][] arr) {
		int maxDigits = 1;
		for(int i = 0; i < arr.length; i++) {
			for(int a = 0; a < arr[i].length; a++) {
				if(getDigits(arr[i][a]) > maxDigits) {
					maxDigits = getDigits(arr[i][a]);
				}
			}
		}
		for(int i = 0; i < arr.length; i++) {
		
			//prints top bar for each row
			for(int a = 0; a < (((maxDigits+2)*arr[i].length) + arr[i].length + 1); a++) {
				System.out.print("#");
			}
			System.out.println("");
			
			for(int a = 0; a < arr[i].length; a++) {
				//starting left border
				System.out.print("# ");
				System.out.print(arr[i][a]);
				
				//spaces after int
				for(int b = 0; b < maxDigits - getDigits(arr[i][a]) + 1; b++) {
					System.out.print(" ");
				}
				
				//ending right border
				if(a == arr[i].length -1) {
					System.out.print("#");
				}
			}
			
			System.out.println("");
			
			//ending bottom bar
			if(i == arr.length-1) {
				for(int a = 0; a < (((maxDigits+2)*arr[i].length) + arr[i].length + 1); a++) {
				System.out.print("#");
				}
				System.out.println("");
			}
		}
	}
	/**
	* This method is the same as the other printArray function, but it takes in a string
	* array instead. This overloading method is to make sure that when printArray is called
	* with a String array, no error will occur.
	*
	* @param arr The string array (2d) that will be printed
	*/
	public static void printArray (String[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int a = 0; a < arr[i].length; a++) {
				System.out.print(arr[i][a] + " ");
			}
			System.out.println("");
		}
	}
	/**
	* This is a helper method which takes in an integer and returns the amount of digits
	* int it. This was done by dividing the number by 10 repeatedly. If the number was divided by 10
	* and still greater than 0, then the digits variable is increased and it is repeated until
	* it equals 0. When that happens, the digits variable is returned.
	*
	* @param n The number in which the digits will be counted
	* @return int The amount of digits in int n
	*/
	public static int getDigits (int n) {
		int digits = 1;
		while(true) {
			if(n/10 == 0) {
				return digits;
			} else {
				digits++;
				n = n/10;
			}
		}	
	}
}