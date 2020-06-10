package v1;

import v1.model.Player;

public class RollandGarros {


    public static void main(String[] args) {

        Player player1 = new Player("Djoko");
        Player player2 = new Player("Nadal");
        TennisGame tennisGame = new TennisGame(player1, player2);
        System.out.println("Start Tennis Game between " + player1.getName() + " and " + player2.getName());
        while (!tennisGame.isOver()) {
            tennisGame.runPoint();
            System.out.println(tennisGame.getScore());
        }
    }
}


