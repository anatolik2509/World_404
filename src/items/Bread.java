package items;

import items.util.NegativeAmountException;
import items.util.Stackable;
import social.Human;

public class Bread extends Food{
    public Bread(int amount) {
        super(Quality.BAD, 1, amount);
    }

    @Override
    public String getName() {
        return "Bread";
    }

    @Override
    public Stackable split(int amount) {
        Stackable.verifySplitting(amount, this.getAmount());
        this.deleteItems(amount);
        return new Bread(amount);
    }

    @Override
    public void useToHuman(Human target) {
        //TODO human feeding
    }


}
