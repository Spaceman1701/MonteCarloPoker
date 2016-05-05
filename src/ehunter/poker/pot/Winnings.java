package ehunter.poker.pot;

import ehunter.poker.player.Player;

/**
 * Created by 40501 on 5/5/2016.
 */
public class Winnings
{
    private boolean deadChips;

    private Player player;

    private int chips;

    private Winnings(Player player, int chips, boolean isDead) {
        this.player = player;
        this.chips = chips;
        this.deadChips = isDead;

        checkValidity();
    }

    public Player getTargetPlayer() {
        return player;
    }

    public int getChips() {
        return chips;
    }

    public boolean isDeadChips() {
        return deadChips;
    }

    private void checkValidity() {
        if (player != null && deadChips) {
            throw new InvalidWinningsTargetException("dead winnings targets a player!");
        } else if (player == null && !deadChips) {
            throw new InvalidWinningsTargetException("no target!");
        }
    }

    public static Winnings createPlayerWinnings(Player player, int chips) {
        return new Winnings(player, chips, false);
    }

    public static Winnings createDeadChips(int chips) {
        return new Winnings(null, chips, true);
    }
}
