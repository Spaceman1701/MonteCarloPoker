package ehunter.poker.hand;

/**
 * Created by 40501 on 4/14/2016.
 */
public enum CardSuit {
    CLUBS(0), SPADES(3), HEARTS(2), DIAMONDS(1); //sorting also gives suit ranks


    private int sortingValue;

    CardSuit(int sortingValue) {
        this.sortingValue = sortingValue;
    }

    public int getSortingValue() {
        return sortingValue;
    }
}
