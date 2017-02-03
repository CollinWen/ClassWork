import java.util.ArrayList;

public class ProblemSet1 {
	/**
	* This method takes in a positive integer and returns an int[] which is filled
	* will the values: 1,2,...,n-1,n,n-1,...,2,1 where n is the parameter to the method.
	* I did this by first initializing an array, filling half of it with the incrementing
	* numbers, and the other half with decreasing numbers.
	*
	* @param maxNum The highest number in the wedge
	* @return int[] Returns the wedge
	*/
	public static int[] createWedge (int maxNum) {
		int[] wedge = new int[maxNum*2 - 1];
		for(int i = 0; i < maxNum; i++) {
			wedge[i] = i+1;
		}
		for(int i = maxNum; i < wedge.length; i++) {
			wedge[i]  = wedge[i-1]-1;
		}
		return wedge;
 	}
 	/**
 	* This method takes in an integer (n) which is greater than or equal to 2, and returns
 	* an array of the first n Fibonacci numbers. The first two elements are equal to 1, and
 	* the following elements should be the sum of the two previous ones. I did this by
 	* first initializing the array of size n, then setting the first two values to 1. Then,
 	* I made the following slots equal the sum of the previous two.
 	*
 	* @param n The amount of fibonacci numbers in the integer array
 	* @return int[] Returns an array filled with the first n Fibonacci numbers
 	*/
 	public static int[] fibArray (int n) {
 		int[] fibonacci = new int[n];
 		fibonacci[0] = 1;
 		fibonacci[1] = 1;
 		
 		for(int i = 2; i < fibonacci.length; i++) {
 			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
 		}
 		
 		return fibonacci;
 	}
 	/**
 	* This method is a boolean method that determines whether a given rational
 	* number is a meidan for values stored in an array. A number is considered the
 	* median if the number of elements that are greater than the number are the same 
 	* as the number of elements less than that number. I did this by keeping a counter
 	* of numbers less than the "median" and another for numbers over the "median". If 
 	* the two counters were equal at the end, then it would return true.
 	*
 	* @param numArr The set of numbers used to find the median
 	* @param The possible number that will be tested for being the median of numArr
 	* @return boolean True if n is the median of numArr, and false otherwise
 	*/
 	public static boolean isMedian (double[] numArr, double n) {
 		int isGreater = 0;
 		int isLess = 0;
 		
 		for(int i = 0; i < numArr.length; i++) {
 			if(numArr[i] > n) {
 				isGreater++;
 			} else if(numArr[i] < n) {
 				isLess++;
 			}
 		}
 		
 		if(isGreater == isLess) {
 			return true;
 		}
 		return false;
 	}
 	/**
 	* This method rotates a given integer array one slot to the left, where
 	* the left most element goes back to the other end. I did this by 
 	* first saving the left most value, shifting the rest of the integers
 	* back one slot, then putting the first value at the end.
 	*
 	* @param a The array to be rotated
 	*/
 	public static void rotateLeft (int[] a) {
 		int lastVal = a[0];
 		for(int i = 0; i < a.length-1; i++) {
 			a[i] = a[i+1];
 		}
 		a[a.length-1] = lastVal;
 	}
 	/**
 	* This method does the same thing as rotateLeft, except in the opposite direction
 	* Since everything is flipped around, I had to save the rightmost value, shift 
 	* all integers right, then put the saved value on the left side.
 	*
 	* @param a The array to be rotated
 	*/
 	public static void rotateRight (int[] a) {
 		int firstVal = a[a.length-1];
 		for(int i = a.length-1; i > 0 ; i--) {
 			a[i] = a[i-1];
 		}
 		a[0] = firstVal;
 	}
 	/**
 	* This method takes an integer array and rotates it
 	* d amount of times. If d is positive, then the array
 	* will be rotated right d times. If d is negative, then 
 	* the array will be rotated left -d times. I did this by 
 	* using a boolean to determine whether to rotate right or left,
 	* then calling rotateLeft or rotateRight d amount of times.
 	*
 	* @param a The array to be rotated
 	* @param d How many units the array will be shifted; positive for right and negative for left
 	*/
 	public static void rotate (int[] a, int d) { 
 		boolean rightLeft;
 		if(d < 0) {
 			rightLeft = false;
 			d = d * (-1);
 		} else {
 			rightLeft = true;
 		}
 		
 		for(int i = 0; i < d; i++) {
 			if(rightLeft) {
 				rotateRight(a);
 			} else {
 				rotateLeft(a);
 			}
 		}
 	}
 	/**
 	* This method takes in an Integer ArrayList and returns the same values in 
 	* an array of type int. I did this by relying on autounboxing, which means that
 	* an Integer object can automatically convert to the primitive type int, which can
 	* be stored in an integer array.
 	*
 	* @param a The ArrayList to be converted
 	* @return int[] Returns an integer array with the values in ArrayList a
 	*/
 	public static int[] convert (ArrayList<Integer> a) {
 		int[] b = new int[a.size()];
 		for(int i = 0; i < a.size(); i++) {
 			b[i] = a.get(i);
 		}
 		
 		return b;
 	}
 	/**
 	* This method takes in two array lists of Strings and returns whether or not they
 	* contain identical values, ignoring the case of the Strings, and the order of the
 	* elements. I did this by first deep copying both ArrayList and seeing if they
 	* had the same size (items will be removed from this; deep copy ensures that the data is saved)
 	* Then using the helper method isEqual (which ignores cases), each
 	* item in each array is compared with each other. If there is a match, both elements
 	* are removed from their array lists. If this process finishes and there are no elements
 	* int either array, it means that all the values are equal, to which the method will return
 	* true. 
 	*
 	* @param arr1 First arrayList to compare
 	* @param arr2 The second ArrayList to compare
 	* @return boolean True if all values are "equal", and false otherwise
 	*/
 	public static boolean equalsIgnoreCase (ArrayList<String> arr1, ArrayList<String> arr2) { //duplicates?
 		if(arr1.size() != arr2.size()) {
 			return false;
 		}
 		
 		ArrayList<String> a = deepCopy(arr1);
 		ArrayList<String> b = deepCopy(arr2);
 		
 		boolean decreaseX = false;
 		
 		for(int x = 0; x < a.size(); x++) {
 			for(int y = 0; y < a.size(); y++) {
 				if(isEqual(a.get(x), b.get(y))) {
 					a.remove(x);
 					b.remove(y);
 					y--;
 					decreaseX = true;	
 					break;
 				}
 			}
 			if(decreaseX) {
 				x--;
 			}
 			decreaseX = false;
 		}
 		
 		if(a.size() == 0 && b.size() == 0) {
 			return true;
 		}
 		return false;
 	}
 	/**
 	* This method takes in an integer array and returns an 
 	* arrayList with the 5 highest values in the int[] in order
 	* from greatest to least. I did this by converting the array into
 	* an arrayList, then continually finding the greatest value and 
 	* removing that slot from the ArrayList.
 	*
 	* @param arr The array to extract the top 5 values from
 	* @return ArrayList<Integer> Returns an arrayList with the top 5 values from arr
 	*/
 	public static ArrayList<Integer> top5 (int[] arr) {
 		ArrayList<Integer> top = new ArrayList<Integer>();
 		
 		int highestVal;
 		int slot;
 		
 		ArrayList<Integer> num = new ArrayList<Integer>();
 		for(int i = 0; i < arr.length; i++) {
 			num.add(arr[i]);
 		}
 		for(int i = 0; i < 5; i++) {
 			highestVal = num.get(0);
 			slot = 0;
 			for(int a = 0; a < num.size(); a++) {
 				if(num.get(a) > highestVal) {
 					slot = a;
 					highestVal = num.get(a);
 				}
 			}
 			
 			top.add(num.get(slot));
 			num.remove(slot);
 		}
 		return top;
 	}
 	/**
 	* This method takes in an ArrayList of Strings and returns the 
 	* String that comes first in ASCII order. I did this by using 
 	* the compareTo method to keep a record of the first ASCII value 
 	* String.
 	*
 	* @param arr The arrayList to find the fist ASCII value
 	* @return String The String that is the first ASCII value in the ArrayList
 	*/
 	public static String getFirst (ArrayList<String> arr) {
 		int least = 0;
 		for(int i = 0; i < arr.size(); i++) {
 			if(arr.get(i).compareTo(arr.get(least)) < 0) {
 				least = i;
 			}
 		}
 		
 		return arr.get(least);
 	}
 	/**
 	* This method takes in a char[][] and replaces all integer characters with
 	* the character 'z'. I did this by checking the ASCII value of each
 	* element, and checking if it was in the digits range in the ASCII table.
 	* If so, I set that element to 'z'.
 	*
 	* @param arr The character array that will have all digits replaced with 'z'
 	*/
 	public static void replace (char[][] arr) {
 		for(int i = 0; i < arr.length; i++) {
 			for(int a = 0; a < arr[i].length; a++) {
 				if((int)arr[i][a] >= 48 && (int)arr[i][a] <= 57) {
 					arr[i][a] = 'z';
 				}
 			}
 		}
 	}
 	/**
 	* This method takes in two int[][]'s that are matrices and multiplies
 	* them together. It is also given that the two matrices can be multiplied.
 	* First, the solution array is made by taking the number of rows in the first
 	* matrix and the number of columns and making those the dimension of the answer.
 	* Then using, the index of the product array, I multiply the corresponding values 
 	* of each column in the first array and each row in the second and add them to get
 	* one element in the product array. Then this is repeated for the rest of the
 	* elements.
 	*
 	* @param first The first matrix to be multiplied
 	* @param second The second matrix to be multiplied
 	* @return The product of the two matrices
 	*/
 	public static int[][] multiply (int[][] first, int[][] second) { //array will be in dimensions
 		int length = second.length;
 		int[][] product = new int[first.length][second[0].length];
 		
 		for(int x = 0; x < product.length; x++) {
 			for(int y = 0; y < product[x].length; y++) {
 				for(int z = 0; z < length; z++) {
 					product[x][y] += first[x][z]*second[z][y];
 				}
 			}
 		}
 		return product;
 	}
 	/**
 	* This is a helper method that checks to see if two string
 	* have the same content disregarding case. I first make sure
 	* the ACII values of each character are in the upper case range,
 	* then I compare the two integer values. I do this for each for each
 	* character in the string and keep a counter.
 	*
 	* @param a The first string to compare
 	* @param b The second string to compare
 	*/
 	public static boolean isEqual (String a, String b) {
 		if(a.length() != b.length()) {
 			return false;
 		}
 		int counter = 0;
 		int firstASCII;
 		int secondASCII;
 		
 		for(int i = 0; i < a.length(); i++) {
 			firstASCII = (int)a.charAt(i);
 			secondASCII = (int)b.charAt(i);
 			
 			if(firstASCII < 91) {
 				firstASCII += 32;
 			}
 			if(secondASCII < 91) {
 				secondASCII += 32;
 			}
 			
 			if(firstASCII == secondASCII) {
 				counter++;
 			}
 		}
 		
 		if(counter == a.length()) {
 			return true;
 		}
 		return false;
 	}
 	/**
 	* This method takes in an ArrayList and makes a new one with the same values
 	* but a different address to avoid pass by reference. I did this by creating a
 	* new integer object for each element, then adding those values to a different
 	* arrayList.
 	*
 	* @param a The arrayList to make a deep copy of
 	* @return ArrayList<String> Returns an arrayList with same values as a but at a different address
 	*/
 	public static ArrayList<String> deepCopy (ArrayList<String> a) {
 		ArrayList<String> b = new ArrayList<String>();
 		for(String x : a) {
 			b.add(x);
 		}
 		return b;
 	}
}