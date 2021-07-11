package nextstep.blackjack.model;

import java.util.*;

public class Deck {
    private static final Set<PlayingCard> PLAYING_CARDS;

    static {
        PLAYING_CARDS = new HashSet<>();
        Arrays.stream(Suit.values()).forEach(
                suit -> Arrays.stream(Denomination.values()).forEach(
                        denomination -> PLAYING_CARDS.add(new PlayingCard(suit, denomination))
                )
        );
    }

    private final Stack<PlayingCard> playingCards;

    public Deck() {
        playingCards = new Stack<>();
        playingCards.addAll(PLAYING_CARDS);
    }

    public void shuffle() {
        Collections.shuffle(playingCards);
    }

    public List<PlayingCard> draw(int count) {
        List<PlayingCard> draw = new ArrayList<>();
        while (count-- > 0) {
            draw.add(playingCards.pop());
        }
        return draw;
    }
}
