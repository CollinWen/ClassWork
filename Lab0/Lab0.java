/**
* In this lab, we learned to analyze strings based on the ASCII value of certain characters 
* within the string. Overall, the main idea of the lab was password manipulation, and how
* we can use the ascii values to not only generate randomized passwords, but to see whether
* a password contains capital letters, lowercase, numbers, or symbols. Generally, I made
* booleans such as hasCaps, or hasLower that would be made true if a character fell between
* an ascii number range, meaning that it was either capital, lowercase, etc. I also used
* a lot of for loops where the incrementor, i, served as an index for the password string.
* I also used string concatenation in the generate password, Vigenere encryptor, and Vigenere
* decryption. For each of them, I found the right ascii number for a character, then added
* on to the complete password. My main problems involved the Vigenere ciphers, as it was
* hard to get the key index to loop back over as well as the ascii number. However, I was 
* able to solve this by using the % operator, because % by the size of the range will be 
* equivalent to subtracting it by that amount, which gives the effect of the numbers 
* "looping around". In conclusion, I learned a lot about integrating the ascii table and 
* getting ascii values to Strings and characters.
*
* @author Collin Wen
* @version 1.0
*/
public class Lab0 {
	/**
	* This method takes in a password string and returns a boolean: true 
	* if the password has a length greater than 7 and contains at least one number, one symbol,
	* one uppercase letter, and one lowercase letter (otherwise false). The way I approached this
	* was to first check if the password has a sufficient length, then to check the ASCII value of 
	* every character. For each specification, I had a boolean so if a certain character was a
	* symbol, caps, lower, or number, that boolean would be made true. After all the characters
	* in the word are analyzed, then the program checks each boolean and returns true/false 
	* accordingly
	*
	* @param pw The password that will be checked for complexity
	* @return boolean true if the password meets all specifications, false otherwise
	*/
	public static boolean checkComplexity (String pw) {
		boolean hasCaps = false;
		boolean hasLower = false;
		boolean hasSymbol = false;
		boolean hasNum = false;
		
		if(pw.length() < 8) {
			return false;
		} 
		
		for(int i = 0; i < pw.length(); i++) {
			if(((int)pw.charAt(i) >= 33 && (int)pw.charAt(i) <= 47) ||
			   ((int)pw.charAt(i) >= 58 && (int)pw.charAt(i) <= 64) ||
			   ((int)pw.charAt(i) >= 91 && (int)pw.charAt(i) <= 96) ||
			   ((int)pw.charAt(i) >= 123 && (int)pw.charAt(i) <= 126)) {
				hasSymbol = true;
			} else if((int)pw.charAt(i) >= 65 && (int)pw.charAt(i) <= 90) {
		 		hasCaps = true;	
			} else if((int)pw.charAt(i) >= 97 && (int)pw.charAt(i) <= 122) {
				hasLower = true;
			} else if((int)pw.charAt(i) >= 48 && (int)pw.charAt(i) <= 57) {
				hasNum = true;
			}
		}
		
		if(hasCaps == true && hasLower == true && hasSymbol == true && hasNum == true) {
			return true;
		} else {
			return false;
		}
	}
	/**
	* This method generates a random password between the lengths of 8 and 20 that has a
	* has a strength of at least 90. I did this by getting a random length, then generating
	* a random ASCII character that many times. This will form a random password; if it
	* passes the checkComplexity() test and has a strength of at least 90, then if will 
	* return that password. Otherwise, it will repeat this process until a password fits
	* the specifications. 
	*
	* @return String the random password
	*/
	public static String generatePW () {
		int randLength;
		
		String password = "";
		
		while(true) {
			randLength = (int)(Math.random() * 13 + 8);
			for(int i = 0; i < randLength; i++) {
				password += (char)((int)(Math.random()*94+33));
			}
			if(checkComplexity(password) && getPWStrength(password) >= 90) {
				return password;
			} else {
				password = "";
			}
		}
	}
	/**
	* This method takes in a password and assigns it with a number representing its complexity. 
	* The higher the number, the stronger the password. First, the program sees if the password
	* contains symbols, uppercase, lowercase, or numbers using booleans. Then based on which of these
	* booleans are true, a bits variable is assigned to a constant. Then, the program goes and runs the
	* getType method one each character and the one after it. If they are the same, then a counter 
	* variable will increase by 1. This finds the amount of times that a character type is the same as
	* the type of the character after. Then, the strength of the password is returned by multiplying the
	* the bits constant with the length of the password, then subtracting the counter. 
	*
	* @param pw The password to get the strength of
	* @return int The number assigned to the strength of the password. The higher the number, the stronger the password
	*/
	public static double getPWStrength (String pw) {
		boolean hasCaps = false;
		boolean hasLower = false;
		boolean hasSymbol = false;
		boolean hasNum = false;
		
		for(int i = 0; i < pw.length(); i++) {
			if(getType(pw.charAt(i)) == 0) {
				hasLower = true;
			} else if(getType(pw.charAt(i)) == 1) {
				hasCaps = true;
			} else if(getType(pw.charAt(i)) == 2) {
				hasNum = true;
			} else if(getType(pw.charAt(i)) == 3) {
				hasSymbol = true;
			}
		}
		
		double bits = 0.0;
		
		if(hasNum == true && hasCaps == false && hasLower == false && hasSymbol == false) { //numbers only
			bits = 3.3;
		} else if((hasNum == false && hasCaps == true && hasLower == false && hasSymbol == false) || (hasNum == false && hasCaps == false && hasLower == true && hasSymbol == false)) { //case insensitive
			bits = 4.7;	
		} else if(hasNum == false && hasCaps == true && hasLower == true && hasSymbol == false) { //letters only
			bits = 5.7;
		} else if((hasNum == true && hasCaps == true && hasLower == false && hasSymbol == false) ||
				(hasNum == true && hasCaps == false && hasLower == true && hasSymbol == false)) { //Case insensitive alphanumeric
			bits = 5.1;
		} else if(hasNum == true && hasCaps == true && hasLower == true && hasSymbol == false) {
			bits = 6.0;
		} else if(hasNum == true && hasCaps == true && hasLower == true && hasSymbol == true) {
			bits = 6.6;
		}
		
		int counter = 0;
		for(int i = 1; i < pw.length(); i++) {
			if(pw.length() <= 1) {
				break;
			} else {
				if(getType(pw.charAt(i)) == getType(pw.charAt(i-1))) {
					counter++;
				}
			}
		}
		
		return (pw.length()*bits)-counter;
	}
	/**
	* This method is a helper method that returns different integers depending on the type of
	* character. A character is taken in, then either 0, 1, 2, or 3 are returned; 0 for  a lowercase
	* letter, 1 for a capital letter, 2 for a number, and 3 for a symbol (-1 is just in case there are
	* exceptions). The way I did this was by checking the ASCII value for the character, then seeing if
	* they were in certain ranges of the ASCII values with if and else if loops.
	*
	* @param c The character to get the type on
	* @return int Returns 0, 1, 2, 3, or -1 depending on the type of character (c) 
	*/
	public static int getType (char c) {
		if((((int)c) >= 33 && ((int)c) <= 47) || (((int)c) >= 58 && ((int)c) <= 64) || (((int)c) >= 91 && ((int)c) <= 96) || (((int)c) >= 123 && ((int)c) <= 126)) { //symbol
				return 3;
		} else if((int)c >= 65 && (int)c <= 90) { //caps
			return 1;
		} else if((int)c >= 97 && (int)c <= 122) { //lower
			return 0;
		} else if((int)c >= 48 && (int)c <= 57) { //num
			return 2;
		} else {
			return -1;
		}
	}
	/**
	* This method encrypts a password or any text using the Vigenere cipher with all characters
	* between the ASCII values of 33 to 126 (all characters excluding space key). The way a vigenere
	* cipher works is that it shifts the character over a certain amount depending on a key (also a 
	* string of text). If the key is shorter than the password, then the key will repeat itself over 
	* again. Basically, the each character will be shifted over in (ASCII value) by the ascii value
	* of the key. The way I did this was by concatenating a string for each character in the password.
	* Then, I also kept a counter so that the character index of the key would continually increase.
	* After that, I had a for loop that will take the ascii value of the password character, subtract it
	* by 33 (so that the range would be 0 through 93), get the ascii value of one of the characters in the
	* key (using counter and %), subtracting that by 33, adding them together, % 93 to make sure the number 
	* was in range (and would loop back over to the beginning, and add 33 to get rid of the offset.
	*
	* @param key The key for the Vigenere Cipher
	* @param password The password to be encrypted with the Vigenere cipher
	* @return String Returns the encrypted password
	*/
	public static String encryptPW (String key, String password) {
		String encryptedPW = "";
		int counter = 0;
		
		for(int i = 0; i < password.length(); i++) { 
			encryptedPW += (char)(((((int)(password.charAt(i) - 33)) + ((int)(key.charAt(counter % key.length()) - 33))) % 93) + 33);
			counter++;
		}
		
		/*
		
			ALTERNATE SOLUTION WITH LETTERS ONLY AND WRAPS AROUND
		
			int n = 0;
			int a = 0;
			
			for(int i = 0; i < password.length(); i++) {
				if(key.charAt(counter % key.length()) <= 90) { //CAPITAL CHARACTER IN KEY
					n = 65;
				} else {
					n = 97;
				}
				if((int)password.charAt(i) <= 90) { //CAPITAL CHARACTER
					a = 65;
				} else {
					a = 97;
				}
				encryptedPW += (char)(((((int)password.charAt(i) - a) + ((int)key.charAt(counter % key.length()) - n)) % 26) + a);
				counter++;
			}
		*/
		
		return encryptedPW;
	}
	/**
	* This method uses the same concept as the encryptPW method, except it 
	* works backwards to decrypt an encrypted text with a key. Basically, instead 
	* of adding the two values in encryptPW, it subtracts the ascii value of the encrypted
	* text by the ascii value of character in the key.
	*
	* @param key The key to the encrypted text
	* @param encryptedTxt The encrypted text to be decrypted
	* @return String Returns the decrypted version of encryptedTxt
	*/
	public static String decryptPW (String key, String encryptedTxt) {
		String decodedPW = "";
		int counter = 0;
		
		for(int i = 0; i < encryptedTxt.length(); i++) {
			decodedPW += (char)(((((int)encryptedTxt.charAt(i) - 33) - ((int)(key.charAt(counter % key.length()) - 33)) + 93) % 93) + 33);
			counter++;
		}
		
		return decodedPW;
	}
}