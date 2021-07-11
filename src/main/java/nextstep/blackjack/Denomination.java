package nextstep.blackjack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Denomination {
    ACE(1, 11),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10);

    private final List<Integer> values;

    Denomination(int... values) {
        this.values = Arrays.stream(values).boxed().collect(Collectors.toList());
    }

    public List<Integer> getValues() {
        return values;
    }
}
