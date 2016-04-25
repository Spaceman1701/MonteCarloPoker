package ehunter.poker.pot;

import ehunter.poker.player.Player;

/**
 * Created by 40501 on 4/25/2016.
 */
public class IndividualContribution {
    private Player p;

    private int amount;

    public IndividualContribution(Player p, int amount) {
        this.p = p;
        this.amount = amount;
    }

    public Player getPlayer() {
        return p;
    }

    public int getAmount() {
        return amount;
    }

    public int useAmount(int amount) {
        this.amount -= amount;
        return amount;
    }
}
