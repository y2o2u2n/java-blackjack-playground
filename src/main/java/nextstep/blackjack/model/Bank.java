package nextstep.blackjack.model;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<Player, Long> betAmountByPlayer;

    public Bank() {
        this.betAmountByPlayer = new HashMap<>();
    }

    public void deposit(Player player, long betAmount) {
        betAmountByPlayer.put(player, betAmount);
    }
}
