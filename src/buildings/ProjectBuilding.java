package buildings;

import items.material.Iron;
import items.material.Stone;
import items.material.Wood;
import items.util.ItemStack;

import java.util.Arrays;

public enum ProjectBuilding {
    BAKERY(ItemStack.itemStacksByItems(new Wood(), new Stone()),
            new int[]{200,70},
            200),
    BLACK_SMITH(ItemStack.itemStacksByItems(new Wood(), new Stone(), new Iron()),
            new int[]{50,200,20},
            250),
    HOUSE(ItemStack.itemStacksByItems(new Wood(), new Stone()),
            new int[]{200, 70},
            200),
    MARKET(ItemStack.itemStacksByItems(new Wood(), new Stone()),
            new int[]{300, 100},
            300),
    WORKSHOP(ItemStack.itemStacksByItems(new Wood(), new Stone(), new Iron()),
            new int[]{50,200,20},
            250);


    private final ItemStack[] itemTypes;
    private final int[] itemAmounts;
    private final double workPoints;



    ProjectBuilding(ItemStack[] itemTypes, int[] itemAmounts, double workPoints){
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

    public double getWorkPoints() {
        return workPoints;
    }
}
