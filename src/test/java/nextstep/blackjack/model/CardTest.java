package nextstep.blackjack.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardTest {

	@Test
	void equals() {
		assertEquals(new Card(Suit.SPADE, Denomination.ACE), new Card(Suit.SPADE, Denomination.ACE));
	}

	@Test
	void isAce() {
		assertTrue(new Card(Suit.SPADE, Denomination.ACE).isAce());
		assertFalse(new Card(Suit.SPADE, Denomination.THREE).isAce());
	}

	@Test
	void isKqj() {
		assertTrue(new Card(Suit.SPADE, Denomination.KING).isKqj());
		assertTrue(new Card(Suit.SPADE, Denomination.QUEEN).isKqj());
		assertTrue(new Card(Suit.SPADE, Denomination.JACK).isKqj());
		assertFalse(new Card(Suit.SPADE, Denomination.SEVEN).isKqj());
	}
}