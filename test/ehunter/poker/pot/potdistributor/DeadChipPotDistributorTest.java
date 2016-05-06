package ehunter.poker.pot.potdistributor;

import ehunter.poker.TestUtilities;
import ehunter.poker.hand.CardSuit;
import ehunter.poker.hand.CardValue;
import ehunter.poker.hand.HandTest;
import ehunter.poker.player.HoleCards;
import ehunter.poker.player.Player;
import ehunter.poker.pot.Bet;
import ehunter.poker.pot.Pot;
import ehunter.poker.pot.Winnings;
import ehunter.poker.table.Game;
import org.junit.Test;

import ehunter.poker.hand.Card;

import java.util.Calendar;
import java.util.Collection;

/**
 * Created by 40501 on 5/5/2016.
 */
public class DeadChipPotDistributorTest {

    @Test
    public void testDistributePotAmongPlayersOneWinner() {
        Card[] tableCards = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.QUEEN, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.TWO, CardSuit.CLUBS),
                new Card(CardValue.SEVEN, CardSuit.CLUBS)
        };

        Player straightPlayer = new Player();
        straightPlayer.setHoleCards(new HoleCards(new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.JACK, CardSuit.HEARTS)));

        Player flushPlayer = new Player(); //SHOULD WIN
        flushPlayer.setHoleCards(new HoleCards(new Card(CardValue.THREE, CardSuit.CLUBS), new Card(CardValue.FOUR,
                CardSuit.CLUBS)));

        Player highCardPlayer = new Player();
        highCardPlayer.setHoleCards(new HoleCards(new Card(CardValue.FOUR, CardSuit.HEARTS),
                new Card(CardValue.SIX, CardSuit.SPADES)));
        highCardPlayer.fold();

        Game game = new Game();
        TestUtilities.assignCommunityCards(game, tableCards);

        straightPlayer.game = game;
        flushPlayer.game = game;
        highCardPlayer.game = game;

        Pot pot = new Pot();

        pot.bet(new Bet(straightPlayer, 100));
        pot.bet(new Bet(flushPlayer, 100));
        pot.bet(new Bet(highCardPlayer, 10));

        DeadChipPotDistributor distributor = new DeadChipPotDistributor();

        Collection<Winnings> winnings =
                distributor.distributePotAmongPlayers(pot, new Player[]{straightPlayer, flushPlayer, highCardPlayer});

        assert winnings.size() == 1 : "wrong size winnings set: " + winnings.size();

        for (Winnings w : winnings) {
            Player p = w.getTargetPlayer();
            int chips = w.getChips();
            boolean deadChips = w.isDeadChips();

            assert !deadChips;

            boolean foundPlayer = false;
            if (p == straightPlayer) {
                foundPlayer = true;
                assert chips == 0;
            } else if (p == flushPlayer) {
                foundPlayer = true;
                assert chips == 210;
            } else if (p == highCardPlayer) {
                foundPlayer = true;
                assert chips == 0;
            }
        }

    }

    @Test
    public void testDistributePotAmongPlayersMultipleWinnersNoOddChips() {
        Card[] tableCards = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.QUEEN, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.TWO, CardSuit.CLUBS),
                new Card(CardValue.SEVEN, CardSuit.CLUBS)
        };

        Player straightPlayer = new Player();
        straightPlayer.setHoleCards(new HoleCards(new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.JACK, CardSuit.HEARTS)));

        Player striaghtPlayer2 = new Player(); //SHOULD WIN
        striaghtPlayer2.setHoleCards(new HoleCards(new Card(CardValue.KING, CardSuit.CLUBS), new Card(CardValue.JACK,
                CardSuit.HEARTS)));

        Player highCardPlayer = new Player();
        highCardPlayer.setHoleCards(new HoleCards(new Card(CardValue.FOUR, CardSuit.HEARTS),
                new Card(CardValue.SIX, CardSuit.SPADES)));
        highCardPlayer.fold();

        Game game = new Game();
        TestUtilities.assignCommunityCards(game, tableCards);

        straightPlayer.game = game;
        striaghtPlayer2.game = game;
        highCardPlayer.game = game;

        Pot pot = new Pot();

        pot.bet(new Bet(straightPlayer, 100));
        pot.bet(new Bet(striaghtPlayer2, 100));
        pot.bet(new Bet(highCardPlayer, 10));

        DeadChipPotDistributor distributor = new DeadChipPotDistributor();

        Collection<Winnings> winnings =
                distributor.distributePotAmongPlayers(pot, new Player[]{straightPlayer, striaghtPlayer2, highCardPlayer});

        assert winnings.size() == 2 : "wrong size winnings set: " + winnings.size();

        for (Winnings w : winnings) {
            Player p = w.getTargetPlayer();
            int chips = w.getChips();
            boolean deadChips = w.isDeadChips();

            assert !deadChips;

            boolean foundPlayer = false;
            if (p == straightPlayer) {
                foundPlayer = true;
                assert chips == 105;
            } else if (p == striaghtPlayer2) {
                foundPlayer = true;
                assert chips == 105;
            } else if (p == highCardPlayer) {
                foundPlayer = true;
                assert chips == 0;
            }
        }

    }

    @Test
    public void testDistributePotAmongPlayersMultipleWinnersOddChips() {
        Card[] tableCards = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.QUEEN, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.TWO, CardSuit.CLUBS),
                new Card(CardValue.SEVEN, CardSuit.CLUBS)
        };

        Player straightPlayer = new Player();
        straightPlayer.setHoleCards(new HoleCards(new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.JACK, CardSuit.HEARTS)));

        Player striaghtPlayer2 = new Player(); //SHOULD WIN
        striaghtPlayer2.setHoleCards(new HoleCards(new Card(CardValue.KING, CardSuit.CLUBS), new Card(CardValue.JACK,
                CardSuit.HEARTS)));

        Player highCardPlayer = new Player();
        highCardPlayer.setHoleCards(new HoleCards(new Card(CardValue.FOUR, CardSuit.HEARTS),
                new Card(CardValue.SIX, CardSuit.SPADES)));
        highCardPlayer.fold();



        Game game = new Game();
        TestUtilities.assignCommunityCards(game, tableCards);

        straightPlayer.game = game;
        striaghtPlayer2.game = game;
        highCardPlayer.game = game;

        Pot pot = new Pot();

        pot.bet(new Bet(straightPlayer, 100));
        pot.bet(new Bet(striaghtPlayer2, 100));
        pot.bet(new Bet(highCardPlayer, 15));

        DeadChipPotDistributor distributor = new DeadChipPotDistributor();

        Collection<Winnings> winnings =
                distributor.distributePotAmongPlayers(pot, new Player[]{straightPlayer, striaghtPlayer2, highCardPlayer});

        assert winnings.size() == 3 : "wrong size winnings set: " + winnings.size();

        for (Winnings w : winnings) {
            Player p = w.getTargetPlayer();
            int chips = w.getChips();
            boolean deadChips = w.isDeadChips();

            if (deadChips) {
                assert chips == 1;
            }

            boolean foundPlayer = false;
            if (p == straightPlayer) {
                foundPlayer = true;
                assert chips == 107;
            } else if (p == striaghtPlayer2) {
                foundPlayer = true;
                assert chips == 107;
            } else if (p == highCardPlayer) {
                foundPlayer = true;
                assert chips == 0;
            }
        }
    }

    @Test
    public void testDistributePotAmoungPlayersMultiplePotsMultipleWinners() {
        Card[] tableCards = new Card[] {
                new Card(CardValue.ACE, CardSuit.CLUBS),
                new Card(CardValue.QUEEN, CardSuit.HEARTS),
                new Card(CardValue.TEN, CardSuit.DIAMONDS),
                new Card(CardValue.TWO, CardSuit.CLUBS),
                new Card(CardValue.SEVEN, CardSuit.CLUBS)
        };

        Player straightPlayer = new Player();
        straightPlayer.setHoleCards(new HoleCards(new Card(CardValue.KING, CardSuit.DIAMONDS),
                new Card(CardValue.JACK, CardSuit.HEARTS)));

        Player threeOfAKindPlayer = new Player();
        threeOfAKindPlayer.setHoleCards(new HoleCards(new Card(CardValue.QUEEN, CardSuit.CLUBS), new Card(CardValue.QUEEN,
                CardSuit.HEARTS)));

        Player highCardPlayer = new Player();
        highCardPlayer.setHoleCards(new HoleCards(new Card(CardValue.FOUR, CardSuit.HEARTS),
                new Card(CardValue.SIX, CardSuit.SPADES)));
        highCardPlayer.fold();

        Player flushPlayer = new Player(); //SHOULD WIN
        flushPlayer.setHoleCards(new HoleCards(new Card(CardValue.THREE, CardSuit.CLUBS), new Card(CardValue.FOUR,
                CardSuit.CLUBS)));

        Game game = new Game();
        TestUtilities.assignCommunityCards(game, tableCards);

        straightPlayer.game = game;
        threeOfAKindPlayer.game = game;
        highCardPlayer.game = game;
        flushPlayer.game = game;

        Pot pot = new Pot();

        pot.bet(new Bet(straightPlayer, 100));
        pot.bet(new Bet(threeOfAKindPlayer, 100));
        pot.bet(new Bet(flushPlayer, 50));
        pot.bet(new Bet(highCardPlayer, 10));

        DeadChipPotDistributor distributor = new DeadChipPotDistributor();

        Collection<Winnings> winnings =
                distributor.distributePotAmongPlayers(pot, new Player[]{straightPlayer, threeOfAKindPlayer,
                        highCardPlayer, flushPlayer});

        assert winnings.size() == 2 : "wrong size winnings set: " + winnings.size();

        for (Winnings w : winnings) {
            Player p = w.getTargetPlayer();
            int chips = w.getChips();
            boolean deadChips = w.isDeadChips();

            assert !deadChips;

            boolean foundPlayer = false;
            if (p == straightPlayer) {
                foundPlayer = true;
                assert chips == 100;
            } else if (p == threeOfAKindPlayer) {
                foundPlayer = true;
                assert chips == 0;
            } else if (p == highCardPlayer) {
                foundPlayer = true;
                assert chips == 0;
            } else if (p == flushPlayer) {
                foundPlayer = true;
                assert chips == 160;
            }
        }
    }

}
