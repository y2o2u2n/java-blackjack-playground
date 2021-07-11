package nextstep.blackjack;

import java.util.*;

public class PossibleSums {
    private final Set<Integer> sums;

    public PossibleSums(int[] sums) {
        this.sums = new HashSet<>();

        for( int sum : sums) {
            this.sums.add(sum);
        }
    }

    public static PossibleSums of(int... sums) {
        return new PossibleSums(sums);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PossibleSums that = (PossibleSums) o;
        return Objects.equals(sums, that.sums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sums);
    }
}
