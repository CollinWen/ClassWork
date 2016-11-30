public class ProblemSet0 {
	/**
	* This method takes in and integer in base 10 then converts that number
	* to binary. I was able to do this by having a while loop repeatedly find the remainder
	* of the number, concatenate it to a string, then divide the number by two until the 
	* number reached zero. The binary number needed to by stored as a string so that individual 
	* digits could be added on to the end.
	* @param int num Integer to convert to Binary
	* @return int Returned integer in binary
	*/
	public static int toBinary(int num) {
		String binary = "";
		while(true) {
			if(num/2 == 0) {
				binary = "1" + binary;
				break;
			} else {
				if(num % 2 == 1) {
					num = num/2;
					binary = "1" + binary;
				} else {
					num = num/2;
					binary = "0" + binary;
				}
			}
		}		
		return Integer.parseInt(binary);
	}
	/**
	* This method is a simulation of rolling a die with a certain amount
	* of sides. I did this by using the Math.random() method and by multiplying 
	* it by the number sides and adding one, I was able to generate any random 
	* number within the range.
	* @param int sides The number of sides the simulated dice will have
	* @return int Returns a random integer within the range of the dice
	*/
	public static int rollDie(int sides) {
		return (int)(Math.random() * sides + 1);
	}
	/**
	* This method prints out 1 multiple of 1, 2 multiples of 2, 3 multiples of 3, and
	* so on up until the max number. I did this by having a nested for loop within
	* another for loop. The first foor loop was to get the current number, then the
	* second loop generated the first ____ multiples of that number.
	* @param int maxNum The last base number of the last row of multiples
	*/
	public static void multiples(int maxNum) {
		for(int currentNum = 1; currentNum <= maxNum; currentNum++) {
			for(int multiplier = 1; multiplier <= currentNum; multiplier++) {
				System.out.print(currentNum + currentNum*(multiplier-1));
				System.out.print("    ");
			}
			System.out.println();
		}
	}
	/**
	* This method swaps the digit a integer's unit place with the digit
	* in the integer's tens place. If there is no tens place, then the digit
	* will be swapped with 0. I did this by subtracting up to the 
	* hundreds place with the mod operator, then adding back the unit's 
	* digit multiplied by 10 and the hundred's number divided by 10.
	* @param int num The integer that will be swapped
	* @return int The swapped integer
	*/
	public static int swap(int num) {
		int returnInt = num;
		returnInt = returnInt - (returnInt % 100);
		
		returnInt = returnInt + ((num % 10)*10);
		num = num - (num % 10);
		
		returnInt = returnInt + (num % 100)/10;
		
		return returnInt;
	}
	/**
	* This method prints out booleans statements alternative to the xor gate
	* that have the same outputs. I did this by testing all the 
	* boolean combinations on a chart, then determining which 
	* statements' outputs corresponded with the xor gate.
	*/
	public static void xor() {
		System.out.println("a != b");
		System.out.println("(a || b) != (a && b)");
		System.out.println("!(!(a && b) == (a == b))");
	}
	/**
	* This method takes in an integer and prints that number
	* of stars. I did this by making a for loop that would print
	* stars until the variable i became equal with num variable.
	* @param int num The number of stars to print
	*/
	public static void printStars(int num) {
		for(int i = 0; i < num; i++) 
			System.out.print("*");
		System.out.println("");
	}
	/**
	* This method prints a triangle with one star in the first row,
	* two stars in the second row, and so on, up to n stars in the last row. 
	* I did this by having two for loops, one nested within another. The outside
	* for loop kept track of which column, then the second for printing that 
	* number of stars in a row.
	* @param int num The number of stars in the last row
	*/
	public static void printTriangle(int num) {
		for(int column = 1; column <= num; column++) {
			for(int row = 0; row < column; row++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	/**
	* This method prints out the same type of triangle as the printTriangle()
	* method, except this method uses recursion. I did by calling the method
	* recursively one less than the previous iteration until it reached the
	* base case, when the variable num = 1. After that, it could cycle back
	* and print out each row until the end.
	* @param int num The number of stars on the last row of the triangle
	*/
	public static void printRecursive(int num) {
		if(num == 1) {
			System.out.println("*");
		} else {
			printRecursive(num-1);
			for(int row = 0; row < num; row++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	/**
	* This method prints the same type of triangle as printRecursive 
	* except that the triangle is flipped upside down. I did this by
	* calling the recursive method after printing the stars in the row
	* so that the number of stars in the row would decrease until reaching
	* 1, then deallocate each frame. 
	* @param int num The number of stars in the first row of the triangle
	*/
	public static void printRecursive2(int num) {
		if(num==1) {
			System.out.println("*");
		} else {
			for(int i = 0; i < num; i++) {
				System.out.print("*");
			}
			System.out.println("");
			printRecursive2(num-1);
		}
	}
	/**
	* This method takes Integer n and returns the sum of all
	* the digits. I did this by finding the "length" of the number
	* using the mod operator, then using the mod operator again to 
	* separate the digit and adding it to the a total sum.
	* @param int n The integer that's digits will be added up
	* @return int The sum of all the digits of int n
	*/
	public static int sumDigits(int n) {
		int num = n;
		int sum = 0;
		
		int length = 1;
		while(n % (Math.pow(10,length)) != n) {
			length++;
		}
		
		for(int i = 1; i <= length; i++) {
			sum += (num % Math.pow(10,i))/(Math.pow(10,i-1));
			num -= num % Math.pow(10,i);
		}
		
		return sum;
	}
	/**
	* This method returns a boolean, true if a number is divisible
	* by 3, and false if the number is not. I did this by making a
	* a recursive method that would repeated call itself with the
	* number - 3 until the number divided to 1 or 0.
	* @param int n The number to check if divisible by 3
	* @return boolean True if divisible by 3 and False if not
	*/
	public static boolean isDivisible(int n) { //check
		if(n/3 == 1 && (n/3)*3 == n) {
			return true;
		} else if(n/3 == 0){
			return false;
		} else {
			return isDivisible(n-3);
		}
	}
	/**
	* This method prints Stars in the shape of a diamond,
	* the size depending on the parameter, int n. I had two
	* sets of nested loops, one set for the first have where
	* the number of stars in each row increments, then another
	* for when the number of stars in each row decreases. Within
	* each of those, there are two for loops, to print stars before
	* and after the middle star, which occurs in every row.
	* @param int n Half the number of stars in the length of the row containing horizontal vertex
	*/
	public static void printMoreStars(int n) { //check
		for(int column = 0; column < n; column++) {
			for(int row = n-1; row > 0; row--) {
				if(column >= row) {
					System.out.print("*      ");
				} else {
					System.out.print("       ");
				}
				
			}
			System.out.print("*");
			for(int row = 1; row <= n-1; row++) {
				if(column >= row) {
					System.out.print("      *");
				} else {
					System.out.print("       ");
				}
				
			}
			System.out.println("");
		}
		
		for(int column = n-2; column >= 0; column--) {
			for(int row = n-1; row > 0; row--) {
				if(column >= row) {
					System.out.print("*      ");
				} else {
					System.out.print("       ");
				}
				
			}
			System.out.print("*");
			for(int row = 1; row <= n-1; row++) {
				if(column >= row) {
					System.out.print("      *");
				} else {
					System.out.print("       ");
				}
				
			}
			System.out.println("");
		}
	}
	/**
	* This method calculates the least number of coins it takes 
	* to equal the a given amount of cents. I did this by dividing
	* the amount of cents by 25 for quarters, 10 for dimes, etc., 
	* which worked because the amount of each coin would truncate
	* down.
	* @param int cents The least amount of coins that will be calculated out of this amount of cents   
	* @return int The least amount of coins it takes to equal int cents 
	*/
	public static int leastCoins(int cents) { //check 
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		int pennies = 0;
		
		quarters = cents/25;
		cents -= 25*quarters;
		dimes = cents/10	;
		cents -= 10*dimes;
		nickels = cents/5;
		cents -= 5*nickels;
		pennies = cents;
		
		System.out.println("Quarters: " + quarters);
		System.out.println("Dimes: " + dimes);
		System.out.println("Nickels: " + nickels);
		System.out.println("Pennies: " + pennies);
		
		return quarters + nickels + dimes + pennies;
	}
	/**
	* This method prints out every combination of coins that can
	* add up to a certain amount of cents. I did this by creating three
	* nested while loops that would test each possible amount of each coin.
	* @param int i The combos formed off of this amount of cents
	* @return int The number of coin combinations formed from int i
	*/
	public static int combinations(int i) {
		int cents = i;
		int q = 0; //quarters
		int d = 0; //dimes
		int n = 0; //nickels
		int p = 0; //pennies
		
		int combos = 0;
		
		while(25*q <= cents) {
			cents -= 25*q;
			while(10*d <= cents) {
				cents -= 10*d;
				while(5*n <= cents) {
					cents -= 5*n;
					combos++;
					System.out.println("Combination " + combos + ": " + q + " Quarters, " + d + " Dimes, " + n + " Nickels, " + cents + " Pennies");
					cents = i - 25*q - 10*d;
					if(5*(n+1) > cents) {
						n = 0;
						break;
					} else {
						n++;
					}
				}
				cents = i - 25*q;
				if(10*(d+1) > cents) {
					d = 0;
					break;
				} else {
					d++;
				}
			}
			cents = i;
			if(25*(q+1) > cents) {
				q = 0;
				break;
			} else {
				q++;
			}
		}
		
		return combos;
	}
}
