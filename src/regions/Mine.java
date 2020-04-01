package regions;

import items.Iron;
import items.Item;
import items.Stone;
import items.util.Stackable;
import world.Square;

public class Mine extends Region implements Extractive{
    public Mine(Square place){
        super(place, RegionProject.MINE);
        resource = getSquareResource();
    }

    private Stackable resource;

    @Override
    public Stackable extract(int amount) {
        if(resource != null) {
            Stackable s = resource.split(0);
            s.createItems(amount);
            return s;
        }
        return null;
    }

    @Override
    public Stackable extractiveItems() {
        return resource.split(0);
    }

    public Stackable getSquareResource(){
        Square s = this.getPlace();
        switch (s.getResource()) {
            case DIAMOND:
                return null;//TODO diamond
            case SILVER:
                return null;//TODO silver
            case GOLD:
                return null;//TODO gold
            case IRON:
                return new Iron(0);
            case STONE:
                return new Stone(0);
            default:
                return null;
        }
    }

    public Stackable getResource() {
        return resource.split(0);
    }

    public static boolean canBuilt(Square s){
        if(s.getType() == Square.WATER) return false;
        if(s.getType() == Square.HILL) return false;
        switch (s.getResource()) {
            case DIAMOND:
            case SILVER:
            case GOLD:
            case IRON:
            case STONE:
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean canThisBuilt(Square s) {
        return canBuilt(s);
    }
}
