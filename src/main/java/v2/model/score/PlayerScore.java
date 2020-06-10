package v2.model.score;

import v2.model.Player;

public class PlayerScore extends Score {

    public PlayerScore(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public boolean canApply() {
        return player1.getNbPoint() <=3 && player1.getNbPoint() <= 3;
    }

    @Override
    public String display() {
        return PlayerScoreValue.fromNbPoint(player1.getNbPoint())+"-"+PlayerScoreValue.fromNbPoint(player2.getNbPoint());
    }
}
