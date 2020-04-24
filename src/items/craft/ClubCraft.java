package items.craft;

import items.util.ItemStack;
import items.weapon.Club;
import items.Item;

public class ClubCraft extends ItemCraft{
    public ClubCraft() {
        super(new Club(Item.Quality.NORMAL), Recipe.CLUB_RECIPE);
    }

    @Override
    public ItemStack finish(Item.Quality quality) {
        if(getNeedWorkPoints() <= getWorkPoints()) {
            return new ItemStack(new Club(quality), 1);
        }
        return null;
    }

    @Override
    public ItemCraft getCopy() {
        return new ClubCraft();
    }
}
