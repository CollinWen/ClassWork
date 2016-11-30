public class ExamPractice0 {
	public static void main (String[] args) {
		System.out.println(convertName("Wen, Collin"));
		System.out.println(countx("xxxxixxxxx"));
		System.out.println(separate("aabbccdeefgg"));
	}
	public static String convertName (String firstLast) {
		int comma = -1;
		int start = -1;
		for(int i = 0; i < firstLast.length(); i++) {
			if(firstLast.substring(i,i+1).equals(",")) {
				comma = i;
			} else if(comma >= 0 && firstLast.substring(i,i+1).equals(" ")) {
				start = i+1;
				break;
			}
		}
		
		String name = firstLast.substring(start) + " " + firstLast.substring(0, comma);
		return name;
	}
	public static int countx (String s) {
		if(s.length() == 1) {
			if(s.substring(0).equals("x")) {
				return 1;
			} else {
				return 0;
			}
		} else {
			if(s.substring(0,1).equals("x")) {
				return 1 + countx(s.substring(1));
			} else {
				return countx(s.substring(1));
			}
		}
	}
	public static String separate (String s) {
		if(s.length() == 1) {
			return s;
		} else if(s.length() == 2) {
			if(s.substring(0,1).equals(s.substring(1))) {
				return s.substring(0,1) + "*" + s.substring(1);
			} else {
				return s;
			}
		} else {
			if(s.substring(0,1).equals(s.substring(1,2))) {
				return s.substring(0,1) + "*" + separate(s.substring(1));
			} else {
				return s.substring(0,1) + separate(s.substring(1));
			}
		}
	}
}