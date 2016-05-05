package ehunter.poker.player;

import ehunter.poker.hand.Card;
import ehunter.poker.hand.Hand;
import ehunter.poker.table.Game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 40501 on 4/25/2016.
 */
public class Player {

    private boolean folded;

    private HoleCards holeCards;

    private int chips;

    public Game game;

    public Player() {
        folded = false;
    }

    public Player(Player copy) {
        this.folded = copy.folded;
        this.holeCards = new HoleCards(copy.holeCards);
        this.chips = copy.chips;
    }

    public boolean isFolded() {
        return folded;
    }

    public void fold() {
        folded = true;
    }

    public boolean bet(int amount) {
        if (amount <= chips) {
            chips -= amount;
            //TODO: BET HERE
            return true;
        }

        return false;
    }

    public int getChipsAmount() {
        return chips;
    }

    public HoleCards getHoleCards() {
        return holeCards;
    }

    public void setHoleCards(HoleCards holeCards) {
        this.holeCards = holeCards;
    }

    public void exitRound() {

    }

    public Hand getBestHand() {
        Set<Card> communityCards = game.getCommunityCards();

        return getBestHand(communityCards);
    }

    public Hand getBestHand(Set<Card> communityCards) {
        Card[] cards = new Card[7];
        cards[5] = holeCards.getFirst();
        cards[6] = holeCards.getSecond();

        int i = 0;
        for (Card c : communityCards) {
            cards[i] = c;
            i++;
        }

        Set<Hand> allHands = Hand.getAllHands(cards);

        Hand bestHand = null;
        int bestValue = - 1;

        for (Hand h : allHands) {
            int hValue = game.getHandEvaluator().evaluateHand(h).getValue();
            if (hValue > bestValue) {
                bestHand = h;
                bestValue = hValue;
            }
        }

        return bestHand;
    }

    public Hand[] allPossibleHands() {
        return null; //TODO: IMPLEMENT
    }
}
