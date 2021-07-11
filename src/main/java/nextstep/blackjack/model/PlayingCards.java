package nextstep.blackjack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayingCards {
    private final List<PlayingCard> playingCards;

    public PlayingCards() {
        this.playingCards = new ArrayList<>();
    }

    public void addAll(List<PlayingCard> playingCards) {
        this.playingCards.addAll(playingCards);
    }

    public PossibleSums calculatePossibleSums() {
        List<List<Integer>> denominationValuesList = playingCards.stream()
                .map(PlayingCard::getDenominationValues)
                .collect(Collectors.toList());

        List<Integer> possibleSums = new ArrayList<>();
        perm(denominationValuesList, possibleSums, 0, 0);

        return PossibleSums.of(possibleSums.stream().distinct().mapToInt(i -> i).toArray());
    }

    private void perm(
            List<List<Integer>> denominationValuesList,
            List<Integer> possibleSums,
            int index,
            int acc
    ) {
        if (denominationValuesList.size() == index) {
            possibleSums.add(acc);
            return;
        }

        List<Integer> denominationValues = denominationValuesList.get(index);
        for (int denominationValue : denominationValues) {
            perm(denominationValuesList, possibleSums, index + 1, acc + denominationValue);
        }
    }
}
