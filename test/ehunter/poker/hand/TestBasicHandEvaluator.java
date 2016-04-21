package ehunter.poker.hand;


import com.sun.istack.internal.NotNull;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.Parameterized;

/**
 * Created by 40501 on 4/20/2016.
 */
public class TestBasicHandEvaluator {

    public static final int STRAIGHT_FLUSH_BASE_VALUE = 8_000_000;
    public static final int FOUR_OF_A_KIND_BASE_VALUE = 7_000_000;
    public static final int FULL_HOUSE_BASE_VALUE = 6_000_000;
    public static final int FLUSH_BASE_VALUE = 5_000_000;
    public static final int STRAIGHT_BASE_VALUE = 4_000_000;
    public static final int THREE_OF_A_KIND_BASE_VALUE = 3_000_000;
    public static final int TWO_PAIR_BASE_VALUE = 2_000_000;
    public static final int ONE_PAIR_BASE_VALUE = 1_000_000;
    public static final int HIGH_CARD_BASE_VALUE = 0;

    private static final HandEvaluator eval = new BasicHandEvaluator();

    @Rule
    private ExpectedException expectedEx = ExpectedException.none();

    public void valueStraightFlushIntra() {
        //This method probably works since it is just the high card method + a base value
    }
    @Test
    public void value4OfAKindInBounds() {
        Card[] highest4 = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.ACE, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.HEARTS),
                new Card(CardValue.KING, CardSuit.SPADES)
        };

        Hand h = new Hand(highest4);

        assert eval.evaluateHand(h).getValue() < STRAIGHT_FLUSH_BASE_VALUE;
    }

    @Test
    public void value4OfAKindIntraCompare() {
        Card[] highest4 = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.ACE, CardSuit.SPADES),
                new Card(CardValue.ACE, CardSuit.HEARTS),
                new Card(CardValue.KING, CardSuit.SPADES)
        };

        assert eval.evaluateHand(new Hand(highest4)).getValue() > eval.evaluateHand(new Hand(HandTest.FOUR_OF_A_KIND)).getValue();
    }

    @Test
    public void testValueFlushInBounds() {
        Card[] highestFlush = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.KING, CardSuit.CLUBS),
                new Card(CardValue.QUEEN, CardSuit.CLUBS),
                new Card(CardValue.JACK, CardSuit.CLUBS),
                new Card(CardValue.NINE, CardSuit.CLUBS)
        };

        assert eval.evaluateHand(new Hand(highestFlush)).getValue() < FULL_HOUSE_BASE_VALUE;
    }

    @Test
    public void testValueFlushIntraCompare() {
        Card[] highestFlush = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.KING, CardSuit.CLUBS),
                new Card(CardValue.QUEEN, CardSuit.CLUBS),
                new Card(CardValue.JACK, CardSuit.CLUBS),
                new Card(CardValue.NINE, CardSuit.CLUBS)
        };

        assert eval.evaluateHand(new Hand(highestFlush)).getValue() > eval.evaluateHand(new Hand(HandTest.FLUSH)).getValue();
    }

    @Test
    public void testValueStraightInBounds() {
        Card[] highestStraight = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.QUEEN, CardSuit.CLUBS),
                new Card(CardValue.JACK, CardSuit.CLUBS),
                new Card(CardValue.TEN, CardSuit.HEARTS)
        };

        assert eval.evaluateHand(new Hand(highestStraight)).getValue() < FLUSH_BASE_VALUE;
    }

    @Test
    public void testValueStraightIntraCompare() {
        Card[] highestStraight = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.QUEEN, CardSuit.CLUBS),
                new Card(CardValue.JACK, CardSuit.CLUBS),
                new Card(CardValue.TEN, CardSuit.HEARTS)
        };

        assert eval.evaluateHand(new Hand(highestStraight)).getValue() > eval.evaluateHand(new Hand(HandTest.STRAIGHT)).getValue();
    }

    @Test
    public void value3OfAKindInBounds() {
        Card[] highest3 = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.ACE, CardSuit.HEARTS),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.KING, CardSuit.CLUBS),
                new Card(CardValue.JACK, CardSuit.CLUBS)
        };

        assert eval.evaluateHand(new Hand(highest3)).getValue() < STRAIGHT_BASE_VALUE;
    }

    @Test
    public void value3OfAKindIntraCompare() {
        Card[] highest3 = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.ACE, CardSuit.HEARTS),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.KING, CardSuit.CLUBS),
                new Card(CardValue.JACK, CardSuit.CLUBS)
        };

        assert eval.evaluateHand(new Hand(highest3)).getValue() > eval.evaluateHand(new Hand(HandTest.THREE_OF_A_KIND)).getValue();
    }

    @Test
    public void testValue2PairInBounds() {
        Card[] highestPair = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.KING, CardSuit.CLUBS),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.QUEEN, CardSuit.SPADES)
        };
        Hand h = new Hand(highestPair);

        assert eval.evaluateHand(h).getValue() < THREE_OF_A_KIND_BASE_VALUE;
    }

    @Test
    public void testValue2PairIntra() {
        Card[] highestPair = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.KING, CardSuit.CLUBS),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.QUEEN, CardSuit.SPADES)
        };

        Hand h = new Hand(highestPair);

        assert eval.evaluateHand(h).getValue() > eval.evaluateHand(new Hand(HandTest.TWO_PAIR)).getValue();
    }

    @Test
    public void testFullHouseInBounds() {
        Card[] highestFullHouse = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.ACE, CardSuit.HEARTS),
                new Card(CardValue.KING, CardSuit.CLUBS),
                new Card(CardValue.KING, CardSuit.HEARTS)
        };

        assert eval.evaluateHand(new Hand(highestFullHouse)).getValue() < FOUR_OF_A_KIND_BASE_VALUE;
    }

    @Test
    public void testFullHouseIntraCompare() {
        Card[] highestFullHouse = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.ACE, CardSuit.HEARTS),
                new Card(CardValue.KING, CardSuit.CLUBS),
                new Card(CardValue.KING, CardSuit.HEARTS)
        };

        assert eval.evaluateHand(new Hand(highestFullHouse)).getValue() < eval.evaluateHand(new Hand(HandTest.FULL_HOUSE)).getValue();
    }

    @Test
    public void testPairInBounds() {
        Card[] highestPair = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.ACE, CardSuit.HEARTS),
                new Card(CardValue.KING, CardSuit.CLUBS),
                new Card(CardValue.QUEEN, CardSuit.SPADES),
                new Card(CardValue.JACK, CardSuit.DIAMONDS)
        };

        assert eval.evaluateHand(new Hand(highestPair)).getValue() < TWO_PAIR_BASE_VALUE;
    }

    @Test
    public void testPairIntraCompare() {
        Card[] highestPair = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.ACE, CardSuit.HEARTS),
                new Card(CardValue.KING, CardSuit.CLUBS),
                new Card(CardValue.QUEEN, CardSuit.SPADES),
                new Card(CardValue.JACK, CardSuit.DIAMONDS)
        };

        assert eval.evaluateHand(new Hand(highestPair)).getValue() > eval.evaluateHand(new Hand(HandTest.ONE_PAIR)).getValue();
    }

    @Test
    public void testHighCardInBounds() {
        Card[] highestHigh = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.QUEEN, CardSuit.CLUBS),
                new Card(CardValue.JACK, CardSuit.HEARTS),
                new Card(CardValue.NINE, CardSuit.DIAMONDS)
        };

        assert eval.evaluateHand(new Hand(highestHigh)).getValue() < ONE_PAIR_BASE_VALUE;
    }

    @Test
    public void testHighCardIntraCompare() {
        Card[] highestHigh = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.KING, CardSuit.SPADES),
                new Card(CardValue.QUEEN, CardSuit.CLUBS),
                new Card(CardValue.JACK, CardSuit.HEARTS),
                new Card(CardValue.NINE, CardSuit.DIAMONDS)
        };

        assert eval.evaluateHand(new Hand(highestHigh)).getValue() > eval.evaluateHand(new Hand(HandTest.HIGH_CARD)).getValue();
    }


}
