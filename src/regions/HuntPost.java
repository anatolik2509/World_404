package regions;

import items.Item;
import items.food.Meat;
import items.material.Fur;
import items.util.ItemStack;
import world.Resource;
import world.Square;

public class HuntPost extends Region implements Extractive{
    public HuntPost(Square place){
        super(place, RegionProject.HUNT_POST);
        if(getSquareResource() == null){
            resources = new Meat();
        }
        else {
            resources = getSquareResource();
        }
    }

    private Item resources;

    @Override
    public ItemStack extract(int amount) {
        if(resources != null) {
            ItemStack s = new ItemStack(resources, amount);
            return s;
        }
        return null;
    }

    @Override
    public Item extractiveItems() {
        return resources;
    }

    public Item getSquareResource(){
        Square s = this.getPlace();
        switch (s.getResource()) {
            case FUR:
                return new Fur();//TODO fur
            case ELEPHANTS:
                return null;//TODO elephants
            default:
                return null;
        }
    }

    public Item getResources() {
        return resources;
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
