package v2.model.score;

public enum PlayerScoreValue {

    LOVE, FIFTEEN, THIRTY, FORTY;

    public static PlayerScoreValue fromNbPoint(int nbPoint) {
        switch (nbPoint) {
            case 3:
                return FORTY;
            case 2:
                return THIRTY;
            case 1:
                return FIFTEEN;
            case 0:
                return LOVE;
        }
        return null;
    }
}

