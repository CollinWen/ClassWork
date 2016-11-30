/**
* To summarize, the purpose of the lab was to learn to manipulate and use arrays to simulate
* a game of blackjack. When approaching these problems, I made sure to be efficient while using
* arrays by using as few lines of code as possible. For example, when trying making sure the should
* I hit method would only return true n% of the time, I realized that Math.random() would ensure
* that that would happen, without having to create additional variables. I also learned how to represent
* a deck as a series of integers (int[]) so that it would simulate a deck of cards. The idea of setting
* the last slot of the deck[] as a integer to store the index of the top card was very useful, because
* it meant that additional variables would not have to be created. The global variables also were useful
* in keeping track of universal statistics, so that unnecessary parameters would not have to be introduced. 
* I was able to practice manipulating arrays and changing values within them with the helper methods, such as
* getCard, shuffle, and buildDeck. In conclusion, the blackjack program not only helped me learn more about
* the probabilities and odds behind black jack, but also how to use arrays effectively.
*
* @author Collin Wen
* @version 1.0
*/

import java.util.Scanner;
public class CollinWenBlackJack {
	public static int[] arrWin;
	public static int[] arrCount;
	
	
	public static void main (String[] args) {
		initArray();
		int[] deck = buildDeck();
		
		System.out.print("Deck Values (in order): ");
		for(int i = 0; i < deck.length; i++) {
			System.out.print(deck[i] + " ");
		}
		
		System.out.println("");
		System.out.print("Deck Values (shuffled): ");
		shuffle(deck);
		for(int i = 0; i < deck.length; i++) {
			System.out.print(deck[i] + " ");
		}
		
		System.out.println("");
		System.out.println("First Card (getCard method): " + getCard(deck));
		
		simulate(deck, 1000);
		
		double[] odds = calculateOdds();
		for(int i = 0; i < odds.length; i++) {
			System.out.println("Value: " + i + " Odds: " + odds[i]);
		}
		
		System.out.println("-----------------------------");
		
		for(int i = 0; i < odds.length; i++) {
			if(i <= 1) {
				System.out.println("Value not possible");
			} else {
				System.out.println("Value: " + i + " " + shouldIHit(i, odds));
			}
		}
		
		System.out.println("-----------------------------");
		playBlackJack(2, odds);

	}
	/**
	* This method initializes the arrays that will keep track of how many times hitting
	* will succeed and how many times the player gets a certain value. arrWin will count
	* how many times hitting will not lead you to loosing, where the index is the total
	* value. arrCount will count how many times you have a certain value, where the index 
	* is also the total value. Then the rate of succes can be calculated by times successful/total times.
	* I did this by initiating the two arrays with a length of 21, where the indexes represent
	* all the possible values of total card count. 
	*/
	public static void initArray() {
		arrWin = new int[21];
		arrCount = new int[21];
	}
	/**
	* This method simulates one automated round of blackjack. However, the method
	* keeps hitting until you lose in order to update the odds appropriately. I made 
	* this method keep drawing cards and updating the odds by having a while loop only
	* if the total card count was under 21, or the max. If it is over, then you would have lost.
	* This method also takes a shuffle deck, from which the cards are drawn after each round. 
	* Before the card is added to the total, the arrCount[total] will be increased. If the 
	* total and the current card added together are still under  21 (you have not busted), then  
	* arrWin[total] is increased because you were successful with the hit.
	*
	* @param deck The shuffled deck of all the cards ranging from 0 to 10
	*/
	public static void playHand(int[] deck) {	
		int total = 0;
		int currentCard;
		total += getCard(deck) + getCard(deck);
		
		while(total <= 20) {
			currentCard = getCard(deck);
			arrCount[total]++;
			
			if(total + currentCard > 21) {
				break;
			} else {
				arrWin[total]++;
				total += currentCard;
			}
		}
	}
	/**
	* This method repeats the playHand method (simulating one round of blackjack with 
	* on player automatically hitting). In a for loop that will repeat itself numTimes
	* amount of times, the method first creates a new deck, shuffles it, then calls the
	* playHand method with that deck. This ensures that a new deck is used each time a
	* round is played
	*
	* @param deck The deck (int[]) that will be used for the rounds
	* @param numTimes The amount of blackjack rounds that will be simulated
	*/
	public static void simulate(int [] deck, int numTimes) {
		for(int i = 0; i < numTimes; i++) {
			deck = buildDeck();
			shuffle(deck);
			playHand(deck);
		}
	}
	/**
	* This method creates an integer array that represents a deck of cards.
	* In this deck of cards 1 will represent 1s, 2 will represent 2s, up 
	* to 10. Jacks, Queens, and Kings will also be worth 10 as well. Then, there
	* is one more slot at the end of the array to keep track of which is the next
	* card to be drawn (the card at the "top" of the deck after cards are drawn).
	* The deck of cards will also be in order from least to greatest. I did this 
	* by having a counter that would be the number of the card. Then, every 4 cards, 
	* I incremented the counter value. This was repeated in a for loop up to the
	* second to last slot. When the counter equaled 10, then an if loop prevented it 
	* from further incrementing, since all the face cards are worth 10 (10 is the max
	* value). Then, I set the last slot of the deck array to 0, since deck[0] would be
	* the card on the top of the pile. As cards get drawn, deck[53] will increase, and
	* that number will tell which card to be drawn next.
	*
	* @return int[] Returns the organized deck in the order above
	*/
	public static int[] buildDeck() {
		int[] deck  = new int[53];
		
		int counter  = 1;
		for(int i = 0; i < deck.length - 1; i++) {
			deck[i] = counter;
			if ((i+1) % 4 == 0) {
				if(counter < 10) {
					counter++;
				}
			}
		}
		
		deck[deck.length-1] = 0;
		
		return deck;
	}
	/**
	* This method will take in any given deck and shuffle it randomly. 
	* I did this by going through each index of the card (except the last)
	* and swapping values with another random index (except the last). Using
	* the helper method swap, a for loop that called the swap method, and Math.random()
	* the values of the deck are shuffled by swapping cards with other random cards.
	*
	* @param deck The deck of cards to be shuffled 
	*/
	public static void shuffle(int [] deck) {
		for(int i = 0; i < deck.length - 1; i++) {
			deck = swap(deck, i, (int)(Math.random() * deck.length-1));
		}
	}
	/**
	* This method takes a given deck and returns the value of the 
	* card on the top of the pile. Since the value of the last slot
	* of the deck array indicates the index of the topmost card, 
	* deck[value of last slot of deck array] will be returned. I did
	* this by first incrementing the last value (because after you take the
	* card from the pile, the card after that will be on top), then by returning
	* deck[value of last slot of deck array - 1] (because the value was incremented).
	*
	* @param deck The deck the card will be retrieved from
	* @return int The value of the topmost card in the deck
	*/
	public static int getCard(int [] deck) {
		deck[deck.length-1]++;
		return deck[deck[deck.length-1]-1];
	}
	/**
	* This method is a helper method for the shuffle method. This will
	* return an array where the values of first and second index will
	* be swapper around. I did this by assigning a variable to the value
	* of the first index, setting the value first index to the value of
	* the second index, and then setting the value of the second index 
	* to the variable.
	* 
	* @param deck The deck in which the cards will be swapped
	* @param first The first card to be swapped
	* @param second The second card to be swapped
	* @return int[] the deck with the appropriate cards swapped
	*/
	public static int[] swap (int[] deck, int first, int second) {
		int temp = deck[first];
		deck[first] = deck[second];
		deck[second] = temp;
		
		return deck;
	}
	/**
	* This method uses the global scoped int[], arrWin and arrCount to keep
	* calculate the odds of succeeding for each different value. The double
	* of a certain value will be determined by (amount of successes)/(amount of tries). 
	* I made this double[] by going through each corresponding index of arrWin and arrCount
	* and dividing arrWin[i] by arrCount[i]. However, if the number of tries (the value of 
	* arrCount) was zero, then the odds of that value were automatically set to zero, otherwise
	* dividing by 0 would result in an error. 
	* 
	* @return double[] returns the odds of success in hitting given the statistics of arrWin and arrCount
	*/
	public static double[] calculateOdds() {
		double[] odds = new double[21];
		
		for(int i = 0; i < arrWin.length; i++) {
			if(arrCount[i] == 0) {
				odds[i] = 0.0;
			} else {
				odds[i] = (double)arrWin[i]/arrCount[i];
			}
		}
		
		return odds;
	}
	/**
	* This method takes in the array of the odds of success hitting and 
	* the current value of the cards, returning true if you should hit
	* and false if you should not. Given a percentage (int decimal form), 
	* it the method will return true that percent of the time. The way I did
	* this was by first checking if the player had black jack (value of 21).
	* If so, then the method would return false, since you have already won. 
	* Otherwise, Math.random is used to generate a random double between 0.0 and
	* .999, which is then compared with odds[currVal] to see if it is less than or equal to that 
	* that value. This will ensure that it will return true odds[currVal]% of the
	* time because all odds are between 0 and 1. The smaller the odds number, the less
	* likely Math.random() will be less than that value, and vice versa. 
	*
	* @param currVal The players total of all the cards they have
	* @param odds The odds of success hitting for each total value of cards
	* @return boolean True if the player should hit, and False if the player should not 
	*/
	public static boolean shouldIHit(int currVal, double[] odds) {
		if(currVal == 21) {
			return false;
		} else {
			if(Math.random() <= odds[currVal]) {
				return true;
			} 
			return false;
		}
	}
	/**
	* This method lets you play a simulated version of black jack with other people. The
	* way i did this was by making hasBombed and isDone boolean arrays which would check 
	* if a given player has bombed or has finished. I also made a totals variable which
	* kept track of each player's total card count. Then, with a while loop, I made sure
	* to give each person a turn until they either bombed or finished. When every player
	* has finished, then a winner is determined from the scores in the total array. Before
	* making a decision to hit or stay, the shouldIHit method is used to recommend what the
	* player should do.
	*
	* @param players The amount of players playing the game
	* @param odds The odds that are used to make the computer recommendation to hit or stay
	*/
	public static void playBlackJack(int players, double[] odds) {
		System.out.println("Welcome to Black Jack! There are " + players + " in this game.");
		int[] totals = new int[players];
		boolean[] hasBombed = new boolean[players];
		boolean[] isDone = new boolean[players];
		Scanner input = new Scanner(System.in);
		
		int[] deck = buildDeck();
		shuffle(deck);
		
		for(int i = 0; i < totals.length; i++) {
			totals[i] += getCard(deck) + getCard(deck);
		}
		
		int counter = 0;
		while(counter < players) {
			counter = 0;
			for(int i = 0; i < players; i++) {
				if(isDone[i] == false) {
					System.out.println("Player " + i + ", you have " + totals[i]);
					if(shouldIHit(totals[i], odds)) {
						System.out.println("The computer suggests that you should hit.");
					} else {
						System.out.println("The computer suggests that you stay.");
					}
					
					System.out.println("Do you want to hit? Type 'yes' or 'no'.");
					if(input.nextLine().equals("yes")) {
						totals[i] += getCard(deck);
						if(totals[i] > 21) {
							isDone[i] = true;
							hasBombed[i] = true;
							System.out.println("You have " + totals[i] + " and you bombed!");
						}
					} else {
						isDone[i] = true;
						System.out.println("You have finished your turn!");
					}
				}
			}
			for(int i = 0; i < isDone.length; i++) {
				if(isDone[i] == true) {
					counter++;
				}
			}
		}
		int bestScore = 0; 
		for(int i = 0; i < players; i++) {
			if(!hasBombed[i]) {
				if(totals[i] > bestScore) {
					bestScore = totals[i];
				}
			}
		}
		for(int i = 0; i < players;i++) {
			if(totals[i] == bestScore) {
				System.out.println("Player " + i + " has won!");
			}
		}
	}
}