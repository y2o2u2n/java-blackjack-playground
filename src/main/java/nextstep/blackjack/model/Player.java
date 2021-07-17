package nextstep.blackjack.model;

public class Player extends Person {
	private final String name;
	private Integer betAmount;

	public Player(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public void decideBetAmount(int betAmount) {
		this.betAmount = betAmount;
	}

	public int getBetAmount() {
		return betAmount;
	}
}
