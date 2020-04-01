package items.craft;

import items.Bread;
import items.Club;
import items.Item;

public class BreadCraft extends ItemCraft {
    public BreadCraft() {
        super(new Bread(1), Recipe.BREAD_RECIPE);
    }

    @Override
    public Item finish(Item.Quality quality) {
        if(getNeedWorkPoints() <= getWorkPoints()) {
            return new Bread(1);
        }
        return null;
    }

    @Override
    public ItemCraft getCopy() {
        return new BreadCraft();
    }
}
