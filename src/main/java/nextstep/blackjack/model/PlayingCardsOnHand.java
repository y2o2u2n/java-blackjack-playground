package nextstep.blackjack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayingCardsOnHand {
    private final List<PlayingCard> playingCards;

    public PlayingCardsOnHand() {
        this.playingCards = new ArrayList<>();
    }

    public void addAll(List<PlayingCard> playingCards) {
        this.playingCards.addAll(playingCards);
    }

    public PossibleSums calculatePossibleSums() {
        List<Integer> possibleSums = new ArrayList<>();
        perm(playingCards, possibleSums, 0, 0);

        return PossibleSums.of(possibleSums.stream().distinct().mapToInt(i -> i).toArray());
    }

    private void perm(
            List<PlayingCard> playingCards,
            List<Integer> possibleSums,
            int index,
            int acc
    ) {
        if (playingCards.size() == index) {
            possibleSums.add(acc);
            return;
        }

        PlayingCard playingCard = playingCards.get(index);
        Denomination denomination = playingCard.getDenomination();
        perm(playingCards, possibleSums, index + 1, acc + denomination.getValue());
        if (denomination.isAce()) {
            perm(playingCards, possibleSums, index + 1, acc + 11);
        }
    }

    @Override
    public String toString() {
        return playingCards.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
