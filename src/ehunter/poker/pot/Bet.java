package ehunter.poker.pot;

import ehunter.poker.player.Player;

/**
 * Created by 40501 on 4/25/2016.
 */
public class Bet {
    private final Player player;
    private final int amount;


    public Bet(Player p, int amount) {
        this.player = p;
        this.amount = amount;
    }

    public Player getPlayer() {
        return player;
    }

    public int getAmount() {
        return amount;
    }
}
