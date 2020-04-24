package items.material;

import items.Item;

public class Stone extends Material {
    private static final int WEIGHT = 1;


    public Stone(){
        super(Item.Quality.NORMAL, WEIGHT);
    }

    @Override
    public String getName() {
        return "Stone";
    }


}
