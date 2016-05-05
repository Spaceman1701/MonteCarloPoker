package ehunter.poker.pot;

import ehunter.poker.player.Player;

import java.util.Collection;

/**
 * Created by 40501 on 4/22/2016.
 */
public interface PotDistributor {
    Collection<Winnings> distributePotAmongPlayers(Pot pot, Player[] players);
}
