package v2.model.score;

import v2.model.Player;

public class AdvantageScore extends Score {

    public AdvantageScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public boolean canApply() {
        return player1.hasAdvantage(player2) || player2.hasAdvantage(player1);
    }

    @Override
    public String display() {
        Player advantagePlayer = player1.hasAdvantage(player2) ? player1 : player2;
        return "ADVANTAGE "+advantagePlayer.getName();
    }
}
