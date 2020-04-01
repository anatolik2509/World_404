package items;

import items.util.NegativeAmountException;
import items.util.Stackable;
import items.util.Usable;
import social.Human;

public class Wheat extends Food {
    private static final int WEIGHT = 1;

    public Wheat(int amount){
        super(Quality.VERY_BAD, WEIGHT, amount);
    }

    @Override
    public Stackable split(int amount) {
        Stackable.verifySplitting(amount, this.getAmount());
        this.deleteItems(amount);
        return new Wheat(amount);
    }

    @Override
    public void useToHuman(Human target) {
        //TODO human feeding
    }

    @Override
    public String getName() {
        return "Wheat";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Wheat(getAmount());
    }
}
