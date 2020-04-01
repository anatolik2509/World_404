package regions;

import items.Food;
import items.Wheat;
import items.util.Stackable;
import world.Square;

public class Farm extends Region implements Extractive {

    public enum AVAILABLE_PLANTS{
        //TODO new plants;
        WHEAT(new Wheat(0)),
        DEFAULT(null);

        private Stackable plant;

        AVAILABLE_PLANTS(Stackable plant){
            this.plant = plant;
        }

        public Stackable getPlant() {
            return plant;
        }
    }

    public Farm(Square place){
        this(place, new Wheat(0));
        if(getSquarePlant() != null){
            setPlant(AVAILABLE_PLANTS.DEFAULT);
        }
    }

    public Farm(Square place, Food plant){
        super(place, RegionProject.FARM);
        this.plant = plant;
    }

    private Stackable plant;

    @Override
    public Stackable extract(int amount) {
        if(plant != null) {
            Stackable s = plant.split(0);
            s.createItems(amount);
            return s;
        }
        return null;
    }

    @Override
    public Stackable extractiveItems() {
        return getPlant();
    }

    public Stackable getSquarePlant(){
        Square s = this.getPlace();
        switch (s.getResource()){
            case TEA:
                return null;//TODO tea
            case GRAPE:
                return null;//TODO grape
            case EXOTIC_FRUITS:
                return null;//TODO fruits
            default:
                return null;
        }
    }

    public Stackable getPlant() {
        return plant.split(0);
    }

    public void setPlant(AVAILABLE_PLANTS plant) {
        if(plant.getPlant() == null){
            this.plant = getSquarePlant();
        }
        else {
            this.plant = plant.getPlant();
        }
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
