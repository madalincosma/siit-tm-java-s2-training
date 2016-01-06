package ro.tm.siit.homework.w4d2;

/**
 * The BlackJack class contains the logic to play a black jack name.
 * 
 * @author mco
 *
 */
public class BlackJack {

	/**
	 * the logic to play black jack in multiple rounds until one player does not have money anymore
	 * 
	 * @param deck
	 *            the deck of cards
	 * @param dealer
	 *            the dealer
	 * @param player
	 *            the player/customer
	 */
	public void play(BlackJackDeck deck, Player dealer, Player player) {

		while (player.hasEnoughCredit() && dealer.hasEnoughCredit()) {
			checkDeck(deck);
			playRound(deck, dealer, player);
			detectWinner(dealer, player);

			player.clearHand();
			dealer.clearHand();
		}
	}

	/**
	 * checks if the deck has enough cards; if not the deck is put together and re-shuffled. 
	 * @param deck the deck
	 */
	private void checkDeck(BlackJackDeck deck) {
		if (!deck.hasEnoughCards()) {
			deck.reset();
			deck.shuffle();
		}
	}

	/**
	 * plays one round of black jack
	 * @param deck a good deck of cards
	 * @param dealer the dealer
	 * @param player the player
	 */
	private void playRound(BlackJackDeck deck, Player dealer, Player player) {
		player.bet();
		player.addCard(deck.serve());

		dealer.bet();
		dealer.addCard(deck.serve());

		player.addCard(deck.serve());
		dealer.addCard(deck.serve());

		while (player.getScore() < 21 && dealer.getScore() < 21) {
			if (player.asksForACard()) {
				player.addCard(deck.serve());
			}
			if (dealer.asksForACard()) {
				dealer.addCard(deck.serve());
			}
			if (!player.asksForACard() && !dealer.asksForACard()) {
				break;
			}
		}
	}

	/**
	 * logic to detect the winner of the round
	 * @param player1 
	 * @param player2
	 */
	private void detectWinner(Player player1, Player player2) {
		boolean player2Won = false;
		if (player2.getScore() == 21) {
			player2.won();
			player2Won = true;
		} else if (player2.getScore() < 21) {
			if (player2.getScore() > player1.getScore()) {
				player2.won();
				player2Won = true;
			} else {
				player1.won();
			}
		} else {
			if (player2.getScore() < player1.getScore()) {
				player2.won();
				player2Won = true;
			} else {
				player1.won();
			}
		}

		System.out.println("the winner is: " + (player2Won ? player2 : player1));
	}

	/**
	 * alternative logic to detect the winner of the round [more compact code]
	 * @param player1 
	 * @param player2
	 */
	private void detectWinner2(Player dealer, Player player) {
		int playerOffset = player.getScore() - 21;
		int dealerOffset = dealer.getScore() - 21;
		if ((playerOffset > 0 && playerOffset < dealerOffset) || (playerOffset < 0 && playerOffset > dealerOffset)) {
			player.won();
		} else {
			dealer.won();
		}
	}

}
