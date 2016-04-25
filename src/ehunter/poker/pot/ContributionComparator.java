package ehunter.poker.pot;

import java.util.Comparator;

/**
 * Created by 40501 on 4/25/2016.
 */
public class ContributionComparator implements Comparator<IndividualContribution> {
    @Override
    public int compare(IndividualContribution o1, IndividualContribution o2) {
        if (o1.getAmount() > o2.getAmount()) {
            return 1;
        } else if (o1.getAmount() < o2.getAmount()) {
            return -1;
        }

        return 0;
    }
}
