package nextstep.blackjack.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayingCardsTest {
	private PlayingCards aPlayingCards;
	private PlayingCards bPlayingCards;
	private PlayingCards cPlayingCards;
	private PlayingCards dPlayingCards;
	private final List<Card> aCardList = Arrays.asList(
		new Card(Suit.HEART, Denomination.TWO),
		new Card(Suit.SPADE, Denomination.EIGHT));
	private final List<Card> bCardList = Arrays.asList(
		new Card(Suit.CLUB, Denomination.SEVEN),
		new Card(Suit.SPADE, Denomination.KING));
	private final List<Card> cCardList = Arrays.asList(
		new Card(Suit.CLUB, Denomination.ACE),
		new Card(Suit.SPADE, Denomination.KING));
	private final List<Card> dCardList = Arrays.asList(
		new Card(Suit.CLUB, Denomination.NINE),
		new Card(Suit.SPADE, Denomination.KING),
		new Card(Suit.SPADE, Denomination.FIVE));

	@BeforeEach
	void setUp() {
		aPlayingCards = new PlayingCards();
		aPlayingCards.addAll(aCardList);
		bPlayingCards = new PlayingCards();
		bPlayingCards.addAll(bCardList);
		cPlayingCards = new PlayingCards();
		cPlayingCards.addAll(cCardList);
		dPlayingCards = new PlayingCards();
		dPlayingCards.addAll(dCardList);
	}

	@Test
	void isOverlap() {
		assertFalse(aPlayingCards.isOverlap(bPlayingCards));
		assertTrue(bPlayingCards.isOverlap(cPlayingCards));
		assertFalse(cPlayingCards.isOverlap(aPlayingCards));
	}

	@Test
	void isBlackjack() {
		assertFalse(aPlayingCards.isBlackjack());
		assertTrue(cPlayingCards.isBlackjack());
	}

	@Test
	void sum() {
		assertEquals(10, aPlayingCards.sum());
		assertEquals(17, bPlayingCards.sum());
	}

	@Test
	void isBurst() {
		assertFalse(aPlayingCards.isBurst());
		assertTrue(dPlayingCards.isBurst());
	}
}