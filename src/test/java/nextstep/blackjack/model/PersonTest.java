package nextstep.blackjack.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PersonTest {
	private Deck deck;
	private Person personA;
	private Person personB;

	@BeforeEach
	void setUp() {
		deck = new Deck();
		personA = new Person() {
			@Override
			public String getName() {
				return "personA";
			}
		};
		personB = new Person() {
			@Override
			public String getName() {
				return "personB";
			}
		};
	}

	@Test
	void receive() {
		deck.dealCards(personA, 2);
		PlayingCards playingCards = personA.getPlayingCards();

		assertEquals(2, playingCards.size());
	}

	@Test
	void hasBlackjack() {
		List<Card> aCardList = Arrays.asList(
			new Card(Suit.CLUB, Denomination.ACE),
			new Card(Suit.SPADE, Denomination.KING));
		personA.receive(aCardList);
		List<Card> bCardList = Arrays.asList(
			new Card(Suit.CLUB, Denomination.ACE),
			new Card(Suit.SPADE, Denomination.THREE));
		personB.receive(bCardList);

		assertTrue(personA.hasBlackjack());
		assertFalse(personB.hasBlackjack());
	}

	@Test
	void hasBurst() {
		List<Card> aCardList = Arrays.asList(
			new Card(Suit.CLUB, Denomination.QUEEN),
			new Card(Suit.SPADE, Denomination.KING));
		personA.receive(aCardList);
		List<Card> bCardList = Arrays.asList(
			new Card(Suit.CLUB, Denomination.QUEEN),
			new Card(Suit.SPADE, Denomination.KING),
			new Card(Suit.SPADE, Denomination.FIVE));
		personB.receive(bCardList);

		assertFalse(personA.hasBurst());
		assertTrue(personB.hasBurst());
	}
}