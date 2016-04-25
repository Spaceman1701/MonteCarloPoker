package ehunter.poker.pot;

import java.util.Comparator;

/**
 * Created by 40501 on 4/25/2016.
 */
public class PotComparator implements Comparator<InternalPot> {
    @Override
    public int compare(InternalPot o1, InternalPot o2) {
        if (o1.getMinimumBet() < o2.getMinimumBet()) {
            return 1;
        } else if (o2.getMinimumBet() < o1.getMinimumBet()) {
            return -1;
        }

        return 0;
    }
}
