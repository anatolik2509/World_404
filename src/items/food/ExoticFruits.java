package items.food;

import items.util.Plant;
import social.Human;
import world.Square;

public class ExoticFruits extends Food implements Plant {
    private static final double WEIGHT = 0.1;

    public ExoticFruits(){
        super(Quality.VERY_GOOD, WEIGHT);
    }

    @Override
    public void useToHuman(Human target) {
        //TODO human feeding
    }

    @Override
    public String getName() {
        return "Exotic fruits";
    }

    @Override
    public double getProductivity(Square square) {
        return 0;//TODO productivity
    }

}
