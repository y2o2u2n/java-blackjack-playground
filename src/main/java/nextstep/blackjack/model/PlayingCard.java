package nextstep.blackjack.model;

import java.util.Objects;

public class PlayingCard {
    private Suit suit;
    private Denomination denomination;

    public PlayingCard(Suit suit, Denomination denomination) {
        this(suit, denomination, false);
    }

    public PlayingCard(Suit suit, Denomination denomination, boolean isOpened) {
        this.suit = suit;
        this.denomination = denomination;
    }

    public Suit getSuit() {
        return suit;
    }

    public Denomination getDenomination() {
        return denomination;
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

    @Override
    public String toString() {
        return String.format("%s%s", denomination.getName(), suit.getName());
    }
}
