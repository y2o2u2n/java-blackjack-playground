package nextstep.blackjack.model;

import java.util.List;
import java.util.Objects;

public class PlayingCard {
    private Suit suit;
    private Denomination denomination;
    private boolean isOpened;

    public PlayingCard(Suit suit, Denomination denomination, boolean isOpened) {
        this.suit = suit;
        this.denomination = denomination;
        this.isOpened = isOpened;
    }

    public List<Integer> getDenominationValues() {
        return denomination.getValues();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayingCard playingCard = (PlayingCard) o;
        return suit == playingCard.suit && denomination == playingCard.denomination;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, denomination);
    }
}
