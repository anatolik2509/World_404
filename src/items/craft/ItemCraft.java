package items.craft;

import items.Item;
import items.util.Stackable;

import java.util.Arrays;

public abstract class ItemCraft {
    private Recipe recipe;

    private Item item;

    private Stackable[] itemTypes;
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
            if(itemTypes[i].getAmount() < itemAmounts[i]) {
                return false;
            }
        }
        return true;
    }

    public void work(double workPoints){
        this.workPoints = workPoints;
    }

    public abstract Item finish(Item.Quality quality);

    public Recipe getRecipe() {
        return recipe;
    }

    public Item getItem() {
        return item;
    }

    public Stackable[] getItemTypes() {
        return itemTypes;
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
