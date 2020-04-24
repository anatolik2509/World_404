package items.material;


import items.Item;

public class Wood extends Material{
    private static final int WEIGHT = 1;

    public Wood(){
        super(Item.Quality.NORMAL, WEIGHT);
    }

    @Override
    public String getName() {
        return "Wood";
    }
}
