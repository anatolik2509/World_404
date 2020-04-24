package items.material;

import items.util.Plant;
import world.Square;

public class Cotton extends Material implements Plant {
    public static final double WEIGHT = 0.1;

    public Cotton(){
        super(Quality.NORMAL, WEIGHT);
    }

    @Override
    public String getName() {
        return "Cotton";
    }

    @Override
    public double getProductivity(Square square) {
        return 0;//TODO productivity
    }
}
