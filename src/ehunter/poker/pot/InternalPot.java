package ehunter.poker.pot;

import ehunter.poker.player.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by 40501 on 4/25/2016.
 */
public class InternalPot {
    private int minimumBet;


    private Set<Player> playerStakes;

    private Contribution totalContributions;

    //minbet = creaiton amount initialize all playerbets to minbet
    //subract from playerbet
    //if playerBets.get(player) == 0

    private ChipHolder chips;

    public InternalPot(int minimumBet) {
        this.minimumBet = minimumBet;

        chips = new ChipHolder(0);

        playerStakes = new HashSet<Player>();

        totalContributions = new Contribution();
    }

    public boolean playerHasStakes(Player p) {
        return playerStakes.contains(p);
    }

    public void playerBet(Bet b) {
        if (b.getAmount() != 0) {
            if (!playerStakes.contains(b.getPlayer())) {
                playerStakes.add(b.getPlayer());
            }
            totalContributions.addContribution(b.getPlayer(), b.getAmount());
            chips.addChips(b.getAmount());
        }
    }

    public boolean playerFold(Player p) {
        return playerStakes.remove(p);
    }

    public int getContribution(Player p) {
        return totalContributions.getContribution(p);
    }

    public boolean noStakes() {
        return playerStakes.isEmpty();
    }

    public int getMinimumBet() {
        return minimumBet;
    }

}
