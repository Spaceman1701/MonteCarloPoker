package ehunter.poker.hand;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

/**
 * Created by 40501 on 4/19/2016.
 */
public class HandTest {
    public static final Card[] FULL_HOUSE = new Card[]{
            new Card(CardValue.ACE, CardSuit.CLUBS),
            new Card(CardValue.ACE, CardSuit.DIAMONDS),
            new Card(CardValue.ACE, CardSuit.HEARTS),
            new Card(CardValue.KING, CardSuit.SPADES),
            new Card(CardValue.KING, CardSuit.HEARTS)};
    public static final Card[] HIGH_CARD = new Card[]{
            new Card(CardValue.ACE, CardSuit.SPADES),
            new Card(CardValue.KING, CardSuit.HEARTS),
            new Card(CardValue.SEVEN, CardSuit.SPADES),
            new Card(CardValue.FOUR, CardSuit.SPADES),
            new Card(CardValue.THREE, CardSuit.SPADES)
    };
    public static final Card[] ONE_PAIR = new Card[]{
            new Card(CardValue.JACK, CardSuit.HEARTS),
            new Card(CardValue.JACK, CardSuit.SPADES),
            new Card(CardValue.EIGHT, CardSuit.HEARTS),
            new Card(CardValue.SIX, CardSuit.CLUBS),
            new Card(CardValue.THREE, CardSuit.HEARTS)
    };

    public static final Card[] TWO_PAIR = new Card[]{
            new Card(CardValue.KING, CardSuit.DIAMONDS),
            new Card(CardValue.KING, CardSuit.SPADES),
            new Card(CardValue.QUEEN, CardSuit.CLUBS),
            new Card(CardValue.QUEEN, CardSuit.DIAMONDS),
            new Card(CardValue.TWO, CardSuit.DIAMONDS)
    };

    public static final Card[] THREE_OF_A_KIND = new Card[]{
            new Card(CardValue.JACK, CardSuit.HEARTS),
            new Card(CardValue.JACK, CardSuit.SPADES),
            new Card(CardValue.JACK, CardSuit.CLUBS),
            new Card(CardValue.SIX, CardSuit.CLUBS),
            new Card(CardValue.THREE, CardSuit.HEARTS)
    };

    public static final Card[] FOUR_OF_A_KIND = new Card[]{
            new Card(CardValue.JACK, CardSuit.HEARTS),
            new Card(CardValue.JACK, CardSuit.SPADES),
            new Card(CardValue.JACK, CardSuit.CLUBS),
            new Card(CardValue.JACK, CardSuit.DIAMONDS),
            new Card(CardValue.THREE, CardSuit.HEARTS)
    };

    public static final Card[] FLUSH = new Card[]{
            new Card(CardValue.ACE, CardSuit.HEARTS),
            new Card(CardValue.TWO, CardSuit.HEARTS),
            new Card(CardValue.KING, CardSuit.HEARTS),
            new Card(CardValue.EIGHT, CardSuit.HEARTS),
            new Card(CardValue.TEN, CardSuit.HEARTS)
    };

    public static final Card[] STRAIGHT = new Card[]{
            new Card(CardValue.FIVE, CardSuit.HEARTS),
            new Card(CardValue.SIX, CardSuit.DIAMONDS),
            new Card(CardValue.SEVEN, CardSuit.CLUBS),
            new Card(CardValue.EIGHT, CardSuit.HEARTS),
            new Card(CardValue.NINE, CardSuit.SPADES)
    };

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testInvalidHandConstructed() {
        expectedEx.expect(InvalidHandException.class);
        Hand h = new Hand(new Card[] {new Card(CardValue.JACK, CardSuit.CLUBS)});
    }

    @Test
    public void testIsFullHousePositive() {
        Hand h = new Hand(FULL_HOUSE);

        boolean result = Hand.isFullHouse(h);

        assert result;
    }

    @Test
    public void testIsFullHouseNegative() {
        Hand h = new Hand(HIGH_CARD);

        assert !Hand.isFullHouse(h);
    }

    @Test
    public void testIsStraightPositive() {
        Hand h = new Hand(STRAIGHT);

        assert Hand.isStraight(h);
    }

    @Test
    public void testIsStraightNegative() {
        Hand h = new Hand(HIGH_CARD);

        assert !Hand.isStraight(h);
    }

    @Test
    public void testIsFlushPositive() {
        Hand h = new Hand(FLUSH);

        assert Hand.isFlush(h);
    }

    @Test
    public void testIsFlushNegative() {
        Hand h = new Hand(HIGH_CARD);

        assert !Hand.isFlush(h);
    }

    @Test
    public void Is4OfAKindPositive() {
        Hand h = new Hand(FOUR_OF_A_KIND);

        assert Hand.is4OfAKind(h);
    }

