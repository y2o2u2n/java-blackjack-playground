package nextstep.blackjack.model;

import java.util.List;

public class Dealer extends Person {
    private static final String NAME = "딜러";

    public void handOut(Person person, List<PlayingCard> playingCards) {
        person.receive(playingCards);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
