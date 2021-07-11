package nextstep.blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayingCardsOnHandTest {
    private PlayingCardsOnHand aPlayingCardsOnHand;
    private PlayingCardsOnHand bPlayingCardsOnHand;
    private PlayingCardsOnHand cPlayingCardsOnHand;

    private final List<PlayingCard> aPlayingCardList = Arrays.asList(new PlayingCard(Suit.HEART, Denomination.TWO, true), new PlayingCard(Suit.SPADE, Denomination.EIGHT, true));
    private final List<PlayingCard> bPlayingCardList = Arrays.asList(new PlayingCard(Suit.CLUB, Denomination.SEVEN, true), new PlayingCard(Suit.SPADE, Denomination.KING, true));
    private final List<PlayingCard> cPlayingCardList = Arrays.asList(new PlayingCard(Suit.CLUB, Denomination.ACE, true), new PlayingCard(Suit.SPADE, Denomination.KING, true));

    @BeforeEach
    void setUp() {
        aPlayingCardsOnHand = new PlayingCardsOnHand();
        aPlayingCardsOnHand.addAll(aPlayingCardList);

        bPlayingCardsOnHand = new PlayingCardsOnHand();
        bPlayingCardsOnHand.addAll(bPlayingCardList);

        cPlayingCardsOnHand = new PlayingCardsOnHand();
        cPlayingCardsOnHand.addAll(cPlayingCardList);
    }

    @Test
    void calculatePossibleSums() {
        assertEquals(PossibleSums.of(10), aPlayingCardsOnHand.calculatePossibleSums());
        assertEquals(PossibleSums.of(17), bPlayingCardsOnHand.calculatePossibleSums());
        assertEquals(PossibleSums.of(11, 21), cPlayingCardsOnHand.calculatePossibleSums());
    }
}