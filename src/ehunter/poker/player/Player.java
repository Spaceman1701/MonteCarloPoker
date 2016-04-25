package ehunter.poker.player;

/**
 * Created by 40501 on 4/25/2016.
 */
public class Player {

    private boolean folded = false;

    public boolean isFolded() {
        return folded;
    }

    public void fold() {
        folded = true;
    }
}
