package nextstep.blackjack.model;

import java.util.List;

public abstract class Person {
    private final Cards cards;

    public Person() {
        this.cards = new Cards();
    }

    protected void receive(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public PossibleSums checkPossibleSums() {
        return cards.calculatePossibleSums();
    }

    public abstract String getName();

    public Cards getPlayingCards() {
        return cards;
    }
}
