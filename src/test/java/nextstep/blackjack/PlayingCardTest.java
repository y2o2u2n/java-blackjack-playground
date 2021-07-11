package nextstep.blackjack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayingCardTest {

    @Test
    void equals() {
        assertEquals(new PlayingCard(Suit.SPADE, Denomination.ACE, true), new PlayingCard(Suit.SPADE, Denomination.ACE, false));
    }
}