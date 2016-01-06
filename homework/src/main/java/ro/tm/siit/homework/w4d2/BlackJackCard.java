package ro.tm.siit.homework.w4d2;

/**
 * The Card class models a card from a deck of cards to eb sued in a black jack game.
 * @author mco
 *
 */
public class BlackJackCard {

	/**
	 * the value of the card; expected from 2 to 14
	 */
	private int value;
	
	/**
	 * the type of card - club, diamond, heart, spade
	 */
	private String type;
	
	/**
	 * Constructor for Card invoked with a value to be set as value of the card
	 * @param value a value
	 */
	public BlackJackCard(int value) {
		this.value = value;
	}

	/**
	 * 
	 * @return the value of the card
	 */
	public int getValue() {
		return value;
	}

}
