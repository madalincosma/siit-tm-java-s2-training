package ro.tm.siit.homework.w4d2;

/**
 * The Player class represents a black jack player whether this is a dealer or a
 * normal player.
 * 
 * @author mco
 *
 */
public class Player {

	/**
	 * the name of the player
	 */
	private String name;

	/**
	 * the array where cards are kept during a round
	 */
	// not more than 9 cards needed to pass 21
	private BlackJackCard[] cards = new BlackJackCard[9];

	/**
	 * the number of cards in hand during current round
	 */
	private int cardsInHand = 0;

	/**
	 * the bet performed at the start of the round
	 */
	private int betLevel = 5;

	/**
	 * the current credit of the player
	 */
	private int credit = 500;

	/**
	 * the default no-arg constructor for Player class
	 */
	public Player() {

	}

	/**
	 * A constructor which allows to specify player name and its initial credit.
	 * 
	 * @param name
	 *            the name
	 * @param credit
	 *            credit level
	 */
	public Player(String name, int credit) {
		this.name = name;
		this.credit = credit;
	}

	/**
	 * add a card in hand for current round
	 * 
	 * @param card
	 *            the card
	 */
	public void addCard(BlackJackCard card) {
		cards[cardsInHand++] = card;
	}

	/**
	 * checks if player has enough credit to start a new rount/to bet
	 * 
	 * @return true if it has
	 */
	public boolean hasEnoughCredit() {
		return credit > betLevel;
	}

	/**
	 * gets the score of the user by summing the values of the cards in hand
	 * 
	 * @return an int value as the sum of cards
	 */
	public int getScore() {
		// count cards
		int count = 0;
		for (int i = 0; i <= cardsInHand; i++) {
			count = count + cards[i].getValue();
		}
		return count;
	}

	/**
	 * removes the cards in hand
	 */
	public void clearHand() {
		cardsInHand = 0;
	}

	/**
	 * places a bet and reduces credit level with betLevel
	 */
	public void bet() {
		credit = credit - betLevel;
	}

	/**
	 * 
	 * @return true if the player wants a new card
	 */
	public boolean asksForACard() {
		return getScore() < 18;
	}

	/**
	 * increases credit level by 2 * betLevel
	 */
	public void won() {
		credit = credit + 2 * betLevel;
	}

	/**
	 * checks if the player is alreayd broke
	 * 
	 * @return true if it does not have enough money
	 */
	public boolean isBroke() {
		return credit < betLevel;
	}

	/**
	 * toString method for Player class
	 * 
	 * @return the name of the player
	 */
	@Override
	public String toString() {
		return name;
	}

}
