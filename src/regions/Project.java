package regions;

import items.util.ItemStack;
import world.Square;

public class Project extends Region{

    private Region regionProject;

    private ItemStack[] itemTypes;
    private int[] itemAmounts;

    private int workPoints;
    private int neededWorkPoints;

    public Project(Square place, Region regionProject) {
        super(place, null);
        this.regionProject = regionProject;
        this.neededWorkPoints= regionProject.getProject().getWorkPoints();
        RegionProject p = regionProject.getProject();
        itemAmounts = p.getItemAmounts();
        itemTypes = p.getItemTypes();
    }

    public void build(int workPoints){
        if(checkResources()) {
            this.workPoints += workPoints;
            if (this.workPoints >= neededWorkPoints) {
                getPlace().setRegion(regionProject);
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

    public Region getRegionProject() {
        return regionProject;
    }

    public ItemStack[] getItemTypes() {
        return itemTypes;
    }

    public int[] getItemAmounts() {
        return itemAmounts;
    }

    public int getWorkPoints() {
        return workPoints;
    }

    @Override
    public boolean canThisBuilt(Square s) {
        return true;
    }
}
