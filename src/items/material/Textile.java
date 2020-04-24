package items.material;

import items.Item;

public class Textile extends Material {
    private static final double WEIGHT = 0.1;


    public Textile(){
        super(Item.Quality.NORMAL, WEIGHT);
    }

    @Override
    public String getName() {
        return "Textile";
    }
}
