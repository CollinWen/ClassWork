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
}