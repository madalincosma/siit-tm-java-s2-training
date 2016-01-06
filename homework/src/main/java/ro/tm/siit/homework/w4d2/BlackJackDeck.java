package ro.tm.siit.homework.w4d2;

/**
 * The Deck class models a deck of cards, a Standard 52-card deck. It includes
 * thirteen ranks multiplied by four for each four French suits, clubs,
 * diamonds, hearts and spades although the type is not set. The deck is
 * suitable for use in a Black Jack game.O
 * 
 * @author mco
 *
 */
public class BlackJackDeck {

	/**
	 * the cards in the deck
	 */
	private BlackJackCard[] cards = new BlackJackCard[52];

	/**
	 * the index of the card in the deck to be served next
	 */
	private int currentCardIndex = 0;

	public BlackJackDeck() {
		for (int i = 0; i < 13; i++) {
			cards[i] = new BlackJackCard(i);
			cards[2 * i] = new BlackJackCard(i);
			cards[3 * i] = new BlackJackCard(i);
			cards[4 * i] = new BlackJackCard(i);
		}
	}

	/**
	 * shuffles the deck; not implemented yet
	 */
	public void shuffle() {
		// do shuffle
	}

	/**
	 * serves next card from the deck
	 * @return a Card
	 */
	public BlackJackCard serve() {
		return cards[currentCardIndex++];
	}

	/**
	 * checks if the deck has enough cards to start a new round
	 * @return true if it has enough
	 */
	public boolean hasEnoughCards() {
		return 52 - currentCardIndex > 14;// with 14 cards both players have at
											// least 21 points
	}

	/**
	 * resets the deck so that all cards are available again.
	 */
	public void reset() {
		// recreates deck
		currentCardIndex = 0;
	}

}
