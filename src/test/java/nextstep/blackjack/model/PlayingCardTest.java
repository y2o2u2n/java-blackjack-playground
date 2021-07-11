package nextstep.blackjack.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayingCardTest {

    @Test
    void equals() {
        assertEquals(new PlayingCard(Suit.SPADE, Denomination.ACE, true), new PlayingCard(Suit.SPADE, Denomination.ACE, false));
    }
}