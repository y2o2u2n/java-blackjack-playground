package nextstep.blackjack.controller;

import nextstep.blackjack.model.Bank;
import nextstep.blackjack.model.Dealer;
import nextstep.blackjack.model.Deck;
import nextstep.blackjack.model.Player;
import nextstep.blackjack.view.InputView;
import nextstep.blackjack.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Blackjack {
    private final Dealer dealer;
    private final List<Player> players;
    private final Deck deck;
    private final Bank bank;

    public Blackjack() {
        dealer = new Dealer();
        players = new ArrayList<>();
        deck = new Deck();
        bank = new Bank();
    }

    public void start() {
        beforeStart();
        shuffleDeck();
        initialHandOut();
    }

    private void beforeStart() {
        OutputView.printInputPlayerNames();
        List<Player> players = InputView.inputPlayerNames();
        this.players.addAll(players);
        this.players.forEach(player -> {
            OutputView.printInputPlayerBetAmount(player);
            bank.deposit(player, InputView.inputPlayerBetAmount());
        });
    }

    private void shuffleDeck() {
        deck.shuffle();
    }

    private void initialHandOut() {
        dealer.handOut(dealer, deck.draw(2));
        players.forEach(player -> dealer.handOut(player, deck.draw(2)));
        OutputView.printDealPlayingCards(dealer, players);
    }
}
