package ehunter.poker.pot;

import ehunter.poker.player.*;

import java.util.*;

/**
 * Created by 40501 on 4/22/2016.
 */
public class Pot {
    //Handle side pots

    private Contribution playerContributions;

    public Pot() {
        playerContributions = new Contribution();

    }

    public void bet(Bet b) {
        playerContributions.addContribution(b.getPlayer(), b.getAmount());
    }

    public SidePot[] getPots() {
        IndividualContribution[] contributions = playerContributions.getSortedContributions();
        return null;
    }
}
