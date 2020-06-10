package v2.model.score;

import v2.model.Player;

public class DeuceScore extends Score {

    public DeuceScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public boolean canApply() {
        return player1.isDeuce(player2);
    }

    @Override
    public String display() {
        return "DEUCE";
    }
}
