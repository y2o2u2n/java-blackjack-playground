package nextstep.blackjack.view;

import nextstep.blackjack.model.Player;

public class OutputView {
    public static void printInputPlayerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    public static void printInputPlayerBetAmount(Player player) {
        String message = String.format("%s의 배팅 금액은?", player.getName());
        System.out.println(message);
    }
}
