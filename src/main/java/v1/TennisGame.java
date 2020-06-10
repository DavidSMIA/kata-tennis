package v1;

import io.vavr.control.Option;
import v1.model.Player;
import v1.model.Score;

import java.util.Random;

public class TennisGame {

    private Player player1;
    private Player player2;

    private Player winner;

    public TennisGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {
        return displayWinner()
                .orElse(displayAdvantage())
                .orElse(displayDeuce())
                .getOrElse(displayPlayersScore());
    }

    private Option<String> displayAdvantage() {

            if (player1.hasAdvantage(player2)) {
                return Option.of(Score.ADVANTAGE + " " + player1.getName());
            }
            if (player2.hasAdvantage(player1)) {
                return Option.of(Score.ADVANTAGE + " " + player2.getName());
            }
        return Option.none();
    }

    private Option<String> displayDeuce() {
        if (player1.isDeuce(player2)) {
            return Option.of(Score.DEUCE.name());
        }
        return Option.none();
    }

    private Option<String> displayWinner() {
        if (player1.hasWon(player2)) {
                winner = player1;
                return Option.of(Score.GAME + " " + player1.getName());
        }
        if (player2.hasWon(player1)) {
            winner = player2;
            return Option.of(Score.GAME + " " + player2.getName());
        }
        return Option.none();
    }

    public void winPoint(Player winner) {
        winner.addPoint();
    }

    private String displayPlayersScore() {
        return player1.getScore() + "-" + player2.getScore();
    }

    public boolean isOver() {
        return winner != null;
    }

    public void runPoint() {
        Random r = new Random();
        Player winnerPlayer = r.ints(0, 2).findFirst().getAsInt() == 0 ? player1 : player2;
        System.out.println("Point for "+winnerPlayer.getName());
        winPoint(winnerPlayer);
    }
}
