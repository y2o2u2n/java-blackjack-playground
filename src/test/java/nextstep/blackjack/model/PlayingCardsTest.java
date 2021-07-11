package nextstep.blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayingCardsTest {
    private PlayingCards aPlayingCards;
    private  PlayingCards bPlayingCards;
    private  PlayingCards cPlayingCards;

    private final List<PlayingCard> aPlayingCardList = Arrays.asList(new PlayingCard(Suit.HEART, Denomination.TWO, true), new PlayingCard(Suit.SPADE, Denomination.EIGHT, true));
    private final List<PlayingCard> bPlayingCardList = Arrays.asList(new PlayingCard(Suit.CLUB, Denomination.SEVEN, true), new PlayingCard(Suit.SPADE, Denomination.KING, true));
    private final List<PlayingCard> cPlayingCardList = Arrays.asList(new PlayingCard(Suit.CLUB, Denomination.ACE, true), new PlayingCard(Suit.SPADE, Denomination.KING, true));

    @BeforeEach
    void setUp() {
        aPlayingCards = new PlayingCards();
        aPlayingCards.addAll(aPlayingCardList);

        bPlayingCards = new PlayingCards();
        bPlayingCards.addAll(bPlayingCardList);

        cPlayingCards = new PlayingCards();
        cPlayingCards.addAll(cPlayingCardList);
    }

    @Test
    void calculatePossibleSums() {
        assertEquals(PossibleSums.of(10), aPlayingCards.calculatePossibleSums());
        assertEquals(PossibleSums.of(17), bPlayingCards.calculatePossibleSums());
        assertEquals(PossibleSums.of(11, 21), cPlayingCards.calculatePossibleSums());
    }
}