package nextstep.blackjack.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardTest {

    @Test
    void equals() {
        assertEquals(new Card(Suit.SPADE, Denomination.ACE, true), new Card(Suit.SPADE, Denomination.ACE, false));
    }
}