package nextstep.blackjack.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckTest {
	private Deck deck;

	@BeforeEach
	void setUp() {
		deck = new Deck();
	}

	@Test
	void dealCards() {
		Person dealer = new Dealer();
		Person playerA = new Player("a");
		Person playerB = new Player("b");

		deck.dealCards(dealer, 2);
		deck.dealCards(playerA, 2);
		deck.dealCards(playerB, 2);

		PlayingCards dealerPlayingCards = dealer.getPlayingCards();
		PlayingCards playerAPlayingCards = playerA.getPlayingCards();
		PlayingCards playerBPlayingCards = playerB.getPlayingCards();

		assertEquals(2, dealerPlayingCards.size());
		assertEquals(2, playerAPlayingCards.size());
		assertEquals(2, playerBPlayingCards.size());
		assertFalse(dealerPlayingCards.isOverlap(playerAPlayingCards));
		assertFalse(playerAPlayingCards.isOverlap(playerBPlayingCards));
		assertFalse(playerBPlayingCards.isOverlap(dealerPlayingCards));
	}
}