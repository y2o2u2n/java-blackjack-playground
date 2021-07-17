package nextstep.blackjack.model;

import java.util.List;

public abstract class Person {
    private final PlayingCards playingCards;

    public Person() {
        this.playingCards = new PlayingCards();
    }

    protected void receive(List<Card> playingCards) {
        this.playingCards.addAll(playingCards);
    }

    public abstract String getName();

    public PlayingCards getPlayingCards() {
        return playingCards;
    }
}
