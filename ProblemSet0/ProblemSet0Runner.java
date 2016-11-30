public class ProblemSet0Runner {
	public static void main(String[] args) {
	
		//toBinary
		System.out.println("------ toBinary Method ------");
		System.out.println(ProblemSet0.toBinary(2));
		System.out.println(ProblemSet0.toBinary(64));
		System.out.println(ProblemSet0.toBinary(99));
		
		//rollDie
		System.out.println("------ rollDie Method ------");
		System.out.println("20 Sides " + ProblemSet0.rollDie(20));
		System.out.println("1 Side " + ProblemSet0.rollDie(1));
		System.out.println("3 Sides " + ProblemSet0.rollDie(3));
		
		//multiples
		System.out.println("------ multiples Method ------");
		ProblemSet0.multiples(7);
		ProblemSet0.multiples(3);
		ProblemSet0.multiples(12);
		
		//swap
		System.out.println("------ swap Method ------");
		System.out.println("3: " + ProblemSet0.swap(3));
		System.out.println("123: " + ProblemSet0.swap(123));
		System.out.println("24680: " + ProblemSet0.swap(24680));
		
		//xor
		System.out.println("------ xor Method ------");
		ProblemSet0.xor();
		
		//printStars
		System.out.println("------ printStars Method ------");
		System.out.print("1: ");
		ProblemSet0.printStars(1);
		System.out.print("7: ");
		ProblemSet0.printStars(7);
		System.out.print("25: ");
		ProblemSet0.printStars(25);
		
		//printTriangle
		System.out.println("------ printTriangle Method ------");
		ProblemSet0.printTriangle(2);
		ProblemSet0.printTriangle(10);
		ProblemSet0.printTriangle(25);
		
		//printRecursive
		System.out.println("------ printRecursive Method ------");
		ProblemSet0.printRecursive(3);
		ProblemSet0.printRecursive(28);
		ProblemSet0.printRecursive(36);
		
		//printRecursive2
		System.out.println("------ printRecursive2 Method ------");
		ProblemSet0.printRecursive2(19);
		ProblemSet0.printRecursive2(5);
		ProblemSet0.printRecursive2(23);
		
		//sumDigits
		System.out.println("------ sumDigits Method ------");
		System.out.println("1: " + ProblemSet0.sumDigits(1));
		System.out.println("278: " + ProblemSet0.sumDigits(278));
		System.out.println("7359: " + ProblemSet0.sumDigits(7359));
		
		//isDivisible
		System.out.println("------ isDivisible Method ------");
		System.out.println("3: " + ProblemSet0.isDivisible(3));
		System.out.println("40: " + ProblemSet0.isDivisible(40));
		System.out.println("6738: " + ProblemSet0.isDivisible(6738));
		
		//printMoreStars
		System.out.println("------ printMoreStars Method ------");
		ProblemSet0.printMoreStars(1);
		ProblemSet0.printMoreStars(3);
		ProblemSet0.printMoreStars(8);
		
		//leastCoins
		System.out.println("------ leastCoins Method ------");
		System.out.println("25: " + ProblemSet0.leastCoins(25));
		System.out.println("87: " + ProblemSet0.leastCoins(87));
		System.out.println("38: " + ProblemSet0.leastCoins(38));
		
		//combinations
		System.out.println("------ combinations Method ------");
		System.out.println("25: " + ProblemSet0.combinations(25));
		System.out.println("10: " + ProblemSet0.combinations(10));
		System.out.println("57: " + ProblemSet0.combinations(57));
		
	}
}