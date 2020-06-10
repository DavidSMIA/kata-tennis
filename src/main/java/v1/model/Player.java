package v1.model;

import static java.lang.Math.abs;

public class Player {
    private String name;
    private int nbPoint;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPoint() {
        nbPoint = nbPoint + 1;
    }

    public int getNbPoint() {
        return nbPoint;
    }

    public Score getScore() {
        return Score.fromNbPoint(nbPoint);
    }

    public boolean canWin() {
        return getNbPoint() > 3 ;
    }

    public boolean hasAdvantage(Player opponent) {
        int pointsDiff = nbPoint - opponent.getNbPoint();
        return canWin() && pointsDiff == 1;
    }

    public boolean isDeuce(Player opponent) {
        return nbPoint >= 3 && opponent.getNbPoint() == nbPoint;
    }

    public boolean hasWon(Player opponent) {
        boolean hasEnoughDiff = nbPoint - opponent.getNbPoint() >= 2;
        return canWin() && hasEnoughDiff;
    }
}
