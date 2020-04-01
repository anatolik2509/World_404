package items.craft;

import items.Club;
import items.Item;

public class ClubCraft extends ItemCraft{
    public ClubCraft() {
        super(new Club(Item.Quality.NORMAL), Recipe.CLUB_RECIPE);
    }

    @Override
    public Item finish(Item.Quality quality) {
        if(getNeedWorkPoints() <= getWorkPoints()) {
            return new Club(quality);
        }
        return null;
    }

    @Override
    public ItemCraft getCopy() {
        return new ClubCraft();
    }
}
