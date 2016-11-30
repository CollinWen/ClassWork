public class PracticeProblem0 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println(sumArray(arr));
		
		String[] a = {"a", "aa", "aaa"};
		System.out.println(countOccurence(a, "a"));
	}
	public static int sumArray (int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum+= arr[i];
		}
		return sum;
	}
	public static int countOccurence (String[] arr, String instance) {
		int total = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int a = 0; a < arr[i].length(); a++) {
				if(arr[i].substring(a,a+1).equals(instance)) {
					total++;
				}
			}
		}
		return total;
	}
}