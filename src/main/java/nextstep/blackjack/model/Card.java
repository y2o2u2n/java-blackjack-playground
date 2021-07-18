package nextstep.blackjack.model;

import java.util.Objects;

public class Card {
	private final Suit suit;
	private final Denomination denomination;

	public Card(Suit suit, Denomination denomination) {
		this.suit = suit;
		this.denomination = denomination;
	}

	public Denomination getDenomination() {
		return denomination;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Card card = (Card)o;
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

	public boolean isAce() {
		return denomination == Denomination.ACE;
	}

	public boolean isKqj() {
		return denomination == Denomination.KING
			|| denomination == Denomination.QUEEN
			|| denomination == Denomination.JACK;
	}
}
