package nextstep.blackjack.controller;

import nextstep.blackjack.model.Bank;
import nextstep.blackjack.model.Dealer;
import nextstep.blackjack.model.Player;
import nextstep.blackjack.view.InputView;
import nextstep.blackjack.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Blackjack {
    private Dealer dealer;
    private List<Player> players;
    private Bank bank;

    public Blackjack() {
        this.dealer = new Dealer();
        this.players = new ArrayList<>();
        this.bank = new Bank();
    }

    public void start() {
        beforeStart();
    }

    private void beforeStart() {
        OutputView.printInputPlayerNames();
        List<Player> players = InputView.inputPlayerNames();
        for (Player player : players) {
            OutputView.printInputPlayerBetAmount(player);
            bank.deposit(player, InputView.inputPlayerBetAmount());
        }
    }
}
