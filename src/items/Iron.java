package items;

import items.util.NegativeAmountException;
import items.util.Stackable;

public class Iron extends Material{
    public Iron(int amount) {
        super(Quality.NORMAL, 1, amount);
    }

    @Override
    public String getName() {
        return "Iron";
    }

    @Override
    public Stackable split(int amount) {
        Stackable.verifySplitting(amount, this.getAmount());
        this.deleteItems(amount);
        return new Iron(amount);
    }


}
