package items.material;

import items.util.Plant;
import world.Square;

public class Tea extends Material implements Plant {
    public static final double WEIGHT = 0.1;

    public Tea(){
        super(Quality.GOOD, WEIGHT);
    }

    @Override
    public String getName() {
        return "Tea";
    }

    @Override
    public double getProductivity(Square square) {
        return 0;//TODO productivity
    }
}
