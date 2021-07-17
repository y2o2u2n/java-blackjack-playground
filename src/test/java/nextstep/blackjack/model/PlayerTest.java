package nextstep.blackjack.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
	private Player player;

	@BeforeEach
	void setUp() {
		player = new Player("y2o2u2n");
	}

	@Test
	void decideBetAmount() {
		player.decideBetAmount(200);
		assertEquals(200, player.getBetAmount());
	}
}