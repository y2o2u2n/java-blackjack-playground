package nextstep.blackjack.view;

import nextstep.blackjack.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Player> inputPlayerNames() {
        String input = scanner.next();
        return inputPlayerNames(input);
    }

    public static List<Player> inputPlayerNames(String input) {
        List<Player> players = new ArrayList<>();
        for (String name : input.split(",")) {
            players.add(new Player(name));
        }
        return players;
    }

    public static long inputPlayerBetAmount() {
        String input = scanner.next();
        return inputPlayerBetAmount(input);
    }

    public static long inputPlayerBetAmount(String input) {
        return Long.parseLong(input);
    }
}
