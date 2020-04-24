package buildings;

import items.util.ItemStack;
import regions.City;

public class Project extends Building {

    private Building projectBuilding;

    private ItemStack[] itemTypes;
    private int[] itemAmounts;

    private double workPoints;
    private double neededWorkPoints;

    public Project(City region, Building projectBuilding) {
        super(region, null);
        this.projectBuilding = projectBuilding;
        this.neededWorkPoints= projectBuilding.getProject().getWorkPoints();
        ProjectBuilding p = projectBuilding.getProject();
        itemAmounts = p.getItemAmounts();
        itemTypes = p.getItemTypes();

    }

    public void build(double workPoints){
        if(checkResources()) {
            this.workPoints += workPoints;
            if (this.workPoints >= neededWorkPoints) {
                getPlace().finishProject(this);
            }
        }
    }

    public boolean checkResources(){
        for(int i = 0; i < Math.min(itemTypes.length, itemAmounts.length); i++){
            if(itemTypes[i].getSize() < itemAmounts[i]) {
                return false;
            }
        }
        return true;
    }

    public Building getProjectBuilding() {
        return projectBuilding;
    }

    public ItemStack[] getItemTypes() {
        return itemTypes;
    }

    public int[] getItemAmounts() {
        return itemAmounts;
    }

    public double getWorkPoints() {
        return workPoints;
    }
}
