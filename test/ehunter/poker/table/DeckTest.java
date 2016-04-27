package ehunter.poker.table;

import org.junit.Test;

/**
 * Created by 40501 on 4/27/2016.
 */
public class DeckTest {

    @Test
    public void testDeckNumberOfCards() {
        Deck d = new Deck();

        assert d.getSize() == 52;
    }
}
