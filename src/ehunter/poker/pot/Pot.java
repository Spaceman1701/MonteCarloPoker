package ehunter.poker.pot;

import ehunter.poker.player.*;
import javafx.geometry.Side;

import java.lang.reflect.Array;
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

    protected void setContributions(Contribution c) {
        playerContributions = c;
    }

    public void bet(Bet b) {
        playerContributions.addContribution(b.getPlayer(), b.getAmount());
    }

    public SidePot[] getPots() { //Doesn't handle folded players yet
        IndividualContribution[] contributions = playerContributions.getSortedContributions();

        Set<IndividualContribution> contributionSet = new HashSet<IndividualContribution>();
        contributionSet.addAll(Arrays.asList(contributions));

        List<SidePot> pots = new ArrayList<SidePot>();

        int sidePotValue = -1;
        SidePot currentPot = null;
        for (IndividualContribution c : contributions) {
            int value = c.getAmount();

            if (value > sidePotValue) {
                sidePotValue = value;
                currentPot = new SidePot(value * contributionSet.size(),value , getPlayers(contributionSet));
                pots.add(currentPot);
                for (IndividualContribution c2 : contributions) {
                    c2.useAmount(value);
                }
                sidePotValue = 0;
            }

            contributionSet.remove(c);
        }

        List<SidePot> condensedPots = new ArrayList<SidePot>();

        for (int i = 0; i < pots.size(); i++) {
            SidePot potI = pots.get(i);

            if (i == pots.size() - 1) {
                condensedPots.add(potI);
                System.out.println("add final pot " + potI.getContraValue());
                break;
            }

            SidePot nextPot = pots.get(i + 1);

            if (potI.sharesContributors(nextPot)) {
                nextPot.addValue(potI.getValue());
                //condensedPots.add(nextPot);
                System.out.println("pot merged " + potI.getContraValue() + " " + potI.getContributors().size());
            } else {
                condensedPots.add(potI);
                //condensedPots.add(nextPot);
                System.out.println("pot added " + potI.getContraValue() + " " + potI.getContributors().size());

                //System.out.println("pot added " + nextPot.getContraValue() + " " + nextPot.getContributors().size());
               // i++;
            }
        }

        SidePot[] sidePots = new SidePot[condensedPots.size()];

        condensedPots.toArray(sidePots);

        return sidePots;
    }

    private Player[] getPlayers(Set<IndividualContribution> contributionSet) {
        Player[] players = new Player[contributionSet.size()];
        Object[] objects = contributionSet.toArray();

        for(int i = 0; i < players.length; i++) {
            players[i] = ((IndividualContribution)objects[i]).getPlayer();
        }

        return players;
    }
}
