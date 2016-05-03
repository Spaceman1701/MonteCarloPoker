package ehunter.poker.player;

import ehunter.poker.hand.Card;
import ehunter.poker.hand.Hand;
import ehunter.poker.table.Game;

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

    public void exitRound() {

    }

    public Hand bestHand() {
        Set<Card> communityCards = game.getCommunityCards();

        Card[] cards = new Card[7];
        cards[5] = holeCards.getFirst();
        cards[6] = holeCards.getSecond();

        int i = 0;
        for (Card c : communityCards) {
            cards[i] = c;
            i++;
        }



        return null; //TODO: IMPLEMENT
    }

    private Set<Card[]> getAllHands(Card[] input) {
        Set<Card[]> hands = new HashSet<Card[]>();

        int[] indicies = new int[5];

        hands.add(getHandFromIndicies(input, new int[] {0, 1, 2, 3, 4}));

        for (;;) {
            int i;
            
        }
    }

    private Card[] getHandFromIndicies(Card[] input, int[] indicies) {
        Card[] result = new Card[5];
        for (int i = 0; i < 5; i++) {
            result[i] = input[indicies[i]];
        }

        return result;
    }

    public Hand[] allPossibleHands() {
        return null; //TODO: IMPLEMENT
    }
}
