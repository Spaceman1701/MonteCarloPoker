package ehunter.poker;

import ehunter.poker.table.Game;

import ehunter.poker.hand.Card;

import java.lang.reflect.Field;

/**
 * Created by 40501 on 5/5/2016.
 */
public class TestUtilities {

    private TestUtilities() {};


    public static void assignCommunityCards(Game g, Card[] communityCards) {
        Field field = null;
        try {
            field = Game.class.getDeclaredField("communityCards");
            field.setAccessible(true);
            field.set(g, communityCards);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
