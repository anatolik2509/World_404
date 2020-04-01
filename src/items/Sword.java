package items;

import regions.Region;
import social.Human;

public class Sword extends Weapon {


    public Sword(Quality quality) {
        super(quality, 5, 50);
    }

    @Override
    public String getName() {
        return "Sword";
    }

    @Override
    public void useToHuman(Human target) {
        //TODO human damage
    }


}
