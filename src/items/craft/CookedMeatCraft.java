package items.craft;

import items.food.CookedMeat;
import items.Item;
import items.util.ItemStack;

public class CookedMeatCraft extends ItemCraft {
    public CookedMeatCraft() {
        super(new CookedMeat(), Recipe.BREAD_RECIPE);//TODO recipe
    }

    @Override
    public ItemStack finish(Item.Quality quality) {
        if(getNeedWorkPoints() <= getWorkPoints()) {
            return new ItemStack(new CookedMeat(), 1);
        }
        return null;
    }

    @Override
    public ItemCraft getCopy() {
        return new CookedMeatCraft();
    }
}
