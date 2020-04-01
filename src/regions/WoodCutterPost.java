package regions;

import items.Item;
import items.Wood;
import items.util.Stackable;
import world.Resource;
import world.Square;

public class WoodCutterPost extends Region implements Extractive{
    public WoodCutterPost(Square place){
        super(place, RegionProject.WOOD_CUTTER_POST);
    }

    @Override
    public Stackable extract(int amount) {
        return new Wood(amount);
    }

    @Override
    public Stackable extractiveItems() {
        return new Wood(0);
    }

    public static boolean canBuilt(Square s){
        if(s.getType() == Square.WATER) return false;
        if(s.getType() == Square.HILL) return false;
        if(s.getResource() != Resource.WOOD) return false;
        return true;
    }

    @Override
    public boolean canThisBuilt(Square s) {
        return canBuilt(s);
    }
}
