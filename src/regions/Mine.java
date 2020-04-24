package regions;

import items.Item;
import items.material.*;
import items.util.ItemStack;
import world.Square;

public class Mine extends Region implements Extractive{
    public Mine(Square place){
        super(place, RegionProject.MINE);
        resource = getSquareResource();
    }

    private Item resource;

    @Override
    public ItemStack extract(int amount) {
        if(resource != null) {
            return new ItemStack(resource, amount);
        }
        return null;
    }

    @Override
    public Item extractiveItems() {
        return resource;
    }

    public Item getSquareResource(){
        Square s = this.getPlace();
        switch (s.getResource()) {
            case DIAMOND:
                return new Diamond();
            case SILVER:
                return new Silver();
            case GOLD:
                return new Gold();
            case IRON:
                return new Iron();
            case STONE:
                return new Stone();
            default:
                return null;
        }
    }

    public Item getResource() {
        return resource;
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
