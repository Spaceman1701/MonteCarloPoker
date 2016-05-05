package ehunter.poker.pot.potdistributor;

import ehunter.poker.game.Agent;
import ehunter.poker.hand.HandEvaluator;
import ehunter.poker.player.Player;
import ehunter.poker.pot.Pot;
import ehunter.poker.pot.PotDistributor;
import ehunter.poker.pot.SidePot;
import ehunter.poker.pot.Winnings;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 40501 on 5/5/2016.
 */
public class DeadChipPotDistributor implements PotDistributor {
    @Override
    public Collection<Winnings> distributePotAmongPlayers(Pot pot, Player[] players) {
        HandEvaluator handEvaluator = Agent.getAgentHandEvaluator();


        Set<Winnings> winningsSet = new HashSet<Winnings>();

        SidePot[] pots = pot.getPots();

        for (SidePot sidePot : pots) {
            Set<Player> contributors = sidePot.getContributors();

            Set<Player> winners = new HashSet<Player>();

            int bestHandValue= -1;

            for(Player p : contributors) { //Find winning hand value
                int handValue = handEvaluator.evaluateHand(p.getBestHand()).getValue();
                if (handValue > bestHandValue) {
                    bestHandValue = handValue;
                }
            }

            for (Player p : contributors) { //Add players with the winning hand value to the winners set
                int handValue = handEvaluator.evaluateHand(p.getBestHand()).getValue();
                if (handValue == bestHandValue) {
                    winners.add(p);
                }
            }
            int numWinners = winners.size();

            int oddChips = sidePot.getValue() % numWinners;

            int valuePerPlayer = (sidePot.getValue() - oddChips)/numWinners;

            for (Player p : winners) {
                winningsSet.add(Winnings.createPlayerWinnings(p, valuePerPlayer));
            }

            winningsSet.add(Winnings.createDeadChips(oddChips));
        }

        return winningsSet;
    }
}
