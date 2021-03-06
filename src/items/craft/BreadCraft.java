package items.craft;

import items.food.Bread;
import items.Item;
import items.util.ItemStack;

public class BreadCraft extends ItemCraft {
    public BreadCraft() {
        super(new Bread(), Recipe.BREAD_RECIPE);
    }

    @Override
    public ItemStack finish(Item.Quality quality) {
        if(getNeedWorkPoints() <= getWorkPoints()) {
            return new ItemStack(new Bread(), 1);
        }
        return null;
    }

    @Override
    public ItemCraft getCopy() {
        return new BreadCraft();
    }
}
