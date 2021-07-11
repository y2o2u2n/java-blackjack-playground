package nextstep.blackjack;

import java.util.List;

public class Dealer extends Person {
    public void handOut(Person person, List<PlayingCard> playingCards) {
        person.receive(playingCards);
    }
}
