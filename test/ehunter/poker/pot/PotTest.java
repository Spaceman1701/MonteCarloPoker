package ehunter.poker.pot;

import ehunter.poker.player.Player;
import org.junit.Test;

/**
 * Created by 40501 on 4/25/2016.
 */
public class PotTest {


    @Test
    public void testGetPots() {
        Contribution contribution = new Contribution();

        Player a = new Player();
        Player b = new Player();
        Player c = new Player();
        Player d = new Player();
        Player e = new Player();
        e.fold();

        contribution.addContribution(a, 140);
        contribution.addContribution(b, 70);
        contribution.addContribution(c, 40);
        contribution.addContribution(d, 140);
        //contribution.addContribution(e, 60);

        Pot p = new Pot();

        p.setContributions(contribution);

        SidePot[] pots = p.getPots();

        assert pots.length == 3 : "wrong number of pots = " + pots.length;
    }
}
