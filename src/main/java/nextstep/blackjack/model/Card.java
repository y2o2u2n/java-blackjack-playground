package nextstep.blackjack.model;

import java.util.Objects;

public class Card {
    private Suit suit;
    private Denomination denomination;

    public Card(Suit suit, Denomination denomination) {
        this(suit, denomination, false);
    }

    public Card(Suit suit, Denomination denomination, boolean isOpened) {
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
        Card card = (Card) o;
        return suit == card.suit && denomination == card.denomination;
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
