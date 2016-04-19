package ehunter.poker.hand;

/**
 * Created by 40501 on 4/14/2016.
 */
public class BasicHandEvaluator implements HandEvaluator {

    public static final int STRAIGHT_FLUSH_BASE_VALUE = 8_000_000;
    public static final int FOUR_OF_A_KIND_BASE_VALUE = 7_000_000;
    public static final int FULL_HOUSE_BASE_VALUE = 6_000_000;
    public static final int FLUSH_BASE_VALUE = 5_000_000;
    public static final int STRAIGHT_BASE_VALUE = 4_000_000;
    public static final int THREE_OF_A_KIND_BASE_VALUE = 3_000_000;
    public static final int TWO_PAIR_BASE_VALUE = 2_000_000;
    public static final int ONE_PAIR_BASE_VALUE = 1_000_000;
    public static final int HIGH_CARD_BASE_VALUE = 0;

    public static final int HIGHEST_VALUE = 13;


    @Override
    public HandValue evaluateHand(Hand h) {
        HandValue v;
        if (h.isStraight(h) && h.isFlush(h)) { //StraighFlush
            v = valueStraightFlush(h);
        } else if (h.is4OfAKind(h)) {
            v = value4OfAKind(h);
        } else if (h.isFullHouse(h)) {
            v = valueFullHouse(h);
        } else if (h.isFlush(h)) {
            v = valueFlush(h);
        } else if (h.isStraight(h)) {
            v = valueStraight(h);
        } else if (h.is3OfAKind(h)) {
            v = value3OfAKind((h));
        } else if (h.is2Pair(h)) {
            v = value2Pair(h);
        } else if (h.isPair(h)) {
            v = valuePair(h);
        } else { //High card. Bad hand
            v = valueHighCard(h);
        }

        return v;
    }

    private HandValue valueStraightFlush(Hand h) {
        return null;
    }

    private HandValue value4OfAKind(Hand h) {
        return null;
    }

    private HandValue valueFlush(Hand h) {
        return null;
    }

    private HandValue valueStraight(Hand h) {
        return null;
    }

    private HandValue value3OfAKind(Hand h) { //Set?
        h.sortByValue();

        //3rd card in hand will always be part of the 3... means card[2]

        return new HandValue(h, HandType.THREE_OF_A_KIND, h.getCards()[2].getValue().getCardValue() * THREE_OF_A_KIND_BASE_VALUE);
    }
    
    private HandValue value2Pair(Hand h) {
        h.sortByValue();
        Card[] c = h.getCards();
        int value = 0;
        if (c[0].getValue().getCardValue() == c[1].getValue().getCardValue() &&
                c[2].getValue().getCardValue() == c[3].getValue().getCardValue()) {
            value = value2Pair(c[2], c[0], c[4]);
        } else if (c[0].getValue().getCardValue() == c[1].getValue().getCardValue() &&
                c[3].getValue().getCardValue() == c[4].getValue().getCardValue()) {
            value = value2Pair(c[3], c[0], c[2]);
        } else if (c[1].getValue().getCardValue() == c[2].getValue().getCardValue() &&
                c[3].getValue().getCardValue() == c[4].getValue().getCardValue()) {
            value = value2Pair(c[3], c[1], c[0]);
        }

        return new HandValue(h, HandType.TWO_PAIR, value +  TWO_PAIR_BASE_VALUE);
    }

    private int value2Pair(Card highMatch, Card lowMatch, Card unmatched) {
        return weight(2)*highMatch.getValue().getCardValue() + weight(1)*lowMatch.getValue().getCardValue()
                + weight(0) * unmatched.getValue().getCardValue();
    }

    private HandValue valuePair(Hand h) {
        h.sortByValue();
        Card[] cards = h.getCards();
        int v = 0;
        if (cards[0].getValue().getCardValue() == cards[1].getValue().getCardValue()) {
            v = valuePair(new Card[]{cards[0], cards[1]}, new Card[]{cards[2], cards[3], cards[4]});
        } else if (cards[1].getValue().getCardValue() == cards[2].getValue().getCardValue()) {
            v = valuePair(new Card[]{cards[1], cards[2]}, new Card[]{cards[0], cards[3], cards[4]});
        } else if (cards[2].getValue().getCardValue() == cards[3].getValue().getCardValue()) {
            v = valuePair(new Card[]{cards[2], cards[3]}, new Card[]{cards[0], cards[1], cards[4]});
        } else if (cards[3].getValue().getCardValue() == cards[4].getValue().getCardValue()) {
            v = valuePair(new Card[]{cards[3], cards[4]}, new Card[]{cards[0], cards[1], cards[2]});
        }

        return new HandValue(h, HandType.ONE_PAIR, ONE_PAIR_BASE_VALUE + v);
    }
    //unmatched will always be length 3
    private int valuePair(Card[] matched, Card[] unmtached) {
        unmtached = Hand.sortCardArrayByValue(unmtached);

        return weight(3)*matched[0].getValue().getCardValue() + weight(2)*unmtached[2].getValue().getCardValue()
                + weight(1)*unmtached[1].getValue().getCardValue() + weight(0)*unmtached[0].getValue().getCardValue();
    }

    private HandValue valueHighCard(Hand h) {
        h.sortByValue();

        int value = 0;
        for (int i = 0; i < h.getCards().length; i++) {
            int val = h.getCards()[i].getValue().getCardValue();

            value += val * Math.pow(HIGHEST_VALUE, i);
        }

        return new HandValue(h, HandType.HIGH_CARD, value + HIGH_CARD_BASE_VALUE);
    }

    private HandValue valueFullHouse(Hand h) {
        return null;
    }

    private int weight(int weight) {
        return (int)Math.pow(HIGHEST_VALUE, weight);
    }
}
