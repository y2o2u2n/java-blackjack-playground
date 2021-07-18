package nextstep.blackjack.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
	private Player player;

	@BeforeEach
	void setUp() {
		player = new Player("y2o2u2n");
		player.decideBetAmount(200);
	}

	@Test
	void betAmount() {
		assertEquals(200, player.getBetAmount());
	}

	@Test
	void earningOnBlackjack() {
		player.receive(Arrays.asList(
			new Card(Suit.SPADE, Denomination.ACE),
			new Card(Suit.SPADE, Denomination.KING)));

		Dealer dealer = new Dealer();
		dealer.receive(Arrays.asList(
			new Card(Suit.HEART, Denomination.ACE),
			new Card(Suit.HEART, Denomination.TWO)));

		assertEquals(200 * 1.5, player.getEarning(dealer));
	}

	@Test
	void earningOnBothBlackjack() {
		player.receive(Arrays.asList(
			new Card(Suit.SPADE, Denomination.ACE),
			new Card(Suit.SPADE, Denomination.KING)));

		Dealer dealer = new Dealer();
		dealer.receive(Arrays.asList(
			new Card(Suit.HEART, Denomination.ACE),
			new Card(Suit.HEART, Denomination.KING)));

		assertEquals(0, player.getEarning(dealer));
	}

	@Test
	void earningOnDealerBurst() {
		player.receive(
			Arrays.asList(
				new Card(Suit.SPADE, Denomination.KING),
				new Card(Suit.SPADE, Denomination.QUEEN)));

		Dealer dealer = new Dealer();
		dealer.receive(Arrays.asList(
			new Card(Suit.HEART, Denomination.SEVEN),
			new Card(Suit.HEART, Denomination.EIGHT),
			new Card(Suit.HEART, Denomination.NINE)));

		assertEquals(200, player.getEarning(dealer));
	}

	@Test
	void earningOnBurst() {
		player.receive(Arrays.asList(
			new Card(Suit.SPADE, Denomination.KING),
			new Card(Suit.SPADE, Denomination.QUEEN),
			new Card(Suit.SPADE, Denomination.JACK)));

		Dealer dealer = new Dealer();
		dealer.receive(Arrays.asList(
			new Card(Suit.HEART, Denomination.ACE),
			new Card(Suit.HEART, Denomination.TWO)));

		assertEquals(-200, player.getEarning(dealer));
	}

	@Test
	void earningOnWin() {
		player.receive(Arrays.asList(
			new Card(Suit.SPADE, Denomination.TWO),
			new Card(Suit.SPADE, Denomination.THREE),
			new Card(Suit.SPADE, Denomination.FIVE)));

		Dealer dealer = new Dealer();
		dealer.receive(Arrays.asList(
			new Card(Suit.HEART, Denomination.TWO),
			new Card(Suit.HEART, Denomination.THREE),
			new Card(Suit.HEART, Denomination.FOUR)));

		assertEquals(200, player.getEarning(dealer));
	}

	@Test
	void earningOnLose() {
		player.receive(Arrays.asList(
			new Card(Suit.SPADE, Denomination.TWO),
			new Card(Suit.SPADE, Denomination.THREE),
			new Card(Suit.SPADE, Denomination.FOUR)));

		Dealer dealer = new Dealer();
		dealer.receive(Arrays.asList(
			new Card(Suit.HEART, Denomination.TWO),
			new Card(Suit.HEART, Denomination.THREE),
			new Card(Suit.HEART, Denomination.FIVE)));

		assertEquals(-200, player.getEarning(dealer));
	}
}