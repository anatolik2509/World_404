package regions;

import items.Item;
import items.material.Wood;
import items.util.ItemStack;
import world.Resource;
import world.Square;

public class WoodCutterPost extends Region implements Extractive{
    public WoodCutterPost(Square place){
        super(place, RegionProject.WOOD_CUTTER_POST);
    }

    @Override
    public ItemStack extract(int amount) {
        return new ItemStack(new Wood(), amount);
    }

    @Override
    public Item extractiveItems() {
        return new Wood();
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
