package nextstep.blackjack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cards {
    private final List<Card> cards;

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public void addAll(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public PossibleSums calculatePossibleSums() {
        List<Integer> possibleSums = new ArrayList<>();
        perm(cards, possibleSums, 0, 0);

        return PossibleSums.of(possibleSums.stream().distinct().mapToInt(i -> i).toArray());
    }

    private void perm(
            List<Card> cards,
            List<Integer> possibleSums,
            int index,
            int acc
    ) {
        if (cards.size() == index) {
            possibleSums.add(acc);
            return;
        }

        Card card = cards.get(index);
        Denomination denomination = card.getDenomination();
        perm(cards, possibleSums, index + 1, acc + denomination.getValue());
        if (denomination.isAce()) {
            perm(cards, possibleSums, index + 1, acc + 11);
        }
    }

    @Override
    public String toString() {
        return cards.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
