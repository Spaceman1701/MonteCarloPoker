package ehunter.poker.hand;

/**
 * Created by 40501 on 4/14/2016.
 */
public enum CardValue {
    TWO(false, 0, 1, "2"), THREE(false, 1, 2, "3"), FOUR(false, 2, 3, "4"), FIVE(false, 3, 4, "5"), SIX(false, 4, 5, "6"),
        SEVEN(false, 5, 6, "7"), EIGHT(false, 6, 7, "8"), NINE(false, 7, 8, "9"), TEN(false, 8, 9, "10"),
        JACK(true, 9, 10, "J"), QUEEN(true, 10, 11, "Q"), KING(true, 11, 12, "K"), ACE(true, 12, 13, "A");

    private boolean facecard;

    private int sortingValue;
    private int cardValue;
    private String shortHand;

    CardValue(boolean facecard, int sortingValue, int cardValue, String shorthand) {
        this.facecard = facecard;
        this.sortingValue = sortingValue;
        this.cardValue = cardValue;
        this.shortHand = shorthand;
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

    public String getShortHand() {
        return shortHand;
    }
}
