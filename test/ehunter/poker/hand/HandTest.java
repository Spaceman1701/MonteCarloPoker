package ehunter.poker.hand;

import org.junit.Test;

/**
 * Created by 40501 on 4/19/2016.
 */
public class HandTest {
    private static final Card[] FULL_HOUSE = new Card[]{
            new Card(CardValue.ACE, CardSuit.CLUBS),
            new Card(CardValue.ACE, CardSuit.DIAMONDS),
            new Card(CardValue.ACE, CardSuit.HEARTS),
            new Card(CardValue.KING, CardSuit.SPADES),
            new Card(CardValue.KING, CardSuit.HEARTS)};
    private static final Card[] HIGH_CARD;

    @Test
    public void testIsFullHousePositive() {
        Hand h = new Hand(FULL_HOUSE);

        boolean result = Hand.isFullHouse(h);

        assert result;
    }

    @Test
    public void testIsFullHouseNegative() {

    }

    @Test
    public void testIsStraightPositive() {

    }

    @Test
    public void testIsStraightNegative() {

    }

    @Test
    public void testIsFlushPositive() {

    }

    @Test
    public void testIsFlushNegative() {

    }

    @Test
    public void Is4OfAKindPositive() {

    }

    @Test
    public void Is4OfAKindNegative() {

    }

    @Test
    public void testIs3OfAKindPositive() {

    }

    @Test
    public void testIs3OfAKindNegative() {

    }

    @Test
    public void testIs2PairPositive() {

    }

    @Test
    public void testIs2PairNegative() {

    }

    @Test
    public void testIsPairPositive() {

    }

    @Test
    public void testIsPairNegative() {

    }

    @Test
    public void testSortBySuit() {
    }

    @Test
    public void testSortByValue() {
    }

    @Test
    public void testSortCardArrayBySuit() {

    }

    @Test
    public void testSortCardArrayByValue() {

    }

    @Test
    public void testGetCardValues() {

    }
}
