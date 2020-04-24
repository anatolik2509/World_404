package items.food;

import items.util.Plant;
import social.Human;
import world.Square;

public class Grape extends Food implements Plant {
    private static final double WEIGHT = 0.1;

    public Grape(){
        super(Quality.GOOD, WEIGHT);
    }

    @Override
    public void useToHuman(Human target) {
        //TODO human feeding
    }

    @Override
    public String getName() {
        return "Grape";
    }

    @Override
    public double getProductivity(Square square) {
        return 0;//TODO productivity
    }
}
