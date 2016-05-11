package ehunter.poker.table;

import ehunter.poker.hand.Card;
import ehunter.poker.hand.CardSuit;
import ehunter.poker.hand.CardValue;

import java.util.*;

/**
 * Created by 40501 on 4/27/2016.
 */
public class Deck {
    private Random rand;
    private List<Card> cards;
    private Set<Card> drawnCards;

    public Deck() {
        cards = new LinkedList<Card>();
        drawnCards = new HashSet<Card>();
        fillDeck();
        rand = new Random();
        //shuffleDeck();
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

    public List<Card> getCards() {
        return cards;
    }

    public Card getRandomCard() {
        int index = rand.nextInt(cards.size());
        Card c = cards.remove(index);
        drawnCards.add(c);
        return c;
    }

    public boolean removeCard(Card card) {
        if (cards.remove(card)) {
            drawnCards.add(card);
            return true;
        }

        return false;
    }

    public boolean isNextCard() {
        return cards.size() != 0;
    }

    public int getSize() {
        return cards.size();
    }
}
