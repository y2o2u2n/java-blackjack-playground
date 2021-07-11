package nextstep.blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {
    private Dealer dealer;
    private Player playerA;
    private Player playerB;
    private Player playerC;

    private final List<PlayingCard> dealerPlayingCards = Arrays.asList(new PlayingCard(Suit.DIAMOND, Denomination.THREE, true), new PlayingCard(Suit.CLUB, Denomination.NINE, false));
    private final List<PlayingCard> playerAPlayingCards = Arrays.asList(new PlayingCard(Suit.HEART, Denomination.TWO, true), new PlayingCard(Suit.SPADE, Denomination.EIGHT, true));
    private final List<PlayingCard> playerBPlayingCards = Arrays.asList(new PlayingCard(Suit.CLUB, Denomination.SEVEN, true), new PlayingCard(Suit.SPADE, Denomination.KING, true));
    private final List<PlayingCard> playerCPlayingCards = Arrays.asList(new PlayingCard(Suit.CLUB, Denomination.ACE, true), new PlayingCard(Suit.SPADE, Denomination.KING, true));

    @BeforeEach
    void setUp() {
        dealer = new Dealer();
        playerA = new Player("pobi");
        playerB = new Player("jason");
        playerC = new Player("y2o2u2n");

        dealer.handOut(dealer, dealerPlayingCards);
        dealer.handOut(playerA, playerAPlayingCards);
        dealer.handOut(playerB, playerBPlayingCards);
        dealer.handOut(playerC, playerCPlayingCards);
    }

    @Test
    void calculateSum() {
        assertEquals(PossibleSums.of(12), dealer.checkPossibleSums());
        assertEquals(PossibleSums.of(10), playerA.checkPossibleSums());
        assertEquals(PossibleSums.of(17), playerB.checkPossibleSums());
        assertEquals(PossibleSums.of(11, 21), playerC.checkPossibleSums());
    }
}