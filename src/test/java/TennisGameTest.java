import v1.TennisGame;
import v1.model.Player;
import v1.model.Score;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.stream.IntStream;

public class TennisGameTest {


    Player player1 = new Player("Djoko");
    Player player2 = new Player("Nadal");
    TennisGame tennisGame = null;

    @BeforeEach
    public void init() {
        tennisGame = new TennisGame(player1, player2);
    }

    @Test
    public void newGameShouldReturnLoveToLove() {
        Assertions.assertThat(tennisGame.getScore()).isEqualTo(Score.LOVE+"-"+Score.LOVE);
    }

    @Test
    public void playerWinFirstPointShouldSetHisScoreToOne() {
        tennisGame.winPoint(player1);
        Assertions.assertThat(player1.getNbPoint()).isEqualTo(1);
    }


    @ParameterizedTest(name = "Score {0} to {1} should display {2}")
    @CsvSource({
            "0,4,GAME Nadal",
            "1,4,GAME Nadal",
            "2,4,GAME Nadal",
            "3,5,GAME Nadal",
            "4,6,GAME Nadal",
            "4,0,GAME Djoko",
            "4,0,GAME Djoko",
            "4,1,GAME Djoko",
            "4,2,GAME Djoko",
            "5,3,GAME Djoko",
            "6,4,GAME Djoko",
            "18,16,GAME Djoko",
    })
    public void shouldDisplayWinner(int player1Points, int player2Points, String expectedScore) {
        runGame(player1Points, player2Points);
        Assertions.assertThat(tennisGame.getScore()).isEqualTo(expectedScore);
    }

    @ParameterizedTest(name = "Score {0} to {1} should display {2}")
    @CsvSource({
            "3,3,DEUCE",
            "4,4,DEUCE",
            "5,5,DEUCE",
            "6,6,DEUCE",
    })
    public void shouldDisplayDeuce(int player1Points, int player2Points, String expectedScore) {
        runGame(player1Points, player2Points);
        Assertions.assertThat(tennisGame.getScore()).isEqualTo(expectedScore);
    }

    @ParameterizedTest(name = "Score {0} to {1} should display {2}")
    @CsvSource({
            "4,3,ADVANTAGE Djoko",
            "3,4,ADVANTAGE Nadal",
            "5,4,ADVANTAGE Djoko",
            "4,5,ADVANTAGE Nadal",
    })
    public void shouldDisplayAdvantage(int player1Points, int player2Points, String expectedScore) {
        runGame(player1Points, player2Points);
        Assertions.assertThat(tennisGame.getScore()).isEqualTo(expectedScore);
    }

    @ParameterizedTest(name = "Score {0} to {1} should display {2}")
    @CsvSource({
            "0,1,LOVE-FIFTEEN",
            "0,2,LOVE-THIRTY",
            "0,3,LOVE-FORTY",
            "1,0,FIFTEEN-LOVE",
            "2,0,THIRTY-LOVE",
            "3,0,FORTY-LOVE",
            "1,0,FIFTEEN-LOVE",
            "1,1,FIFTEEN-FIFTEEN",
            "1,2,FIFTEEN-THIRTY",
            "2,1,THIRTY-FIFTEEN",
            "2,2,THIRTY-THIRTY",
            "3,1,FORTY-FIFTEEN",
            "3,2,FORTY-THIRTY",
            "2,3,THIRTY-FORTY",
    })
    public void shouldDisplayPlayerScore(int player1Points, int player2Points, String expectedScore) {
        runGame(player1Points, player2Points);
        Assertions.assertThat(tennisGame.getScore()).isEqualTo(expectedScore);
    }

    private void runGame(int player1Points, int player2Points) {
        IntStream.range(0, player1Points).forEach( i -> tennisGame.winPoint(player1));
        IntStream.range(0, player2Points).forEach( i -> tennisGame.winPoint(player2));
    }

}