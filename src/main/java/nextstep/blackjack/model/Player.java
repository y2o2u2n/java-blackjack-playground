package nextstep.blackjack.model;

public class Player extends Person {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
