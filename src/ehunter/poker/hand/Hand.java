package ehunter.poker.hand;

import java.util.Arrays;

/**
 * Created by 40501 on 4/14/2016.
 */
public class Hand {

    private Card[] cards;
    //Contains all data for a single hand

    public Hand() {
        cards = new Card[5];
    }

    public Hand(Card[] cards) {
        this.cards = Arrays.copyOf(cards, cards.length);
        Hand.checkValidHand(this);
    }

    public Hand(Hand copy) {
        this(copy.getCards());
    }

    public void setCard(Card c, int index) {
        cards[index] = c;
    }

    private static void checkValidHand(Hand h) {
        if (h.getCards().length != 5) {
            throw new InvalidHandException();
        }
    }

    public Card getCard(int index) {
        return cards[index];
    }

    public Card[] getCards() {
        return cards;
    }

    public static boolean isFullHouse(Hand h) {
        checkValidHand(h);

        h.sortByValue();

        int[] cards = getCardValues(h.getCards());

        //xxxyy
        boolean lower = (cards[0] == cards[1]) && (cards[1] == cards[2]) && (cards[3] == cards[4]);

        //yyxxx
        boolean higher = (cards[0] == cards[1]) && (cards[2] == cards[3]) && (cards[3] == cards[4]);

        return higher || lower;
    }

    public static boolean isStraight(Hand h) {
        checkValidHand(h);

        h.sortByValue();

        Card[] cards = h.getCards();

        int testRank = cards[0].getValue().getSortingValue();

        for (Card c : cards) {
            if (c.getValue().getSortingValue() != testRank) {
                return false;
            }
            testRank++;
        }

        return true;
    }

    public static boolean isFlush(Hand h) {
        checkValidHand(h);
        h.sortBySuit();

        return h.getCards()[0].getSuit() == h.getCards()[4].getSuit();
    }

    public static boolean is4OfAKind(Hand h) {
        checkValidHand(h);
        h.sortByValue();

        Card[] cards = h.getCards();

        boolean lower4 = (cards[0].getValue() == cards[1].getValue()) && (cards[1].getValue() == cards[2].getValue()) &&
                (cards[2].getValue() == cards[3].getValue());
        boolean higher4 = (cards[1].getValue() == cards[2].getValue()) && (cards[2].getValue() == cards[3].getValue()) &&
                (cards[3].getValue() == cards[4].getValue());


        return lower4 || higher4;
    }

    public static boolean is3OfAKind(Hand h) {
        checkValidHand(h);

        if (is4OfAKind(h) || isFullHouse(h)) {
            return false; //lets the method be simplified to litterally just look for 3 cards with the same value.
        }

        h.sortByValue();

        Card[] cards = h.getCards();

        boolean lower = (cards[0].getValue() == cards[1].getValue()) &&
                (cards[1].getValue() == cards[2].getValue());
        boolean middle = (cards[1].getValue() == cards[2].getValue()) &&
                (cards[2].getValue() == cards[3].getValue());
        boolean higher = (cards[2].getValue() == cards[3].getValue()) &&
                (cards[3].getValue() == cards[4].getValue());

        return lower || middle || higher;
    }

    public static boolean is2Pair(Hand h) {
        checkValidHand(h);

        if (isFullHouse(h) || is3OfAKind(h) || is4OfAKind(h)) {
            return false;
        }

        h.sortByValue();

        Card[] cards = h.getCards();

        boolean lower = (cards[0].getValue() == cards[1].getValue()) &&
                (cards[2].getValue() == cards[3].getValue()); //aa bb x
        boolean lower2 = (cards[0].getValue() == cards[1].getValue()) &&
                (cards[3].getValue() == cards[4].getValue()); // aa x bb
        boolean higher = (cards[1].getValue() == cards[2].getValue()) &&
                (cards[3].getValue() == cards[4].getValue()); //x aa bb

        return lower || lower2 || higher;
    }

    public static boolean isPair(Hand h) {
        checkValidHand(h);
        if (is2Pair(h) || is4OfAKind(h) || isFullHouse(h) || is3OfAKind(h)) {
            return false;
        }


        for (int i = 0; i < h.getCards().length; i ++) {
            if (i == h.getCards().length - 1) {
                return false;
            }
            if (h.getCards()[i].getValue() == h.getCards()[i + 1].getValue()) {
                return true;
            }
        }
        return false;
    }

    public void sortBySuit() {
        Arrays.sort(getCards(), new SuitComparator());
    }

    public void sortByValue() {
        Arrays.sort(getCards(), new ValueComparator());
    }

    public static Card[] sortCardArrayBySuit(Card[] cards) {
        Arrays.sort(cards, new SuitComparator());
        return cards;
    }

    public static Card[] sortCardArrayByValue(Card[] cards) {
        Arrays.sort(cards, new ValueComparator());
        return cards;
    }

    public static int[] getCardValues(Card[] c) {
        int[] values = new int[c.length];

        for (int i  = 0; i < c.length; i++) {
            values[i] = c[i].getValue().getCardValue();
        }

        return values;
    }
}
