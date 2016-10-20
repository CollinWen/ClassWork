public class StringMethods {
	public static void main(String[] args) {
		System.out.println(findString("racecar", "car", 0));
		System.out.println(countStrings("carcarcar", "car"));
		System.out.println(convertItalics("_hello___"));
	}
	
	/**
	* Finds the first instance of s in line,
	* starting at the position start
	* @param o the orignal string 	
	* @param s the string to find 
	* @param start the position to start searching.
	* Guaranteed to be in the string line. (precondition)
	* @return the index of the first single instance of
	* s if the string is found OR -1 if it is not found.
	*/
	public static int findString (String o, String s, int start) {

		int length = o.length();
		for(int i = start; i < length; i++) {
			if(i == length- s.length()) {
				if(o.substring(i).equals(s)) {
					return i;
				}
				break;
			} else {
				if(o.substring(i, i+s.length()).equals(s)) {
					return i;
				}
			}
		}
		
		return -1;
	}
	
	/**
	* Count the number of times instances of s appear in
	* the line.
	* @param o the original string
	* @param s the string to find.
	* @return the number of times the string appears in the line
	*/
	public static int countStrings (String o, String s) {
		int counter = 0;
		
		int length = o.length();
		
		for(int i = 0; i < length; i++) {
			if(i == length- s.length()) {
				if(o.substring(i).equals(s)) {
					counter++;
				}
				break;
			} else {
				if(o.substring(i, i+s.length()).equals(s)) {
					counter++;
				}
			}
		}
		
		return counter;
	}
	
	/**
	* Replace all instances of underscores in the line given by
	* line with italics tags.  There must be an even number of underscores
	* in the line, and they will be replaced by <I>, </I>, alternating.
	* @param line a string with 0 or more underscores
	* @return the line that has underscores replaced with <I> </I> tags or 
	* the original line if there are not an even number of underscores.
	*/
  	public static String convertItalics (String line) {
  		int counter = 0;
  		for(int i = 0; i < line.length(); i++) {
  			if(line.charAt(i) == '_') {
  				counter++;
  			}
  		}
  		int[] underscores = new int[counter];
  		counter = 0;
  		for(int i = 0; i < line.length(); i++) {
  			if(line.charAt(i) == '_') {
  				underscores[counter] = i;
  				counter++; 
  			}
  		}
  		counter = 0;
  		if(underscores.length % 2 == 1) {
  			underscores[underscores.length-1] = -1;
  		}
  		for(int i = 0; i < underscores.length-1; i+=2) {
  			if(underscores[i+1]-underscores[i] == 1) {
  				underscores[i] = -1;
  				underscores[i+1] = -1;
  			} 
  		}
  		counter = 0;
  		String finishedLine = "";
  		boolean lock = false;
  		for(int i = 0; i < line.length(); i++) {
  			if(i == underscores[counter]) {
  				if(!lock) {
  					finishedLine += "<I>";
  					lock = !lock;
  				} else {
  					finishedLine += "</I>";
  					lock = !lock;
  				}
  				
  				counter++;
  			} else {
  				finishedLine += line.charAt(i);
  			}
  		}
  		
  		return finishedLine;
  	}
}