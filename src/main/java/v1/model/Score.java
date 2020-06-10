package v1.model;

//“love”, “fifteen”, “thirty”, and “forty” respectively.
public enum Score {
    LOVE, FIFTEEN, THIRTY, FORTY, DEUCE, GAME, ADVANTAGE;


    public static Score fromNbPoint(int nbPoint) {
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
