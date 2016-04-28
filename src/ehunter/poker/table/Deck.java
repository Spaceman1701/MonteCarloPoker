package ehunter.poker.table;

import ehunter.poker.hand.Card;
import ehunter.poker.hand.CardSuit;
import ehunter.poker.hand.CardValue;

import java.util.*;

/**
 * Created by 40501 on 4/27/2016.
 */
public class Deck {
    private LinkedList<Card> cards;

    public Deck() {
        cards = new LinkedList<Card>();
        fillDeck();
        shuffleDeck();
    }

    private void fillDeck() {
        CardSuit[] suits = CardSuit.values();
        CardValue[] values = CardValue.values();

        for (CardSuit s : suits) {
            for (CardValue v : values) {
                cards.add(new Card(v, s));
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card getTopCard() {
        return cards.poll();
    }

    public boolean isNextCard() {
        return cards.peek() != null;
    }

    public int getSize() {
        return cards.size();
    }
}
