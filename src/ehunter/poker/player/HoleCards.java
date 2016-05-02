package ehunter.poker.player;

import ehunter.poker.hand.Card;
import ehunter.poker.hand.ValueComparator;

import java.util.*;

/**
 * Created by 40501 on 5/2/2016.
 */
public class HoleCards {
    private List<Card> cards;

    private HoleCards() {
        cards = new ArrayList<Card>();
        Collections.sort(cards, new ValueComparator());
    }

    public HoleCards(Card c1, Card c2) {
        this();
        cards.add(c1);
        cards.add(c2);
    }

    public HoleCards(Collection<Card> cards) {
        this();
        this.cards.addAll(cards);
    }

    public HoleCards(Card[] cards) {
        this();
        this.cards.add(cards[0]);
        this.cards.add(cards[1]);
    }

    public boolean contains(Card c) {
        return cards.contains(c);
    }

    public Card getFirst() {
        return cards.get(0);
    }

    public Card getSecond() {
        return cards.get(1);
    }

    public Card[] getCards() {
        return new Card[] {cards.get(0), cards.get(1)};
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() == HoleCards.class) {
            HoleCards other = (HoleCards)o;

            return other.cards.containsAll(this.cards);
        }

        return false;
    }
}


