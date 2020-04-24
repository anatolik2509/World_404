package items.food;

import items.Item;
import items.util.DifferentItemsException;
import items.util.NegativeAmountException;
import items.util.Usable;

public abstract class Food extends Item implements Usable {
    public Food(Quality quality, double itemWeight) {
        super(quality, itemWeight, Type.FOOD);
    }
}
