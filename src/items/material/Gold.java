package items.material;

import items.Item;

public class Gold extends Material{
    public static final double WEIGHT = 0.1;

    public Gold(){
        super(Quality.GOOD, WEIGHT);
    }

    @Override
    public String getName() {
        return "Gold";
    }
}
