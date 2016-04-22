package ehunter.poker.pot;

/**
 * Created by 40501 on 4/22/2016.
 */
public class ChipHolder {
    private int chips;

    public ChipHolder(int chips) {
        this.chips = chips;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public void addChips(int chips) {
        this.chips += chips;
    }

    public void subtractChips(int chips) {
        this.chips -= chips;
    }
}
