package nextstep.blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardsOnHandTest {
    private Cards aCards;
    private Cards bCards;
    private Cards cCards;

    private final List<Card> aCardList = Arrays.asList(new Card(Suit.HEART, Denomination.TWO, true), new Card(Suit.SPADE, Denomination.EIGHT, true));
    private final List<Card> bCardList = Arrays.asList(new Card(Suit.CLUB, Denomination.SEVEN, true), new Card(Suit.SPADE, Denomination.KING, true));
    private final List<Card> cCardList = Arrays.asList(new Card(Suit.CLUB, Denomination.ACE, true), new Card(Suit.SPADE, Denomination.KING, true));

    @BeforeEach
    void setUp() {
        aCards = new Cards();
        aCards.addAll(aCardList);

        bCards = new Cards();
        bCards.addAll(bCardList);

        cCards = new Cards();
        cCards.addAll(cCardList);
    }

    @Test
    void calculatePossibleSums() {
        assertEquals(PossibleSums.of(10), aCards.calculatePossibleSums());
        assertEquals(PossibleSums.of(17), bCards.calculatePossibleSums());
        assertEquals(PossibleSums.of(11, 21), cCards.calculatePossibleSums());
    }
}