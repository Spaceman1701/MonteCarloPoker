package ehunter.poker.player;

import ehunter.poker.hand.Hand;

/**
 * Created by 40501 on 4/25/2016.
 */
public class Player {

    private boolean folded;

    private HoleCards holeCards;

    public Player() {
        folded = false;
    }

    public Player(Player copy) {
        this.folded = copy.isFolded();
        this.holeCards = new HoleCards(copy.holeCards);
    }

    public boolean isFolded() {
        return folded;
    }

    public void fold() {
        folded = true;
    }

    public void exitRound() {

    }

    public Hand bestHand() {
        return null; //TODO: IMPLEMENT
    }

    public Hand[] allPossibleHands() {
        return null; //TODO: IMPLEMENT
    }
}
