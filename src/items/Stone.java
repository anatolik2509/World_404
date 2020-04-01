package items;

import items.util.NegativeAmountException;
import items.util.Stackable;

public class Stone extends Material {
    private static final int WEIGHT = 1;


    public Stone(int amount){
        super(Item.Quality.NORMAL, WEIGHT, amount);
    }

    @Override
    public Stackable split(int amount) {
        Stackable.verifySplitting(amount, this.getAmount());
        this.deleteItems(amount);
        return new Stone(amount);
    }

    @Override
    public String getName() {
        return "Stone";
    }


}
