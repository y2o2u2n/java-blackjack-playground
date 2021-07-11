package nextstep.blackjack;

import java.util.List;

public abstract class Person {
    private PlayingCards playingCards;

    public Person() {
        this.playingCards = new PlayingCards();
    }

    protected void receive(List<PlayingCard> playingCards) {
        this.playingCards.addAll(playingCards);
    }

    public PossibleSums checkPossibleSums() {
        return playingCards.calculatePossibleSums();
    }
}
