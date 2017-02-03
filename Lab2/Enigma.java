import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Enigma
{
	
	//global variables for the rotors of Enigma machine
	public static ArrayList<Integer> rotor1;
	public static ArrayList<Integer> rotor2;
	public static ArrayList<Integer> backplate;
	
	//global variable for the name of the output file
	public static String output;
	
	public static void main(String args [])
	{	
		System.out.println("Welcome to the Enigma Machine! This program simulates the enigma machine to encrypt/decrypt messages.");
		System.out.println("");
	
	
		String inputfilename = args[0];
		output = args[1];
		int rotor1Start = Integer.parseInt(args[2]);
		int rotor2Start = Integer.parseInt(args[3]);
		int backplateStart = Integer.parseInt(args[4]);
		
		System.out.println("Input File: " + inputfilename);
		System.out.println("Output File: " + output);
		System.out.println("");
		
		ArrayList<Integer> input = new ArrayList<Integer> ();
		
		readFile(inputfilename, input);
		
		//prompts the user if they want to encrypt or decrypt the text
		System.out.println("Would you like to encrypt or decrypt? Type 'e' to encrypt or 'd' to decrypt.");
		Scanner kb = new Scanner(System.in);
		while(true) {
			String kbText = kb.nextLine();
			if(kbText.equals("e")) {
				initializeRotors(rotor1Start, rotor2Start, backplateStart);
				encryptFile(input);
				System.out.println("Encrypted!");
				break;
			} else if(kbText.equals("d")) {
				initializeRotors(rotor1Start, rotor2Start, backplateStart);
				decryptFile(input);
				System.out.println("Decrypted");
				break;
			} else {
				System.out.println("Not a valid option. Please enter 'e' or 'd'.");
			}
		}
		
		//writes the decrypted arrayList on the output file
		for(int i = 0; i < input.size(); i++) {
			char c = (char)((int)input.get(i));
			writeToFile(c);
		}
	}
	
	/**
	* This method reads in the input text from a file and initializes the input ArrayList
	* 
	* @param name The name of the file to read
	* @param list The arrayList in which the read text will go
	*/
	public static void readFile(String name, ArrayList<Integer> list)
	{
		File file = new File(name);	
		Scanner input = null;
		try
		{
			input = new Scanner(file);
		}
		catch (FileNotFoundException ex)
		{
			System.out.println(" Cannot open " + name );
			System.exit(1);
		}
	
		while( input.hasNextLine() )
		{
			String s = input.nextLine();
			for( int i = 0; i < s.length(); i++)
				list.add((int)s.charAt(i));
		}
	}
	
	/**
	* This method takes a character and writes it on a given output text folder.
	*
	* @param ch The character to write
	*/
	public static void writeToFile(char ch)
	{
		String pathname = output;
		Writer writer = null;	
	
		try
		{
			writer = new FileWriter(pathname, true);
		}
		catch (IOException ex)
		{
			System.out.println(" Cannot create/open " + pathname );
			System.exit(1); //quit the program
		}
	
		PrintWriter output = new PrintWriter(writer);
		output.print(ch);
		output.close();
	}
	
	/**
	* This method takes in a given arrayList representing a rotor and "rotates" all items 
	* in a single clockwise rotation. I did this by storing the last value, shifting all 
	* items on slot upward, then putting the last value into the first index of the arrayList.
	* 
	* @param rotor The rotor to rotate
	*/
	public static void advanceRotor (ArrayList<Integer> rotor) { //one clockwise rotation
		int lastVal = rotor.get(rotor.size()-1);
		for(int i = rotor.size()-1; i >0; i--) {
			rotor.set(i,rotor.get(i-1));
		}
		
		rotor.set(0, lastVal);
	}
	
	/**
	* This method takes the given starting ASCII values for each rotor and adds values in the
	* appropriate order to the rotors. I did this by first checking if the values were in range, 
	* then subtracting 32 to counteract the offset. With that, I made sure that the numbers looped
	* back when they got over the highest ASCII value, 126.
	*
	* @param s1 Starting point for rotor1
	* @param s2 Starting point for rotor2
	* @param s3 Starting point for backplate
	*/
	public static void initializeRotors(int s1, int s2, int s3) {
		if(s1 < 32 || s1 > 126 || s2 < 32 || s2 > 126 || s3 < 32 || s3 > 126) {
			System.out.println("INVALID STARTING NUMBER(S)");
			System.exit(1);
		} else {
			rotor1 = new ArrayList<Integer>();
			rotor2 = new ArrayList<Integer>();
			backplate = new ArrayList<Integer>();
			
			s1-= 32; s2 -= 32; s3 -= 32;
			
			for(int i = 0; i < 95; i++) {
				rotor1.add((s1 % 95)+32);
				s1++;
			}
			
			for(int i = 0; i < 95; i++) {
				rotor2.add((s2 % 95)+32);
				s2++;
			}
			
			for(int i = 0; i < 95; i++) {
				backplate.add((s3 % 95)+32);
				s3++;
			}
		}
	}
	
	/**
	* This method takes a set of characters in ASCII numbers and encrypts them using
	* the rotors and backplate. I did this by using the find method get the index of 
	* the baseNumber, getting the backplate char of that index, finding that backplate char
	* in rotor2, then taking that index of the backplate. Then, I made sure that the rotors
	* rotated appropriately after each character encryption.
	*
	* @param in The set of character ASCIIs to encrypt
	*/
	public static void encryptFile(ArrayList<Integer> in) {
		
		for(int i = 0; i < in.size(); i++) {
			int baseNum = in.get(i);
			in.set(i, backplate.get(find(rotor2, backplate.get(find(rotor1, baseNum)))));
			if((i + 1) % rotor1.size() == 0 && i > 0) {
				advanceRotor(rotor1);
				advanceRotor(rotor2);
			} else {
				advanceRotor(rotor1);
			}
		}
	}
	 /**
	 * This method retraces the encryptFile method by reversing the find process. Asides from
	 * the find algorithm, it is the same as the encryptFile method.
	 *
	 * @param in The set of character ASCIIs to decrypt
	 */
	public static void decryptFile(ArrayList<Integer> in) {
		for(int i = 0; i < in.size(); i++) {
			int baseNum = in.get(i);
			in.set(i, rotor1.get(find(backplate, rotor2.get(find(backplate, baseNum)))));
			if((i+1) % rotor1.size() == 0 && i > 0) {
				advanceRotor(rotor1);
				advanceRotor(rotor2);
			} else {
				advanceRotor(rotor1);
			}
		}
	}
	/**
	* This method is a simple linear search that finds a key in and arrayList.
	*
	* @param in The arrayList to find the number from
	* @param find The item for the method to find
	* @return The index of the found item
	*/
	public static int find(ArrayList<Integer> in, int find) {
		for(int i = 0; i < in.size(); i++) {
			if(in.get(i) == find) {
				return i;
			}
		}
		
		return -1;
	}
}