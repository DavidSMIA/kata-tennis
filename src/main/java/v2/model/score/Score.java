package v2.model.score;

import v2.model.Player;

public abstract class Score {

    protected Player player1;
    protected Player player2;

    public Score(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public abstract boolean canApply();

    public abstract String display();
}
