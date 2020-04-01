package items;

import regions.Region;
import social.Human;

public class SimpleWoodaxe extends Tool{
    public SimpleWoodaxe(Quality quality) {
        super(quality, 3, 30);
    }

    @Override
    public String getName() {
        return "Simple woodaxe";
    }

    @Override
    public void useToHuman(Human target) {
        //TODO human damage
    }

    @Override
    public void useToRegion(Region target) {
        //TODO chopping
    }

    @Override
    public void useToBuilding(Region target) {
        //TODO idk
    }


}
