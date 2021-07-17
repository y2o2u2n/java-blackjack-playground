package nextstep.blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {
	private Deck deck;
	private Person person;

	@BeforeEach
	void setUp() {
		deck = new Deck();
		person = new Person() {
			@Override
			public String getName() {
				return "person";
			}
		};
	}

	@Test
	void receive() {
		deck.dealCards(person, 2);
		PlayingCards playingCards = person.getPlayingCards();

		assertEquals(2, playingCards.size());
	}
}