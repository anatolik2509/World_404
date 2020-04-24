package items.food;

import items.util.Plant;
import social.Human;
import world.Square;

public class Wheat extends Food implements Plant {
    private static final double WEIGHT = 0.1;

    public Wheat(){
        super(Quality.VERY_BAD, WEIGHT);
    }

    @Override
    public void useToHuman(Human target) {
        //TODO human feeding
    }

    @Override
    public String getName() {
        return "Wheat";
    }

    @Override
    public double getProductivity(Square square) {
        return 0;//TODO productivity
    }

}
