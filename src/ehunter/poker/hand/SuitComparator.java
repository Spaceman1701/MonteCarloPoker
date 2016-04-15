package ehunter.poker.hand;

import java.util.Comparator;

/**
 * Created by Ethan on 4/14/2016.
 */
public class SuitComparator implements Comparator<Card> {
    @Override
    public int compare(Card c1, Card c2) {
        if (c1.getValue().getSortingValue() > c2.getValue().getSortingValue()) {
            return 1;
        } else if (c1.getValue().getSortingValue() < c2.getValue().getSortingValue()) {
            return -1;
        }

        return 0;
    }
}
