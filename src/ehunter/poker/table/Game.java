package ehunter.poker.table;

import ehunter.poker.hand.BasicHandEvaluator;
import ehunter.poker.hand.Card;
import ehunter.poker.hand.HandEvaluator;
import ehunter.poker.hand.ValueComparator;
import ehunter.poker.pot.Pot;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by 40501 on 5/3/2016.
 */
public class Game {

    private Set<Card> communityCards;

    private HandEvaluator handEvaluator;

    public Game() {
        communityCards = new TreeSet<Card>(new ValueComparator());
        handEvaluator = new BasicHandEvaluator();
    }

    /*protected void setCommunityCards(Set<Card> cards) {
        communityCards = cards;
    } */

    public Set<Card> getCommunityCards() {
        TreeSet<Card> output = new TreeSet<Card>(new ValueComparator());
        output.addAll(communityCards);
        return output;
    }

    public Pot getPot() {
        return null; //TODO: IMPLEMENT
    }

    public HandEvaluator getHandEvaluator() {
        return handEvaluator; //TODO: IMPLEMENT
    }
}
