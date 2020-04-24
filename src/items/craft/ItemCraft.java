package items.craft;

import items.Item;
import items.util.ItemStack;

import java.util.Arrays;

public abstract class ItemCraft {
    private Recipe recipe;

    private Item item;

    private ItemStack[] itemTypes;
    private int[] itemAmounts;
    private double needWorkPoints;
    private double workPoints;

    public ItemCraft(Item item, Recipe recipe){
        this.recipe = recipe;
        this.item = item;
        itemTypes = recipe.getItemTypes();
        itemAmounts = recipe.getItemAmounts();
        needWorkPoints = recipe.getWorkPoints();
        workPoints = 0;
    }

    public boolean checkResources(){
        for(int i = 0; i < Math.min(itemTypes.length, itemAmounts.length); i++){
            if(itemTypes[i].getSize() < itemAmounts[i]) {
                return false;
            }
        }
        return true;
    }

    public void work(double workPoints){
        this.workPoints = workPoints;
    }

    public abstract ItemStack finish(Item.Quality quality);

    public Recipe getRecipe() {
        return recipe;
    }

    public Item getItem() {
        return item;
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

    public double getNeedWorkPoints() {
        return needWorkPoints;
    }

    public double getWorkPoints() {
        return workPoints;
    }

    public abstract ItemCraft getCopy();
}
