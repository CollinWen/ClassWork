/**
* This Problem Set focused on manipulating Arrays and ArrayLists, in addition
* to practicing more complex algorithms. Through this lab, I not only learned
* the basic commands with ArrayLists, but I also learned how to use them effectively,
* as they can a changeable capacity. There were also many problems related to sorting or finding the greatest value.
* I approached these problems the same way: I keep a variable that holds the record 
* and check other elements to see if they top the record. If so, then I would set the record
* to that value. To summarize, This lab helped me learn a lot about ArrayLists, as 
* well as how to design algorithms for sorting and finding specific values.
*
* @author Collin Wen
* @version 1.0
*/

import java.util.ArrayList;
import java.util.Arrays;

public class PS1Runner {
	public static void main (String[] args) {
		
		System.out.println("------ createWedge Method ------");
		int[] wedge = ProblemSet1.createWedge(1);
		printArray(wedge);
		System.out.println("");
		
		int[] wedge2 = ProblemSet1.createWedge(5);
		printArray(wedge2);
		System.out.println("");
		
		int[] wedge3 = ProblemSet1.createWedge(13);
		printArray(wedge3);
		System.out.println("");
		
		System.out.println("------ fibArray Method ------");
		int[] fib = ProblemSet1.fibArray(2);
		printArray(fib);
		System.out.println("");
		
		int[] fib2 = ProblemSet1.fibArray(6);
		printArray(fib2);
		System.out.println("");
		
		int[] fib3 = ProblemSet1.fibArray(10);
		printArray(fib3);
		System.out.println("");
		
		System.out.println("------ isMedian Method ------");
		double[] dbl = {0.0,1.3,4.8,7.3,6.2,5.9,2.6,3.7,8.4,10.3};
		printArray(dbl);
		System.out.println("Median = 5 : " + ProblemSet1.isMedian(dbl, 5.0));
		
		double[] dbl1 = {0.0, 9.9, 6.6, 7.8, 4.2, 4.5};
		printArray(dbl1);
		System.out.println("Median = 3 : " + ProblemSet1.isMedian(dbl1, 3.0));
		
		double[] dbl3 = {1.0, 1.0, 1.0, 2.0, 3.0, 5.0, 7.0, 8.0, 10.0, 200.0};
		printArray(dbl3);
		System.out.println("Median = 4 : " + ProblemSet1.isMedian(dbl3, 4.0));
		
		System.out.println("------ rotate Method(s) ------");
		int[] rotateL = {0,1,2,3,4,5,6,7,8,9};
		printArray(rotateL);
		ProblemSet1.rotateLeft(rotateL);
		System.out.print("Rotate Left: ");
		printArray(rotateL);
		System.out.println("");
		
		int[] rotateR = {0,1,5,3,6,8,4,7,8,3,5};
		printArray(rotateR);
		ProblemSet1.rotateRight(rotateR);
		System.out.print("Rotate Right: ");
		printArray(rotateR);
		System.out.println("");
		
		int[] rotate2 = {0,2,5,7,2,45,7,3,63,4,7,2,66};
		printArray(rotate2);
		ProblemSet1.rotate(rotate2, 3);
		System.out.print("Rotate +3 (right): ");
		printArray(rotate2);
		System.out.println("");
		
		int[] rotate3 = {34,6,7,455,2};
		printArray(rotate3);
		ProblemSet1.rotate(rotate3, -4);
		System.out.print("Rotate -4 (left): ");
		printArray(rotate3);
		System.out.println("");
		
		System.out.println("------ convert Method ------");
		ArrayList<Integer> conv = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		ArrayList<Integer> conv2 = new ArrayList<>(Arrays.asList(0,4,66,3,4,75,45));
		ArrayList<Integer> conv3 = new ArrayList<>(Arrays.asList(10,3,5));
		
		System.out.print(conv + " convert to: ");
		printArray(ProblemSet1.convert(conv));
		System.out.println("");
		
		System.out.print(conv2 + " convert to: ");
		printArray(ProblemSet1.convert(conv2));
		System.out.println("");
		
		System.out.print(conv3 + " convert to: ");
		printArray(ProblemSet1.convert(conv3));
		System.out.println("");
		
		System.out.println("------ isEqual (helper) Method ------");
		System.out.println("pingry = PiNgRy : " + ProblemSet1.isEqual("pingry", "PiNgRy"));
		System.out.println("dog = CAT : " + ProblemSet1.isEqual("dog", "CAT"));
		System.out.println("JAva = jAVA : " + ProblemSet1.isEqual("JAva", "jAVA"));
		
		System.out.println("------ equalsIgnoreCase Method ------");
		
		ArrayList<String> eIC = new ArrayList<>(Arrays.asList("Dog", "cat", "lion", "zebra", "donkey"));
		ArrayList<String> eIC2 = new ArrayList<>(Arrays.asList("CAT", "ZEBRA", "DOnkeY", "DoG", "lION"));
		ArrayList<String> eIC3 = new ArrayList<>(Arrays.asList("Cat", "Cat", "Dog", "Lion", "Donkey", "DONKEY"));
		ArrayList<String> eIC4 = new ArrayList<>(Arrays.asList("DONKEY", "CAT", "LION", "Zebra", "dOg"));
		
		System.out.print(eIC);
		System.out.print(" = ");
		System.out.print(eIC2);;
		System.out.println(" : " + ProblemSet1.equalsIgnoreCase(eIC, eIC2));
		
		System.out.print(eIC3);
		System.out.print(" = ");
		System.out.print(eIC);
		System.out.println(" : " + ProblemSet1.equalsIgnoreCase(eIC3, eIC));
		
		System.out.print(eIC4);
		System.out.print(" = ");
		System.out.print(eIC2);
		System.out.println(" : " + ProblemSet1.equalsIgnoreCase(eIC4, eIC2));
		
		System.out.println("------ top5 Method ------");
		
		int[] top = {9,8,7,6,5,4,3,2,1};
		printArray(top);
		System.out.print(" Top 5: " + ProblemSet1.top5(top));
		System.out.println("");
		
		int[] top2 = {3,464,232,86,964};
		printArray(top2);
		System.out.print(" Top 5: " + ProblemSet1.top5(top2));
		System.out.println("");
		
		int[] top3 = {-2,4,-5,-7,-9,2,-1,3,-7,0,-2};
		printArray(top3);
		System.out.print(" Top 5: " + ProblemSet1.top5(top3));
		System.out.println("");
		
		System.out.println("------ getFirst Method ------");
		
		ArrayList<String> first = new ArrayList<>(Arrays.asList("z", "b", "c", "d", "e", "a"));
		System.out.print(first + " First: " + ProblemSet1.getFirst(first));
		System.out.println("");
		
		ArrayList<String> first2 = new ArrayList<>(Arrays.asList("pingry", "GO BIG BLUE", "pingrybigblue"));
		System.out.print(first2 + " First: " + ProblemSet1.getFirst(first2));
		System.out.println("");
		
		ArrayList<String> first3 = new ArrayList<>(Arrays.asList("abcdefg", "bcdefg", "cdefg", "defg"));
		System.out.print(first3 + " First: " + ProblemSet1.getFirst(first3));
		System.out.println("");
		
		System.out.println("------ replace Method ------");
		char[][] cArr = {{'1','2','0'}, {'a','b','n'}, {'5', 'g', ','}};
		printArray(cArr);
		ProblemSet1.replace(cArr);
		System.out.println("");
		printArray(cArr);
		
		System.out.println("");
		
		char[][] cArr2 = {{'1','2','0','a','6'}, {'a','b','n','k',';'}, {'5', 'g', ',','q','m'}};
		printArray(cArr2);
		ProblemSet1.replace(cArr2);
		System.out.println("");
		printArray(cArr2);
		
		System.out.println("");
		
		char[][] cArr3 = {{'0','1','2','3','a'}, {'6','5','4', 'b'}, {'9','8','7'}};
		printArray(cArr3);
		ProblemSet1.replace(cArr3);
		System.out.println("");
		printArray(cArr3);
		
		System.out.println("------ multiply Method ------");
		int[][] twoD = {{1,2},{3,4}};
		int[][] twoD2 = {{4,2},{7,3}};
		printArray(twoD);
		System.out.println("Multiplied by: ");
		printArray(twoD2);
		System.out.println("Equals: ");
		printArray(ProblemSet1.multiply(twoD, twoD2));
		
		System.out.println("");
		
		int[][] twoD3 = {{1,2},{3,4}};
		int[][] twoD4 = {{5,6},{7,8}};
		printArray(twoD3);
		System.out.println("Multiplied by: ");
		printArray(twoD4);
		System.out.println("Equals: ");
		printArray(ProblemSet1.multiply(twoD3, twoD4));
		
		System.out.println("");
		
		int[][] twoD5 = {{1,2,3},{4,5,6}}; //2 x 3
		int[][] twoD6 = {{5,6},{7,8},{9,10}}; //3 x 2
		printArray(twoD5);
		System.out.println("Multiplied by: ");
		printArray(twoD6);
		System.out.println("Equals: ");
		printArray(ProblemSet1.multiply(twoD5, twoD6));
	}
	
	public static void printArray (int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static void printArray (char[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static void printArray (double[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static void printArray (String[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static void printArray (int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int a = 0; a < arr[i].length; a++) {
				System.out.print(arr[i][a] + " ");
			}
			System.out.println("");
		}
	}
	public static void printArray (char[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int a = 0; a < arr[i].length; a++) {
				System.out.print(arr[i][a] + " ");
			}
			System.out.println("");
		}
	}
	public static void printArray (ArrayList<String> arr) {
		for(int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
	}
}