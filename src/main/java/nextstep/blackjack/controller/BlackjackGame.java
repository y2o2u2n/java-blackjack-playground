package nextstep.blackjack.controller;

import nextstep.blackjack.model.Dealer;
import nextstep.blackjack.model.Deck;
import nextstep.blackjack.model.Player;
import nextstep.blackjack.view.InputView;
import nextstep.blackjack.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BlackjackGame {
    private final Dealer dealer;
    private final List<Player> players;
    private final Deck deck;

    public BlackjackGame() {
        dealer = new Dealer();
        players = new ArrayList<>();
        deck = new Deck();
    }

    public void start() {
        beforeStart();
        initialDealCards();
    }

    private void beforeStart() {
        OutputView.printInputPlayerNames();
        List<Player> players = InputView.inputPlayerNames();
        this.players.addAll(players);
        this.players.forEach(player -> {
            OutputView.printInputPlayerBetAmount(player);
            player.decideBetAmount(InputView.inputPlayerBetAmount());
        });
    }

    private void initialDealCards() {
        deck.dealCards(dealer, 2);
        players.forEach(player -> deck.dealCards(player, 2));
        OutputView.printPlayingCards(dealer, players);
    }
}
