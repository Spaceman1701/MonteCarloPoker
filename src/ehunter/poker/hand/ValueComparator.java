package ehunter.poker.hand;

import java.util.Comparator;

/**
 * Created by Ethan on 4/14/2016.
 */
public class ValueComparator implements Comparator<Card> {

    public int compare(Card c1, Card c2) {

        if (c1.equals(c2)) {
            return 0;
        }

        if (c1.getValue().getSortingValue() > c2.getValue().getSortingValue()) {
            return 1;
        } else if (c1.getValue().getSortingValue() < c2.getValue().getSortingValue()) {
            return -1;
        } else { //if they are equal value, compare by suit
            return new SuitComparator().compare(c1, c2);
        }
    }
}
