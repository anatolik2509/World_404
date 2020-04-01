package items;

import items.util.NegativeAmountException;
import items.util.Stackable;
import social.Human;

public class CookedMeat extends Food{
    public CookedMeat(int amount) {
        super(Quality.BAD, 1, amount);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Stackable split(int amount) {
        Stackable.verifySplitting(amount, this.getAmount());
        this.deleteItems(amount);
        return new CookedMeat(amount);
    }

    @Override
    public void useToHuman(Human target) {
        //TODO human feeding
    }



}
