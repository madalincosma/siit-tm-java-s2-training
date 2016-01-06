package ro.tm.siit.homework.w4d2;

/**
 * The BlackJackApp class is an application which simulates BlackJack/21 game.
 * The game ends when one player does not have enough money to bet anymore.
 * 
 * @author mco
 *
 */
public class BlackJackApp {

	/**
	 * the starting point in a java application; it creates a dealer, a player,
	 * a deck of cards and a black jack game and starts the game. At the end the winner is printed
	 * 
	 * @param args
	 *            the user supplied command line arguments
	 */
	public static void main(String[] args) {
		Player dealer = new Player("John", 10000);
		Player player = new Player("Max", 1000);

		BlackJackDeck deck = new BlackJackDeck();
		deck.shuffle();

		BlackJack game = new BlackJack();

		game.play(deck, dealer, player);

		System.out.println("final winner is: " + (dealer.isBroke() ? player : dealer));

	}

}
