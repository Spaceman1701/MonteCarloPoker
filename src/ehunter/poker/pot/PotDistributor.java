package ehunter.poker.pot;

import ehunter.poker.player.PlayerInfo;

/**
 * Created by 40501 on 4/22/2016.
 */
public interface PotDistributor {
    public void distributePotAmoungPlayers(Pot pot, PlayerInfo[] players);
}
