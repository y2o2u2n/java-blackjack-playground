package nextstep.blackjack.view;

import nextstep.blackjack.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private List<Player> players;

    @BeforeEach
    void setUp() {
        players = InputView.inputPlayerNames("pobi,jason");
    }

    @Test
    void inputPlayerNames() {
        assert players != null;

        assertEquals(2, players.size());
        assertEquals("pobi", players.get(0).getName());
        assertEquals("jason", players.get(1).getName());
    }

    @Test
    void inputPlayerBetAmount() {
        assertEquals(100L, InputView.inputPlayerBetAmount("100"));
    }
}