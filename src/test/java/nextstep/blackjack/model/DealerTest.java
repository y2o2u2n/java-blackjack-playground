package nextstep.blackjack.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DealerTest {
	private Dealer dealer;

	@BeforeEach
	void setUp() {
		dealer = new Dealer();
	}

	@Test
	void getEarning() {
		Player player = new Player("y2o2u2n");
		player.decideBetAmount(200);
		player.receive(Arrays.asList(
			new Card(Suit.SPADE, Denomination.TWO),
			new Card(Suit.SPADE, Denomination.THREE),
			new Card(Suit.SPADE, Denomination.FIVE)));

		dealer.receive(Arrays.asList(
			new Card(Suit.HEART, Denomination.TWO),
			new Card(Suit.HEART, Denomination.THREE),
			new Card(Suit.HEART, Denomination.FOUR)));

		assertEquals(-player.getEarning(dealer), dealer.getEarning(Collections.singletonList(player)));
	}
}