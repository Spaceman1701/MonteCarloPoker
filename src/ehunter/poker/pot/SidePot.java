package ehunter.poker.pot;

import ehunter.poker.player.Player;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 40501 on 4/25/2016.
 */
public class SidePot {
    private int value;

    private Set<Player> contributors;

    public SidePot(int value, Player[] contributors) {
        this.contributors = new HashSet<Player>();
        addAllUnfolded(contributors);
    }

    private void addAllUnfolded(Player[] contributors) {
        for(Player p : contributors) {
            if (!p.isFolded()) {
                this.contributors.add(p);
            }
        }
    }

    public boolean sharesContributors(SidePot other) {
        if (other.getContributors().size() != getContributors().size()) {
            return false;
        }

        for (Player p : getContributors()) {
            if (!other.getContributors().contains(p)) {
                return false;
            }
        }

        return true;
    }

    public Set<Player> getContributors() {
        return contributors;
    }

    public int getValue() {
        return value;
    }

    public void addValue(int v) {
        value += v;
    }

}
