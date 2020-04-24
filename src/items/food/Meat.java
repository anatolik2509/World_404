package items.food;
import social.Human;

public class Meat extends Food {

    private static final double WEIGHT = 0.1;

    public Meat(){
        super(Quality.VERY_BAD, WEIGHT);
    }

    @Override
    public void useToHuman(Human target) {
        //TODO human feeding
    }

    @Override
    public String getName() {
        return "Meat";
    }


}
