package buildings;

import items.Iron;
import items.Stone;
import items.Wood;
import items.util.Stackable;

import java.util.Arrays;

public enum ProjectBuilding {
    BAKERY(new Stackable[]{new Wood(0), new Stone(0)},
            new int[]{200,70},
            200),
    BLACK_SMITH(new Stackable[]{new Wood(0), new Stone(0), new Iron(0)},
            new int[]{50,200,20},
            250),
    HOUSE(new Stackable[]{new Wood(0), new Stone(0)},
            new int[]{200, 70},
            200),
    MARKET(new Stackable[]{new Wood(0), new Stone(0)},
            new int[]{300, 100},
            300),
    WORKSHOP(new Stackable[]{new Wood(0), new Stone(0), new Iron(0)},
            new int[]{50,200,20},
            250);


    private final Stackable[] itemTypes;
    private final int[] itemAmounts;
    private final double workPoints;



    ProjectBuilding(Stackable[] itemTypes, int[] itemAmounts, double workPoints){
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
