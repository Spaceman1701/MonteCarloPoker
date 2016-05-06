package ehunter.poker.player;

import ehunter.poker.TestUtilities;
import ehunter.poker.hand.*;
import ehunter.poker.table.Game;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by 40501 on 5/3/2016.
 */
public class PlayerTest {


    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testGetBestHand() throws Exception {
        Player p = new Player();

        Game game = new Game();

        Card[] tableCards = new Card[]{
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.ACE, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
                new Card(CardValue.JACK, CardSuit.CLUBS),
                new Card(CardValue.FOUR, CardSuit.SPADES)
        };

        Card[] holeCards = new Card[] {
                new Card(CardValue.TEN, CardSuit.HEARTS),
                new Card(CardValue.ACE, CardSuit.DIAMONDS)
        };

        Card[] playerFullHouse = new Card[] {
                new Card(CardValue.TEN, CardSuit.HEARTS),
                new Card(CardValue.ACE, CardSuit.DIAMONDS),
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.ACE, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.SPADES),
        };

        //full house possible, 3 ace and 2 tens

        TestUtilities.assignCommunityCards(game, tableCards);
        assert game.getCommunityCards().size() == 5 : "community cards failed to set";

        p.game = game;

        p.setHoleCards(new HoleCards(holeCards));

        Hand h = p.getBestHand();

        HandValue bestHandValue = game.getHandEvaluator().evaluateHand(h);
        HandValue expectedHandValue = game.getHandEvaluator().evaluateHand(new Hand(playerFullHouse));

        assert bestHandValue.getType() == expectedHandValue.getType() : "found wrong hand type";

        assert bestHandValue.getValue() == expectedHandValue.getValue() : "found wrong hand";

    }
}
