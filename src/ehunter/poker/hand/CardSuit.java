package ehunter.poker.hand;

/**
 * Created by 40501 on 4/14/2016.
 */
public enum CardSuit {
    CLUBS(0, "c"), SPADES(3, "s"), HEARTS(2, "h"), DIAMONDS(1, "d"); //sorting also gives suit ranks


    private int sortingValue;
    private String shortHand;

    CardSuit(int sortingValue, String shortHand) {
        this.sortingValue = sortingValue;
        this.shortHand = shortHand;
    }

    public int getSortingValue() {
        return sortingValue;
    }

    public String getShorthand() {
        return shortHand;
    }
}
