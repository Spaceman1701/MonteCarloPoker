package ehunter.poker.hand;

/**
 * Created by 40501 on 4/14/2016.
 */
public enum CardValue {
    TWO(false, 0, 1), THREE(false, 1, 2), FOUR(false, 2, 3), FIVE(false, 3, 4), SIX(false, 4, 5), SEVEN(false, 5, 6), EIGHT(false, 6, 7), NINE(false, 7, 8), TEN(false, 8, 9),
        JACK(true, 9, 10), QUEEN(true, 10, 11), KING(true, 11, 12), ACE(true, 12, 13);

    private boolean facecard;

    private int sortingValue;
    private int cardValue;

    CardValue(boolean facecard, int sortingValue, int cardValue) {
        this.facecard = facecard;
        this.sortingValue = sortingValue;
        this.cardValue = cardValue;
    }

    public boolean isFacecard() {
        return facecard;
    }

    public int getSortingValue() {
        return sortingValue;
    }

    public int getCardValue() {
        return cardValue;
    }
}
