package nextstep.blackjack.model;

import java.util.List;

public abstract class Person {
    private final PlayingCardsOnHand playingCardsOnHand;

    public Person() {
        this.playingCardsOnHand = new PlayingCardsOnHand();
    }

    protected void receive(List<PlayingCard> playingCards) {
        this.playingCardsOnHand.addAll(playingCards);
    }

    public PossibleSums checkPossibleSums() {
        return playingCardsOnHand.calculatePossibleSums();
    }

    public abstract String getName();

    public PlayingCardsOnHand getPlayingCards() {
        return playingCardsOnHand;
    }
}
