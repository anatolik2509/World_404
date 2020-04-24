package items.food;

import items.Item;
import social.Human;

public class Bread extends Food{
    public Bread(Quality quality) {
        super(quality, 0.5);
    }

    public Bread(){
        this(Quality.NORMAL);
    }

    @Override
    public String getName() {
        return "Bread";
    }

    @Override
    public void useToHuman(Human target) {
        //TODO human feeding
    }
}
