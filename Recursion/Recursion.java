public class Recursion {
	public static void main(String[] args) {
		printNum(5);
	}
	public static void printNum(int n) {
		if(n == 0) {
			System.out.println("0");
			return;
		}
		printNum(n-1);
		System.out.println(n);
		
	}
}