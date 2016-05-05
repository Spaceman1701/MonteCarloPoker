package ehunter.poker.hand;

import java.util.Comparator;

/**
 * Created by Ethan on 4/14/2016.
 */
public class SuitComparator implements Comparator<Card> {
    @Override
    public int compare(Card c1, Card c2) {

        if (c1.equals(c2)) {
            return 0;
        }

        if (c1.getSuit().getSortingValue() > c2.getSuit().getSortingValue()) {
            return 1;
        } else if (c1.getSuit().getSortingValue() < c2.getSuit().getSortingValue()) {
            return -1;
        } else {// If they are equal suit, sort by value
            return new ValueComparator().compare(c1, c2);
        }
    }
}
