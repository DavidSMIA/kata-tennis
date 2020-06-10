package v2;

import io.vavr.collection.List;
import io.vavr.control.Option;
import v2.model.Player;
import v2.model.score.*;

import java.util.Random;

public class TennisGame {

    private Player player1;
    private Player player2;
    private Score score;

    public TennisGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String displayScore() {
        score = generatePossibleScores().filter(Score::canApply).get();
        return score.display();
    }

   private List<Score> generatePossibleScores() {
        return List.of(new AdvantageScore(player1, player2),
                new DeuceScore(player1, player2),
                new GameScore(player1, player2),
                new PlayerScore(player1, player2));
   }

   public void winPoint(Player winner) {
        winner.addPoint();
    }

    public boolean isOver() {
        return score instanceof GameScore;
    }

    public void runPoint() {
        Random r = new Random();
        Player winnerPlayer = r.ints(0, 2).findFirst().getAsInt() == 0 ? player1 : player2;
        System.out.println("Point for "+winnerPlayer.getName());
        winPoint(winnerPlayer);

    }
}
