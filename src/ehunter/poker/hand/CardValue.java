package ehunter.poker.hand;

/**
 * Created by 40501 on 4/14/2016.
 */
public enum CardValue {
    TWO(false), THREE(false), FOUR(false), FIVE(false), SIX(false), SEVEN(false), EIGHT(false), NINE(false), TEN(false),
        JACK(true), QUEEN(true), KING(true), ACE(true);

    private boolean facecard;

    CardValue(boolean facecard) {
        this.facecard = facecard;
    }

    public boolean isFacecard() {
        return facecard;
    }
}
