package ehunter.poker.pot;

import ehunter.poker.player.Player;

/**
 * Created by 40501 on 4/22/2016.
 */
public interface PotDistributor {
    public void distributePotAmoungPlayers(Pot pot, Player[] players);
}
