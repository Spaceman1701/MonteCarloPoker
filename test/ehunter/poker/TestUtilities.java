package ehunter.poker;

import ehunter.poker.hand.ValueComparator;
import ehunter.poker.table.Game;

import ehunter.poker.hand.Card;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by 40501 on 5/5/2016.
 */
public class TestUtilities {

    private TestUtilities() {};


    public static void assignCommunityCards(Game g, Card[] tableCards) {
        try {
            Set<Card> communityCards = new TreeSet<Card>(new ValueComparator());

            for (Card c :tableCards) {
                communityCards.add(c);
            }

            Field field = Game.class.getDeclaredField("communityCards");
            field.setAccessible(true);
            field.set(g, communityCards);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
