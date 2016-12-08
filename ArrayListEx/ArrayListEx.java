import java.util.ArrayList;

public class ArrayListEx {
	public static void main (String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		System.out.println(a.size());
		
		/*
		a.add(3);
		a.add(4);
		
		System.out.println(a.size());
		System.out.println(a);
		
		Integer i = new Integer(5);
		a.add(i);
		System.out.println(a);
		i = 6;
		System.out.println(i);
		System.out.println(a);
		a.add(0, -3);
		System.out.println(a);
		a.set(a.size()-1, 6);
		System.out.println(a);
		
		a.set(0, -2);
		
		System.out.println(a.size());
		System.out.println(a);
		
		a.remove(0);
		
		System.out.println(a.size());
		System.out.println(a);
		*/
		
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.add(2);
		b.add(2);
		b.add(3);
		b.add(0);
		b.add(4);
		b.add(-2);
		
		System.out.println(b);
		removeInstance(b, 2);
		System.out.println(b);
		
		ArrayList<String> c = new ArrayList<String>();
		c.add("eye");
		c.add("abc");
		c.add("elephant");
		
		System.out.println(c);
		replaceE(c);
		System.out.println(c);
	}
	public static void removeInstance (ArrayList<Integer> arr, int instance) {
		for(int i = arr.size()-1; i >= 0; i--) {
			if(arr.get(i) == instance) {
				arr.remove(i);
			}
		}
	}
	public static void replaceE (ArrayList<String> arr) {
		for(int i = 0; i < arr.size(); i++) {
			String word = "";
			for(int a = 0; a < arr.get(i).length(); a++) {
				if(arr.get(i).substring(a, a+1).equals("e")) {
					word += "x";
				} else {
					word += arr.get(i).substring(a, a+1);
				}
			}
			arr.set(i, word);
		}
	}
}