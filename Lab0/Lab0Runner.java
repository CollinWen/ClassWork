public class Lab0Runner {
	public static void main (String[] args) {
		System.out.println("------ Check Complexity Method ------");
		System.out.println("pingry: " + Lab0.checkComplexity("pingry"));
		System.out.println("GoBigBlue: " + Lab0.checkComplexity("GoBigBlue"));
		System.out.println("GoBigBlue123: " + Lab0.checkComplexity("GoBigBlue123"));
		System.out.println("GoBigBlue123!: " + Lab0.checkComplexity("GoBigBlue123!"));
		
		System.out.println("------ Generate Password Method ------");
		for(int i = 0; i < 3; i++) {
			String password = Lab0.generatePW();
			System.out.println(password + " (Score): " + Lab0.getPWStrength(password));
		}
		
		System.out.println("------ Get Password Strength Method ------");
		System.out.println("pingry: " + Lab0.getPWStrength("pingry"));
		System.out.println("GoBigBlue: " + Lab0.getPWStrength("GoBigBlue"));
		System.out.println("goBIGBLUE!!1!: " + Lab0.getPWStrength("goBIGBLUE!!1!"));
		String password = Lab0.generatePW();
		System.out.println(password + ": " + Lab0.getPWStrength(password));
		
		System.out.println("------ Get Type Method ------");
		System.out.println(Lab0.getType('a'));
		System.out.println(Lab0.getType('A'));
		System.out.println(Lab0.getType('1'));
		System.out.println(Lab0.getType('!'));
		
		System.out.println("------ Encrypt Password Method ------");
		System.out.println("Text: pingry!*123 Code: bigblue - " + Lab0.encryptPW("bigblue", "pingry!*123"));
		System.out.println("Text: garden Code: !! - " + Lab0.encryptPW("!!", "garden"));
		System.out.println("Text: !!#gobigblue Code: pingry - " + Lab0.encryptPW("pingry" , "!!#gobigblue"));
		
		System.out.println("------ Decrypt Password Method ------");
		System.out.println("Text: TTWK`pekyxt Code: bigblue - " + Lab0.decryptPW("bigblue", "TTWK`pekyxt"));
		System.out.println("Text: garden Code: !! - " + Lab0.decryptPW("!!", "garden"));
		System.out.println("Text: pipPc][RRUi` Code: pingry - " + Lab0.decryptPW("pingry", "pipPc][RRUi`"));
	}
}