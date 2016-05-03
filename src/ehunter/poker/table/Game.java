package ehunter.poker.table;

import ehunter.poker.hand.Card;
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

    public Game() {
        communityCards = new TreeSet<Card>(new ValueComparator());
    }

    protected void setCommunityCards(Set<Card> cards) {
        communityCards = cards;
    }

    public Set<Card> getCommunityCards() {
        return new TreeSet<Card>(communityCards);
    }

    public Pot getPot() {
        return null; //TODO: IMPLEMENT
    }
}
