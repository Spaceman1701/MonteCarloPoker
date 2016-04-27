package ehunter.poker.pot;

import ehunter.poker.player.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by 40501 on 4/25/2016.
 */
public class Contribution {

    private HashMap<Player, Integer> contributions;

    public Contribution() {
        contributions = new HashMap<Player, Integer>();
    }

    public Contribution(Contribution copy) {
        contributions = new HashMap<Player, Integer>();

        for (Player p : copy.contributions.keySet()) {
            contributions.put(new Player(p), copy.contributions.get(p));
        }
    }

    public void addContribution(Player p, int amount) {
        if (contributions.containsKey(p)) {
            contributions.put(p, contributions.get(p) + amount);
        } else {
            contributions.put(p, amount);
        }
    }

    public int getContribution(Player p) {
        if (contributions.containsKey(p)) {
            return contributions.get(p);
        }
        return 0;
    }

    public IndividualContribution[] getSortedContributions() {
        Set<Player> keySet = contributions.keySet();
        Object[] keyArray = keySet.toArray();
        IndividualContribution[] contributionArray = new IndividualContribution[keySet.size()];

        for (int i = 0; i < contributionArray.length; i++) {
            contributionArray[i] = new IndividualContribution((Player)keyArray[i], contributions.get((Player)keyArray[i]));
        }

        Arrays.sort(contributionArray, new ContributionComparator());

        return contributionArray;
    }
}
