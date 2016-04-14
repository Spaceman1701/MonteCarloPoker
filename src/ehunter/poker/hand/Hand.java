package ehunter.poker.hand;

/**
 * Created by 40501 on 4/14/2016.
 */
public class Hand {
    //Contains all data for a single hand

    public static boolean isFullHouse(Hand h) {
        return false;
    }

    public static boolean isStraight(Hand h) {

        h.sortBySuit();


        return false;
    }

    public static boolean isFlush(Hand h) {
        return false;
    }

    public static boolean is4OfAKind(Hand h) {
        return false;
    }

    public static boolean is3OfAKind(Hand h) {
        return false;
    }

    public static boolean is2Pair(Hand h) {
        return false;
    }

    public static boolean isPair(Hand h) {
        return false;
    }

    public void sortBySuit() {

    }
}
