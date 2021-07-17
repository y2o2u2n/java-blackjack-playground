package nextstep.blackjack.view;

import nextstep.blackjack.model.Dealer;
import nextstep.blackjack.model.Person;
import nextstep.blackjack.model.Player;
import nextstep.blackjack.model.PlayingCards;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printInputPlayerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    public static void printInputPlayerBetAmount(Player player) {
        String message = String.format("%s의 배팅 금액은?", player.getName());
        System.out.println(message);
    }

    public static void printPlayingCards(
            Dealer dealer,
            List<Player> players
    ) {
        String joinedPlayerNames = players.stream().map(Player::getName).collect(Collectors.joining(", "));
        String message = String.format("%s와 %s에게 2장의 나누었습니다.", dealer.getName(), joinedPlayerNames);
        System.out.println(message);
        printPlayingCards(dealer);
        players.forEach(OutputView::printPlayingCards);
    }

    public static void printPlayingCards(Person person) {
        String name = person.getName();
        PlayingCards playingCards = person.getPlayingCards();
        String message = String.format("%s: %s", name, playingCards.toString());
        System.out.println(message);
    }
}
