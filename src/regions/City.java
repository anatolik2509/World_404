package regions;

import buildings.Building;
import world.Square;

import java.util.ArrayList;

public class City extends Region {

    public static final int MAX_BUILDINGS_AMOUNT = 100;

    public City(Square place){
        super(place, RegionProject.CITY);
        buildings = new ArrayList<>();
    }

    public void finishProject(buildings.Project project){
        buildings.remove(project);
        buildings.add(project.getProjectBuilding());
    }

    public boolean addProject(buildings.Project project){
        if(buildings.size() >= MAX_BUILDINGS_AMOUNT){
            return false;
        }
        buildings.add(project);
        return true;
    }

    public boolean addBuilding(Building building){
        if(buildings.size() >= MAX_BUILDINGS_AMOUNT){
            return false;
        }
        buildings.add(building);
        return true;
    }

    //TODO

    private ArrayList<Building> buildings;

    public ArrayList<Building> getBuildings() {
        return (ArrayList<Building>)buildings.clone();
    }


    public static boolean canBuilt(Square s){
        if(s.getType() == Square.WATER) return false;
        if(s.getType() == Square.HILL) return false;
        return true;
    }

    @Override
    public boolean canThisBuilt(Square s) {
        return canBuilt(s);
    }
}
