package ehunter.poker.hand;

/**
 * Created by 40501 on 4/14/2016.
 */
public class HandValue {
    private final Hand hand;
    private final HandType type;
    private final int value;

    public HandValue(Hand hand, HandType type, int value) {
        this.hand = hand;
        this.type = type;
        this.value = value;
    }

    public Hand getHand() {
        return hand;
    }

    public HandType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
