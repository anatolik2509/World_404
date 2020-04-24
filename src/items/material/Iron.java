package items.material;

import items.Item;

public class Iron extends Material{
    public Iron() {
        super(Item.Quality.NORMAL, 1);
    }

    @Override
    public String getName() {
        return "Iron";
    }
}
