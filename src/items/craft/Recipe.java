package items.craft;

import items.*;
import items.util.Stackable;

import java.util.Arrays;

public enum Recipe {
    CLUB_RECIPE(new Stackable[]{new Wood(0)},
            new int[]{5},
            1),
    BREAD_RECIPE(new Stackable[]{new Wheat(0)},
            new int[]{20},
            20);
    ;

    private Stackable[] itemTypes;
    private int[] itemAmounts;
    private double workPoints;

    Recipe(Stackable[] itemTypes, int[] itemAmounts, double workPoints) {
        this.itemTypes = itemTypes;
        this.itemAmounts = itemAmounts;
        this.workPoints = workPoints;
    }

    public Stackable[] getItemTypes() {
        Stackable[] s = new Stackable[itemTypes.length];
        for(int i = 0; i < s.length; i++){
            s[i] = itemTypes[i].split(0);
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