    @Test
    public void Is4OfAKindNegative() {
        Hand h = new Hand(HIGH_CARD);

        assert !Hand.is4OfAKind(h);
    }

    @Test
    public void testIs3OfAKindPositive() {
        Hand h = new Hand(THREE_OF_A_KIND);

        assert Hand.is3OfAKind(h);
    }

    @Test
    public void testIs3OfAKindNegative() {
        Hand h = new Hand(FULL_HOUSE);

        assert !Hand.is3OfAKind(h);

        Hand h2 = new Hand(FOUR_OF_A_KIND);

        assert !Hand.is3OfAKind(h2);
    }

    @Test
    public void testIs2PairPositive() {
        Hand h = new Hand(TWO_PAIR);

        assert Hand.is2Pair(h);
    }

    @Test
    public void testIs2PairNegative() {
        Hand h = new Hand(FOUR_OF_A_KIND);

        assert !Hand.is2Pair(h);

        Hand h2 = new Hand(HIGH_CARD);

        assert !h2.is2Pair(h2);
    }

    @Test
    public void testIsPairPositive() {
        Hand h = new Hand(ONE_PAIR);

        assert Hand.isPair(h);
    }

    @Test
    public void testIsPairNegative() {
        Hand h = new Hand(THREE_OF_A_KIND);

        assert !Hand.isPair(h);

        Hand h2 = new Hand(HIGH_CARD);

        assert !Hand.isPair(h2);
    }

    @Test
    public void testSortBySuit() {
        Card[] expected = new Card[]{
                new Card(CardValue.JACK, CardSuit.CLUBS),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.THREE, CardSuit.HEARTS),
                new Card(CardValue.JACK, CardSuit.HEARTS),
                new Card(CardValue.JACK, CardSuit.DIAMONDS),
        };

        Hand h = new Hand(FOUR_OF_A_KIND);

        h.sortBySuit();

        Card[] result = h.getCards();

        for (int i = 0; i < result.length; i++) {
            //assert result[i].getValue() == expected[i].getValue();
            assert result[i].getSuit() == expected[i].getSuit();
        }
    }

    @Test
    public void testSortByValue() {
        Card[] expected = new Card[]{
                new Card(CardValue.TWO, CardSuit.HEARTS),
                new Card(CardValue.EIGHT, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.HEARTS),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.ACE, CardSuit.HEARTS)
        };

        Hand h = new Hand(FLUSH);

        h.sortByValue();

        Card[] result = h.getCards();

        for (int i = 0; i < result.length; i++) {
            assert result[i].getValue() == expected[i].getValue();
            //assert result[i].getSuit() == expected[i].getSuit(); -- May fail even if method works correctly
        }
    }

    @Test
    public void testSortCardArrayBySuit() {
        Card[] expected = new Card[]{
                new Card(CardValue.JACK, CardSuit.CLUBS),
                new Card(CardValue.JACK, CardSuit.SPADES),
                new Card(CardValue.THREE, CardSuit.HEARTS),
                new Card(CardValue.JACK, CardSuit.HEARTS),
                new Card(CardValue.JACK, CardSuit.DIAMONDS),
        };

        Card[] result = Arrays.copyOf(expected, expected.length);

        result = Hand.sortCardArrayBySuit(result);

        for (int i = 0; i < result.length; i++) {
            //assert result[i].getValue() == expected[i].getValue();
            assert result[i].getSuit() == expected[i].getSuit();
        }
    }

    @Test
    public void testSortCardArrayByValue() {
        Card[] expected = new Card[]{
                new Card(CardValue.TWO, CardSuit.HEARTS),
                new Card(CardValue.EIGHT, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.HEARTS),
                new Card(CardValue.KING, CardSuit.HEARTS),
                new Card(CardValue.ACE, CardSuit.HEARTS)};

        Card[] result = Arrays.copyOf(expected, expected.length);

        for (int i = 0; i < result.length; i++) {
            assert result[i].getValue() == expected[i].getValue();
            //assert result[i].getSuit() == expected[i].getSuit(); -- May fail even if method works correctly
        }

    }

    @Test
    public void testGetCardValues() {
        int[] expected = new int[]{
                CardValue.ACE.getCardValue(),
                CardValue.KING.getCardValue(),
                CardValue.SEVEN.getCardValue(),
                CardValue.FOUR.getCardValue(),
                CardValue.THREE.getCardValue(),
        };
        int[] result = Hand.getCardValues(HIGH_CARD);

        for (int i = 0; i < expected.length; i++) {

            result = Hand.getCardValues(HIGH_CARD);

            assert result[i] == expected[i];
        }
    }
}
