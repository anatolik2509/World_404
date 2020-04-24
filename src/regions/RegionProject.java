package regions;

import items.material.Stone;
import items.material.Wood;
import items.util.ItemStack;

import java.util.Arrays;

public enum RegionProject {
    CITY(ItemStack.itemStacksByItems(new Wood(), new Stone()),
            new int[]{500,300},
            1000),
    FARM(new ItemStack[]{},
            new int[]{},
            500),
    MINE(new ItemStack[]{},
            new int[]{},
            100),
    WOOD_CUTTER_POST(new ItemStack[]{},
            new int[]{},
            100),
    HUNT_POST(new ItemStack[]{},
            new int[]{},
            100);




    private final ItemStack[] itemTypes;
    private final int[] itemAmounts;
    private final int workPoints;



    RegionProject(ItemStack[] itemTypes, int[] itemAmounts, int workPoints){
        this.itemTypes = itemTypes;
        this.itemAmounts = itemAmounts;
        this.workPoints = workPoints;
    }

    public ItemStack[] getItemTypes() {
        ItemStack[] s = new ItemStack[itemTypes.length];
        for(int i = 0; i < s.length; i++){
            s[i] = new ItemStack(itemTypes[i].getItem());
        }
        return s;
    }

    public int[] getItemAmounts() {
        return Arrays.copyOf(itemAmounts, itemAmounts.length);
    }

    public int getWorkPoints() {
        return workPoints;
    }
}
