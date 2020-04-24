package items.food;

import items.Item;
import social.Human;

public class CookedMeat extends Food{

    public CookedMeat(){
        this(Quality.NORMAL);
    }

    public CookedMeat(Quality quality) {
        super(quality, 0.1);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void useToHuman(Human target) {
        //TODO human feeding
    }



}
