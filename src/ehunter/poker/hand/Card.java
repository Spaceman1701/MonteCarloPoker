package ehunter.poker.hand;

/**
 * Created by 40501 on 4/14/2016.
 */
public class Card {
    private final CardValue value;
    private final CardSuit suit;

    public Card(CardValue value, CardSuit suit) {
        this.value = value;
        this.suit = suit;
    }

    public CardValue getValue() {
        return value;
    }

    public CardSuit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() == Card.class) {
            Card other = (Card)o;

            return other.value == this.value && other.suit == this.suit;
        }

        return false;
    }

    @Override
    public String toString() {
        return value.getShortHand() + suit.getShorthand();
    }
}
