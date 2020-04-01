package items;

import regions.Region;
import social.Human;

public class SimplePickaxe extends Tool{
    public SimplePickaxe(Quality quality) {
        super(quality, 3, 30);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void useToHuman(Human target) {
        //TODO human damage
    }

    @Override
    public void useToRegion(Region target) {
        //TODO mining
    }

    @Override
    public void useToBuilding(Region target) {
        //TODO hmm, mining?
    }


}
