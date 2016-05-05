package ehunter.poker.game;

import ehunter.poker.hand.BasicHandEvaluator;
import ehunter.poker.hand.Hand;
import ehunter.poker.hand.HandEvaluator;
import ehunter.poker.pot.Pot;
import ehunter.poker.pot.PotDistributor;
import ehunter.poker.pot.potdistributor.DeadChipPotDistributor;

/**
 * Created by 40501 on 5/5/2016.
 */
public class Agent {

    private HandEvaluator handEvaluator;
    private PotDistributor potDistributor;


    private static Agent agent;

    public static void main(String[] args) {
        agent = createAgent();
    }

    private static Agent createAgent() {
        return new Agent(new BasicHandEvaluator(), new DeadChipPotDistributor());
    }

    public Agent(HandEvaluator handEvaluator, PotDistributor potDistributor) {
        this.handEvaluator = handEvaluator;
        this.potDistributor = potDistributor;
    }

    public static Agent getAgent() {

        if (agent == null) {
            agent = createAgent();
        }

        return agent;
    }

    public PotDistributor getPotDistributor() {
        return potDistributor;
    }

    public HandEvaluator getHandEvaluator() {
        return handEvaluator;
    }

    public static HandEvaluator getAgentHandEvaluator() {
        return getAgent().getHandEvaluator();
    }

    public static PotDistributor getAgentPotDistributor() {
        return getAgent().getPotDistributor();
    }


}
