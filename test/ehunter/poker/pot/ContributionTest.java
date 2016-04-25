package ehunter.poker.pot;

import ehunter.poker.player.Player;
import org.junit.Test;

/**
 * Created by 40501 on 4/25/2016.
 */
public class ContributionTest {

    @Test
    public void testGetSortedContributions() {
        Contribution contribution = new Contribution();

        Player a = new Player();
        Player b = new Player();
        Player c = new Player();
        Player d = new Player();

        contribution.addContribution(a, 140);
        contribution.addContribution(b, 70);
        contribution.addContribution(c, 40);
        contribution.addContribution(d, 140);

        IndividualContribution[] expected = new IndividualContribution[] { //ish
                new IndividualContribution(a, 40),
                new IndividualContribution(b, 70),
                new IndividualContribution(c, 140),
                new IndividualContribution(d, 140)
        };
        IndividualContribution[] result = contribution.getSortedContributions();

        for (int i = 0; i < 4; i++) {
            assert result[i].getAmount() == expected[i].getAmount();
        }

    }
}
