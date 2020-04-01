package regions;

import items.Meat;
import items.Item;
import items.util.Stackable;
import world.Resource;
import world.Square;

public class HuntPost extends Region implements Extractive{
    public HuntPost(Square place){
        super(place, RegionProject.HUNT_POST);
        if(getSquareResource() == null){
            resources = new Meat(0);
        }
        else {
            resources = getSquareResource();
        }
    }

    private Stackable resources;

    @Override
    public Stackable extract(int amount) {
        if(resources != null) {
            Stackable s = resources.split(0);
            s.createItems(amount);
            return s;
        }
        return null;
    }

    @Override
    public Stackable extractiveItems() {
        return resources.split(0);
    }

    public Stackable getSquareResource(){
        Square s = this.getPlace();
        switch (s.getResource()) {
            case FUR:
                return null;//TODO fur
            case ELEPHANTS:
                return null;//TODO elephants
            default:
                return null;
        }
    }

    public Stackable getResources() {
        return resources.split(0);
    }

    public static boolean canBuilt(Square s){
        if(s.getType() == Square.WATER) return false;
        if(s.getType() == Square.HILL) return false;
        if(s.getResource() != Resource.WOOD && s.getResource() != Resource.ELEPHANTS) return false;
        return true;
    }

    @Override
    public boolean canThisBuilt(Square s) {
        return canBuilt(s);
    }
}
