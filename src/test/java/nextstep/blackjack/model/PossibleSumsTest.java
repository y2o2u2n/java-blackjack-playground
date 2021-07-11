package nextstep.blackjack.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PossibleSumsTest {

    @Test
    void equals() {
        assertEquals(PossibleSums.of(11, 21), PossibleSums.of(21, 11));
    }
}