package items.craft;

import items.food.Wheat;
import items.material.Textile;
import items.material.Wood;
import items.util.ItemStack;

import java.util.Arrays;

public enum Recipe {
    CLUB_RECIPE(new ItemStack[]{new ItemStack(new Wood())},
            new int[]{5},
            2),
    BREAD_RECIPE(new ItemStack[]{new ItemStack(new Wheat())},
            new int[]{6},
            20),
    COOKED_MEAT_CRAFT(new ItemStack[]{new ItemStack(new Wheat())},
            new int[]{1},
            10),
    SIMPLE_PANTS_CRAFT(new ItemStack[]{new ItemStack(new Textile())},
            new int[]{5},
            20);
    ;

    private ItemStack[] itemTypes;
    private int[] itemAmounts;
    private double workPoints;

    Recipe(ItemStack[] itemTypes, int[] itemAmounts, double workPoints) {
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
