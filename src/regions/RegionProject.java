package regions;

import items.Stone;
import items.Wood;
import items.util.Stackable;

import java.util.Arrays;

public enum RegionProject {
    CITY(new Stackable[]{new Wood(0), new Stone(0)},
            new int[]{500,300},
            1000),
    FARM(new Stackable[]{},
            new int[]{},
            500),
    MINE(new Stackable[]{},
            new int[]{},
            100),
    WOOD_CUTTER_POST(new Stackable[]{},
            new int[]{},
            100),
    HUNT_POST(new Stackable[]{},
            new int[]{},
            100);




    private final Stackable[] itemTypes;
    private final int[] itemAmounts;
    private final int workPoints;



    RegionProject(Stackable[] itemTypes, int[] itemAmounts, int workPoints){
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

    public int getWorkPoints() {
        return workPoints;
    }
}
