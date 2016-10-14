public class StringExamples {
	public static void main(String[] args) {
		//how to get ASCII value of a char
		
		int i = 65;
		char c = (char) i;
		System.out.println(c);
		
		char d = 'e';
		int j = (int) d;
		System.out.println(j);
		
		
		String s = "az";
		String s1 = new String("abcdazsaszsas");
		String s2 = new String("abc");
		String s3 = new String("abe");
		
		System.out.println(s.compareTo(s1));
		System.out.println(s1.compareTo(s));
		System.out.println(s.compareTo(s2));
		System.out.println(s.compareTo(s3));
		
		System.out.println(s3.compareTo(s));
		System.out.println(s1.compareTo(s2));
		System.out.println(s2.compareTo(s2));
		System.out.println(s2.compareTo(s3));
		
		System.out.println("--------------");
		System.out.println(s1.indexOf(s));
		
		System.out.println("--------------");
		System.out.println(hasDigit("hello"));
		System.out.println("--------------");
		
		System.out.println(isPalindrome("racecar"));
		System.out.println(isPalindrome2("bob"));
		System.out.println(isPalindrome3("lol"));
		System.out.println(isPalindrome4("pop"));


	}
	/**
	*	This method takes in a string and returns true
	*	if the given String has a digit, false otherwise
	*	@param s the given Str to check whether it has a digit
	*	@return boolean true if it has a digit, false otherwise
	*/
	public static boolean hasDigit(String s) {
		for(int i = 0; i < s.length(); i++) {
			if((int)s.charAt(i) >= 48 && (int)s.charAt(i) <= 57) {
				return true;
			}
		}
		return false;
	}
	/**
	*	This method takes in a String and returns true if the given String is a palindrome.
	*
	*	ITERATIVE PROCEDURE WITH CHARAT METHOD
	*
	*	@param s the String to check whether it is a palindrome
	*	@return boolean true if palindrome, false otherwise
	*/
	public static boolean isPalindrome(String s) {
		int fst = 0;
		int lst = s.length()-1;
		
		while(fst != lst) {
			if(s.charAt(fst) == s.charAt(lst)) {
				fst++;
				lst--;
			} else {
				return false;
			}
		}
		return true;
	}
	/**
	*	This method takes in a String and returns true if the given String is a palindrome.
	*
	*	RECURSIVE PROCEDURE WITH CHARAT METHOD
	*
	*	@param s the String to check whether it is a palindrome
	*	@return boolean true if palindrome, false otherwise
	*/
	public static boolean isPalindrome2(String s) {
		int fst = 0; 
		int lst = s.length()-1;
		
		if(fst == lst) {
			return true;
		} else {
			if(s.charAt(fst) == s.charAt(lst)) {
				return isPalindrome2(s.substring(++fst,lst));
			} else {
				return false;
			}
		}
	}
	/**
	*	This method takes in a String and returns true if the given String is a palindrome.
	*
	*	ITERATIVE PROCEDURE WITHOUT CHARAT METHOD
	*
	*	@param s the String to check whether it is a palindrome
	*	@return boolean true if palindrome, false otherwise
	*/
	public static boolean isPalindrome3(String s) {
		int fst = 0;
		int lst = s.length()-1;
		
		if(s.length() == 1) {
			return true;
		} else {
			if(s.substring(fst,fst+1).equals(s.substring(lst))) {
				return isPalindrome3(s.substring(++fst,lst));
			} else {
				return false;
			}
		}
	}
	/**
	*	This method takes in a String and returns true if the given String is a palindrome.
	*
	*	RECURSIVE PROCEDURE WITHOUT CHARAT METHOD
	*
	*	@param s the String to check whether it is a palindrome
	*	@return boolean true if palindrome, false otherwise
	*/
	public static boolean isPalindrome4(String s) {
		int fst = 0;
		int lst = s.length()-1;
		
		while(fst != lst) {
			if(s.substring(fst,fst+1).equals(s.substring(lst))) {
				fst++;
				lst--;
			} else {
				return false;
			}
		}
		return true;
	}
}