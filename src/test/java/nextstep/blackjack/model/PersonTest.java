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

    private final List<Card> dealerCards = Arrays.asList(new Card(Suit.DIAMOND, Denomination.THREE, true), new Card(Suit.CLUB, Denomination.NINE, false));
    private final List<Card> playerACards = Arrays.asList(new Card(Suit.HEART, Denomination.TWO, true), new Card(Suit.SPADE, Denomination.EIGHT, true));
    private final List<Card> playerBCards = Arrays.asList(new Card(Suit.CLUB, Denomination.SEVEN, true), new Card(Suit.SPADE, Denomination.KING, true));
    private final List<Card> playerCCards = Arrays.asList(new Card(Suit.CLUB, Denomination.ACE, true), new Card(Suit.SPADE, Denomination.KING, true));

    @BeforeEach
    void setUp() {
        dealer = new Dealer();
        playerA = new Player("pobi");
        playerB = new Player("jason");
        playerC = new Player("y2o2u2n");

        dealer.handOut(dealer, dealerCards);
        dealer.handOut(playerA, playerACards);
        dealer.handOut(playerB, playerBCards);
        dealer.handOut(playerC, playerCCards);
    }

    @Test
    void calculateSum() {
        assertEquals(PossibleSums.of(12), dealer.checkPossibleSums());
        assertEquals(PossibleSums.of(10), playerA.checkPossibleSums());
        assertEquals(PossibleSums.of(17), playerB.checkPossibleSums());
        assertEquals(PossibleSums.of(11, 21), playerC.checkPossibleSums());
    }
}